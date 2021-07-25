package pack.dao;

import pack.entity.docAvail;

public interface docAvailDAO {
	public docAvail getDocAvail(int id);
	public void saveDocAvail(docAvail da);
	public void clearNull();
}
