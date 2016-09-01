/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.inventario.util.report;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.DeepLoadType;
import com.bydan.erp.inventario.util.report.ModificacionLineasProductosConstantesFunciones;

import com.bydan.erp.inventario.business.entity.report.*;//ModificacionLineasProductos


import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ModificacionLineasProductosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ModificacionLineasProductos modificacionlineasproductos;	
	protected List<ModificacionLineasProductos> modificacionlineasproductoss;
	
	
	public List<Producto> productosForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<Linea> lineacategoriasForeignKey;
	public List<Linea> lineamarcasForeignKey;
	public List<Linea> lineadestinosForeignKey;
	public List<Linea> lineagrupodestinosForeignKey;
	public List<Linea> lineacategoriadestinosForeignKey;
	public List<Linea> lineamarcadestinosForeignKey;
	
	public ModificacionLineasProductosParameterReturnGeneral () throws Exception {						
		super();
		this.modificacionlineasproductoss= new ArrayList<ModificacionLineasProductos>();
		this.modificacionlineasproductos= new ModificacionLineasProductos();
		
		
		this.productosForeignKey=new ArrayList<Producto>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.lineacategoriasForeignKey=new ArrayList<Linea>();
		this.lineamarcasForeignKey=new ArrayList<Linea>();
		this.lineadestinosForeignKey=new ArrayList<Linea>();
		this.lineagrupodestinosForeignKey=new ArrayList<Linea>();
		this.lineacategoriadestinosForeignKey=new ArrayList<Linea>();
		this.lineamarcadestinosForeignKey=new ArrayList<Linea>();
	} 
	
	public ModificacionLineasProductos getModificacionLineasProductos() throws Exception {	
		return modificacionlineasproductos;
	}
		
	public void setModificacionLineasProductos(ModificacionLineasProductos newModificacionLineasProductos) {
		this.modificacionlineasproductos = newModificacionLineasProductos;
	}
	
	public List<ModificacionLineasProductos> getModificacionLineasProductoss() throws Exception {		
		return modificacionlineasproductoss;
	}
	
	public void setModificacionLineasProductoss(List<ModificacionLineasProductos> newModificacionLineasProductoss) {
		this.modificacionlineasproductoss = newModificacionLineasProductoss;
	}
	
	

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}

	public List<Linea> getlineagruposForeignKey() {
		return this.lineagruposForeignKey;
	}

	public List<Linea> getlineacategoriasForeignKey() {
		return this.lineacategoriasForeignKey;
	}

	public List<Linea> getlineamarcasForeignKey() {
		return this.lineamarcasForeignKey;
	}

	public List<Linea> getlineadestinosForeignKey() {
		return this.lineadestinosForeignKey;
	}

	public List<Linea> getlineagrupodestinosForeignKey() {
		return this.lineagrupodestinosForeignKey;
	}

	public List<Linea> getlineacategoriadestinosForeignKey() {
		return this.lineacategoriadestinosForeignKey;
	}

	public List<Linea> getlineamarcadestinosForeignKey() {
		return this.lineamarcadestinosForeignKey;
	}
	
	

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}

	public void setlineagruposForeignKey(List<Linea> lineagruposForeignKey) {
		this.lineagruposForeignKey=lineagruposForeignKey;
	}

	public void setlineacategoriasForeignKey(List<Linea> lineacategoriasForeignKey) {
		this.lineacategoriasForeignKey=lineacategoriasForeignKey;
	}

	public void setlineamarcasForeignKey(List<Linea> lineamarcasForeignKey) {
		this.lineamarcasForeignKey=lineamarcasForeignKey;
	}

	public void setlineadestinosForeignKey(List<Linea> lineadestinosForeignKey) {
		this.lineadestinosForeignKey=lineadestinosForeignKey;
	}

	public void setlineagrupodestinosForeignKey(List<Linea> lineagrupodestinosForeignKey) {
		this.lineagrupodestinosForeignKey=lineagrupodestinosForeignKey;
	}

	public void setlineacategoriadestinosForeignKey(List<Linea> lineacategoriadestinosForeignKey) {
		this.lineacategoriadestinosForeignKey=lineacategoriadestinosForeignKey;
	}

	public void setlineamarcadestinosForeignKey(List<Linea> lineamarcadestinosForeignKey) {
		this.lineamarcadestinosForeignKey=lineamarcadestinosForeignKey;
	}
}

