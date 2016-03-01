package org.devoxx.javaee6;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Stateless
public class ItemEJB {

    // ======================================
    // =             Attributes             =
    // ======================================


    // ======================================
    // =          Business methods          =
    // ======================================

    public Book createBook(Book book)
    {
    	List<Book> books=null;
        if(((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("books")==null)
        {
        	books=new ArrayList<Book>();
        	books.add(book);
        	((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("books", books);
        }else
        {
        	books=(List<Book>)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("books");
        	books.add(book);
        	((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("books", books);
        }	
        return book;
    }

    public List<Book> findAllBooks()
    {
        return (List<Book>)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("books");
    }

    public List<Book> findAllScifiBooks() 
    {
        return (List<Book>)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("books");
    }
}