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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.ProcesoBancoNominaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoBancoNomina extends ProcesoBancoNominaAdditional implements Serializable ,Cloneable {//ProcesoBancoNominaAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private ProcesoBancoNomina procesobanconominaOriginal;
	
	private Map<String, Object> mapProcesoBancoNomina;
			
	public Map<String, Object> getMapProcesoBancoNomina() {
		return mapProcesoBancoNomina;
	}

	public void setMapProcesoBancoNomina(Map<String, Object> mapProcesoBancoNomina) {
		this.mapProcesoBancoNomina = mapProcesoBancoNomina;
	}
	
	public void inicializarMapProcesoBancoNomina() {
		this.mapProcesoBancoNomina = new HashMap<String,Object>();
	}
	
	public void setMapProcesoBancoNominaValue(String sKey,Object oValue) {
		this.mapProcesoBancoNomina.put(sKey, oValue);
	}
	
	public Object getMapProcesoBancoNominaValue(String sKey) {
		return this.mapProcesoBancoNomina.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_banco_disco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_otros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_internet;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_secuenciales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean genera_texto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean genera_excel;
			
	
	public Banco banco;
	public CuentaBanco cuentabanco;
	public TipoContrato tipocontrato;
	public TipoBancoDisco tipobancodisco;
	
	
	private String banco_descripcion;
	private String cuentabanco_descripcion;
	private String tipocontrato_descripcion;
	private String tipobancodisco_descripcion;
	
	
		
	public ProcesoBancoNomina () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesobanconominaOriginal=this;
		
 		this.id_banco=-1L;
 		this.id_cuenta_banco=-1L;
 		this.id_tipo_contrato=-1L;
 		this.id_tipo_banco_disco=-1L;
 		this.con_otros=false;
 		this.con_internet=false;
 		this.fecha=new Date();
 		this.numero_secuenciales=0;
 		this.genera_texto=false;
 		this.genera_excel=false;
		
		
		this.banco=null;
		this.cuentabanco=null;
		this.tipocontrato=null;
		this.tipobancodisco=null;
		
		
		this.banco_descripcion="";
		this.cuentabanco_descripcion="";
		this.tipocontrato_descripcion="";
		this.tipobancodisco_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoBancoNomina getProcesoBancoNominaOriginal() {
		return this.procesobanconominaOriginal;
	}
	
	public void setProcesoBancoNominaOriginal(ProcesoBancoNomina procesobanconomina) {
		try {
			this.procesobanconominaOriginal=procesobanconomina;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoBancoNominaAdditional procesobanconominaAdditional=null;
	
	public ProcesoBancoNominaAdditional getProcesoBancoNominaAdditional() {
		return this.procesobanconominaAdditional;
	}
	
	public void setProcesoBancoNominaAdditional(ProcesoBancoNominaAdditional procesobanconominaAdditional) {
		try {
			this.procesobanconominaAdditional=procesobanconominaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_cuenta_banco() {
		return this.id_cuenta_banco;
	}
    
	
	public Long getid_tipo_contrato() {
		return this.id_tipo_contrato;
	}
    
	
	public Long getid_tipo_banco_disco() {
		return this.id_tipo_banco_disco;
	}
    
	
	public Boolean getcon_otros() {
		return this.con_otros;
	}
    
	
	public Boolean getcon_internet() {
		return this.con_internet;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Integer getnumero_secuenciales() {
		return this.numero_secuenciales;
	}
    
	
	public Boolean getgenera_texto() {
		return this.genera_texto;
	}
    
	
	public Boolean getgenera_excel() {
		return this.genera_excel;
	}
	
    
	public void setid_banco(Long newid_banco)throws Exception
	{
		try {
			if(this.id_banco!=newid_banco) {
				if(newid_banco==null) {
					//newid_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_banco(Long newid_cuenta_banco)throws Exception
	{
		try {
			if(this.id_cuenta_banco!=newid_cuenta_banco) {
				if(newid_cuenta_banco==null) {
					//newid_cuenta_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna id_cuenta_banco");
					}
				}

				this.id_cuenta_banco=newid_cuenta_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_contrato(Long newid_tipo_contrato)throws Exception
	{
		try {
			if(this.id_tipo_contrato!=newid_tipo_contrato) {
				if(newid_tipo_contrato==null) {
					//newid_tipo_contrato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna id_tipo_contrato");
					}
				}

				this.id_tipo_contrato=newid_tipo_contrato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_banco_disco(Long newid_tipo_banco_disco)throws Exception
	{
		try {
			if(this.id_tipo_banco_disco!=newid_tipo_banco_disco) {
				if(newid_tipo_banco_disco==null) {
					//newid_tipo_banco_disco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna id_tipo_banco_disco");
					}
				}

				this.id_tipo_banco_disco=newid_tipo_banco_disco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_otros(Boolean newcon_otros)throws Exception
	{
		try {
			if(this.con_otros!=newcon_otros) {
				if(newcon_otros==null) {
					//newcon_otros=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna con_otros");
					}
				}

				this.con_otros=newcon_otros;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_internet(Boolean newcon_internet)throws Exception
	{
		try {
			if(this.con_internet!=newcon_internet) {
				if(newcon_internet==null) {
					//newcon_internet=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna con_internet");
					}
				}

				this.con_internet=newcon_internet;
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
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_secuenciales(Integer newnumero_secuenciales)throws Exception
	{
		try {
			if(this.numero_secuenciales!=newnumero_secuenciales) {
				if(newnumero_secuenciales==null) {
					//newnumero_secuenciales=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna numero_secuenciales");
					}
				}

				this.numero_secuenciales=newnumero_secuenciales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgenera_texto(Boolean newgenera_texto)throws Exception
	{
		try {
			if(this.genera_texto!=newgenera_texto) {
				if(newgenera_texto==null) {
					//newgenera_texto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna genera_texto");
					}
				}

				this.genera_texto=newgenera_texto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgenera_excel(Boolean newgenera_excel)throws Exception
	{
		try {
			if(this.genera_excel!=newgenera_excel) {
				if(newgenera_excel==null) {
					//newgenera_excel=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoBancoNomina:Valor nulo no permitido en columna genera_excel");
					}
				}

				this.genera_excel=newgenera_excel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Banco getBanco() {
		return this.banco;
	}

	public CuentaBanco getCuentaBanco() {
		return this.cuentabanco;
	}

	public TipoContrato getTipoContrato() {
		return this.tipocontrato;
	}

	public TipoBancoDisco getTipoBancoDisco() {
		return this.tipobancodisco;
	}

	
	
	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String getcuentabanco_descripcion() {
		return this.cuentabanco_descripcion;
	}

	public String gettipocontrato_descripcion() {
		return this.tipocontrato_descripcion;
	}

	public String gettipobancodisco_descripcion() {
		return this.tipobancodisco_descripcion;
	}

	
	
	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaBanco(CuentaBanco cuentabanco) {
		try {
			this.cuentabanco=cuentabanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoContrato(TipoContrato tipocontrato) {
		try {
			this.tipocontrato=tipocontrato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoBancoDisco(TipoBancoDisco tipobancodisco) {
		try {
			this.tipobancodisco=tipobancodisco;
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


	public  void  setcuentabanco_descripcion(String cuentabanco_descripcion) {
		try {
			this.cuentabanco_descripcion=cuentabanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocontrato_descripcion(String tipocontrato_descripcion) {
		try {
			this.tipocontrato_descripcion=tipocontrato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipobancodisco_descripcion(String tipobancodisco_descripcion) {
		try {
			this.tipobancodisco_descripcion=tipobancodisco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_banco_descripcion="";String id_cuenta_banco_descripcion="";String id_tipo_contrato_descripcion="";String id_tipo_banco_disco_descripcion="";String con_otros_descripcion="";String con_internet_descripcion="";String genera_texto_descripcion="";String genera_excel_descripcion="";
	
	
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_cuenta_banco_descripcion() {
		return id_cuenta_banco_descripcion;
	}
	public String getid_tipo_contrato_descripcion() {
		return id_tipo_contrato_descripcion;
	}
	public String getid_tipo_banco_disco_descripcion() {
		return id_tipo_banco_disco_descripcion;
	}
	public String getcon_otros_descripcion() {
		return con_otros_descripcion;
	}
	public String getcon_internet_descripcion() {
		return con_internet_descripcion;
	}
	public String getgenera_texto_descripcion() {
		return genera_texto_descripcion;
	}
	public String getgenera_excel_descripcion() {
		return genera_excel_descripcion;
	}
	
	
	public void setid_banco_descripcion(String newid_banco_descripcion)throws Exception {
		try {
			this.id_banco_descripcion=newid_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_banco_descripcion(String newid_cuenta_banco_descripcion)throws Exception {
		try {
			this.id_cuenta_banco_descripcion=newid_cuenta_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_contrato_descripcion(String newid_tipo_contrato_descripcion)throws Exception {
		try {
			this.id_tipo_contrato_descripcion=newid_tipo_contrato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_banco_disco_descripcion(String newid_tipo_banco_disco_descripcion)throws Exception {
		try {
			this.id_tipo_banco_disco_descripcion=newid_tipo_banco_disco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_otros_descripcion(String newcon_otros_descripcion)throws Exception {
		try {
			this.con_otros_descripcion=newcon_otros_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_internet_descripcion(String newcon_internet_descripcion)throws Exception {
		try {
			this.con_internet_descripcion=newcon_internet_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setgenera_texto_descripcion(String newgenera_texto_descripcion)throws Exception {
		try {
			this.genera_texto_descripcion=newgenera_texto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setgenera_excel_descripcion(String newgenera_excel_descripcion)throws Exception {
		try {
			this.genera_excel_descripcion=newgenera_excel_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_banco_descripcion="";this.id_cuenta_banco_descripcion="";this.id_tipo_contrato_descripcion="";this.id_tipo_banco_disco_descripcion="";this.con_otros_descripcion="";this.con_internet_descripcion="";this.genera_texto_descripcion="";this.genera_excel_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

