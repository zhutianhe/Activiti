package com.zth.util;

import java.util.*;

/**
 * A Map that converts all keys to lowercase Strings for case insensitive
 * lookups.  This is needed for the toMap() implementation because 
 * databases don't consistenly handle the casing of column names. 
 */
@SuppressWarnings("rawtypes")
public class CaseInsensitiveHashMap extends HashMap {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4455925612889480682L;

	/**
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    public boolean containsKey(Object key) {
        return super.containsKey(key.toString().toLowerCase());
    }

    /**
     * @see java.util.Map#get(java.lang.Object)
     */
    public Object get(Object key) {
        return super.get(key.toString().toLowerCase());
    }

    /**
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    @SuppressWarnings("unchecked")
	public Object put(Object key, Object value) {
        return super.put(key.toString().toLowerCase(), value);
    }

    /**
     * @see java.util.Map#putAll(java.util.Map)
     */
    public void putAll(Map m) {
        Iterator iter = m.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object value = m.get(key);
            this.put(key, value);
        }
    }

    /**
     * @see java.util.Map#remove(java.lang.Object)
     */
    public Object remove(Object key) {
        return super.remove(key.toString().toLowerCase());
    }
}

