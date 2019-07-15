package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveDocument(Document doc) {
		return (Integer)ht.save(doc);
	}

	@Override
	public List<Document> getAllDocuments() {
		return ht.loadAll(Document.class);
	}
	@Override
	public Document getOneDocument(Integer id) {
		return ht.get(Document.class, id);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getFileIdsAndFileNames() {
		return (List<Object[]>) ht.find("select fileId, fileName from  "+Document.class.getName());
	}

}
