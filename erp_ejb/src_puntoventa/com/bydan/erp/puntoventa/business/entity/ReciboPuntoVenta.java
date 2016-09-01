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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.ReciboPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ReciboPuntoVenta extends ReciboPuntoVentaAdditional implements Serializable ,Cloneable {//ReciboPuntoVentaAdditional,GeneralEntity
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
	
	private ReciboPuntoVenta recibopuntoventaOriginal;
	
	private Map<String, Object> mapReciboPuntoVenta;
			
	public Map<String, Object> getMapReciboPuntoVenta() {
		return mapReciboPuntoVenta;
	}

	public void setMapReciboPuntoVenta(Map<String, Object> mapReciboPuntoVenta) {
		this.mapReciboPuntoVenta = mapReciboPuntoVenta;
	}
	
	public void inicializarMapReciboPuntoVenta() {
		this.mapReciboPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapReciboPuntoVentaValue(String sKey,Object oValue) {
		this.mapReciboPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapReciboPuntoVentaValue(String sKey) {
		return this.mapReciboPuntoVenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_efectivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReciboPuntoVentaConstantesFunciones.SREGEXNUMERO_CHEQUE,message=ReciboPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Cliente cliente;
	public Banco banco;
	
	
	private String cliente_descripcion;
	private String banco_descripcion;
	
	
		
	public ReciboPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.recibopuntoventaOriginal=this;
		
 		this.id_cliente=-1L;
 		this.id_banco=-1L;
 		this.valor_efectivo=0.0;
 		this.valor_cheque=0.0;
 		this.numero_cheque="";
 		this.fecha=new Date();
		
		
		this.cliente=null;
		this.banco=null;
		
		
		this.cliente_descripcion="";
		this.banco_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ReciboPuntoVenta (Long id,Date versionRow,Long id_cliente,Long id_banco,Double valor_efectivo,Double valor_cheque,String numero_cheque,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.recibopuntoventaOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_banco=id_banco;
 		this.valor_efectivo=valor_efectivo;
 		this.valor_cheque=valor_cheque;
 		this.numero_cheque=numero_cheque;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ReciboPuntoVenta (Long id_cliente,Long id_banco,Double valor_efectivo,Double valor_cheque,String numero_cheque,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.recibopuntoventaOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_banco=id_banco;
 		this.valor_efectivo=valor_efectivo;
 		this.valor_cheque=valor_cheque;
 		this.numero_cheque=numero_cheque;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ReciboPuntoVenta recibopuntoventaLocal=null;
		
		if(object!=null) {
			recibopuntoventaLocal=(ReciboPuntoVenta)object;
			
			if(recibopuntoventaLocal!=null) {
				if(this.getId()!=null && recibopuntoventaLocal.getId()!=null) {
					if(this.getId().equals(recibopuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ReciboPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ReciboPuntoVentaConstantesFunciones.getReciboPuntoVentaDescripcion(this);
		} else {
			sDetalle=ReciboPuntoVentaConstantesFunciones.getReciboPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ReciboPuntoVenta getReciboPuntoVentaOriginal() {
		return this.recibopuntoventaOriginal;
	}
	
	public void setReciboPuntoVentaOriginal(ReciboPuntoVenta recibopuntoventa) {
		try {
			this.recibopuntoventaOriginal=recibopuntoventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ReciboPuntoVentaAdditional recibopuntoventaAdditional=null;
	
	public ReciboPuntoVentaAdditional getReciboPuntoVentaAdditional() {
		return this.recibopuntoventaAdditional;
	}
	
	public void setReciboPuntoVentaAdditional(ReciboPuntoVentaAdditional recibopuntoventaAdditional) {
		try {
			this.recibopuntoventaAdditional=recibopuntoventaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Double getvalor_efectivo() {
		return this.valor_efectivo;
	}
    
	
	public Double getvalor_cheque() {
		return this.valor_cheque;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReciboPuntoVenta:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco(Long newid_banco)throws Exception
	{
		try {
			if(this.id_banco!=newid_banco) {
				if(newid_banco==null) {
					//newid_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReciboPuntoVenta:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_efectivo(Double newvalor_efectivo)throws Exception
	{
		try {
			if(this.valor_efectivo!=newvalor_efectivo) {
				if(newvalor_efectivo==null) {
					//newvalor_efectivo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReciboPuntoVenta:Valor nulo no permitido en columna valor_efectivo");
					}
				}

				this.valor_efectivo=newvalor_efectivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cheque(Double newvalor_cheque)throws Exception
	{
		try {
			if(this.valor_cheque!=newvalor_cheque) {
				if(newvalor_cheque==null) {
					//newvalor_cheque=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReciboPuntoVenta:Valor nulo no permitido en columna valor_cheque");
					}
				}

				this.valor_cheque=newvalor_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque(String newnumero_cheque)throws Exception
	{
		try {
			if(this.numero_cheque!=newnumero_cheque) {
				if(newnumero_cheque==null) {
					//newnumero_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReciboPuntoVenta:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("ReciboPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReciboPuntoVenta:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public Banco getBanco() {
		return this.banco;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cliente_descripcion="";String id_banco_descripcion="";
	
	
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	
	
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_banco_descripcion(String newid_banco_descripcion)throws Exception {
		try {
			this.id_banco_descripcion=newid_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_cliente_descripcion="";this.id_banco_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

