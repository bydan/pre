/*
*ADVERTENCIA : Este programa esta protegido por la ley de derechos de autor.
*La reproducci?n o distribuci?n il?cita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y ser?n objeto de todas las sanciones legales que correspondan.
*/
package com.bydan.erp.activosfijos.business.entity.report;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
//import com.bydan.erp.activosfijos.util.ActivosFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.activosfijos.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class MovimientoActivoFijo extends MovimientoActivoFijoAdditional implements Serializable ,Cloneable {//MovimientoActivoFijoAdditional,GeneralEntity
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
	
	private MovimientoActivoFijo movimientoactivofijoOriginal;
	
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_empresa;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_sucursal;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_usuario;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=Constantes.SVALIDACIONLENGTH)
	@NotEmpty(message=Constantes.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientoActivoFijoConstantesFunciones.SREGEXSECUENCIAL,message=MovimientoActivoFijoConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_empresa_origen;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_sucursal_origen;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_detalle_activo_fijo_origen;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_empresa_destino;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_sucursal_destino;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=Constantes.SVALIDACIONBIGINT)
	private Long id_detalle_activo_fijo_destino;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=Constantes.SVALIDACIONLENGTH)
	@NotEmpty(message=Constantes.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientoActivoFijoConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=MovimientoActivoFijoConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=Constantes.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=Constantes.SVALIDACIONDECIMAL)
	private Double depreciacion;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=Constantes.SVALIDACIONDECIMAL)
	private Double costo_origen;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=Constantes.SVALIDACIONDECIMAL)
	private Double depreciacion_origen;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=Constantes.SVALIDACIONLENGTH)
	@NotEmpty(message=Constantes.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientoActivoFijoConstantesFunciones.SREGEXRAZON,message=MovimientoActivoFijoConstantesFunciones.SMENSAJEREGEXRAZON)
	private String razon;
	
	@NotNull(message=Constantes.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=Constantes.SVALIDACIONLENGTH)
	@NotEmpty(message=Constantes.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientoActivoFijoConstantesFunciones.SREGEXDESCRIPCION,message=MovimientoActivoFijoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public Empresa empresaorigen;
	public Sucursal sucursalorigen;
	public DetalleActivoFijo detalleactivofijoorigen;
	public Empresa empresadestino;
	public Sucursal sucursaldestino;
	public DetalleActivoFijo detalleactivofijodestino;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String empresaorigen_descripcion;
	private String sucursalorigen_descripcion;
	private String detalleactivofijoorigen_descripcion;
	private String empresadestino_descripcion;
	private String sucursaldestino_descripcion;
	private String detalleactivofijodestino_descripcion;
	
	
		
	public MovimientoActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientoactivofijoOriginal=this;
		
 		this.id_empresa=0L;
 		this.id_sucursal=0L;
 		this.id_usuario=0L;
 		this.secuencial="";
 		this.id_empresa_origen=0L;
 		this.id_sucursal_origen=0L;
 		this.id_detalle_activo_fijo_origen=0L;
 		this.id_empresa_destino=0L;
 		this.id_sucursal_destino=0L;
 		this.id_detalle_activo_fijo_destino=0L;
 		this.fecha=new Date();
 		this.numero_documento="";
 		this.costo=0.0;
 		this.depreciacion=0.0;
 		this.costo_origen=0.0;
 		this.depreciacion_origen=0.0;
 		this.razon="";
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.empresaorigen=null;
		this.sucursalorigen=null;
		this.detalleactivofijoorigen=null;
		this.empresadestino=null;
		this.sucursaldestino=null;
		this.detalleactivofijodestino=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.empresaorigen_descripcion="";
		this.sucursalorigen_descripcion="";
		this.detalleactivofijoorigen_descripcion="";
		this.empresadestino_descripcion="";
		this.sucursaldestino_descripcion="";
		this.detalleactivofijodestino_descripcion="";
		
		
		
			
		
    } 
	
    //PARA REPORTES
	public MovimientoActivoFijo (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,String secuencial,Long id_empresa_origen,Long id_sucursal_origen,Long id_detalle_activo_fijo_origen,Long id_empresa_destino,Long id_sucursal_destino,Long id_detalle_activo_fijo_destino,Date fecha,String numero_documento,Double costo,Double depreciacion,Double costo_origen,Double depreciacion_origen,String razon,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.secuencial=secuencial;
 		this.id_empresa_origen=id_empresa_origen;
 		this.id_sucursal_origen=id_sucursal_origen;
 		this.id_detalle_activo_fijo_origen=id_detalle_activo_fijo_origen;
 		this.id_empresa_destino=id_empresa_destino;
 		this.id_sucursal_destino=id_sucursal_destino;
 		this.id_detalle_activo_fijo_destino=id_detalle_activo_fijo_destino;
 		this.fecha=fecha;
 		this.numero_documento=numero_documento;
 		this.costo=costo;
 		this.depreciacion=depreciacion;
 		this.costo_origen=costo_origen;
 		this.depreciacion_origen=depreciacion_origen;
 		this.razon=razon;
 		this.descripcion=descripcion;
    } 
	
	 //PARA REPORTES
	public MovimientoActivoFijo (Long id_empresa,Long id_sucursal,Long id_usuario,String secuencial,Long id_empresa_origen,Long id_sucursal_origen,Long id_detalle_activo_fijo_origen,Long id_empresa_destino,Long id_sucursal_destino,Long id_detalle_activo_fijo_destino,Date fecha,String numero_documento,Double costo,Double depreciacion,Double costo_origen,Double depreciacion_origen,String razon,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.secuencial=secuencial;
 		this.id_empresa_origen=id_empresa_origen;
 		this.id_sucursal_origen=id_sucursal_origen;
 		this.id_detalle_activo_fijo_origen=id_detalle_activo_fijo_origen;
 		this.id_empresa_destino=id_empresa_destino;
 		this.id_sucursal_destino=id_sucursal_destino;
 		this.id_detalle_activo_fijo_destino=id_detalle_activo_fijo_destino;
 		this.fecha=fecha;
 		this.numero_documento=numero_documento;
 		this.costo=costo;
 		this.depreciacion=depreciacion;
 		this.costo_origen=costo_origen;
 		this.depreciacion_origen=depreciacion_origen;
 		this.razon=razon;
 		this.descripcion=descripcion;
    } 
	
	
	public MovimientoActivoFijo getMovimientoActivoFijoOriginal() {
		return this.movimientoactivofijoOriginal;
	}
	
	public  void  setMovimientoActivoFijoOriginal(MovimientoActivoFijo movimientoactivofijo) {
		try {
			this.movimientoactivofijoOriginal=movimientoactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Long getid_empresa_origen() {
		return this.id_empresa_origen;
	}
    
	
	public Long getid_sucursal_origen() {
		return this.id_sucursal_origen;
	}
    
	
	public Long getid_detalle_activo_fijo_origen() {
		return this.id_detalle_activo_fijo_origen;
	}
    
	
	public Long getid_empresa_destino() {
		return this.id_empresa_destino;
	}
    
	
	public Long getid_sucursal_destino() {
		return this.id_sucursal_destino;
	}
    
	
	public Long getid_detalle_activo_fijo_destino() {
		return this.id_detalle_activo_fijo_destino;
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
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(!this.id_empresa.equals(newid_empresa)) {
				if(newid_empresa==null) {
					newid_empresa=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_empresa");
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(!this.id_sucursal.equals(newid_sucursal)) {
				if(newid_sucursal==null) {
					newid_sucursal=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_sucursal");
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(!this.id_usuario.equals(newid_usuario)) {
				if(newid_usuario==null) {
					newid_usuario=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_usuario");
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(!this.secuencial.equals(newsecuencial)) {
				if(newsecuencial==null) {
					newsecuencial="";
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna secuencial");
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("MovimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa_origen(Long newid_empresa_origen)throws Exception
	{
		try {
			if(!this.id_empresa_origen.equals(newid_empresa_origen)) {
				if(newid_empresa_origen==null) {
					newid_empresa_origen=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_empresa_origen");
				}

				this.id_empresa_origen=newid_empresa_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal_origen(Long newid_sucursal_origen)throws Exception
	{
		try {
			if(!this.id_sucursal_origen.equals(newid_sucursal_origen)) {
				if(newid_sucursal_origen==null) {
					newid_sucursal_origen=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_sucursal_origen");
				}

				this.id_sucursal_origen=newid_sucursal_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_activo_fijo_origen(Long newid_detalle_activo_fijo_origen)throws Exception
	{
		try {
			if(!this.id_detalle_activo_fijo_origen.equals(newid_detalle_activo_fijo_origen)) {
				if(newid_detalle_activo_fijo_origen==null) {
					newid_detalle_activo_fijo_origen=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_detalle_activo_fijo_origen");
				}

				this.id_detalle_activo_fijo_origen=newid_detalle_activo_fijo_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa_destino(Long newid_empresa_destino)throws Exception
	{
		try {
			if(!this.id_empresa_destino.equals(newid_empresa_destino)) {
				if(newid_empresa_destino==null) {
					newid_empresa_destino=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_empresa_destino");
				}

				this.id_empresa_destino=newid_empresa_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal_destino(Long newid_sucursal_destino)throws Exception
	{
		try {
			if(!this.id_sucursal_destino.equals(newid_sucursal_destino)) {
				if(newid_sucursal_destino==null) {
					newid_sucursal_destino=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_sucursal_destino");
				}

				this.id_sucursal_destino=newid_sucursal_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_activo_fijo_destino(Long newid_detalle_activo_fijo_destino)throws Exception
	{
		try {
			if(!this.id_detalle_activo_fijo_destino.equals(newid_detalle_activo_fijo_destino)) {
				if(newid_detalle_activo_fijo_destino==null) {
					newid_detalle_activo_fijo_destino=0L;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna id_detalle_activo_fijo_destino");
				}

				this.id_detalle_activo_fijo_destino=newid_detalle_activo_fijo_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(!this.fecha.equals(newfecha)) {
				if(newfecha==null) {
					newfecha=new Date();
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna fecha");
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
			if(!this.numero_documento.equals(newnumero_documento)) {
				if(newnumero_documento==null) {
					newnumero_documento="";
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna numero_documento");
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("MovimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
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
			if(!this.costo.equals(newcosto)) {
				if(newcosto==null) {
					newcosto=0.0;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna costo");
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
			if(!this.depreciacion.equals(newdepreciacion)) {
				if(newdepreciacion==null) {
					newdepreciacion=0.0;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna depreciacion");
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
			if(!this.costo_origen.equals(newcosto_origen)) {
				if(newcosto_origen==null) {
					newcosto_origen=0.0;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna costo_origen");
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
			if(!this.depreciacion_origen.equals(newdepreciacion_origen)) {
				if(newdepreciacion_origen==null) {
					newdepreciacion_origen=0.0;
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna depreciacion_origen");
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
			if(!this.razon.equals(newrazon)) {
				if(newrazon==null) {
					newrazon="";
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna razon");
				}

				if(newrazon!=null&&newrazon.length()>150) {
					newrazon=newrazon.substring(0,148);
					System.out.println("MovimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna razon");
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
			if(!this.descripcion.equals(newdescripcion)) {
				if(newdescripcion==null) {
					newdescripcion="";
					System.out.println("MovimientoActivoFijo:Valor nulo no permitido en columna descripcion");
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("MovimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Empresa getEmpresaOrigen() {
		return this.empresaorigen;
	}

	public Sucursal getSucursalOrigen() {
		return this.sucursalorigen;
	}

	public DetalleActivoFijo getDetalleActivoFijoOrigen() {
		return this.detalleactivofijoorigen;
	}

	public Empresa getEmpresaDestino() {
		return this.empresadestino;
	}

	public Sucursal getSucursalDestino() {
		return this.sucursaldestino;
	}

	public DetalleActivoFijo getDetalleActivoFijoDestino() {
		return this.detalleactivofijodestino;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getempresaorigen_descripcion() {
		return this.empresaorigen_descripcion;
	}

	public String getsucursalorigen_descripcion() {
		return this.sucursalorigen_descripcion;
	}

	public String getdetalleactivofijoorigen_descripcion() {
		return this.detalleactivofijoorigen_descripcion;
	}

	public String getempresadestino_descripcion() {
		return this.empresadestino_descripcion;
	}

	public String getsucursaldestino_descripcion() {
		return this.sucursaldestino_descripcion;
	}

	public String getdetalleactivofijodestino_descripcion() {
		return this.detalleactivofijodestino_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresaOrigen(Empresa empresaorigen) {
		try {
			this.empresaorigen=empresaorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursalOrigen(Sucursal sucursalorigen) {
		try {
			this.sucursalorigen=sucursalorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleActivoFijoOrigen(DetalleActivoFijo detalleactivofijoorigen) {
		try {
			this.detalleactivofijoorigen=detalleactivofijoorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresaDestino(Empresa empresadestino) {
		try {
			this.empresadestino=empresadestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursalDestino(Sucursal sucursaldestino) {
		try {
			this.sucursaldestino=sucursaldestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleActivoFijoDestino(DetalleActivoFijo detalleactivofijodestino) {
		try {
			this.detalleactivofijodestino=detalleactivofijodestino;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempresaorigen_descripcion(String empresaorigen_descripcion) {
		try {
			this.empresaorigen_descripcion=empresaorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsucursalorigen_descripcion(String sucursalorigen_descripcion) {
		try {
			this.sucursalorigen_descripcion=sucursalorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetalleactivofijoorigen_descripcion(String detalleactivofijoorigen_descripcion) {
		try {
			this.detalleactivofijoorigen_descripcion=detalleactivofijoorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempresadestino_descripcion(String empresadestino_descripcion) {
		try {
			this.empresadestino_descripcion=empresadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsucursaldestino_descripcion(String sucursaldestino_descripcion) {
		try {
			this.sucursaldestino_descripcion=sucursaldestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetalleactivofijodestino_descripcion(String detalleactivofijodestino_descripcion) {
		try {
			this.detalleactivofijodestino_descripcion=detalleactivofijodestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
		
}
