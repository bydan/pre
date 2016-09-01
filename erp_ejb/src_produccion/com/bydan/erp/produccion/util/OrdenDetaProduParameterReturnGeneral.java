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
package com.bydan.erp.produccion.util;

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
import com.bydan.erp.produccion.util.OrdenDetaProduConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//OrdenDetaProdu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class OrdenDetaProduParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected OrdenDetaProdu ordendetaprodu;	
	protected List<OrdenDetaProdu> ordendetaprodus;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<OrdenProdu> ordenprodusForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<Bodega> bodegadestinosForeignKey;
	public List<TipoProcesoProdu> tipoprocesoprodusForeignKey;
	
	public OrdenDetaProduParameterReturnGeneral () throws Exception {						
		super();
		this.ordendetaprodus= new ArrayList<OrdenDetaProdu>();
		this.ordendetaprodu= new OrdenDetaProdu();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.ordenprodusForeignKey=new ArrayList<OrdenProdu>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.bodegadestinosForeignKey=new ArrayList<Bodega>();
		this.tipoprocesoprodusForeignKey=new ArrayList<TipoProcesoProdu>();
	} 
	
	public OrdenDetaProdu getOrdenDetaProdu() throws Exception {	
		return ordendetaprodu;
	}
		
	public void setOrdenDetaProdu(OrdenDetaProdu newOrdenDetaProdu) {
		this.ordendetaprodu = newOrdenDetaProdu;
	}
	
	public List<OrdenDetaProdu> getOrdenDetaProdus() throws Exception {		
		return ordendetaprodus;
	}
	
	public void setOrdenDetaProdus(List<OrdenDetaProdu> newOrdenDetaProdus) {
		this.ordendetaprodus = newOrdenDetaProdus;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<OrdenProdu> getordenprodusForeignKey() {
		return this.ordenprodusForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<Bodega> getbodegadestinosForeignKey() {
		return this.bodegadestinosForeignKey;
	}

	public List<TipoProcesoProdu> gettipoprocesoprodusForeignKey() {
		return this.tipoprocesoprodusForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setordenprodusForeignKey(List<OrdenProdu> ordenprodusForeignKey) {
		this.ordenprodusForeignKey=ordenprodusForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setbodegadestinosForeignKey(List<Bodega> bodegadestinosForeignKey) {
		this.bodegadestinosForeignKey=bodegadestinosForeignKey;
	}

	public void settipoprocesoprodusForeignKey(List<TipoProcesoProdu> tipoprocesoprodusForeignKey) {
		this.tipoprocesoprodusForeignKey=tipoprocesoprodusForeignKey;
	}
}

