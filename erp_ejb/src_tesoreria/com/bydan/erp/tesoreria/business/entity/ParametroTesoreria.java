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
package com.bydan.erp.tesoreria.business.entity;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.tesoreria.util.ParametroTesoreriaConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroTesoreria extends ParametroTesoreriaAdditional implements Serializable ,Cloneable {//ParametroTesoreriaAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private ParametroTesoreria parametrotesoreriaOriginal;
	
	private Map<String, Object> mapParametroTesoreria;
			
	public Map<String, Object> getMapParametroTesoreria() {
		return mapParametroTesoreria;
	}

	public void setMapParametroTesoreria(Map<String, Object> mapParametroTesoreria) {
		this.mapParametroTesoreria = mapParametroTesoreria;
	}
	
	public void inicializarMapParametroTesoreria() {
		this.mapParametroTesoreria = new HashMap<String,Object>();
	}
	
	public void setMapParametroTesoreriaValue(String sKey,Object oValue) {
		this.mapParametroTesoreria.put(sKey, oValue);
	}
	
	public Object getMapParametroTesoreriaValue(String sKey) {
		return this.mapParametroTesoreria.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_anticipo_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean por_lotes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cobrar_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cobrar_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cobrar_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_pagar_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_pagar_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_pagar_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ParametroTesoreriaConstantesFunciones.SREGEXDESCRIPCION,message=ParametroTesoreriaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Transaccion transaccioncobrarpago;
	public Transaccion transaccioncobrardebito;
	public Transaccion transaccioncobrarcredito;
	public Transaccion transaccionpagarpago;
	public Transaccion transaccionpagardebito;
	public Transaccion transaccionpagarcredito;
	
	
	private String empresa_descripcion;
	private String transaccioncobrarpago_descripcion;
	private String transaccioncobrardebito_descripcion;
	private String transaccioncobrarcredito_descripcion;
	private String transaccionpagarpago_descripcion;
	private String transaccionpagardebito_descripcion;
	private String transaccionpagarcredito_descripcion;
	
	
		
	public ParametroTesoreria () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrotesoreriaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.con_anticipo_orden_compra=false;
 		this.por_lotes=false;
 		this.id_transaccion_cobrar_pago=-1L;
 		this.id_transaccion_cobrar_debito=-1L;
 		this.id_transaccion_cobrar_credito=-1L;
 		this.id_transaccion_pagar_pago=-1L;
 		this.id_transaccion_pagar_debito=-1L;
 		this.id_transaccion_pagar_credito=-1L;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.transaccioncobrarpago=null;
		this.transaccioncobrardebito=null;
		this.transaccioncobrarcredito=null;
		this.transaccionpagarpago=null;
		this.transaccionpagardebito=null;
		this.transaccionpagarcredito=null;
		
		
		this.empresa_descripcion="";
		this.transaccioncobrarpago_descripcion="";
		this.transaccioncobrardebito_descripcion="";
		this.transaccioncobrarcredito_descripcion="";
		this.transaccionpagarpago_descripcion="";
		this.transaccionpagardebito_descripcion="";
		this.transaccionpagarcredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroTesoreria (Long id,Date versionRow,Long id_empresa,Boolean con_anticipo_orden_compra,Boolean por_lotes,Long id_transaccion_cobrar_pago,Long id_transaccion_cobrar_debito,Long id_transaccion_cobrar_credito,Long id_transaccion_pagar_pago,Long id_transaccion_pagar_debito,Long id_transaccion_pagar_credito,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrotesoreriaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.con_anticipo_orden_compra=con_anticipo_orden_compra;
 		this.por_lotes=por_lotes;
 		this.id_transaccion_cobrar_pago=id_transaccion_cobrar_pago;
 		this.id_transaccion_cobrar_debito=id_transaccion_cobrar_debito;
 		this.id_transaccion_cobrar_credito=id_transaccion_cobrar_credito;
 		this.id_transaccion_pagar_pago=id_transaccion_pagar_pago;
 		this.id_transaccion_pagar_debito=id_transaccion_pagar_debito;
 		this.id_transaccion_pagar_credito=id_transaccion_pagar_credito;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroTesoreria (Long id_empresa,Boolean con_anticipo_orden_compra,Boolean por_lotes,Long id_transaccion_cobrar_pago,Long id_transaccion_cobrar_debito,Long id_transaccion_cobrar_credito,Long id_transaccion_pagar_pago,Long id_transaccion_pagar_debito,Long id_transaccion_pagar_credito,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrotesoreriaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.con_anticipo_orden_compra=con_anticipo_orden_compra;
 		this.por_lotes=por_lotes;
 		this.id_transaccion_cobrar_pago=id_transaccion_cobrar_pago;
 		this.id_transaccion_cobrar_debito=id_transaccion_cobrar_debito;
 		this.id_transaccion_cobrar_credito=id_transaccion_cobrar_credito;
 		this.id_transaccion_pagar_pago=id_transaccion_pagar_pago;
 		this.id_transaccion_pagar_debito=id_transaccion_pagar_debito;
 		this.id_transaccion_pagar_credito=id_transaccion_pagar_credito;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroTesoreria parametrotesoreriaLocal=null;
		
		if(object!=null) {
			parametrotesoreriaLocal=(ParametroTesoreria)object;
			
			if(parametrotesoreriaLocal!=null) {
				if(this.getId()!=null && parametrotesoreriaLocal.getId()!=null) {
					if(this.getId().equals(parametrotesoreriaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroTesoreriaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroTesoreriaConstantesFunciones.getParametroTesoreriaDescripcion(this);
		} else {
			sDetalle=ParametroTesoreriaConstantesFunciones.getParametroTesoreriaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroTesoreria getParametroTesoreriaOriginal() {
		return this.parametrotesoreriaOriginal;
	}
	
	public void setParametroTesoreriaOriginal(ParametroTesoreria parametrotesoreria) {
		try {
			this.parametrotesoreriaOriginal=parametrotesoreria;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroTesoreriaAdditional parametrotesoreriaAdditional=null;
	
	public ParametroTesoreriaAdditional getParametroTesoreriaAdditional() {
		return this.parametrotesoreriaAdditional;
	}
	
	public void setParametroTesoreriaAdditional(ParametroTesoreriaAdditional parametrotesoreriaAdditional) {
		try {
			this.parametrotesoreriaAdditional=parametrotesoreriaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Boolean getcon_anticipo_orden_compra() {
		return this.con_anticipo_orden_compra;
	}
    
	
	public Boolean getpor_lotes() {
		return this.por_lotes;
	}
    
	
	public Long getid_transaccion_cobrar_pago() {
		return this.id_transaccion_cobrar_pago;
	}
    
	
	public Long getid_transaccion_cobrar_debito() {
		return this.id_transaccion_cobrar_debito;
	}
    
	
	public Long getid_transaccion_cobrar_credito() {
		return this.id_transaccion_cobrar_credito;
	}
    
	
	public Long getid_transaccion_pagar_pago() {
		return this.id_transaccion_pagar_pago;
	}
    
	
	public Long getid_transaccion_pagar_debito() {
		return this.id_transaccion_pagar_debito;
	}
    
	
	public Long getid_transaccion_pagar_credito() {
		return this.id_transaccion_pagar_credito;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_anticipo_orden_compra(Boolean newcon_anticipo_orden_compra)throws Exception
	{
		try {
			if(this.con_anticipo_orden_compra!=newcon_anticipo_orden_compra) {
				if(newcon_anticipo_orden_compra==null) {
					//newcon_anticipo_orden_compra=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna con_anticipo_orden_compra");
					}
				}

				this.con_anticipo_orden_compra=newcon_anticipo_orden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpor_lotes(Boolean newpor_lotes)throws Exception
	{
		try {
			if(this.por_lotes!=newpor_lotes) {
				if(newpor_lotes==null) {
					//newpor_lotes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna por_lotes");
					}
				}

				this.por_lotes=newpor_lotes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cobrar_pago(Long newid_transaccion_cobrar_pago)throws Exception
	{
		try {
			if(this.id_transaccion_cobrar_pago!=newid_transaccion_cobrar_pago) {
				if(newid_transaccion_cobrar_pago==null) {
					//newid_transaccion_cobrar_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_transaccion_cobrar_pago");
					}
				}

				this.id_transaccion_cobrar_pago=newid_transaccion_cobrar_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cobrar_debito(Long newid_transaccion_cobrar_debito)throws Exception
	{
		try {
			if(this.id_transaccion_cobrar_debito!=newid_transaccion_cobrar_debito) {
				if(newid_transaccion_cobrar_debito==null) {
					//newid_transaccion_cobrar_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_transaccion_cobrar_debito");
					}
				}

				this.id_transaccion_cobrar_debito=newid_transaccion_cobrar_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cobrar_credito(Long newid_transaccion_cobrar_credito)throws Exception
	{
		try {
			if(this.id_transaccion_cobrar_credito!=newid_transaccion_cobrar_credito) {
				if(newid_transaccion_cobrar_credito==null) {
					//newid_transaccion_cobrar_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_transaccion_cobrar_credito");
					}
				}

				this.id_transaccion_cobrar_credito=newid_transaccion_cobrar_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_pagar_pago(Long newid_transaccion_pagar_pago)throws Exception
	{
		try {
			if(this.id_transaccion_pagar_pago!=newid_transaccion_pagar_pago) {
				if(newid_transaccion_pagar_pago==null) {
					//newid_transaccion_pagar_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_transaccion_pagar_pago");
					}
				}

				this.id_transaccion_pagar_pago=newid_transaccion_pagar_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_pagar_debito(Long newid_transaccion_pagar_debito)throws Exception
	{
		try {
			if(this.id_transaccion_pagar_debito!=newid_transaccion_pagar_debito) {
				if(newid_transaccion_pagar_debito==null) {
					//newid_transaccion_pagar_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_transaccion_pagar_debito");
					}
				}

				this.id_transaccion_pagar_debito=newid_transaccion_pagar_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_pagar_credito(Long newid_transaccion_pagar_credito)throws Exception
	{
		try {
			if(this.id_transaccion_pagar_credito!=newid_transaccion_pagar_credito) {
				if(newid_transaccion_pagar_credito==null) {
					//newid_transaccion_pagar_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna id_transaccion_pagar_credito");
					}
				}

				this.id_transaccion_pagar_credito=newid_transaccion_pagar_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroTesoreria:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("ParametroTesoreria:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Transaccion getTransaccionCobrarPago() {
		return this.transaccioncobrarpago;
	}

	public Transaccion getTransaccionCobrarDebito() {
		return this.transaccioncobrardebito;
	}

	public Transaccion getTransaccionCobrarCredito() {
		return this.transaccioncobrarcredito;
	}

	public Transaccion getTransaccionPagarPago() {
		return this.transaccionpagarpago;
	}

	public Transaccion getTransaccionPagarDebito() {
		return this.transaccionpagardebito;
	}

	public Transaccion getTransaccionPagarCredito() {
		return this.transaccionpagarcredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettransaccioncobrarpago_descripcion() {
		return this.transaccioncobrarpago_descripcion;
	}

	public String gettransaccioncobrardebito_descripcion() {
		return this.transaccioncobrardebito_descripcion;
	}

	public String gettransaccioncobrarcredito_descripcion() {
		return this.transaccioncobrarcredito_descripcion;
	}

	public String gettransaccionpagarpago_descripcion() {
		return this.transaccionpagarpago_descripcion;
	}

	public String gettransaccionpagardebito_descripcion() {
		return this.transaccionpagardebito_descripcion;
	}

	public String gettransaccionpagarcredito_descripcion() {
		return this.transaccionpagarcredito_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCobrarPago(Transaccion transaccioncobrarpago) {
		try {
			this.transaccioncobrarpago=transaccioncobrarpago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCobrarDebito(Transaccion transaccioncobrardebito) {
		try {
			this.transaccioncobrardebito=transaccioncobrardebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCobrarCredito(Transaccion transaccioncobrarcredito) {
		try {
			this.transaccioncobrarcredito=transaccioncobrarcredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionPagarPago(Transaccion transaccionpagarpago) {
		try {
			this.transaccionpagarpago=transaccionpagarpago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionPagarDebito(Transaccion transaccionpagardebito) {
		try {
			this.transaccionpagardebito=transaccionpagardebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionPagarCredito(Transaccion transaccionpagarcredito) {
		try {
			this.transaccionpagarcredito=transaccionpagarcredito;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncobrarpago_descripcion(String transaccioncobrarpago_descripcion) {
		try {
			this.transaccioncobrarpago_descripcion=transaccioncobrarpago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncobrardebito_descripcion(String transaccioncobrardebito_descripcion) {
		try {
			this.transaccioncobrardebito_descripcion=transaccioncobrardebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncobrarcredito_descripcion(String transaccioncobrarcredito_descripcion) {
		try {
			this.transaccioncobrarcredito_descripcion=transaccioncobrarcredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionpagarpago_descripcion(String transaccionpagarpago_descripcion) {
		try {
			this.transaccionpagarpago_descripcion=transaccionpagarpago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionpagardebito_descripcion(String transaccionpagardebito_descripcion) {
		try {
			this.transaccionpagardebito_descripcion=transaccionpagardebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionpagarcredito_descripcion(String transaccionpagarcredito_descripcion) {
		try {
			this.transaccionpagarcredito_descripcion=transaccionpagarcredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String con_anticipo_orden_compra_descripcion="";String por_lotes_descripcion="";String id_transaccion_cobrar_pago_descripcion="";String id_transaccion_cobrar_debito_descripcion="";String id_transaccion_cobrar_credito_descripcion="";String id_transaccion_pagar_pago_descripcion="";String id_transaccion_pagar_debito_descripcion="";String id_transaccion_pagar_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getcon_anticipo_orden_compra_descripcion() {
		return con_anticipo_orden_compra_descripcion;
	}
	public String getpor_lotes_descripcion() {
		return por_lotes_descripcion;
	}
	public String getid_transaccion_cobrar_pago_descripcion() {
		return id_transaccion_cobrar_pago_descripcion;
	}
	public String getid_transaccion_cobrar_debito_descripcion() {
		return id_transaccion_cobrar_debito_descripcion;
	}
	public String getid_transaccion_cobrar_credito_descripcion() {
		return id_transaccion_cobrar_credito_descripcion;
	}
	public String getid_transaccion_pagar_pago_descripcion() {
		return id_transaccion_pagar_pago_descripcion;
	}
	public String getid_transaccion_pagar_debito_descripcion() {
		return id_transaccion_pagar_debito_descripcion;
	}
	public String getid_transaccion_pagar_credito_descripcion() {
		return id_transaccion_pagar_credito_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_anticipo_orden_compra_descripcion(String newcon_anticipo_orden_compra_descripcion)throws Exception {
		try {
			this.con_anticipo_orden_compra_descripcion=newcon_anticipo_orden_compra_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpor_lotes_descripcion(String newpor_lotes_descripcion)throws Exception {
		try {
			this.por_lotes_descripcion=newpor_lotes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cobrar_pago_descripcion(String newid_transaccion_cobrar_pago_descripcion)throws Exception {
		try {
			this.id_transaccion_cobrar_pago_descripcion=newid_transaccion_cobrar_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cobrar_debito_descripcion(String newid_transaccion_cobrar_debito_descripcion)throws Exception {
		try {
			this.id_transaccion_cobrar_debito_descripcion=newid_transaccion_cobrar_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cobrar_credito_descripcion(String newid_transaccion_cobrar_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_cobrar_credito_descripcion=newid_transaccion_cobrar_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_pagar_pago_descripcion(String newid_transaccion_pagar_pago_descripcion)throws Exception {
		try {
			this.id_transaccion_pagar_pago_descripcion=newid_transaccion_pagar_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_pagar_debito_descripcion(String newid_transaccion_pagar_debito_descripcion)throws Exception {
		try {
			this.id_transaccion_pagar_debito_descripcion=newid_transaccion_pagar_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_pagar_credito_descripcion(String newid_transaccion_pagar_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_pagar_credito_descripcion=newid_transaccion_pagar_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.con_anticipo_orden_compra_descripcion="";this.por_lotes_descripcion="";this.id_transaccion_cobrar_pago_descripcion="";this.id_transaccion_cobrar_debito_descripcion="";this.id_transaccion_cobrar_credito_descripcion="";this.id_transaccion_pagar_pago_descripcion="";this.id_transaccion_pagar_debito_descripcion="";this.id_transaccion_pagar_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

