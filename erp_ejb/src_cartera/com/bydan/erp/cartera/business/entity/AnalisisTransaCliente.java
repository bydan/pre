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
//import com.bydan.erp.cartera.util.AnalisisTransaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class AnalisisTransaCliente extends AnalisisTransaClienteAdditional implements Serializable ,Cloneable {//AnalisisTransaClienteAdditional,GeneralEntity
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
	
	private AnalisisTransaCliente analisistransaclienteOriginal;
	
	private Map<String, Object> mapAnalisisTransaCliente;
			
	public Map<String, Object> getMapAnalisisTransaCliente() {
		return mapAnalisisTransaCliente;
	}

	public void setMapAnalisisTransaCliente(Map<String, Object> mapAnalisisTransaCliente) {
		this.mapAnalisisTransaCliente = mapAnalisisTransaCliente;
	}
	
	public void inicializarMapAnalisisTransaCliente() {
		this.mapAnalisisTransaCliente = new HashMap<String,Object>();
	}
	
	public void setMapAnalisisTransaClienteValue(String sKey,Object oValue) {
		this.mapAnalisisTransaCliente.put(sKey, oValue);
	}
	
	public Object getMapAnalisisTransaClienteValue(String sKey) {
		return this.mapAnalisisTransaCliente.get(sKey);
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
	@Pattern(regex=AnalisisTransaClienteConstantesFunciones.SREGEXNOMBRE,message=AnalisisTransaClienteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AnalisisTransaClienteConstantesFunciones.SREGEXDESCRIPCION,message=AnalisisTransaClienteConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion1;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion2;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion3;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion4;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion5;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion6;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion7;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion8;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion9;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transaccion10;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public Transaccion transaccion;
	public Transaccion transaccion1;
	public Transaccion transaccion2;
	public Transaccion transaccion3;
	public Transaccion transaccion4;
	public Transaccion transaccion5;
	public Transaccion transaccion6;
	public Transaccion transaccion7;
	public Transaccion transaccion8;
	public Transaccion transaccion9;
	public Transaccion transaccion10;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String transaccion_descripcion;
	private String transaccion1_descripcion;
	private String transaccion2_descripcion;
	private String transaccion3_descripcion;
	private String transaccion4_descripcion;
	private String transaccion5_descripcion;
	private String transaccion6_descripcion;
	private String transaccion7_descripcion;
	private String transaccion8_descripcion;
	private String transaccion9_descripcion;
	private String transaccion10_descripcion;
	
	
		
	public AnalisisTransaCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.analisistransaclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.nombre="";
 		this.descripcion="";
 		this.id_transaccion=-1L;
 		this.id_transaccion1=null;
 		this.id_transaccion2=null;
 		this.id_transaccion3=null;
 		this.id_transaccion4=null;
 		this.id_transaccion5=null;
 		this.id_transaccion6=null;
 		this.id_transaccion7=null;
 		this.id_transaccion8=null;
 		this.id_transaccion9=null;
 		this.id_transaccion10=null;
		
		
		this.empresa=null;
		this.modulo=null;
		this.transaccion=null;
		this.transaccion1=null;
		this.transaccion2=null;
		this.transaccion3=null;
		this.transaccion4=null;
		this.transaccion5=null;
		this.transaccion6=null;
		this.transaccion7=null;
		this.transaccion8=null;
		this.transaccion9=null;
		this.transaccion10=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.transaccion_descripcion="";
		this.transaccion1_descripcion="";
		this.transaccion2_descripcion="";
		this.transaccion3_descripcion="";
		this.transaccion4_descripcion="";
		this.transaccion5_descripcion="";
		this.transaccion6_descripcion="";
		this.transaccion7_descripcion="";
		this.transaccion8_descripcion="";
		this.transaccion9_descripcion="";
		this.transaccion10_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AnalisisTransaCliente (Long id,Date versionRow,Long id_empresa,Long id_modulo,String nombre,String descripcion,Long id_transaccion,Long id_transaccion1,Long id_transaccion2,Long id_transaccion3,Long id_transaccion4,Long id_transaccion5,Long id_transaccion6,Long id_transaccion7,Long id_transaccion8,Long id_transaccion9,Long id_transaccion10) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.analisistransaclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
 		this.id_transaccion=id_transaccion;
 		this.id_transaccion1=id_transaccion1;
 		this.id_transaccion2=id_transaccion2;
 		this.id_transaccion3=id_transaccion3;
 		this.id_transaccion4=id_transaccion4;
 		this.id_transaccion5=id_transaccion5;
 		this.id_transaccion6=id_transaccion6;
 		this.id_transaccion7=id_transaccion7;
 		this.id_transaccion8=id_transaccion8;
 		this.id_transaccion9=id_transaccion9;
 		this.id_transaccion10=id_transaccion10;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AnalisisTransaCliente (Long id_empresa,Long id_modulo,String nombre,String descripcion,Long id_transaccion,Long id_transaccion1,Long id_transaccion2,Long id_transaccion3,Long id_transaccion4,Long id_transaccion5,Long id_transaccion6,Long id_transaccion7,Long id_transaccion8,Long id_transaccion9,Long id_transaccion10) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.analisistransaclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
 		this.id_transaccion=id_transaccion;
 		this.id_transaccion1=id_transaccion1;
 		this.id_transaccion2=id_transaccion2;
 		this.id_transaccion3=id_transaccion3;
 		this.id_transaccion4=id_transaccion4;
 		this.id_transaccion5=id_transaccion5;
 		this.id_transaccion6=id_transaccion6;
 		this.id_transaccion7=id_transaccion7;
 		this.id_transaccion8=id_transaccion8;
 		this.id_transaccion9=id_transaccion9;
 		this.id_transaccion10=id_transaccion10;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AnalisisTransaCliente analisistransaclienteLocal=null;
		
		if(object!=null) {
			analisistransaclienteLocal=(AnalisisTransaCliente)object;
			
			if(analisistransaclienteLocal!=null) {
				if(this.getId()!=null && analisistransaclienteLocal.getId()!=null) {
					if(this.getId().equals(analisistransaclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AnalisisTransaClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AnalisisTransaClienteConstantesFunciones.getAnalisisTransaClienteDescripcion(this);
		} else {
			sDetalle=AnalisisTransaClienteConstantesFunciones.getAnalisisTransaClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AnalisisTransaCliente getAnalisisTransaClienteOriginal() {
		return this.analisistransaclienteOriginal;
	}
	
	public void setAnalisisTransaClienteOriginal(AnalisisTransaCliente analisistransacliente) {
		try {
			this.analisistransaclienteOriginal=analisistransacliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AnalisisTransaClienteAdditional analisistransaclienteAdditional=null;
	
	public AnalisisTransaClienteAdditional getAnalisisTransaClienteAdditional() {
		return this.analisistransaclienteAdditional;
	}
	
	public void setAnalisisTransaClienteAdditional(AnalisisTransaClienteAdditional analisistransaclienteAdditional) {
		try {
			this.analisistransaclienteAdditional=analisistransaclienteAdditional;
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
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
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
    
	
	public Long getid_transaccion6() {
		return this.id_transaccion6;
	}
    
	
	public Long getid_transaccion7() {
		return this.id_transaccion7;
	}
    
	
	public Long getid_transaccion8() {
		return this.id_transaccion8;
	}
    
	
	public Long getid_transaccion9() {
		return this.id_transaccion9;
	}
    
	
	public Long getid_transaccion10() {
		return this.id_transaccion10;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnalisisTransaCliente:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AnalisisTransaCliente:Valor nulo no permitido en columna id_modulo");
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
						System.out.println("AnalisisTransaCliente:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("AnalisisTransaCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("AnalisisTransaCliente:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("AnalisisTransaCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AnalisisTransaCliente:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion1(Long newid_transaccion1) {
		if(this.id_transaccion1==null&&newid_transaccion1!=null) {
			this.id_transaccion1=newid_transaccion1;
				this.setIsChanged(true);
		}

		if(this.id_transaccion1!=null&&!this.id_transaccion1.equals(newid_transaccion1)) {

			this.id_transaccion1=newid_transaccion1;
				this.setIsChanged(true);
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
    
	public void setid_transaccion6(Long newid_transaccion6) {
		if(this.id_transaccion6==null&&newid_transaccion6!=null) {
			this.id_transaccion6=newid_transaccion6;
				this.setIsChanged(true);
		}

		if(this.id_transaccion6!=null&&!this.id_transaccion6.equals(newid_transaccion6)) {

			this.id_transaccion6=newid_transaccion6;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion7(Long newid_transaccion7) {
		if(this.id_transaccion7==null&&newid_transaccion7!=null) {
			this.id_transaccion7=newid_transaccion7;
				this.setIsChanged(true);
		}

		if(this.id_transaccion7!=null&&!this.id_transaccion7.equals(newid_transaccion7)) {

			this.id_transaccion7=newid_transaccion7;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion8(Long newid_transaccion8) {
		if(this.id_transaccion8==null&&newid_transaccion8!=null) {
			this.id_transaccion8=newid_transaccion8;
				this.setIsChanged(true);
		}

		if(this.id_transaccion8!=null&&!this.id_transaccion8.equals(newid_transaccion8)) {

			this.id_transaccion8=newid_transaccion8;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion9(Long newid_transaccion9) {
		if(this.id_transaccion9==null&&newid_transaccion9!=null) {
			this.id_transaccion9=newid_transaccion9;
				this.setIsChanged(true);
		}

		if(this.id_transaccion9!=null&&!this.id_transaccion9.equals(newid_transaccion9)) {

			this.id_transaccion9=newid_transaccion9;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transaccion10(Long newid_transaccion10) {
		if(this.id_transaccion10==null&&newid_transaccion10!=null) {
			this.id_transaccion10=newid_transaccion10;
				this.setIsChanged(true);
		}

		if(this.id_transaccion10!=null&&!this.id_transaccion10.equals(newid_transaccion10)) {

			this.id_transaccion10=newid_transaccion10;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
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

	public Transaccion getTransaccion6() {
		return this.transaccion6;
	}

	public Transaccion getTransaccion7() {
		return this.transaccion7;
	}

	public Transaccion getTransaccion8() {
		return this.transaccion8;
	}

	public Transaccion getTransaccion9() {
		return this.transaccion9;
	}

	public Transaccion getTransaccion10() {
		return this.transaccion10;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
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

	public String gettransaccion6_descripcion() {
		return this.transaccion6_descripcion;
	}

	public String gettransaccion7_descripcion() {
		return this.transaccion7_descripcion;
	}

	public String gettransaccion8_descripcion() {
		return this.transaccion8_descripcion;
	}

	public String gettransaccion9_descripcion() {
		return this.transaccion9_descripcion;
	}

	public String gettransaccion10_descripcion() {
		return this.transaccion10_descripcion;
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


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  setTransaccion6(Transaccion transaccion6) {
		try {
			this.transaccion6=transaccion6;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion7(Transaccion transaccion7) {
		try {
			this.transaccion7=transaccion7;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion8(Transaccion transaccion8) {
		try {
			this.transaccion8=transaccion8;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion9(Transaccion transaccion9) {
		try {
			this.transaccion9=transaccion9;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion10(Transaccion transaccion10) {
		try {
			this.transaccion10=transaccion10;
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


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
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


	public  void  settransaccion6_descripcion(String transaccion6_descripcion) {
		try {
			this.transaccion6_descripcion=transaccion6_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion7_descripcion(String transaccion7_descripcion) {
		try {
			this.transaccion7_descripcion=transaccion7_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion8_descripcion(String transaccion8_descripcion) {
		try {
			this.transaccion8_descripcion=transaccion8_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion9_descripcion(String transaccion9_descripcion) {
		try {
			this.transaccion9_descripcion=transaccion9_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion10_descripcion(String transaccion10_descripcion) {
		try {
			this.transaccion10_descripcion=transaccion10_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_transaccion_descripcion="";String id_transaccion1_descripcion="";String id_transaccion2_descripcion="";String id_transaccion3_descripcion="";String id_transaccion4_descripcion="";String id_transaccion5_descripcion="";String id_transaccion6_descripcion="";String id_transaccion7_descripcion="";String id_transaccion8_descripcion="";String id_transaccion9_descripcion="";String id_transaccion10_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
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
	public String getid_transaccion6_descripcion() {
		return id_transaccion6_descripcion;
	}
	public String getid_transaccion7_descripcion() {
		return id_transaccion7_descripcion;
	}
	public String getid_transaccion8_descripcion() {
		return id_transaccion8_descripcion;
	}
	public String getid_transaccion9_descripcion() {
		return id_transaccion9_descripcion;
	}
	public String getid_transaccion10_descripcion() {
		return id_transaccion10_descripcion;
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
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion1_descripcion(String newid_transaccion1_descripcion) {
		this.id_transaccion1_descripcion=newid_transaccion1_descripcion;
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
	public void setid_transaccion6_descripcion(String newid_transaccion6_descripcion) {
		this.id_transaccion6_descripcion=newid_transaccion6_descripcion;
	}
	public void setid_transaccion7_descripcion(String newid_transaccion7_descripcion) {
		this.id_transaccion7_descripcion=newid_transaccion7_descripcion;
	}
	public void setid_transaccion8_descripcion(String newid_transaccion8_descripcion) {
		this.id_transaccion8_descripcion=newid_transaccion8_descripcion;
	}
	public void setid_transaccion9_descripcion(String newid_transaccion9_descripcion) {
		this.id_transaccion9_descripcion=newid_transaccion9_descripcion;
	}
	public void setid_transaccion10_descripcion(String newid_transaccion10_descripcion) {
		this.id_transaccion10_descripcion=newid_transaccion10_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_transaccion_descripcion="";this.id_transaccion1_descripcion="";this.id_transaccion2_descripcion="";this.id_transaccion3_descripcion="";this.id_transaccion4_descripcion="";this.id_transaccion5_descripcion="";this.id_transaccion6_descripcion="";this.id_transaccion7_descripcion="";this.id_transaccion8_descripcion="";this.id_transaccion9_descripcion="";this.id_transaccion10_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

