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
package com.bydan.erp.activosfijos.business.entity.report;

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
//import com.bydan.erp.activosfijos.util.TransferenciasConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Transferencias extends TransferenciasAdditional implements Serializable ,Cloneable {//TransferenciasAdditional,GeneralEntity
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
	
	private Transferencias transferenciasOriginal;
	
	private Map<String, Object> mapTransferencias;
			
	public Map<String, Object> getMapTransferencias() {
		return mapTransferencias;
	}

	public void setMapTransferencias(Map<String, Object> mapTransferencias) {
		this.mapTransferencias = mapTransferencias;
	}
	
	public void inicializarMapTransferencias() {
		this.mapTransferencias = new HashMap<String,Object>();
	}
	
	public void setMapTransferenciasValue(String sKey,Object oValue) {
		this.mapTransferencias.put(sKey, oValue);
	}
	
	public Object getMapTransferenciasValue(String sKey) {
		return this.mapTransferencias.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXEMPRESA_ORIGEN,message=TransferenciasConstantesFunciones.SMENSAJEREGEXEMPRESA_ORIGEN)
	private String empresa_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXSUCURSAL_ORIGEN,message=TransferenciasConstantesFunciones.SMENSAJEREGEXSUCURSAL_ORIGEN)
	private String sucursal_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXSUB_GRUPO_ORIGEN,message=TransferenciasConstantesFunciones.SMENSAJEREGEXSUB_GRUPO_ORIGEN)
	private String sub_grupo_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXGRUPO_ORIGEN,message=TransferenciasConstantesFunciones.SMENSAJEREGEXGRUPO_ORIGEN)
	private String grupo_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXACTIVO_ORIGEN,message=TransferenciasConstantesFunciones.SMENSAJEREGEXACTIVO_ORIGEN)
	private String activo_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXEMPRESA_DESTINO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXEMPRESA_DESTINO)
	private String empresa_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXSUCURSAL_DESTINO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXSUCURSAL_DESTINO)
	private String sucursal_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXSUB_GRUPO_DESTINO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXSUB_GRUPO_DESTINO)
	private String sub_grupo_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXGRUPO_DESTINO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXGRUPO_DESTINO)
	private String grupo_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXACTIVO_DESTINO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXACTIVO_DESTINO)
	private String activo_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXSECUENCIAL,message=TransferenciasConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double depreciacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double depreciacion_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXRAZON,message=TransferenciasConstantesFunciones.SMENSAJEREGEXRAZON)
	private String razon;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXDESCRIPCION,message=TransferenciasConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=TransferenciasConstantesFunciones.SREGEXTIPO,message=TransferenciasConstantesFunciones.SMENSAJEREGEXTIPO)
	private String tipo;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public Transferencias () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transferenciasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.empresa_origen="";
 		this.sucursal_origen="";
 		this.sub_grupo_origen="";
 		this.grupo_origen="";
 		this.activo_origen="";
 		this.empresa_destino="";
 		this.sucursal_destino="";
 		this.sub_grupo_destino="";
 		this.grupo_destino="";
 		this.activo_destino="";
 		this.secuencial="";
 		this.fecha=new Date();
 		this.numero_documento="";
 		this.costo=0.0;
 		this.depreciacion=0.0;
 		this.costo_origen=0.0;
 		this.depreciacion_origen=0.0;
 		this.razon="";
 		this.descripcion="";
 		this.tipo="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Transferencias (Long id,Date versionRow,String empresa_origen,String sucursal_origen,String sub_grupo_origen,String grupo_origen,String activo_origen,String empresa_destino,String sucursal_destino,String sub_grupo_destino,String grupo_destino,String activo_destino,String secuencial,Date fecha,String numero_documento,Double costo,Double depreciacion,Double costo_origen,Double depreciacion_origen,String razon,String descripcion,String tipo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transferenciasOriginal=this;
		
 		this.empresa_origen=empresa_origen;
 		this.sucursal_origen=sucursal_origen;
 		this.sub_grupo_origen=sub_grupo_origen;
 		this.grupo_origen=grupo_origen;
 		this.activo_origen=activo_origen;
 		this.empresa_destino=empresa_destino;
 		this.sucursal_destino=sucursal_destino;
 		this.sub_grupo_destino=sub_grupo_destino;
 		this.grupo_destino=grupo_destino;
 		this.activo_destino=activo_destino;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.numero_documento=numero_documento;
 		this.costo=costo;
 		this.depreciacion=depreciacion;
 		this.costo_origen=costo_origen;
 		this.depreciacion_origen=depreciacion_origen;
 		this.razon=razon;
 		this.descripcion=descripcion;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Transferencias (String empresa_origen,String sucursal_origen,String sub_grupo_origen,String grupo_origen,String activo_origen,String empresa_destino,String sucursal_destino,String sub_grupo_destino,String grupo_destino,String activo_destino,String secuencial,Date fecha,String numero_documento,Double costo,Double depreciacion,Double costo_origen,Double depreciacion_origen,String razon,String descripcion,String tipo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transferenciasOriginal=this;
		
 		this.empresa_origen=empresa_origen;
 		this.sucursal_origen=sucursal_origen;
 		this.sub_grupo_origen=sub_grupo_origen;
 		this.grupo_origen=grupo_origen;
 		this.activo_origen=activo_origen;
 		this.empresa_destino=empresa_destino;
 		this.sucursal_destino=sucursal_destino;
 		this.sub_grupo_destino=sub_grupo_destino;
 		this.grupo_destino=grupo_destino;
 		this.activo_destino=activo_destino;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.numero_documento=numero_documento;
 		this.costo=costo;
 		this.depreciacion=depreciacion;
 		this.costo_origen=costo_origen;
 		this.depreciacion_origen=depreciacion_origen;
 		this.razon=razon;
 		this.descripcion=descripcion;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public Transferencias getTransferenciasOriginal() {
		return this.transferenciasOriginal;
	}
	
	public void setTransferenciasOriginal(Transferencias transferencias) {
		try {
			this.transferenciasOriginal=transferencias;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransferenciasAdditional transferenciasAdditional=null;
	
	public TransferenciasAdditional getTransferenciasAdditional() {
		return this.transferenciasAdditional;
	}
	
	public void setTransferenciasAdditional(TransferenciasAdditional transferenciasAdditional) {
		try {
			this.transferenciasAdditional=transferenciasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getempresa_origen() {
		return this.empresa_origen;
	}
    
	
	public String getsucursal_origen() {
		return this.sucursal_origen;
	}
    
	
	public String getsub_grupo_origen() {
		return this.sub_grupo_origen;
	}
    
	
	public String getgrupo_origen() {
		return this.grupo_origen;
	}
    
	
	public String getactivo_origen() {
		return this.activo_origen;
	}
    
	
	public String getempresa_destino() {
		return this.empresa_destino;
	}
    
	
	public String getsucursal_destino() {
		return this.sucursal_destino;
	}
    
	
	public String getsub_grupo_destino() {
		return this.sub_grupo_destino;
	}
    
	
	public String getgrupo_destino() {
		return this.grupo_destino;
	}
    
	
	public String getactivo_destino() {
		return this.activo_destino;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getnumero_documento() {
		return this.numero_documento;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getdepreciacion() {
		return this.depreciacion;
	}
    
	
	public Double getcosto_origen() {
		return this.costo_origen;
	}
    
	
	public Double getdepreciacion_origen() {
		return this.depreciacion_origen;
	}
    
	
	public String getrazon() {
		return this.razon;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public String gettipo() {
		return this.tipo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setempresa_origen(String newempresa_origen)throws Exception
	{
		try {
			if(this.empresa_origen!=newempresa_origen) {
				if(newempresa_origen==null) {
					//newempresa_origen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna empresa_origen");
					}
				}

				if(newempresa_origen!=null&&newempresa_origen.length()>150) {
					newempresa_origen=newempresa_origen.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna empresa_origen");
				}

				this.empresa_origen=newempresa_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsucursal_origen(String newsucursal_origen)throws Exception
	{
		try {
			if(this.sucursal_origen!=newsucursal_origen) {
				if(newsucursal_origen==null) {
					//newsucursal_origen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna sucursal_origen");
					}
				}

				if(newsucursal_origen!=null&&newsucursal_origen.length()>150) {
					newsucursal_origen=newsucursal_origen.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sucursal_origen");
				}

				this.sucursal_origen=newsucursal_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_grupo_origen(String newsub_grupo_origen)throws Exception
	{
		try {
			if(this.sub_grupo_origen!=newsub_grupo_origen) {
				if(newsub_grupo_origen==null) {
					//newsub_grupo_origen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna sub_grupo_origen");
					}
				}

				if(newsub_grupo_origen!=null&&newsub_grupo_origen.length()>150) {
					newsub_grupo_origen=newsub_grupo_origen.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sub_grupo_origen");
				}

				this.sub_grupo_origen=newsub_grupo_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgrupo_origen(String newgrupo_origen)throws Exception
	{
		try {
			if(this.grupo_origen!=newgrupo_origen) {
				if(newgrupo_origen==null) {
					//newgrupo_origen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna grupo_origen");
					}
				}

				if(newgrupo_origen!=null&&newgrupo_origen.length()>150) {
					newgrupo_origen=newgrupo_origen.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna grupo_origen");
				}

				this.grupo_origen=newgrupo_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setactivo_origen(String newactivo_origen)throws Exception
	{
		try {
			if(this.activo_origen!=newactivo_origen) {
				if(newactivo_origen==null) {
					//newactivo_origen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna activo_origen");
					}
				}

				if(newactivo_origen!=null&&newactivo_origen.length()>100) {
					newactivo_origen=newactivo_origen.substring(0,98);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna activo_origen");
				}

				this.activo_origen=newactivo_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setempresa_destino(String newempresa_destino)throws Exception
	{
		try {
			if(this.empresa_destino!=newempresa_destino) {
				if(newempresa_destino==null) {
					//newempresa_destino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna empresa_destino");
					}
				}

				if(newempresa_destino!=null&&newempresa_destino.length()>150) {
					newempresa_destino=newempresa_destino.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna empresa_destino");
				}

				this.empresa_destino=newempresa_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsucursal_destino(String newsucursal_destino)throws Exception
	{
		try {
			if(this.sucursal_destino!=newsucursal_destino) {
				if(newsucursal_destino==null) {
					//newsucursal_destino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna sucursal_destino");
					}
				}

				if(newsucursal_destino!=null&&newsucursal_destino.length()>150) {
					newsucursal_destino=newsucursal_destino.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sucursal_destino");
				}

				this.sucursal_destino=newsucursal_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_grupo_destino(String newsub_grupo_destino)throws Exception
	{
		try {
			if(this.sub_grupo_destino!=newsub_grupo_destino) {
				if(newsub_grupo_destino==null) {
					//newsub_grupo_destino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna sub_grupo_destino");
					}
				}

				if(newsub_grupo_destino!=null&&newsub_grupo_destino.length()>150) {
					newsub_grupo_destino=newsub_grupo_destino.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sub_grupo_destino");
				}

				this.sub_grupo_destino=newsub_grupo_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgrupo_destino(String newgrupo_destino)throws Exception
	{
		try {
			if(this.grupo_destino!=newgrupo_destino) {
				if(newgrupo_destino==null) {
					//newgrupo_destino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna grupo_destino");
					}
				}

				if(newgrupo_destino!=null&&newgrupo_destino.length()>150) {
					newgrupo_destino=newgrupo_destino.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna grupo_destino");
				}

				this.grupo_destino=newgrupo_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setactivo_destino(String newactivo_destino)throws Exception
	{
		try {
			if(this.activo_destino!=newactivo_destino) {
				if(newactivo_destino==null) {
					//newactivo_destino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna activo_destino");
					}
				}

				if(newactivo_destino!=null&&newactivo_destino.length()>100) {
					newactivo_destino=newactivo_destino.substring(0,98);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna activo_destino");
				}

				this.activo_destino=newactivo_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
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
						System.out.println("Transferencias:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_documento(String newnumero_documento)throws Exception
	{
		try {
			if(this.numero_documento!=newnumero_documento) {
				if(newnumero_documento==null) {
					//newnumero_documento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
				}

				this.numero_documento=newnumero_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto(Double newcosto)throws Exception
	{
		try {
			if(this.costo!=newcosto) {
				if(newcosto==null) {
					//newcosto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdepreciacion(Double newdepreciacion)throws Exception
	{
		try {
			if(this.depreciacion!=newdepreciacion) {
				if(newdepreciacion==null) {
					//newdepreciacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna depreciacion");
					}
				}

				this.depreciacion=newdepreciacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_origen(Double newcosto_origen)throws Exception
	{
		try {
			if(this.costo_origen!=newcosto_origen) {
				if(newcosto_origen==null) {
					//newcosto_origen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna costo_origen");
					}
				}

				this.costo_origen=newcosto_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdepreciacion_origen(Double newdepreciacion_origen)throws Exception
	{
		try {
			if(this.depreciacion_origen!=newdepreciacion_origen) {
				if(newdepreciacion_origen==null) {
					//newdepreciacion_origen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna depreciacion_origen");
					}
				}

				this.depreciacion_origen=newdepreciacion_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrazon(String newrazon)throws Exception
	{
		try {
			if(this.razon!=newrazon) {
				if(newrazon==null) {
					//newrazon="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna razon");
					}
				}

				if(newrazon!=null&&newrazon.length()>150) {
					newrazon=newrazon.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna razon");
				}

				this.razon=newrazon;
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
						System.out.println("Transferencias:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(String newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transferencias:Valor nulo no permitido en columna tipo");
					}
				}

				if(newtipo!=null&&newtipo.length()>50) {
					newtipo=newtipo.substring(0,48);
					System.out.println("Transferencias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tipo");
				}

				this.tipo=newtipo;
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

