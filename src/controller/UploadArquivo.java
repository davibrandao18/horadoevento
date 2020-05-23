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

import model.Usuario;
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
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName = null;
        for (Part part : request.getParts()) {
        	fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }
        
        response.getWriter().println("Arquivo recebido com sucesso.\n"
        			+ "Diretório onde os arquivos são armazenados: " + savePath);
        
        // Criando um objeto do tipo File
        File arquivo = new File(savePath + File.separator + fileName);
        
        UsuarioService us = new UsuarioService();
        HttpSession sessao = request.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("sessao_user");
        us.criarImagem(arquivo, usuario.getUserName());
        response.sendRedirect("/horadoevento/perfil/member");
        
	}
	
	/**
     * Extracts file name from HTTP header content-disposition
     */
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

}