package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Empresa;
import model.Usuario;
import service.EmpresaService;
import service.UsuarioService;

@WebServlet("/perfil/UploadArquivo.do")
@MultipartConfig(
		fileSizeThreshold=1024*1024*2, // 2MB
		maxFileSize=1024*1024*10,      // 10MB
		maxRequestSize=1024*1024*50)   // 50MB
public class UploadArquivo extends HttpServlet {
	
	private static final String SAVE_DIR = "uploadFiles";
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// gets absolute path of the web application
        //String appPath = request.getServletContext().getRealPath("");
		
		String appPathW = "C:"+ File.separator;
		String appPathL = "/home/"+ File.separator;
		
		
		// String appPath = "C:"+ File.separator;
		// String appPath = "/home/maiconspa/"+ File.separator;
        // constructs path of the directory to save uploaded file
        String savePathW = appPathW + File.separator + SAVE_DIR;
        String savePathL = appPathL + File.separator + SAVE_DIR;
        String savePath = "";
        
        // creates the save directory if it does not exists
        

    	File fileSaveDir = new File(savePathW);
    	if (!fileSaveDir.exists())
    		fileSaveDir.mkdir();
    	savePath = savePathW;

        
        String fileName = null;
        
        try {
        	for (Part part : request.getParts()) {
            	fileName = extractFileName(part);
                fileName = new File(fileName).getName();
                fileName = randomAlphaNumeric(16) + ".jpg";
                part.write(savePath + File.separator + fileName);
            }
		} catch (Exception e) {
			savePath = savePathL;
	    	fileSaveDir = new File(savePath);
	    	if (!fileSaveDir.exists())
	    		fileSaveDir.mkdir();
	    	
			for (Part part : request.getParts()) {
            	fileName = extractFileName(part);
                fileName = new File(fileName).getName();
                fileName = randomAlphaNumeric(16) + ".jpg";
                part.write(savePath + File.separator + fileName);
            }
		}
        
        //System.out.println("Upload: nome do arquivo = "+fileName);
        
        /*response.getWriter().println("Arquivo recebido com sucesso.\n"
        			+ "Diretório onde os arquivos são armazenados: " + savePath);*/
        
    	// Criando um objeto do tipo File
        File arquivo = new File(savePath + File.separator + fileName);
        
        String entidade = request.getParameter("entidade");
        HttpSession sessao = request.getSession();
        
        switch (entidade) {
        	case "usuario": {
        		UsuarioService us = new UsuarioService();
                Usuario usuario = (Usuario) sessao.getAttribute("sessao_user");
                us.criarImagem(arquivo, usuario.getUserName());
                usuario = us.carregar(usuario.getUserName(), savePath);
                
                sessao.setAttribute("tipo_entidade", "usuario");
                sessao.setAttribute("sessao_user", usuario);
                response.sendRedirect("/horadoevento/perfil/usuario/");
                
                break;
        	}
        	
        	case "empresa": {
        		EmpresaService es = new EmpresaService();
        		Empresa empresa = (Empresa) sessao.getAttribute("sessao_user");
        		es.criarImagem(arquivo, empresa.getUserName());
        		empresa = es.carregar(empresa.getUserName(), savePath);
        		
        		sessao.setAttribute("tipo_entidade", "empresa");
                sessao.setAttribute("sessao_user", empresa);
        		response.sendRedirect("/horadoevento/perfil/empresa/");
                break;
        	}
        }
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric(int count) {
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
    int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    return builder.toString();
    }

}
