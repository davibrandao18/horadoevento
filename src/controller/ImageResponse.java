package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageResponse.do")
public class ImageResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Busca o arquivo:
		String caminho = request.getParameter("file");
		File arquivo = new File(caminho);
		// Informa na resposta HTTP qual o tipo do conteudo do arquivo:
		// Nesse caso, eu usei tipo imagem png:
		response.setContentType("image/jpg");
		response.setContentLength((int)arquivo.length());

		FileInputStream in = new FileInputStream(arquivo);
		OutputStream out = response.getOutputStream();

		// Copia o conteudo do arquivo para o fluxo de saida da resposta do cliente:
		byte[] buf = new byte[1024];
		int count = 0;
		while ((count = in.read(buf)) >= 0) {
			out.write(buf, 0, count);
		}
	    out.close();
	    in.close();

	}

}
