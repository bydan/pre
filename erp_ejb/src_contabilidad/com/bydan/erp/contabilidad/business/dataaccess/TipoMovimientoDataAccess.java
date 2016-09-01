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
package com.bydan.erp.contabilidad.business.dataaccess;

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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoMovimientoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.activosfijos.util.*;




@SuppressWarnings("unused")
final public class TipoMovimientoDataAccess extends  DataAccessHelperSinIdGenerated<TipoMovimiento>{ //TipoMovimientoDataAccessAdditional,DataAccessHelper<TipoMovimiento>
	//static Logger logger = Logger.getLogger(TipoMovimientoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_movimiento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomovimiento from "+TipoMovimientoConstantesFunciones.SPERSISTENCENAME+" tipomovimiento";
	public static String QUERYSELECTNATIVE="select "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".id,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".version_row,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".codigo,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".nombre from "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME;//+" as "+TipoMovimientoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".id,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".version_row,"+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+".nombre from "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME;//+" as "+TipoMovimientoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoMovimientoConstantesFunciones.SCHEMA+"."+TipoMovimientoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMOVIMIENTO_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMOVIMIENTO_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMOVIMIENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMOVIMIENTO_SELECT(?,?)";
	
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
	
	
	public TipoMovimientoDataAccess() {
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
		TipoMovimientoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoMovimientoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoMovimientoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoMovimientoOriginal(TipoMovimiento tipomovimiento)throws Exception  {
		tipomovimiento.setTipoMovimientoOriginal((TipoMovimiento)tipomovimiento.clone());		
	}
	
	public void setTipoMovimientosOriginal(List<TipoMovimiento> tipomovimientos)throws Exception  {
		
		for(TipoMovimiento tipomovimiento:tipomovimientos){
			tipomovimiento.setTipoMovimientoOriginal((TipoMovimiento)tipomovimiento.clone());
		}
	}
	
	public static void setTipoMovimientoOriginalStatic(TipoMovimiento tipomovimiento)throws Exception  {
		tipomovimiento.setTipoMovimientoOriginal((TipoMovimiento)tipomovimiento.clone());		
	}
	
	public static void setTipoMovimientosOriginalStatic(List<TipoMovimiento> tipomovimientos)throws Exception  {
		
		for(TipoMovimiento tipomovimiento:tipomovimientos){
			tipomovimiento.setTipoMovimientoOriginal((TipoMovimiento)tipomovimiento.clone());
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
	
	public  TipoMovimiento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMovimiento entity = new TipoMovimiento();		
		
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
	
	public  TipoMovimiento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMovimiento entity = new TipoMovimiento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoMovimiento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoMovimientoOriginal(new TipoMovimiento());
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMovimiento("",entity,resultSet); 
				
				//entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMovimiento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoMovimiento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMovimiento entity = new TipoMovimiento();
				
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
	
	public  TipoMovimiento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMovimiento entity = new TipoMovimiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoMovimiento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoMovimientoOriginal(new TipoMovimiento());
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMovimiento("",entity,resultSet);    
				
				//entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMovimiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoMovimiento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoMovimiento entity = new TipoMovimiento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoMovimiento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoMovimiento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoMovimiento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
		
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
	
	public  List<TipoMovimiento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimiento("",entity,resultSet);
      	    	
				//entity.setTipoMovimientoOriginal( new TipoMovimiento());
      	    	//entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimientos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMovimiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
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
	
	public  List<TipoMovimiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMovimiento();
					//entity.setMapTipoMovimiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoMovimientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMovimiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         		
					entity=TipoMovimientoDataAccess.getEntityTipoMovimiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMovimientoOriginal( new TipoMovimiento());
					////entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimientos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoMovimiento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMovimiento entity = new TipoMovimiento();		  
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
	
	public  TipoMovimiento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMovimiento entity = new TipoMovimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMovimiento();
					//entity.setMapTipoMovimiento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoMovimientoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMovimiento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         		
					entity=TipoMovimientoDataAccess.getEntityTipoMovimiento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMovimientoOriginal( new TipoMovimiento());
					////entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoMovimiento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoMovimiento getEntityTipoMovimiento(String strPrefijo,TipoMovimiento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoMovimiento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoMovimiento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoMovimientoDataAccess.setFieldReflectionTipoMovimiento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoMovimiento=TipoMovimientoConstantesFunciones.getTodosTiposColumnasTipoMovimiento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoMovimiento) {
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
							field = TipoMovimiento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoMovimiento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoMovimientoDataAccess.setFieldReflectionTipoMovimiento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoMovimiento(Field field,String strPrefijo,String sColumn,TipoMovimiento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoMovimientoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMovimientoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimientoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimientoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMovimiento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoMovimiento();
					entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoMovimiento("",entity,resultSet);
					
					//entity.setTipoMovimientoOriginal( new TipoMovimiento());
					//entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoMovimientos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMovimiento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimientoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimientoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoMovimiento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
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
	
	public  List<TipoMovimiento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimiento> entities = new  ArrayList<TipoMovimiento>();
		TipoMovimiento entity = new TipoMovimiento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimiento("",entity,resultSet);
      	    	
				//entity.setTipoMovimientoOriginal( new TipoMovimiento());
      	    	//entity.setTipoMovimientoOriginal(super.getEntity("",entity.getTipoMovimientoOriginal(),resultSet,TipoMovimientoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimientoOriginal(this.getEntityTipoMovimiento("",entity.getTipoMovimientoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoMovimientos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoMovimiento getEntityTipoMovimiento(String strPrefijo,TipoMovimiento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMovimientoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoMovimientoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoMovimientoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoMovimiento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoMovimiento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoMovimientoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoMovimientoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoMovimientoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoMovimientoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoMovimientoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoMovimientoDataAccess.TABLENAME,TipoMovimientoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoMovimientoDataAccess.setTipoMovimientoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<FacturaProveedorServicio> getFacturaProveedorServicios(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<FacturaProveedorServicio> facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+FacturaProveedorServicioConstantesFunciones.SCHEMA+".factura_proveedor_servicio.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedorservicio.TipoMovimiento WHERE facturaproveedorservicio.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess=new FacturaProveedorServicioDataAccess();

			facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedorservicios;

	}

	public List<FacturaProveedor> getFacturaProveedors(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<FacturaProveedor> facturaproveedors= new ArrayList<FacturaProveedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+FacturaProveedorConstantesFunciones.SCHEMA+".factura_proveedor.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN facturaproveedor.TipoMovimiento WHERE facturaproveedor.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FacturaProveedorDataAccess facturaproveedorDataAccess=new FacturaProveedorDataAccess();

			facturaproveedorDataAccess.setConnexionType(this.connexionType);
			facturaproveedorDataAccess.setParameterDbType(this.parameterDbType);
			facturaproveedors=facturaproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return facturaproveedors;

	}

	public List<PresupuestoFlujoCajaTsr> getPresupuestoFlujoCajaTsrs(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<PresupuestoFlujoCajaTsr> presupuestoflujocajatsrs= new ArrayList<PresupuestoFlujoCajaTsr>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+PresupuestoFlujoCajaTsrConstantesFunciones.SCHEMA+".presupuesto_flujo_caja_tsr.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN presupuestoflujocajatsr.TipoMovimiento WHERE presupuestoflujocajatsr.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoFlujoCajaTsrDataAccess presupuestoflujocajatsrDataAccess=new PresupuestoFlujoCajaTsrDataAccess();

			presupuestoflujocajatsrDataAccess.setConnexionType(this.connexionType);
			presupuestoflujocajatsrDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoflujocajatsrs=presupuestoflujocajatsrDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoflujocajatsrs;

	}

	public List<TipoDocumento> getTipoDocumentos(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<TipoDocumento> tipodocumentos= new ArrayList<TipoDocumento>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+TipoDocumentoConstantesFunciones.SCHEMA+".tipo_documento.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN tipodocumento.TipoMovimiento WHERE tipodocumento.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TipoDocumentoDataAccess tipodocumentoDataAccess=new TipoDocumentoDataAccess();

			tipodocumentoDataAccess.setConnexionType(this.connexionType);
			tipodocumentoDataAccess.setParameterDbType(this.parameterDbType);
			tipodocumentos=tipodocumentoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodocumentos;

	}

	public List<CentroActividad> getCentroActividads(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<CentroActividad> centroactividads= new ArrayList<CentroActividad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+CentroActividadConstantesFunciones.SCHEMA+".centro_actividad.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN centroactividad.TipoMovimiento WHERE centroactividad.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CentroActividadDataAccess centroactividadDataAccess=new CentroActividadDataAccess();

			centroactividadDataAccess.setConnexionType(this.connexionType);
			centroactividadDataAccess.setParameterDbType(this.parameterDbType);
			centroactividads=centroactividadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centroactividads;

	}

	public List<ParametroCompra> getParametroCompras(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<ParametroCompra> parametrocompras= new ArrayList<ParametroCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+ParametroCompraConstantesFunciones.SCHEMA+".parametro_compra.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN parametrocompra.TipoMovimiento WHERE parametrocompra.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCompraDataAccess parametrocompraDataAccess=new ParametroCompraDataAccess();

			parametrocompraDataAccess.setConnexionType(this.connexionType);
			parametrocompraDataAccess.setParameterDbType(this.parameterDbType);
			parametrocompras=parametrocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocompras;

	}

	public List<Sri> getSris(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<Sri> sris= new ArrayList<Sri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+SriConstantesFunciones.SCHEMA+".sri.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN sri.TipoMovimiento WHERE sri.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SriDataAccess sriDataAccess=new SriDataAccess();

			sriDataAccess.setConnexionType(this.connexionType);
			sriDataAccess.setParameterDbType(this.parameterDbType);
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sris;

	}

	public List<AsientoContable> getAsientoContables(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<AsientoContable> asientocontables= new ArrayList<AsientoContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+AsientoContableConstantesFunciones.SCHEMA+".asiento_contable.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN asientocontable.TipoMovimiento WHERE asientocontable.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontables;

	}

	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<ParametroContabilidadDefecto> parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+".parametro_contabilidad_defecto.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN parametrocontabilidaddefecto.TipoMovimiento WHERE parametrocontabilidaddefecto.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroContabilidadDefectoDataAccess parametrocontabilidaddefectoDataAccess=new ParametroContabilidadDefectoDataAccess();

			parametrocontabilidaddefectoDataAccess.setConnexionType(this.connexionType);
			parametrocontabilidaddefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocontabilidaddefectos;

	}

	public List<MantenimientoActivoFijo> getMantenimientoActivoFijos(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<MantenimientoActivoFijo> mantenimientoactivofijos= new ArrayList<MantenimientoActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+".mantenimiento_activo_fijo.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN mantenimientoactivofijo.TipoMovimiento WHERE mantenimientoactivofijo.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MantenimientoActivoFijoDataAccess mantenimientoactivofijoDataAccess=new MantenimientoActivoFijoDataAccess();

			mantenimientoactivofijoDataAccess.setConnexionType(this.connexionType);
			mantenimientoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			mantenimientoactivofijos=mantenimientoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mantenimientoactivofijos;

	}

	public List<Secuencial> getSecuencials(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<Secuencial> secuencials= new ArrayList<Secuencial>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+SecuencialConstantesFunciones.SCHEMA+".secuencial.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN secuencial.TipoMovimiento WHERE secuencial.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SecuencialDataAccess secuencialDataAccess=new SecuencialDataAccess();

			secuencialDataAccess.setConnexionType(this.connexionType);
			secuencialDataAccess.setParameterDbType(this.parameterDbType);
			secuencials=secuencialDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return secuencials;

	}

	public List<Formato> getFormatos(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<Formato> formatos= new ArrayList<Formato>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+FormatoConstantesFunciones.SCHEMA+".formato.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN formato.TipoMovimiento WHERE formato.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);
			formatos=formatoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formatos;

	}

	public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,TipoMovimiento tipomovimiento)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_tipo_movimiento="+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id WHERE "+TipoMovimientoConstantesFunciones.SCHEMA+".tipo_movimiento.id="+String.valueOf(tipomovimiento.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.TipoMovimiento WHERE asientocontablecajachica.TipoMovimiento.id="+String.valueOf(tipomovimiento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AsientoContableCajaChicaDataAccess asientocontablecajachicaDataAccess=new AsientoContableCajaChicaDataAccess();

			asientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			asientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			asientocontablecajachicas=asientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontablecajachicas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoMovimiento tipomovimiento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomovimiento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipomovimiento.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipomovimiento.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomovimiento.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomovimiento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomovimiento.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomovimiento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomovimiento.getId());
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
	
	public void setIsNewIsChangedFalseTipoMovimiento(TipoMovimiento tipomovimiento)throws Exception  {		
		tipomovimiento.setIsNew(false);
		tipomovimiento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoMovimientos(List<TipoMovimiento> tipomovimientos)throws Exception  {				
		for(TipoMovimiento tipomovimiento:tipomovimientos) {
			tipomovimiento.setIsNew(false);
			tipomovimiento.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoMovimiento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
