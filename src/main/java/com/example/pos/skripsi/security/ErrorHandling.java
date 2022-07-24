package com.example.pos.skripsi.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandling {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NullPointerException.class) // exception handled
    public ResponseEntity handleNullPointerExceptions(
        Exception e
    ) {
        // ... potential custom logic
		
		HttpServletResponse response = new HttpServletResponse() {
			
			@Override
			public void setLocale(Locale loc) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setContentType(String type) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setContentLengthLong(long length) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setContentLength(int len) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCharacterEncoding(String charset) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBufferSize(int size) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void resetBuffer() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isCommitted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public PrintWriter getWriter() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ServletOutputStream getOutputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getBufferSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void flushBuffer() throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStatus(int sc, String sm) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setStatus(int sc) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setIntHeader(String name, int value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setHeader(String name, String value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDateHeader(String name, long date) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendRedirect(String location) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendError(int sc, String msg) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void sendError(int sc) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public int getStatus() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Collection<String> getHeaders(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<String> getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getHeader(String name) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeUrl(String url) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeURL(String url) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeRedirectUrl(String url) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String encodeRedirectURL(String url) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsHeader(String name) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void addIntHeader(String name, int value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addHeader(String name, String value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addDateHeader(String name, long date) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addCookie(Cookie cookie) {
				// TODO Auto-generated method stub
				
			}
		};

        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        response.setStatus(404);

        return new ResponseEntity<>(
            status
        );
    }

}
