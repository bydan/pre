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
package com.bydan.erp.tesoreria.business.entity.report;

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
//import com.bydan.erp.tesoreria.util.PresupuestosFlujosCajaConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PresupuestosFlujosCaja extends PresupuestosFlujosCajaAdditional implements Serializable ,Cloneable {//PresupuestosFlujosCajaAdditional,GeneralEntity
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
	
	private PresupuestosFlujosCaja presupuestosflujoscajaOriginal;
	
	private Map<String, Object> mapPresupuestosFlujosCaja;
			
	public Map<String, Object> getMapPresupuestosFlujosCaja() {
		return mapPresupuestosFlujosCaja;
	}

	public void setMapPresupuestosFlujosCaja(Map<String, Object> mapPresupuestosFlujosCaja) {
		this.mapPresupuestosFlujosCaja = mapPresupuestosFlujosCaja;
	}
	
	public void inicializarMapPresupuestosFlujosCaja() {
		this.mapPresupuestosFlujosCaja = new HashMap<String,Object>();
	}
	
	public void setMapPresupuestosFlujosCajaValue(String sKey,Object oValue) {
		this.mapPresupuestosFlujosCaja.put(sKey, oValue);
	}
	
	public Object getMapPresupuestosFlujosCajaValue(String sKey) {
		return this.mapPresupuestosFlujosCaja.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PresupuestosFlujosCajaConstantesFunciones.SREGEXCODIGO_CUENTA,message=PresupuestosFlujosCajaConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA)
	private String codigo_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PresupuestosFlujosCajaConstantesFunciones.SREGEXCODIGO,message=PresupuestosFlujosCajaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PresupuestosFlujosCajaConstantesFunciones.SREGEXNOMBRE,message=PresupuestosFlujosCajaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PresupuestosFlujosCajaConstantesFunciones.SREGEXNOMBRE_MODULO,message=PresupuestosFlujosCajaConstantesFunciones.SMENSAJEREGEXNOMBRE_MODULO)
	private String nombre_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor6;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor7;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor8;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor9;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor10;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor11;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor12;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public PresupuestosFlujosCaja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presupuestosflujoscajaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo_cuenta="";
 		this.codigo="";
 		this.nombre="";
 		this.nombre_modulo="";
 		this.valor1=0.0;
 		this.valor2=0.0;
 		this.valor3=0.0;
 		this.valor4=0.0;
 		this.valor5=0.0;
 		this.valor6=0.0;
 		this.valor7=0.0;
 		this.valor8=0.0;
 		this.valor9=0.0;
 		this.valor10=0.0;
 		this.valor11=0.0;
 		this.valor12=0.0;
 		this.total=0.0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresupuestosFlujosCaja (Long id,Date versionRow,String codigo_cuenta,String codigo,String nombre,String nombre_modulo,Double valor1,Double valor2,Double valor3,Double valor4,Double valor5,Double valor6,Double valor7,Double valor8,Double valor9,Double valor10,Double valor11,Double valor12,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presupuestosflujoscajaOriginal=this;
		
 		this.codigo_cuenta=codigo_cuenta;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_modulo=nombre_modulo;
 		this.valor1=valor1;
 		this.valor2=valor2;
 		this.valor3=valor3;
 		this.valor4=valor4;
 		this.valor5=valor5;
 		this.valor6=valor6;
 		this.valor7=valor7;
 		this.valor8=valor8;
 		this.valor9=valor9;
 		this.valor10=valor10;
 		this.valor11=valor11;
 		this.valor12=valor12;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresupuestosFlujosCaja (String codigo_cuenta,String codigo,String nombre,String nombre_modulo,Double valor1,Double valor2,Double valor3,Double valor4,Double valor5,Double valor6,Double valor7,Double valor8,Double valor9,Double valor10,Double valor11,Double valor12,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presupuestosflujoscajaOriginal=this;
		
 		this.codigo_cuenta=codigo_cuenta;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_modulo=nombre_modulo;
 		this.valor1=valor1;
 		this.valor2=valor2;
 		this.valor3=valor3;
 		this.valor4=valor4;
 		this.valor5=valor5;
 		this.valor6=valor6;
 		this.valor7=valor7;
 		this.valor8=valor8;
 		this.valor9=valor9;
 		this.valor10=valor10;
 		this.valor11=valor11;
 		this.valor12=valor12;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public PresupuestosFlujosCaja getPresupuestosFlujosCajaOriginal() {
		return this.presupuestosflujoscajaOriginal;
	}
	
	public void setPresupuestosFlujosCajaOriginal(PresupuestosFlujosCaja presupuestosflujoscaja) {
		try {
			this.presupuestosflujoscajaOriginal=presupuestosflujoscaja;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresupuestosFlujosCajaAdditional presupuestosflujoscajaAdditional=null;
	
	public PresupuestosFlujosCajaAdditional getPresupuestosFlujosCajaAdditional() {
		return this.presupuestosflujoscajaAdditional;
	}
	
	public void setPresupuestosFlujosCajaAdditional(PresupuestosFlujosCajaAdditional presupuestosflujoscajaAdditional) {
		try {
			this.presupuestosflujoscajaAdditional=presupuestosflujoscajaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo_cuenta() {
		return this.codigo_cuenta;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_modulo() {
		return this.nombre_modulo;
	}
    
	
	public Double getvalor1() {
		return this.valor1;
	}
    
	
	public Double getvalor2() {
		return this.valor2;
	}
    
	
	public Double getvalor3() {
		return this.valor3;
	}
    
	
	public Double getvalor4() {
		return this.valor4;
	}
    
	
	public Double getvalor5() {
		return this.valor5;
	}
    
	
	public Double getvalor6() {
		return this.valor6;
	}
    
	
	public Double getvalor7() {
		return this.valor7;
	}
    
	
	public Double getvalor8() {
		return this.valor8;
	}
    
	
	public Double getvalor9() {
		return this.valor9;
	}
    
	
	public Double getvalor10() {
		return this.valor10;
	}
    
	
	public Double getvalor11() {
		return this.valor11;
	}
    
	
	public Double getvalor12() {
		return this.valor12;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta(String newcodigo_cuenta)throws Exception
	{
		try {
			if(this.codigo_cuenta!=newcodigo_cuenta) {
				if(newcodigo_cuenta==null) {
					//newcodigo_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna codigo_cuenta");
					}
				}

				if(newcodigo_cuenta!=null&&newcodigo_cuenta.length()>50) {
					newcodigo_cuenta=newcodigo_cuenta.substring(0,48);
					System.out.println("PresupuestosFlujosCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta");
				}

				this.codigo_cuenta=newcodigo_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("PresupuestosFlujosCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("PresupuestosFlujosCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_modulo(String newnombre_modulo)throws Exception
	{
		try {
			if(this.nombre_modulo!=newnombre_modulo) {
				if(newnombre_modulo==null) {
					//newnombre_modulo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna nombre_modulo");
					}
				}

				if(newnombre_modulo!=null&&newnombre_modulo.length()>150) {
					newnombre_modulo=newnombre_modulo.substring(0,148);
					System.out.println("PresupuestosFlujosCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_modulo");
				}

				this.nombre_modulo=newnombre_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor1(Double newvalor1)throws Exception
	{
		try {
			if(this.valor1!=newvalor1) {
				if(newvalor1==null) {
					//newvalor1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor1");
					}
				}

				this.valor1=newvalor1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor2(Double newvalor2)throws Exception
	{
		try {
			if(this.valor2!=newvalor2) {
				if(newvalor2==null) {
					//newvalor2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor2");
					}
				}

				this.valor2=newvalor2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor3(Double newvalor3)throws Exception
	{
		try {
			if(this.valor3!=newvalor3) {
				if(newvalor3==null) {
					//newvalor3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor3");
					}
				}

				this.valor3=newvalor3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor4(Double newvalor4)throws Exception
	{
		try {
			if(this.valor4!=newvalor4) {
				if(newvalor4==null) {
					//newvalor4=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor4");
					}
				}

				this.valor4=newvalor4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor5(Double newvalor5)throws Exception
	{
		try {
			if(this.valor5!=newvalor5) {
				if(newvalor5==null) {
					//newvalor5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor5");
					}
				}

				this.valor5=newvalor5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor6(Double newvalor6)throws Exception
	{
		try {
			if(this.valor6!=newvalor6) {
				if(newvalor6==null) {
					//newvalor6=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor6");
					}
				}

				this.valor6=newvalor6;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor7(Double newvalor7)throws Exception
	{
		try {
			if(this.valor7!=newvalor7) {
				if(newvalor7==null) {
					//newvalor7=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor7");
					}
				}

				this.valor7=newvalor7;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor8(Double newvalor8)throws Exception
	{
		try {
			if(this.valor8!=newvalor8) {
				if(newvalor8==null) {
					//newvalor8=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor8");
					}
				}

				this.valor8=newvalor8;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor9(Double newvalor9)throws Exception
	{
		try {
			if(this.valor9!=newvalor9) {
				if(newvalor9==null) {
					//newvalor9=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor9");
					}
				}

				this.valor9=newvalor9;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor10(Double newvalor10)throws Exception
	{
		try {
			if(this.valor10!=newvalor10) {
				if(newvalor10==null) {
					//newvalor10=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor10");
					}
				}

				this.valor10=newvalor10;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor11(Double newvalor11)throws Exception
	{
		try {
			if(this.valor11!=newvalor11) {
				if(newvalor11==null) {
					//newvalor11=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor11");
					}
				}

				this.valor11=newvalor11;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor12(Double newvalor12)throws Exception
	{
		try {
			if(this.valor12!=newvalor12) {
				if(newvalor12==null) {
					//newvalor12=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna valor12");
					}
				}

				this.valor12=newvalor12;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestosFlujosCaja:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

