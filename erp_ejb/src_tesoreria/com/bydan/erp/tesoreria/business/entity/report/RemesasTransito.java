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
//import com.bydan.erp.tesoreria.util.RemesasTransitoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class RemesasTransito extends RemesasTransitoAdditional implements Serializable ,Cloneable {//RemesasTransitoAdditional,GeneralEntity
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
	
	private RemesasTransito remesastransitoOriginal;
	
	private Map<String, Object> mapRemesasTransito;
			
	public Map<String, Object> getMapRemesasTransito() {
		return mapRemesasTransito;
	}

	public void setMapRemesasTransito(Map<String, Object> mapRemesasTransito) {
		this.mapRemesasTransito = mapRemesasTransito;
	}
	
	public void inicializarMapRemesasTransito() {
		this.mapRemesasTransito = new HashMap<String,Object>();
	}
	
	public void setMapRemesasTransitoValue(String sKey,Object oValue) {
		this.mapRemesasTransito.put(sKey, oValue);
	}
	
	public Object getMapRemesasTransitoValue(String sKey) {
		return this.mapRemesasTransito.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RemesasTransitoConstantesFunciones.SREGEXNOMBRE_BANCO,message=RemesasTransitoConstantesFunciones.SMENSAJEREGEXNOMBRE_BANCO)
	private String nombre_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RemesasTransitoConstantesFunciones.SREGEXNOMBRE_GIRADOR,message=RemesasTransitoConstantesFunciones.SMENSAJEREGEXNOMBRE_GIRADOR)
	private String nombre_girador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RemesasTransitoConstantesFunciones.SREGEXNUMERO_CUENTA,message=RemesasTransitoConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RemesasTransitoConstantesFunciones.SREGEXNUMERO_CHEQUE,message=RemesasTransitoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RemesasTransitoConstantesFunciones.SREGEXNUMERO_MAYOR,message=RemesasTransitoConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=RemesasTransitoConstantesFunciones.SREGEXCODIGO,message=RemesasTransitoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento_original;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cambio;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public RemesasTransito () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.remesastransitoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre_banco="";
 		this.nombre_girador="";
 		this.fecha_vencimiento=new Date();
 		this.numero_cuenta="";
 		this.numero_cheque="";
 		this.valor_monto=0.0;
 		this.valor=0.0;
 		this.numero_mayor="";
 		this.codigo="";
 		this.fecha_vencimiento_original=new Date();
 		this.numero_cambio=0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RemesasTransito (Long id,Date versionRow,String nombre_banco,String nombre_girador,Date fecha_vencimiento,String numero_cuenta,String numero_cheque,Double valor_monto,Double valor,String numero_mayor,String codigo,Date fecha_vencimiento_original,Integer numero_cambio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.remesastransitoOriginal=this;
		
 		this.nombre_banco=nombre_banco;
 		this.nombre_girador=nombre_girador;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.valor_monto=valor_monto;
 		this.valor=valor;
 		this.numero_mayor=numero_mayor;
 		this.codigo=codigo;
 		this.fecha_vencimiento_original=fecha_vencimiento_original;
 		this.numero_cambio=numero_cambio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RemesasTransito (String nombre_banco,String nombre_girador,Date fecha_vencimiento,String numero_cuenta,String numero_cheque,Double valor_monto,Double valor,String numero_mayor,String codigo,Date fecha_vencimiento_original,Integer numero_cambio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.remesastransitoOriginal=this;
		
 		this.nombre_banco=nombre_banco;
 		this.nombre_girador=nombre_girador;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.valor_monto=valor_monto;
 		this.valor=valor;
 		this.numero_mayor=numero_mayor;
 		this.codigo=codigo;
 		this.fecha_vencimiento_original=fecha_vencimiento_original;
 		this.numero_cambio=numero_cambio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public RemesasTransito getRemesasTransitoOriginal() {
		return this.remesastransitoOriginal;
	}
	
	public void setRemesasTransitoOriginal(RemesasTransito remesastransito) {
		try {
			this.remesastransitoOriginal=remesastransito;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RemesasTransitoAdditional remesastransitoAdditional=null;
	
	public RemesasTransitoAdditional getRemesasTransitoAdditional() {
		return this.remesastransitoAdditional;
	}
	
	public void setRemesasTransitoAdditional(RemesasTransitoAdditional remesastransitoAdditional) {
		try {
			this.remesastransitoAdditional=remesastransitoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_banco() {
		return this.nombre_banco;
	}
    
	
	public String getnombre_girador() {
		return this.nombre_girador;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public Double getvalor_monto() {
		return this.valor_monto;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Date getfecha_vencimiento_original() {
		return this.fecha_vencimiento_original;
	}
    
	
	public Integer getnumero_cambio() {
		return this.numero_cambio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_banco(String newnombre_banco)throws Exception
	{
		try {
			if(this.nombre_banco!=newnombre_banco) {
				if(newnombre_banco==null) {
					//newnombre_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna nombre_banco");
					}
				}

				if(newnombre_banco!=null&&newnombre_banco.length()>200) {
					newnombre_banco=newnombre_banco.substring(0,198);
					System.out.println("RemesasTransito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_banco");
				}

				this.nombre_banco=newnombre_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_girador(String newnombre_girador)throws Exception
	{
		try {
			if(this.nombre_girador!=newnombre_girador) {
				if(newnombre_girador==null) {
					//newnombre_girador="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna nombre_girador");
					}
				}

				if(newnombre_girador!=null&&newnombre_girador.length()>200) {
					newnombre_girador=newnombre_girador.substring(0,198);
					System.out.println("RemesasTransito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_girador");
				}

				this.nombre_girador=newnombre_girador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("RemesasTransito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
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
						System.out.println("RemesasTransito:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("RemesasTransito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_monto(Double newvalor_monto)throws Exception
	{
		try {
			if(this.valor_monto!=newvalor_monto) {
				if(newvalor_monto==null) {
					//newvalor_monto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna valor_monto");
					}
				}

				this.valor_monto=newvalor_monto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor(String newnumero_mayor)throws Exception
	{
		try {
			if(this.numero_mayor!=newnumero_mayor) {
				if(newnumero_mayor==null) {
					//newnumero_mayor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("RemesasTransito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
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
						System.out.println("RemesasTransito:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("RemesasTransito:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento_original(Date newfecha_vencimiento_original)throws Exception
	{
		try {
			if(this.fecha_vencimiento_original!=newfecha_vencimiento_original) {
				if(newfecha_vencimiento_original==null) {
					//newfecha_vencimiento_original=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna fecha_vencimiento_original");
					}
				}

				this.fecha_vencimiento_original=newfecha_vencimiento_original;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cambio(Integer newnumero_cambio)throws Exception
	{
		try {
			if(this.numero_cambio!=newnumero_cambio) {
				if(newnumero_cambio==null) {
					//newnumero_cambio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RemesasTransito:Valor nulo no permitido en columna numero_cambio");
					}
				}

				this.numero_cambio=newnumero_cambio;
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

