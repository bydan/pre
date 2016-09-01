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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.VigenciaFueConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class VigenciaFue extends VigenciaFueAdditional implements Serializable ,Cloneable {//VigenciaFueAdditional,GeneralEntity
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
	
	private VigenciaFue vigenciafueOriginal;
	
	private Map<String, Object> mapVigenciaFue;
			
	public Map<String, Object> getMapVigenciaFue() {
		return mapVigenciaFue;
	}

	public void setMapVigenciaFue(Map<String, Object> mapVigenciaFue) {
		this.mapVigenciaFue = mapVigenciaFue;
	}
	
	public void inicializarMapVigenciaFue() {
		this.mapVigenciaFue = new HashMap<String,Object>();
	}
	
	public void setMapVigenciaFueValue(String sKey,Object oValue) {
		this.mapVigenciaFue.put(sKey, oValue);
	}
	
	public Object getMapVigenciaFueValue(String sKey) {
		return this.mapVigenciaFue.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_embarques;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VigenciaFueConstantesFunciones.SREGEXFUE,message=VigenciaFueConstantesFunciones.SMENSAJEREGEXFUE)
	private String fue;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultimo_embarque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cajas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
		
	public VigenciaFue () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.vigenciafueOriginal=this;
		
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.numero_embarques=0;
 		this.fue="";
 		this.fecha_ultimo_embarque=new Date();
 		this.valor=0.0;
 		this.numero_cajas=0;
 		this.esta_activo=false;
		
		
		this.pais=null;
		this.ciudad=null;
		
		
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VigenciaFue (Long id,Date versionRow,Long id_pais,Long id_ciudad,Date fecha_inicio,Date fecha_fin,Integer numero_embarques,String fue,Date fecha_ultimo_embarque,Double valor,Integer numero_cajas,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vigenciafueOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.numero_embarques=numero_embarques;
 		this.fue=fue;
 		this.fecha_ultimo_embarque=fecha_ultimo_embarque;
 		this.valor=valor;
 		this.numero_cajas=numero_cajas;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VigenciaFue (Long id_pais,Long id_ciudad,Date fecha_inicio,Date fecha_fin,Integer numero_embarques,String fue,Date fecha_ultimo_embarque,Double valor,Integer numero_cajas,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vigenciafueOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.numero_embarques=numero_embarques;
 		this.fue=fue;
 		this.fecha_ultimo_embarque=fecha_ultimo_embarque;
 		this.valor=valor;
 		this.numero_cajas=numero_cajas;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		VigenciaFue vigenciafueLocal=null;
		
		if(object!=null) {
			vigenciafueLocal=(VigenciaFue)object;
			
			if(vigenciafueLocal!=null) {
				if(this.getId()!=null && vigenciafueLocal.getId()!=null) {
					if(this.getId().equals(vigenciafueLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VigenciaFueConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VigenciaFueConstantesFunciones.getVigenciaFueDescripcion(this);
		} else {
			sDetalle=VigenciaFueConstantesFunciones.getVigenciaFueDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public VigenciaFue getVigenciaFueOriginal() {
		return this.vigenciafueOriginal;
	}
	
	public void setVigenciaFueOriginal(VigenciaFue vigenciafue) {
		try {
			this.vigenciafueOriginal=vigenciafue;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VigenciaFueAdditional vigenciafueAdditional=null;
	
	public VigenciaFueAdditional getVigenciaFueAdditional() {
		return this.vigenciafueAdditional;
	}
	
	public void setVigenciaFueAdditional(VigenciaFueAdditional vigenciafueAdditional) {
		try {
			this.vigenciafueAdditional=vigenciafueAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Integer getnumero_embarques() {
		return this.numero_embarques;
	}
    
	
	public String getfue() {
		return this.fue;
	}
    
	
	public Date getfecha_ultimo_embarque() {
		return this.fecha_ultimo_embarque;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Integer getnumero_cajas() {
		return this.numero_cajas;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_embarques(Integer newnumero_embarques)throws Exception
	{
		try {
			if(this.numero_embarques!=newnumero_embarques) {
				if(newnumero_embarques==null) {
					//newnumero_embarques=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna numero_embarques");
					}
				}

				this.numero_embarques=newnumero_embarques;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfue(String newfue)throws Exception
	{
		try {
			if(this.fue!=newfue) {
				if(newfue==null) {
					//newfue="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna fue");
					}
				}

				if(newfue!=null&&newfue.length()>50) {
					newfue=newfue.substring(0,48);
					System.out.println("VigenciaFue:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fue");
				}

				this.fue=newfue;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultimo_embarque(Date newfecha_ultimo_embarque)throws Exception
	{
		try {
			if(this.fecha_ultimo_embarque!=newfecha_ultimo_embarque) {
				if(newfecha_ultimo_embarque==null) {
					//newfecha_ultimo_embarque=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna fecha_ultimo_embarque");
					}
				}

				this.fecha_ultimo_embarque=newfecha_ultimo_embarque;
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
						System.out.println("VigenciaFue:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cajas(Integer newnumero_cajas)throws Exception
	{
		try {
			if(this.numero_cajas!=newnumero_cajas) {
				if(newnumero_cajas==null) {
					//newnumero_cajas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna numero_cajas");
					}
				}

				this.numero_cajas=newnumero_cajas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VigenciaFue:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	
	
	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_pais_descripcion="";String id_ciudad_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

