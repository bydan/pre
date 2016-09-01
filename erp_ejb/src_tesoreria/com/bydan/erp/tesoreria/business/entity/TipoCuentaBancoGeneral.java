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
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoCuentaBancoGeneral extends TipoCuentaBancoGeneralAdditional implements Serializable ,Cloneable {//TipoCuentaBancoGeneralAdditional,GeneralEntity
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
	
	private TipoCuentaBancoGeneral tipocuentabancogeneralOriginal;
	
	private Map<String, Object> mapTipoCuentaBancoGeneral;
			
	public Map<String, Object> getMapTipoCuentaBancoGeneral() {
		return mapTipoCuentaBancoGeneral;
	}

	public void setMapTipoCuentaBancoGeneral(Map<String, Object> mapTipoCuentaBancoGeneral) {
		this.mapTipoCuentaBancoGeneral = mapTipoCuentaBancoGeneral;
	}
	
	public void inicializarMapTipoCuentaBancoGeneral() {
		this.mapTipoCuentaBancoGeneral = new HashMap<String,Object>();
	}
	
	public void setMapTipoCuentaBancoGeneralValue(String sKey,Object oValue) {
		this.mapTipoCuentaBancoGeneral.put(sKey, oValue);
	}
	
	public Object getMapTipoCuentaBancoGeneralValue(String sKey) {
		return this.mapTipoCuentaBancoGeneral.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoCuentaBancoGeneralConstantesFunciones.SREGEXCODIGO,message=TipoCuentaBancoGeneralConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
			
	
	public Empresa empresa;
	public Banco banco;
	public TipoCuentaBanco tipocuentabanco;
	
	
	private String empresa_descripcion;
	private String banco_descripcion;
	private String tipocuentabanco_descripcion;
	
	
		
	public TipoCuentaBancoGeneral () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipocuentabancogeneralOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_banco=-1L;
 		this.id_tipo_cuenta_banco=-1L;
 		this.codigo="";
		
		
		this.empresa=null;
		this.banco=null;
		this.tipocuentabanco=null;
		
		
		this.empresa_descripcion="";
		this.banco_descripcion="";
		this.tipocuentabanco_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoCuentaBancoGeneral (Long id,Date versionRow,Long id_empresa,Long id_banco,Long id_tipo_cuenta_banco,String codigo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocuentabancogeneralOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco=id_tipo_cuenta_banco;
 		this.codigo=codigo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoCuentaBancoGeneral (Long id_empresa,Long id_banco,Long id_tipo_cuenta_banco,String codigo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocuentabancogeneralOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco=id_tipo_cuenta_banco;
 		this.codigo=codigo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoCuentaBancoGeneral tipocuentabancogeneralLocal=null;
		
		if(object!=null) {
			tipocuentabancogeneralLocal=(TipoCuentaBancoGeneral)object;
			
			if(tipocuentabancogeneralLocal!=null) {
				if(this.getId()!=null && tipocuentabancogeneralLocal.getId()!=null) {
					if(this.getId().equals(tipocuentabancogeneralLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoCuentaBancoGeneralConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoCuentaBancoGeneralConstantesFunciones.getTipoCuentaBancoGeneralDescripcion(this);
		} else {
			sDetalle=TipoCuentaBancoGeneralConstantesFunciones.getTipoCuentaBancoGeneralDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoCuentaBancoGeneral getTipoCuentaBancoGeneralOriginal() {
		return this.tipocuentabancogeneralOriginal;
	}
	
	public void setTipoCuentaBancoGeneralOriginal(TipoCuentaBancoGeneral tipocuentabancogeneral) {
		try {
			this.tipocuentabancogeneralOriginal=tipocuentabancogeneral;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoCuentaBancoGeneralAdditional tipocuentabancogeneralAdditional=null;
	
	public TipoCuentaBancoGeneralAdditional getTipoCuentaBancoGeneralAdditional() {
		return this.tipocuentabancogeneralAdditional;
	}
	
	public void setTipoCuentaBancoGeneralAdditional(TipoCuentaBancoGeneralAdditional tipocuentabancogeneralAdditional) {
		try {
			this.tipocuentabancogeneralAdditional=tipocuentabancogeneralAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_tipo_cuenta_banco() {
		return this.id_tipo_cuenta_banco;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCuentaBancoGeneral:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("TipoCuentaBancoGeneral:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_banco(Long newid_tipo_cuenta_banco)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_banco!=newid_tipo_cuenta_banco) {
				if(newid_tipo_cuenta_banco==null) {
					//newid_tipo_cuenta_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCuentaBancoGeneral:Valor nulo no permitido en columna id_tipo_cuenta_banco");
					}
				}

				this.id_tipo_cuenta_banco=newid_tipo_cuenta_banco;
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
						System.out.println("TipoCuentaBancoGeneral:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoCuentaBancoGeneral:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public TipoCuentaBanco getTipoCuentaBanco() {
		return this.tipocuentabanco;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String gettipocuentabanco_descripcion() {
		return this.tipocuentabanco_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoCuentaBanco(TipoCuentaBanco tipocuentabanco) {
		try {
			this.tipocuentabanco=tipocuentabanco;
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


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocuentabanco_descripcion(String tipocuentabanco_descripcion) {
		try {
			this.tipocuentabanco_descripcion=tipocuentabanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_banco_descripcion="";String id_tipo_cuenta_banco_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_tipo_cuenta_banco_descripcion() {
		return id_tipo_cuenta_banco_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_tipo_cuenta_banco_descripcion(String newid_tipo_cuenta_banco_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_banco_descripcion=newid_tipo_cuenta_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_banco_descripcion="";this.id_tipo_cuenta_banco_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

