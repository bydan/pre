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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.TransaccionClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class TransaccionCliente extends TransaccionClienteAdditional implements Serializable ,Cloneable {//TransaccionClienteAdditional,GeneralEntity
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
	
	private TransaccionCliente transaccionclienteOriginal;
	
	private Map<String, Object> mapTransaccionCliente;
			
	public Map<String, Object> getMapTransaccionCliente() {
		return mapTransaccionCliente;
	}

	public void setMapTransaccionCliente(Map<String, Object> mapTransaccionCliente) {
		this.mapTransaccionCliente = mapTransaccionCliente;
	}
	
	public void inicializarMapTransaccionCliente() {
		this.mapTransaccionCliente = new HashMap<String,Object>();
	}
	
	public void setMapTransaccionClienteValue(String sKey,Object oValue) {
		this.mapTransaccionCliente.put(sKey, oValue);
	}
	
	public Object getMapTransaccionClienteValue(String sKey) {
		return this.mapTransaccionCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionClienteConstantesFunciones.SREGEXNOMBRE,message=TransaccionClienteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion1;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion2;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion3;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion4;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion5;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public Transaccion transaccion1;
	public Transaccion transaccion2;
	public Transaccion transaccion3;
	public Transaccion transaccion4;
	public Transaccion transaccion5;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String transaccion1_descripcion;
	private String transaccion2_descripcion;
	private String transaccion3_descripcion;
	private String transaccion4_descripcion;
	private String transaccion5_descripcion;
	
	
		
	public TransaccionCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transaccionclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.nombre="";
 		this.id_transaccion1=-1L;
 		this.id_transaccion2=null;
 		this.id_transaccion3=null;
 		this.id_transaccion4=null;
 		this.id_transaccion5=null;
		
		
		this.empresa=null;
		this.modulo=null;
		this.transaccion1=null;
		this.transaccion2=null;
		this.transaccion3=null;
		this.transaccion4=null;
		this.transaccion5=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.transaccion1_descripcion="";
		this.transaccion2_descripcion="";
		this.transaccion3_descripcion="";
		this.transaccion4_descripcion="";
		this.transaccion5_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TransaccionCliente (Long id,Date versionRow,Long id_empresa,Long id_modulo,String nombre,Long id_transaccion1,Long id_transaccion2,Long id_transaccion3,Long id_transaccion4,Long id_transaccion5) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccionclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.id_transaccion1=id_transaccion1;
 		this.id_transaccion2=id_transaccion2;
 		this.id_transaccion3=id_transaccion3;
 		this.id_transaccion4=id_transaccion4;
 		this.id_transaccion5=id_transaccion5;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TransaccionCliente (Long id_empresa,Long id_modulo,String nombre,Long id_transaccion1,Long id_transaccion2,Long id_transaccion3,Long id_transaccion4,Long id_transaccion5) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccionclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.id_transaccion1=id_transaccion1;
 		this.id_transaccion2=id_transaccion2;
 		this.id_transaccion3=id_transaccion3;
 		this.id_transaccion4=id_transaccion4;
 		this.id_transaccion5=id_transaccion5;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TransaccionCliente transaccionclienteLocal=null;
		
		if(object!=null) {
			transaccionclienteLocal=(TransaccionCliente)object;
			
			if(transaccionclienteLocal!=null) {
				if(this.getId()!=null && transaccionclienteLocal.getId()!=null) {
					if(this.getId().equals(transaccionclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TransaccionClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TransaccionClienteConstantesFunciones.getTransaccionClienteDescripcion(this);
		} else {
			sDetalle=TransaccionClienteConstantesFunciones.getTransaccionClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TransaccionCliente getTransaccionClienteOriginal() {
		return this.transaccionclienteOriginal;
	}
	
	public void setTransaccionClienteOriginal(TransaccionCliente transaccioncliente) {
		try {
			this.transaccionclienteOriginal=transaccioncliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransaccionClienteAdditional transaccionclienteAdditional=null;
	
	public TransaccionClienteAdditional getTransaccionClienteAdditional() {
		return this.transaccionclienteAdditional;
	}
	
	public void setTransaccionClienteAdditional(TransaccionClienteAdditional transaccionclienteAdditional) {
		try {
			this.transaccionclienteAdditional=transaccionclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_transaccion1() {
		return this.id_transaccion1;
	}
    
	
	public Long getid_transaccion2() {
		return this.id_transaccion2;
	}
    
	
	public Long getid_transaccion3() {
		return this.id_transaccion3;
	}
    
	
	public Long getid_transaccion4() {
		return this.id_transaccion4;
	}
    
	
	public Long getid_transaccion5() {
		return this.id_transaccion5;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionCliente:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionCliente:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TransaccionCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion1(Long newid_transaccion1)throws Exception
	{
		try {
			if(this.id_transaccion1!=newid_transaccion1) {
				if(newid_transaccion1==null) {
					//newid_transaccion1=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionCliente:Valor nulo no permitido en columna id_transaccion1");
					}
				}

				this.id_transaccion1=newid_transaccion1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion2(Long newid_transaccion2) {
		if(this.id_transaccion2==null&&newid_transaccion2!=null) {
			this.id_transaccion2=newid_transaccion2;
				this.setIsChanged(true);
		}

		if(this.id_transaccion2!=null&&!this.id_transaccion2.equals(newid_transaccion2)) {

			this.id_transaccion2=newid_transaccion2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion3(Long newid_transaccion3) {
		if(this.id_transaccion3==null&&newid_transaccion3!=null) {
			this.id_transaccion3=newid_transaccion3;
				this.setIsChanged(true);
		}

		if(this.id_transaccion3!=null&&!this.id_transaccion3.equals(newid_transaccion3)) {

			this.id_transaccion3=newid_transaccion3;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion4(Long newid_transaccion4) {
		if(this.id_transaccion4==null&&newid_transaccion4!=null) {
			this.id_transaccion4=newid_transaccion4;
				this.setIsChanged(true);
		}

		if(this.id_transaccion4!=null&&!this.id_transaccion4.equals(newid_transaccion4)) {

			this.id_transaccion4=newid_transaccion4;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion5(Long newid_transaccion5) {
		if(this.id_transaccion5==null&&newid_transaccion5!=null) {
			this.id_transaccion5=newid_transaccion5;
				this.setIsChanged(true);
		}

		if(this.id_transaccion5!=null&&!this.id_transaccion5.equals(newid_transaccion5)) {

			this.id_transaccion5=newid_transaccion5;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Transaccion getTransaccion1() {
		return this.transaccion1;
	}

	public Transaccion getTransaccion2() {
		return this.transaccion2;
	}

	public Transaccion getTransaccion3() {
		return this.transaccion3;
	}

	public Transaccion getTransaccion4() {
		return this.transaccion4;
	}

	public Transaccion getTransaccion5() {
		return this.transaccion5;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettransaccion1_descripcion() {
		return this.transaccion1_descripcion;
	}

	public String gettransaccion2_descripcion() {
		return this.transaccion2_descripcion;
	}

	public String gettransaccion3_descripcion() {
		return this.transaccion3_descripcion;
	}

	public String gettransaccion4_descripcion() {
		return this.transaccion4_descripcion;
	}

	public String gettransaccion5_descripcion() {
		return this.transaccion5_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion1(Transaccion transaccion1) {
		try {
			this.transaccion1=transaccion1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion2(Transaccion transaccion2) {
		try {
			this.transaccion2=transaccion2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion3(Transaccion transaccion3) {
		try {
			this.transaccion3=transaccion3;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion4(Transaccion transaccion4) {
		try {
			this.transaccion4=transaccion4;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion5(Transaccion transaccion5) {
		try {
			this.transaccion5=transaccion5;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion1_descripcion(String transaccion1_descripcion) {
		try {
			this.transaccion1_descripcion=transaccion1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion2_descripcion(String transaccion2_descripcion) {
		try {
			this.transaccion2_descripcion=transaccion2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion3_descripcion(String transaccion3_descripcion) {
		try {
			this.transaccion3_descripcion=transaccion3_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion4_descripcion(String transaccion4_descripcion) {
		try {
			this.transaccion4_descripcion=transaccion4_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion5_descripcion(String transaccion5_descripcion) {
		try {
			this.transaccion5_descripcion=transaccion5_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_transaccion1_descripcion="";String id_transaccion2_descripcion="";String id_transaccion3_descripcion="";String id_transaccion4_descripcion="";String id_transaccion5_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_transaccion1_descripcion() {
		return id_transaccion1_descripcion;
	}
	public String getid_transaccion2_descripcion() {
		return id_transaccion2_descripcion;
	}
	public String getid_transaccion3_descripcion() {
		return id_transaccion3_descripcion;
	}
	public String getid_transaccion4_descripcion() {
		return id_transaccion4_descripcion;
	}
	public String getid_transaccion5_descripcion() {
		return id_transaccion5_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion1_descripcion(String newid_transaccion1_descripcion)throws Exception {
		try {
			this.id_transaccion1_descripcion=newid_transaccion1_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion2_descripcion(String newid_transaccion2_descripcion) {
		this.id_transaccion2_descripcion=newid_transaccion2_descripcion;
	}
	public void setid_transaccion3_descripcion(String newid_transaccion3_descripcion) {
		this.id_transaccion3_descripcion=newid_transaccion3_descripcion;
	}
	public void setid_transaccion4_descripcion(String newid_transaccion4_descripcion) {
		this.id_transaccion4_descripcion=newid_transaccion4_descripcion;
	}
	public void setid_transaccion5_descripcion(String newid_transaccion5_descripcion) {
		this.id_transaccion5_descripcion=newid_transaccion5_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_transaccion1_descripcion="";this.id_transaccion2_descripcion="";this.id_transaccion3_descripcion="";this.id_transaccion4_descripcion="";this.id_transaccion5_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

