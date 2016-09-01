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
package com.bydan.erp.inventario.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//DefinicionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class DefinicionDataAccess extends  DefinicionDataAccessAdditional{ //DefinicionDataAccessAdditional,DataAccessHelper<Definicion>
	//static Logger logger = Logger.getLogger(DefinicionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="definicion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_modulo,secuencial_formato,secuencial,id_tipo_definicion,id_transaccion,id_sucursal,id_tipo_iva_item,con_mostrar_bodega,factor,con_otro_recargo,id_tipo_global_cliente,con_coa,id_tipo_costeo_definicion,con_retencion,id_tipo_costo_definicion,con_novedad_producto,con_ice,con_cantidad,con_producto_por_proveedor,con_lote_cliente,con_cuenta_contable,con_detalle,con_iva_incluido,con_lotes,numero_descuentos,con_precio,numero_registros,con_centro_costo,con_orden_iva,con_multi_empresa,id_formato,con_en_linea,id_tipo_tributario,id_tipo_retencion,con_evaluacion,con_ot,con_anticipo,con_cierre,con_general,con_por_producto,con_descuento,con_series,cantidad,id_tipo_documento,id_libro_contable,con_interno,con_reserva,con_precio_proveedor,con_produccion,con_codigo_barra,con_romaneos,id_tipo_transaccion_modulo,id_cuenta_contable)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,secuencial_formato=?,secuencial=?,id_tipo_definicion=?,id_transaccion=?,id_sucursal=?,id_tipo_iva_item=?,con_mostrar_bodega=?,factor=?,con_otro_recargo=?,id_tipo_global_cliente=?,con_coa=?,id_tipo_costeo_definicion=?,con_retencion=?,id_tipo_costo_definicion=?,con_novedad_producto=?,con_ice=?,con_cantidad=?,con_producto_por_proveedor=?,con_lote_cliente=?,con_cuenta_contable=?,con_detalle=?,con_iva_incluido=?,con_lotes=?,numero_descuentos=?,con_precio=?,numero_registros=?,con_centro_costo=?,con_orden_iva=?,con_multi_empresa=?,id_formato=?,con_en_linea=?,id_tipo_tributario=?,id_tipo_retencion=?,con_evaluacion=?,con_ot=?,con_anticipo=?,con_cierre=?,con_general=?,con_por_producto=?,con_descuento=?,con_series=?,cantidad=?,id_tipo_documento=?,id_libro_contable=?,con_interno=?,con_reserva=?,con_precio_proveedor=?,con_produccion=?,con_codigo_barra=?,con_romaneos=?,id_tipo_transaccion_modulo=?,id_cuenta_contable=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select definicion from "+DefinicionConstantesFunciones.SPERSISTENCENAME+" definicion";
	public static String QUERYSELECTNATIVE="select "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".version_row,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_empresa,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_modulo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".secuencial_formato,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".secuencial,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_definicion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_transaccion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_sucursal,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_iva_item,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_mostrar_bodega,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".factor,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_otro_recargo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_global_cliente,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_coa,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_costeo_definicion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_retencion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_costo_definicion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_novedad_producto,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_ice,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_cantidad,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_producto_por_proveedor,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_lote_cliente,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_cuenta_contable,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_detalle,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_iva_incluido,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_lotes,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".numero_descuentos,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_precio,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".numero_registros,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_centro_costo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_orden_iva,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_multi_empresa,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_formato,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_en_linea,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_tributario,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_retencion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_evaluacion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_ot,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_anticipo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_cierre,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_general,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_por_producto,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_descuento,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_series,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".cantidad,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_documento,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_libro_contable,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_interno,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_reserva,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_precio_proveedor,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_produccion,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_codigo_barra,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".con_romaneos,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id_cuenta_contable from "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME;//+" as "+DefinicionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".id,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".version_row,"+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+".secuencial_formato from "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME;//+" as "+DefinicionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DefinicionConstantesFunciones.SCHEMA+"."+DefinicionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_modulo=?,secuencial_formato=?,secuencial=?,id_tipo_definicion=?,id_transaccion=?,id_sucursal=?,id_tipo_iva_item=?,con_mostrar_bodega=?,factor=?,con_otro_recargo=?,id_tipo_global_cliente=?,con_coa=?,id_tipo_costeo_definicion=?,con_retencion=?,id_tipo_costo_definicion=?,con_novedad_producto=?,con_ice=?,con_cantidad=?,con_producto_por_proveedor=?,con_lote_cliente=?,con_cuenta_contable=?,con_detalle=?,con_iva_incluido=?,con_lotes=?,numero_descuentos=?,con_precio=?,numero_registros=?,con_centro_costo=?,con_orden_iva=?,con_multi_empresa=?,id_formato=?,con_en_linea=?,id_tipo_tributario=?,id_tipo_retencion=?,con_evaluacion=?,con_ot=?,con_anticipo=?,con_cierre=?,con_general=?,con_por_producto=?,con_descuento=?,con_series=?,cantidad=?,id_tipo_documento=?,id_libro_contable=?,con_interno=?,con_reserva=?,con_precio_proveedor=?,con_produccion=?,con_codigo_barra=?,con_romaneos=?,id_tipo_transaccion_modulo=?,id_cuenta_contable=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DEFINICION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DEFINICION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DEFINICION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DEFINICION_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected DefinicionDataAccessAdditional definicionDataAccessAdditional=null;
	
	public DefinicionDataAccessAdditional getDefinicionDataAccessAdditional() {
		return this.definicionDataAccessAdditional;
	}
	
	public void setDefinicionDataAccessAdditional(DefinicionDataAccessAdditional definicionDataAccessAdditional) {
		try {
			this.definicionDataAccessAdditional=definicionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DefinicionDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		DefinicionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DefinicionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DefinicionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setDefinicionOriginal(Definicion definicion)throws Exception  {
		definicion.setDefinicionOriginal((Definicion)definicion.clone());		
	}
	
	public void setDefinicionsOriginal(List<Definicion> definicions)throws Exception  {
		
		for(Definicion definicion:definicions){
			definicion.setDefinicionOriginal((Definicion)definicion.clone());
		}
	}
	
	public static void setDefinicionOriginalStatic(Definicion definicion)throws Exception  {
		definicion.setDefinicionOriginal((Definicion)definicion.clone());		
	}
	
	public static void setDefinicionsOriginalStatic(List<Definicion> definicions)throws Exception  {
		
		for(Definicion definicion:definicions){
			definicion.setDefinicionOriginal((Definicion)definicion.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  Definicion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Definicion entity = new Definicion();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  Definicion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Definicion entity = new Definicion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Definicion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDefinicionOriginal(new Definicion());
      	    	entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDefinicion("",entity,resultSet); 
				
				//entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDefinicion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Definicion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Definicion entity = new Definicion();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  Definicion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Definicion entity = new Definicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Definicion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDefinicionOriginal(new Definicion());
      	    	entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDefinicion("",entity,resultSet);    
				
				//entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDefinicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Definicion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Definicion entity = new Definicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Definicion.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseDefinicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Definicion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Definicion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Definicion();
      	    	entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDefinicion("",entity,resultSet);
      	    	
				//entity.setDefinicionOriginal( new Definicion());
      	    	//entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDefinicions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Definicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Definicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Definicion();
				
				if(conMapGenerico) {
					entity.inicializarMapDefinicion();
					//entity.setMapDefinicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDefinicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDefinicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         		
					entity=DefinicionDataAccess.getEntityDefinicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDefinicionOriginal( new Definicion());
					////entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
					////entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDefinicions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Definicion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  Definicion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Definicion();
				
				if(conMapGenerico) {
					entity.inicializarMapDefinicion();
					//entity.setMapDefinicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDefinicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDefinicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         		
					entity=DefinicionDataAccess.getEntityDefinicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDefinicionOriginal( new Definicion());
					////entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
					////entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDefinicion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Definicion getEntityDefinicion(String strPrefijo,Definicion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Definicion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Definicion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DefinicionDataAccess.setFieldReflectionDefinicion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDefinicion=DefinicionConstantesFunciones.getTodosTiposColumnasDefinicion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDefinicion) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = Definicion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Definicion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DefinicionDataAccess.setFieldReflectionDefinicion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDefinicion(Field field,String strPrefijo,String sColumn,Definicion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DefinicionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.SECUENCIALFORMATO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DefinicionConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPODEFINICION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPOIVAITEM:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONMOSTRARBODEGA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.FACTOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONOTRORECARGO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONCOA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONRETENCION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONNOVEDADPRODUCTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONICE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONCANTIDAD:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONLOTECLIENTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONCUENTACONTABLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONDETALLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONIVAINCLUIDO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONLOTES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.NUMERODESCUENTOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONPRECIO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.NUMEROREGISTROS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONCENTROCOSTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONORDENIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONMULTIEMPRESA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONENLINEA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPOTRIBUTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONEVALUACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONOT:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONANTICIPO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONCIERRE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONGENERAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONPORPRODUCTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONDESCUENTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONSERIES:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDLIBROCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONINTERNO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONRESERVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONPRECIOPROVEEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONPRODUCCION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONCODIGOBARRA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.CONROMANEOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DefinicionConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Definicion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new Definicion();
					entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDefinicion("",entity,resultSet);
					
					//entity.setDefinicionOriginal( new Definicion());
					//entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
					//entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDefinicions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Definicion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<Definicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Definicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Definicion();
      	    	entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDefinicion("",entity,resultSet);
      	    	
				//entity.setDefinicionOriginal( new Definicion());
      	    	//entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDefinicions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Definicion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<Definicion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Definicion> entities = new  ArrayList<Definicion>();
		Definicion entity = new Definicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Definicion();
      	    	entity=super.getEntity("",entity,resultSet,DefinicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDefinicion("",entity,resultSet);
      	    	
				//entity.setDefinicionOriginal( new Definicion());
      	    	//entity.setDefinicionOriginal(super.getEntity("",entity.getDefinicionOriginal(),resultSet,DefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDefinicionOriginal(this.getEntityDefinicion("",entity.getDefinicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDefinicions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Definicion getEntityDefinicion(String strPrefijo,Definicion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDEMPRESA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDMODULO));
				entity.setsecuencial_formato(resultSet.getString(strPrefijo+DefinicionConstantesFunciones.SECUENCIALFORMATO));
				entity.setsecuencial(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.SECUENCIAL));
				entity.setid_tipo_definicion(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPODEFINICION));
				entity.setid_transaccion(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTRANSACCION));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_iva_item(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPOIVAITEM));
				entity.setcon_mostrar_bodega(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONMOSTRARBODEGA));
				entity.setfactor(resultSet.getDouble(strPrefijo+DefinicionConstantesFunciones.FACTOR));
				entity.setcon_otro_recargo(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONOTRORECARGO));
				entity.setid_tipo_global_cliente(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPOGLOBALCLIENTE));
				entity.setcon_coa(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONCOA));
				entity.setid_tipo_costeo_definicion(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPOCOSTEODEFINICION));
				entity.setcon_retencion(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONRETENCION));
				entity.setid_tipo_costo_definicion(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPOCOSTODEFINICION));
				entity.setcon_novedad_producto(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONNOVEDADPRODUCTO));
				entity.setcon_ice(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONICE));
				entity.setcon_cantidad(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONCANTIDAD));
				entity.setcon_producto_por_proveedor(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONPRODUCTOPORPROVEEDOR));
				entity.setcon_lote_cliente(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONLOTECLIENTE));
				entity.setcon_cuenta_contable(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONCUENTACONTABLE));
				entity.setcon_detalle(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONDETALLE));
				entity.setcon_iva_incluido(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONIVAINCLUIDO));
				entity.setcon_lotes(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONLOTES));
				entity.setnumero_descuentos(resultSet.getInt(strPrefijo+DefinicionConstantesFunciones.NUMERODESCUENTOS));
				entity.setcon_precio(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONPRECIO));
				entity.setnumero_registros(resultSet.getInt(strPrefijo+DefinicionConstantesFunciones.NUMEROREGISTROS));
				entity.setcon_centro_costo(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONCENTROCOSTO));
				entity.setcon_orden_iva(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONORDENIVA));
				entity.setcon_multi_empresa(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONMULTIEMPRESA));
				entity.setid_formato(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setcon_en_linea(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONENLINEA));
				entity.setid_tipo_tributario(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPOTRIBUTARIO));if(resultSet.wasNull()) {entity.setid_tipo_tributario(null); }
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPORETENCION));if(resultSet.wasNull()) {entity.setid_tipo_retencion(null); }
				entity.setcon_evaluacion(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONEVALUACION));
				entity.setcon_ot(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONOT));
				entity.setcon_anticipo(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONANTICIPO));
				entity.setcon_cierre(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONCIERRE));
				entity.setcon_general(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONGENERAL));
				entity.setcon_por_producto(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONPORPRODUCTO));
				entity.setcon_descuento(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONDESCUENTO));
				entity.setcon_series(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONSERIES));
				entity.setcantidad(resultSet.getInt(strPrefijo+DefinicionConstantesFunciones.CANTIDAD));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPODOCUMENTO));if(resultSet.wasNull()) {entity.setid_tipo_documento(null); }
				entity.setid_libro_contable(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDLIBROCONTABLE));if(resultSet.wasNull()) {entity.setid_libro_contable(null); }
				entity.setcon_interno(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONINTERNO));
				entity.setcon_reserva(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONRESERVA));
				entity.setcon_precio_proveedor(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONPRECIOPROVEEDOR));
				entity.setcon_produccion(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONPRODUCCION));
				entity.setcon_codigo_barra(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONCODIGOBARRA));
				entity.setcon_romaneos(resultSet.getBoolean(strPrefijo+DefinicionConstantesFunciones.CONROMANEOS));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+DefinicionConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
			} else {
				entity.setsecuencial_formato(resultSet.getString(strPrefijo+DefinicionConstantesFunciones.SECUENCIALFORMATO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDefinicion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Definicion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DefinicionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DefinicionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DefinicionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DefinicionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DefinicionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DefinicionDataAccess.TABLENAME,DefinicionDataAccess.ISWITHSTOREPROCEDURES);
			
			DefinicionDataAccess.setDefinicionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldefinicion.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Modulo getModulo(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldefinicion.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoDefinicion getTipoDefinicion(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoDefinicion tipodefinicion= new TipoDefinicion();

		try {
			TipoDefinicionDataAccess tipodefinicionDataAccess=new TipoDefinicionDataAccess();

			tipodefinicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodefinicionDataAccess.setConnexionType(this.connexionType);
			tipodefinicionDataAccess.setParameterDbType(this.parameterDbType);

			tipodefinicion=tipodefinicionDataAccess.getEntity(connexion,reldefinicion.getid_tipo_definicion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodefinicion;

	}

	public Transaccion getTransaccion(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reldefinicion.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public Sucursal getSucursal(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldefinicion.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoIvaItem getTipoIvaItem(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoIvaItem tipoivaitem= new TipoIvaItem();

		try {
			TipoIvaItemDataAccess tipoivaitemDataAccess=new TipoIvaItemDataAccess();

			tipoivaitemDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaitemDataAccess.setConnexionType(this.connexionType);
			tipoivaitemDataAccess.setParameterDbType(this.parameterDbType);

			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion,reldefinicion.getid_tipo_iva_item());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoivaitem;

	}

	public TipoGlobalCliente getTipoGlobalCliente(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoGlobalCliente tipoglobalcliente= new TipoGlobalCliente();

		try {
			TipoGlobalClienteDataAccess tipoglobalclienteDataAccess=new TipoGlobalClienteDataAccess();

			tipoglobalclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoglobalclienteDataAccess.setConnexionType(this.connexionType);
			tipoglobalclienteDataAccess.setParameterDbType(this.parameterDbType);

			tipoglobalcliente=tipoglobalclienteDataAccess.getEntity(connexion,reldefinicion.getid_tipo_global_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoglobalcliente;

	}

	public TipoCosteoDefinicion getTipoCosteoDefinicion(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoCosteoDefinicion tipocosteodefinicion= new TipoCosteoDefinicion();

		try {
			TipoCosteoDefinicionDataAccess tipocosteodefinicionDataAccess=new TipoCosteoDefinicionDataAccess();

			tipocosteodefinicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocosteodefinicionDataAccess.setConnexionType(this.connexionType);
			tipocosteodefinicionDataAccess.setParameterDbType(this.parameterDbType);

			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion,reldefinicion.getid_tipo_costeo_definicion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocosteodefinicion;

	}

	public TipoCostoDefinicion getTipoCostoDefinicion(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoCostoDefinicion tipocostodefinicion= new TipoCostoDefinicion();

		try {
			TipoCostoDefinicionDataAccess tipocostodefinicionDataAccess=new TipoCostoDefinicionDataAccess();

			tipocostodefinicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocostodefinicionDataAccess.setConnexionType(this.connexionType);
			tipocostodefinicionDataAccess.setParameterDbType(this.parameterDbType);

			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion,reldefinicion.getid_tipo_costo_definicion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocostodefinicion;

	}

	public Formato getFormato(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,reldefinicion.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoTributario getTipoTributario(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoTributario tipotributario= new TipoTributario();

		try {
			TipoTributarioDataAccess tipotributarioDataAccess=new TipoTributarioDataAccess();

			tipotributarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotributarioDataAccess.setConnexionType(this.connexionType);
			tipotributarioDataAccess.setParameterDbType(this.parameterDbType);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,reldefinicion.getid_tipo_tributario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotributario;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,reldefinicion.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,reldefinicion.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public LibroContable getLibroContable(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		LibroContable librocontable= new LibroContable();

		try {
			LibroContableDataAccess librocontableDataAccess=new LibroContableDataAccess();

			librocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			librocontableDataAccess.setConnexionType(this.connexionType);
			librocontableDataAccess.setParameterDbType(this.parameterDbType);

			librocontable=librocontableDataAccess.getEntity(connexion,reldefinicion.getid_libro_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return librocontable;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reldefinicion.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public CuentaContable getCuentaContable(Connexion connexion,Definicion reldefinicion)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldefinicion.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Definicion definicion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!definicion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(definicion.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(definicion.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_formato=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_formato.setValue(definicion.getsecuencial_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuesecuencial=new ParameterValue<Long>();
					parameterMaintenanceValuesecuencial.setValue(definicion.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_definicion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_definicion.setValue(definicion.getid_tipo_definicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_definicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(definicion.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(definicion.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_iva_item=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_iva_item.setValue(definicion.getid_tipo_iva_item());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_iva_item);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mostrar_bodega=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mostrar_bodega.setValue(definicion.getcon_mostrar_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mostrar_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefactor=new ParameterValue<Double>();
					parameterMaintenanceValuefactor.setValue(definicion.getfactor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefactor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_otro_recargo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_otro_recargo.setValue(definicion.getcon_otro_recargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_otro_recargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_global_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_global_cliente.setValue(definicion.getid_tipo_global_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_global_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_coa=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_coa.setValue(definicion.getcon_coa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_coa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_costeo_definicion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_costeo_definicion.setValue(definicion.getid_tipo_costeo_definicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_costeo_definicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_retencion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_retencion.setValue(definicion.getcon_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_costo_definicion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_costo_definicion.setValue(definicion.getid_tipo_costo_definicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_costo_definicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_novedad_producto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_novedad_producto.setValue(definicion.getcon_novedad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_novedad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_ice=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_ice.setValue(definicion.getcon_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cantidad=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cantidad.setValue(definicion.getcon_cantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_producto_por_proveedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_producto_por_proveedor.setValue(definicion.getcon_producto_por_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_producto_por_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_lote_cliente=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_lote_cliente.setValue(definicion.getcon_lote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_lote_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuenta_contable=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuenta_contable.setValue(definicion.getcon_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle.setValue(definicion.getcon_detalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_iva_incluido=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_iva_incluido.setValue(definicion.getcon_iva_incluido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_iva_incluido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_lotes=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_lotes.setValue(definicion.getcon_lotes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_lotes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_descuentos=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_descuentos.setValue(definicion.getnumero_descuentos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_descuentos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precio=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precio.setValue(definicion.getcon_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_registros=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_registros.setValue(definicion.getnumero_registros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_registros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_centro_costo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_centro_costo.setValue(definicion.getcon_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_orden_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_orden_iva.setValue(definicion.getcon_orden_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_orden_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_multi_empresa=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_multi_empresa.setValue(definicion.getcon_multi_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_multi_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(definicion.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_en_linea=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_en_linea.setValue(definicion.getcon_en_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_en_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_tributario=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_tributario.setValue(definicion.getid_tipo_tributario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_tributario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(definicion.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_evaluacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_evaluacion.setValue(definicion.getcon_evaluacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_evaluacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_ot=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_ot.setValue(definicion.getcon_ot());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_ot);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_anticipo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_anticipo.setValue(definicion.getcon_anticipo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_anticipo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cierre=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cierre.setValue(definicion.getcon_cierre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cierre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_general=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_general.setValue(definicion.getcon_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_por_producto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_por_producto.setValue(definicion.getcon_por_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_por_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_descuento=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_descuento.setValue(definicion.getcon_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_series=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_series.setValue(definicion.getcon_series());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_series);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(definicion.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(definicion.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_libro_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_libro_contable.setValue(definicion.getid_libro_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_libro_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_interno=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_interno.setValue(definicion.getcon_interno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_interno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_reserva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_reserva.setValue(definicion.getcon_reserva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_reserva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precio_proveedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precio_proveedor.setValue(definicion.getcon_precio_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precio_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_produccion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_produccion.setValue(definicion.getcon_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_codigo_barra=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_codigo_barra.setValue(definicion.getcon_codigo_barra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_codigo_barra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_romaneos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_romaneos.setValue(definicion.getcon_romaneos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_romaneos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(definicion.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(definicion.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
						if(!definicion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(definicion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(definicion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(definicion.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseDefinicion(Definicion definicion)throws Exception  {		
		definicion.setIsNew(false);
		definicion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDefinicions(List<Definicion> definicions)throws Exception  {				
		for(Definicion definicion:definicions) {
			definicion.setIsNew(false);
			definicion.setIsChanged(false);
		}
	}
	
	public void generarExportarDefinicion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
