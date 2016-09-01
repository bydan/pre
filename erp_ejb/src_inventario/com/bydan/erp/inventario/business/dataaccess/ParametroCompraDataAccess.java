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
import com.bydan.erp.inventario.util.*;//ParametroCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class ParametroCompraDataAccess extends  ParametroCompraDataAccessAdditional{ //ParametroCompraDataAccessAdditional,DataAccessHelper<ParametroCompra>
	//static Logger logger = Logger.getLogger(ParametroCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="parametro_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,secuencial_pedido,secuencial_cotizacion,secuencial_produccion,id_tipo_documento,id_tipo_movimiento,id_bodega,id_bodega_reserva,id_empleado,id_embarcador,con_centro_costo,texto_mail,id_modulo,id_tipo_movimiento_modulo,descripcion,id_formato_pedido,id_estado_pedido_pendiente,id_formato_cotizacion,id_estado_pedido_cotizado,id_formato_autorizacion,id_estado_pedido_autorizado,id_formato_item,id_estado_pedido_anulado,id_prioridad_pedido,id_estado_pedido_suspendido,id_estado_pedido_regularizado)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,secuencial_pedido=?,secuencial_cotizacion=?,secuencial_produccion=?,id_tipo_documento=?,id_tipo_movimiento=?,id_bodega=?,id_bodega_reserva=?,id_empleado=?,id_embarcador=?,con_centro_costo=?,texto_mail=?,id_modulo=?,id_tipo_movimiento_modulo=?,descripcion=?,id_formato_pedido=?,id_estado_pedido_pendiente=?,id_formato_cotizacion=?,id_estado_pedido_cotizado=?,id_formato_autorizacion=?,id_estado_pedido_autorizado=?,id_formato_item=?,id_estado_pedido_anulado=?,id_prioridad_pedido=?,id_estado_pedido_suspendido=?,id_estado_pedido_regularizado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select parametrocompra from "+ParametroCompraConstantesFunciones.SPERSISTENCENAME+" parametrocompra";
	public static String QUERYSELECTNATIVE="select "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".version_row,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_empresa,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_pedido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_cotizacion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_produccion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_tipo_documento,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_bodega,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_bodega_reserva,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_empleado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_embarcador,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".con_centro_costo,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".texto_mail,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_modulo,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".descripcion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_pedido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_pendiente,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_cotizacion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_cotizado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_autorizacion,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_autorizado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_formato_item,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_anulado,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_prioridad_pedido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_suspendido,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id_estado_pedido_regularizado from "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME;//+" as "+ParametroCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".id,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".version_row,"+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+".secuencial_cotizacion from "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME;//+" as "+ParametroCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ParametroCompraConstantesFunciones.SCHEMA+"."+ParametroCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,secuencial_pedido=?,secuencial_cotizacion=?,secuencial_produccion=?,id_tipo_documento=?,id_tipo_movimiento=?,id_bodega=?,id_bodega_reserva=?,id_empleado=?,id_embarcador=?,con_centro_costo=?,texto_mail=?,id_modulo=?,id_tipo_movimiento_modulo=?,descripcion=?,id_formato_pedido=?,id_estado_pedido_pendiente=?,id_formato_cotizacion=?,id_estado_pedido_cotizado=?,id_formato_autorizacion=?,id_estado_pedido_autorizado=?,id_formato_item=?,id_estado_pedido_anulado=?,id_prioridad_pedido=?,id_estado_pedido_suspendido=?,id_estado_pedido_regularizado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PARAMETROCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PARAMETROCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PARAMETROCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PARAMETROCOMPRA_SELECT(?,?)";
	
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
	
	
	protected ParametroCompraDataAccessAdditional parametrocompraDataAccessAdditional=null;
	
	public ParametroCompraDataAccessAdditional getParametroCompraDataAccessAdditional() {
		return this.parametrocompraDataAccessAdditional;
	}
	
	public void setParametroCompraDataAccessAdditional(ParametroCompraDataAccessAdditional parametrocompraDataAccessAdditional) {
		try {
			this.parametrocompraDataAccessAdditional=parametrocompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ParametroCompraDataAccess() {
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
		ParametroCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ParametroCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ParametroCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setParametroCompraOriginal(ParametroCompra parametrocompra)throws Exception  {
		parametrocompra.setParametroCompraOriginal((ParametroCompra)parametrocompra.clone());		
	}
	
	public void setParametroComprasOriginal(List<ParametroCompra> parametrocompras)throws Exception  {
		
		for(ParametroCompra parametrocompra:parametrocompras){
			parametrocompra.setParametroCompraOriginal((ParametroCompra)parametrocompra.clone());
		}
	}
	
	public static void setParametroCompraOriginalStatic(ParametroCompra parametrocompra)throws Exception  {
		parametrocompra.setParametroCompraOriginal((ParametroCompra)parametrocompra.clone());		
	}
	
	public static void setParametroComprasOriginalStatic(List<ParametroCompra> parametrocompras)throws Exception  {
		
		for(ParametroCompra parametrocompra:parametrocompras){
			parametrocompra.setParametroCompraOriginal((ParametroCompra)parametrocompra.clone());
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
	
	public  ParametroCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroCompra entity = new ParametroCompra();		
		
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
	
	public  ParametroCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ParametroCompra entity = new ParametroCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ParametroCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setParametroCompraOriginal(new ParametroCompra());
      	    	entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroCompra("",entity,resultSet); 
				
				//entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ParametroCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroCompra entity = new ParametroCompra();
				
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
	
	public  ParametroCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ParametroCompra entity = new ParametroCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ParametroCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setParametroCompraOriginal(new ParametroCompra());
      	    	entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityParametroCompra("",entity,resultSet);    
				
				//entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseParametroCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ParametroCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ParametroCompra entity = new ParametroCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ParametroCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseParametroCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ParametroCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		
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
	
	public  List<ParametroCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCompra();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCompra("",entity,resultSet);
      	    	
				//entity.setParametroCompraOriginal( new ParametroCompra());
      	    	//entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
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
	
	public  List<ParametroCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroCompra();
					//entity.setMapParametroCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapParametroCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         		
					entity=ParametroCompraDataAccess.getEntityParametroCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroCompraOriginal( new ParametroCompra());
					////entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ParametroCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroCompra entity = new ParametroCompra();		  
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
	
	public  ParametroCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapParametroCompra();
					//entity.setMapParametroCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapParametroCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapParametroCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         		
					entity=ParametroCompraDataAccess.getEntityParametroCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setParametroCompraOriginal( new ParametroCompra());
					////entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseParametroCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ParametroCompra getEntityParametroCompra(String strPrefijo,ParametroCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ParametroCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ParametroCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ParametroCompraDataAccess.setFieldReflectionParametroCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasParametroCompra=ParametroCompraConstantesFunciones.getTodosTiposColumnasParametroCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasParametroCompra) {
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
							field = ParametroCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ParametroCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ParametroCompraDataAccess.setFieldReflectionParametroCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionParametroCompra(Field field,String strPrefijo,String sColumn,ParametroCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ParametroCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.SECUENCIALPEDIDO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDTIPODOCUMENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDBODEGARESERVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDEMBARCADOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.CONCENTROCOSTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.TEXTOMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDFORMATOPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDFORMATOITEM:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ParametroCompra();
					entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityParametroCompra("",entity,resultSet);
					
					//entity.setParametroCompraOriginal( new ParametroCompra());
					//entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseParametroCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ParametroCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ParametroCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ParametroCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ParametroCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
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
	
	public  List<ParametroCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCompra();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCompra("",entity,resultSet);
      	    	
				//entity.setParametroCompraOriginal( new ParametroCompra());
      	    	//entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseParametroCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarParametroCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ParametroCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
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
	
	public  List<ParametroCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ParametroCompra> entities = new  ArrayList<ParametroCompra>();
		ParametroCompra entity = new ParametroCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ParametroCompra();
      	    	entity=super.getEntity("",entity,resultSet,ParametroCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityParametroCompra("",entity,resultSet);
      	    	
				//entity.setParametroCompraOriginal( new ParametroCompra());
      	    	//entity.setParametroCompraOriginal(super.getEntity("",entity.getParametroCompraOriginal(),resultSet,ParametroCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setParametroCompraOriginal(this.getEntityParametroCompra("",entity.getParametroCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseParametroCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ParametroCompra getEntityParametroCompra(String strPrefijo,ParametroCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDEMPRESA));
				entity.setsecuencial_pedido(resultSet.getString(strPrefijo+ParametroCompraConstantesFunciones.SECUENCIALPEDIDO));
				entity.setsecuencial_cotizacion(resultSet.getString(strPrefijo+ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION));
				entity.setsecuencial_produccion(resultSet.getString(strPrefijo+ParametroCompraConstantesFunciones.SECUENCIALPRODUCCION));
				entity.setid_tipo_documento(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDTIPODOCUMENTO));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDBODEGA));
				entity.setid_bodega_reserva(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDBODEGARESERVA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDEMPLEADO));
				entity.setid_embarcador(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDEMBARCADOR));
				entity.setcon_centro_costo(resultSet.getBoolean(strPrefijo+ParametroCompraConstantesFunciones.CONCENTROCOSTO));
				entity.settexto_mail(resultSet.getString(strPrefijo+ParametroCompraConstantesFunciones.TEXTOMAIL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDMODULO));
				entity.setid_tipo_movimiento_modulo(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDTIPOMOVIMIENTOMODULO));
				entity.setdescripcion(resultSet.getString(strPrefijo+ParametroCompraConstantesFunciones.DESCRIPCION));
				entity.setid_formato_pedido(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDFORMATOPEDIDO));
				entity.setid_estado_pedido_pendiente(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDESTADOPEDIDOPENDIENTE));
				entity.setid_formato_cotizacion(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDFORMATOCOTIZACION));
				entity.setid_estado_pedido_cotizado(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDESTADOPEDIDOCOTIZADO));
				entity.setid_formato_autorizacion(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDFORMATOAUTORIZACION));
				entity.setid_estado_pedido_autorizado(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDESTADOPEDIDOAUTORIZADO));
				entity.setid_formato_item(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDFORMATOITEM));
				entity.setid_estado_pedido_anulado(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDESTADOPEDIDOANULADO));
				entity.setid_prioridad_pedido(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDPRIORIDADPEDIDO));
				entity.setid_estado_pedido_suspendido(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDESTADOPEDIDOSUSPENDIDO));
				entity.setid_estado_pedido_regularizado(resultSet.getLong(strPrefijo+ParametroCompraConstantesFunciones.IDESTADOPEDIDOREGULARIZADO));
			} else {
				entity.setsecuencial_cotizacion(resultSet.getString(strPrefijo+ParametroCompraConstantesFunciones.SECUENCIALCOTIZACION));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowParametroCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ParametroCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ParametroCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ParametroCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ParametroCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ParametroCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ParametroCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ParametroCompraDataAccess.TABLENAME,ParametroCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			ParametroCompraDataAccess.setParametroCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relparametrocompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoDocumento getTipoDocumento(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		TipoDocumento tipodocumento= new TipoDocumento();

		try {
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);

			tipodocumento=tipodocumentoDataAccess.getEntity(connexion,relparametrocompra.getid_tipo_documento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumento;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relparametrocompra.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}

	public Bodega getBodega(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrocompra.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Bodega getBodegaReserva(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relparametrocompra.getid_bodega_reserva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Empleado getEmpleado(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relparametrocompra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Embarcador getEmbarcador(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Embarcador embarcador= new Embarcador();

		try {
			EmbarcadorDataAccess embarcadorDataAccess=new EmbarcadorDataAccess();

			embarcadorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			embarcadorDataAccess.setConnexionType(this.connexionType);
			embarcadorDataAccess.setParameterDbType(this.parameterDbType);

			embarcador=embarcadorDataAccess.getEntity(connexion,relparametrocompra.getid_embarcador());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return embarcador;

	}

	public Modulo getModulo(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relparametrocompra.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoMovimientoModulo getTipoMovimientoModulo(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		TipoMovimientoModulo tipomovimientomodulo= new TipoMovimientoModulo();

		try {
			TipoMovimientoModuloDataAccess tipomovimientomoduloDataAccess=new TipoMovimientoModuloDataAccess();

			tipomovimientomoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientomoduloDataAccess.setConnexionType(this.connexionType);
			tipomovimientomoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimientomodulo=tipomovimientomoduloDataAccess.getEntity(connexion,relparametrocompra.getid_tipo_movimiento_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimientomodulo;

	}

	public Formato getFormatoPedido(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrocompra.getid_formato_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public EstadoPedido getEstadoPedidoPendiente(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relparametrocompra.getid_estado_pedido_pendiente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public Formato getFormatoCotizacion(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrocompra.getid_formato_cotizacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public EstadoPedido getEstadoPedidoCotizado(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relparametrocompra.getid_estado_pedido_cotizado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public Formato getFormatoAutorizacion(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrocompra.getid_formato_autorizacion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public EstadoPedido getEstadoPedidoAutorizado(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relparametrocompra.getid_estado_pedido_autorizado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public Formato getFormatoItem(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relparametrocompra.getid_formato_item());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public EstadoPedido getEstadoPedidoAnulado(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relparametrocompra.getid_estado_pedido_anulado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public PrioridadPedido getPrioridadPedido(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		PrioridadPedido prioridadpedido= new PrioridadPedido();

		try {
			PrioridadPedidoDataAccess prioridadpedidoDataAccess=new PrioridadPedidoDataAccess();

			prioridadpedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			prioridadpedidoDataAccess.setConnexionType(this.connexionType);
			prioridadpedidoDataAccess.setParameterDbType(this.parameterDbType);

			prioridadpedido=prioridadpedidoDataAccess.getEntity(connexion,relparametrocompra.getid_prioridad_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return prioridadpedido;

	}

	public EstadoPedido getEstadoPedidoSuspendido(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relparametrocompra.getid_estado_pedido_suspendido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public EstadoPedido getEstadoPedidoRegularizado(Connexion connexion,ParametroCompra relparametrocompra)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relparametrocompra.getid_estado_pedido_regularizado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ParametroCompra parametrocompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!parametrocompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(parametrocompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_pedido=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_pedido.setValue(parametrocompra.getsecuencial_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_cotizacion=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_cotizacion.setValue(parametrocompra.getsecuencial_cotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_cotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial_produccion=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial_produccion.setValue(parametrocompra.getsecuencial_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_documento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_documento.setValue(parametrocompra.getid_tipo_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(parametrocompra.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(parametrocompra.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_reserva=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_reserva.setValue(parametrocompra.getid_bodega_reserva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_reserva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(parametrocompra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_embarcador=new ParameterValue<Long>();
					parameterMaintenanceValueid_embarcador.setValue(parametrocompra.getid_embarcador());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_embarcador);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_centro_costo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_centro_costo.setValue(parametrocompra.getcon_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetexto_mail=new ParameterValue<String>();
					parameterMaintenanceValuetexto_mail.setValue(parametrocompra.gettexto_mail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetexto_mail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(parametrocompra.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento_modulo.setValue(parametrocompra.getid_tipo_movimiento_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(parametrocompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_pedido.setValue(parametrocompra.getid_formato_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_pendiente=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_pendiente.setValue(parametrocompra.getid_estado_pedido_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_pendiente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_cotizacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_cotizacion.setValue(parametrocompra.getid_formato_cotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_cotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_cotizado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_cotizado.setValue(parametrocompra.getid_estado_pedido_cotizado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_cotizado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_autorizacion=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_autorizacion.setValue(parametrocompra.getid_formato_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_autorizado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_autorizado.setValue(parametrocompra.getid_estado_pedido_autorizado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_autorizado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_item=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_item.setValue(parametrocompra.getid_formato_item());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_item);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_anulado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_anulado.setValue(parametrocompra.getid_estado_pedido_anulado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_anulado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_prioridad_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_prioridad_pedido.setValue(parametrocompra.getid_prioridad_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_prioridad_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_suspendido=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_suspendido.setValue(parametrocompra.getid_estado_pedido_suspendido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_suspendido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_regularizado=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_regularizado.setValue(parametrocompra.getid_estado_pedido_regularizado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_regularizado);
					parametersTemp.add(parameterMaintenance);
					
						if(!parametrocompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(parametrocompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(parametrocompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(parametrocompra.getId());
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
	
	public void setIsNewIsChangedFalseParametroCompra(ParametroCompra parametrocompra)throws Exception  {		
		parametrocompra.setIsNew(false);
		parametrocompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseParametroCompras(List<ParametroCompra> parametrocompras)throws Exception  {				
		for(ParametroCompra parametrocompra:parametrocompras) {
			parametrocompra.setIsNew(false);
			parametrocompra.setIsChanged(false);
		}
	}
	
	public void generarExportarParametroCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
