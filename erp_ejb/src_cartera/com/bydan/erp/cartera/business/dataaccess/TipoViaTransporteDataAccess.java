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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TipoViaTransporteConstantesFunciones;


import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class TipoViaTransporteDataAccess extends  DataAccessHelperSinIdGenerated<TipoViaTransporte>{ //TipoViaTransporteDataAccessAdditional,DataAccessHelper<TipoViaTransporte>
	//static Logger logger = Logger.getLogger(TipoViaTransporteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_via_transporte";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoviatransporte from "+TipoViaTransporteConstantesFunciones.SPERSISTENCENAME+" tipoviatransporte";
	public static String QUERYSELECTNATIVE="select "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".id,"+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".version_row,"+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".nombre from "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME;//+" as "+TipoViaTransporteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".id,"+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".version_row,"+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+".nombre from "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME;//+" as "+TipoViaTransporteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoViaTransporteConstantesFunciones.SCHEMA+"."+TipoViaTransporteConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOVIATRANSPORTE_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOVIATRANSPORTE_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOVIATRANSPORTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOVIATRANSPORTE_SELECT(?,?)";
	
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
	
	
	public TipoViaTransporteDataAccess() {
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
		TipoViaTransporteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoViaTransporteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoViaTransporteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoViaTransporteOriginal(TipoViaTransporte tipoviatransporte)throws Exception  {
		tipoviatransporte.setTipoViaTransporteOriginal((TipoViaTransporte)tipoviatransporte.clone());		
	}
	
	public void setTipoViaTransportesOriginal(List<TipoViaTransporte> tipoviatransportes)throws Exception  {
		
		for(TipoViaTransporte tipoviatransporte:tipoviatransportes){
			tipoviatransporte.setTipoViaTransporteOriginal((TipoViaTransporte)tipoviatransporte.clone());
		}
	}
	
	public static void setTipoViaTransporteOriginalStatic(TipoViaTransporte tipoviatransporte)throws Exception  {
		tipoviatransporte.setTipoViaTransporteOriginal((TipoViaTransporte)tipoviatransporte.clone());		
	}
	
	public static void setTipoViaTransportesOriginalStatic(List<TipoViaTransporte> tipoviatransportes)throws Exception  {
		
		for(TipoViaTransporte tipoviatransporte:tipoviatransportes){
			tipoviatransporte.setTipoViaTransporteOriginal((TipoViaTransporte)tipoviatransporte.clone());
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
	
	public  TipoViaTransporte getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoViaTransporte entity = new TipoViaTransporte();		
		
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
	
	public  TipoViaTransporte getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoViaTransporte entity = new TipoViaTransporte();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoViaTransporte.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoViaTransporteOriginal(new TipoViaTransporte());
      	    	entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoViaTransporte("",entity,resultSet); 
				
				//entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoViaTransporte(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoViaTransporte getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoViaTransporte entity = new TipoViaTransporte();
				
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
	
	public  TipoViaTransporte getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoViaTransporte entity = new TipoViaTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoViaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoViaTransporte.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoViaTransporteOriginal(new TipoViaTransporte());
      	    	entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoViaTransporte("",entity,resultSet);    
				
				//entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoViaTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoViaTransporte
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoViaTransporte entity = new TipoViaTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoViaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoViaTransporte.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoViaTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoViaTransporte> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
		
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
	
	public  List<TipoViaTransporte> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoViaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoViaTransporte();
      	    	entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoViaTransporte("",entity,resultSet);
      	    	
				//entity.setTipoViaTransporteOriginal( new TipoViaTransporte());
      	    	//entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoViaTransportes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoViaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoViaTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
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
	
	public  List<TipoViaTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoViaTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoViaTransporte();
					//entity.setMapTipoViaTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoViaTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoViaTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         		
					entity=TipoViaTransporteDataAccess.getEntityTipoViaTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoViaTransporteOriginal( new TipoViaTransporte());
					////entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoViaTransportes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoViaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoViaTransporte getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoViaTransporte entity = new TipoViaTransporte();		  
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
	
	public  TipoViaTransporte getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoViaTransporte entity = new TipoViaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoViaTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoViaTransporte();
					//entity.setMapTipoViaTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoViaTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoViaTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         		
					entity=TipoViaTransporteDataAccess.getEntityTipoViaTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoViaTransporteOriginal( new TipoViaTransporte());
					////entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoViaTransporte(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoViaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoViaTransporte getEntityTipoViaTransporte(String strPrefijo,TipoViaTransporte entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoViaTransporte.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoViaTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoViaTransporteDataAccess.setFieldReflectionTipoViaTransporte(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoViaTransporte=TipoViaTransporteConstantesFunciones.getTodosTiposColumnasTipoViaTransporte();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoViaTransporte) {
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
							field = TipoViaTransporte.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoViaTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoViaTransporteDataAccess.setFieldReflectionTipoViaTransporte(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoViaTransporte(Field field,String strPrefijo,String sColumn,TipoViaTransporte entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoViaTransporteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoViaTransporteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoViaTransporteConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoViaTransporte>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoViaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoViaTransporte();
					entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoViaTransporte("",entity,resultSet);
					
					//entity.setTipoViaTransporteOriginal( new TipoViaTransporte());
					//entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoViaTransportes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoViaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoViaTransporte>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoViaTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoViaTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoViaTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
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
	
	public  List<TipoViaTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoViaTransporte> entities = new  ArrayList<TipoViaTransporte>();
		TipoViaTransporte entity = new TipoViaTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoViaTransporte();
      	    	entity=super.getEntity("",entity,resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoViaTransporte("",entity,resultSet);
      	    	
				//entity.setTipoViaTransporteOriginal( new TipoViaTransporte());
      	    	//entity.setTipoViaTransporteOriginal(super.getEntity("",entity.getTipoViaTransporteOriginal(),resultSet,TipoViaTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoViaTransporteOriginal(this.getEntityTipoViaTransporte("",entity.getTipoViaTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoViaTransportes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoViaTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoViaTransporte getEntityTipoViaTransporte(String strPrefijo,TipoViaTransporte entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoViaTransporteConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoViaTransporteConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoViaTransporte(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoViaTransporte entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoViaTransporteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoViaTransporteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoViaTransporteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoViaTransporteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoViaTransporteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoViaTransporteDataAccess.TABLENAME,TipoViaTransporteDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoViaTransporteDataAccess.setTipoViaTransporteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.TipoViaTransporte WHERE pedidocompraimpor.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}

	public List<Proforma> getProformas(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<Proforma> proformas= new ArrayList<Proforma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+ProformaConstantesFunciones.SCHEMA+".proforma.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN proforma.TipoViaTransporte WHERE proforma.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProformaDataAccess proformaDataAccess=new ProformaDataAccess();

			proformaDataAccess.setConnexionType(this.connexionType);
			proformaDataAccess.setParameterDbType(this.parameterDbType);
			proformas=proformaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proformas;

	}

	public List<Transporte> getTransportes(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<Transporte> transportes= new ArrayList<Transporte>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+TransporteConstantesFunciones.SCHEMA+".transporte.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN transporte.TipoViaTransporte WHERE transporte.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);
			transportes=transporteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportes;

	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<ParametroInventarioDefecto> parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+".parametro_inventario_defecto.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN parametroinventariodefecto.TipoViaTransporte WHERE parametroinventariodefecto.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroInventarioDefectoDataAccess parametroinventariodefectoDataAccess=new ParametroInventarioDefectoDataAccess();

			parametroinventariodefectoDataAccess.setConnexionType(this.connexionType);
			parametroinventariodefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroinventariodefectos;

	}

	public List<Embarcador> getEmbarcadors(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<Embarcador> embarcadors= new ArrayList<Embarcador>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+EmbarcadorConstantesFunciones.SCHEMA+".embarcador.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN embarcador.TipoViaTransporte WHERE embarcador.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmbarcadorDataAccess embarcadorDataAccess=new EmbarcadorDataAccess();

			embarcadorDataAccess.setConnexionType(this.connexionType);
			embarcadorDataAccess.setParameterDbType(this.parameterDbType);
			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return embarcadors;

	}

	public List<Transportista> getTransportistas(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<Transportista> transportistas= new ArrayList<Transportista>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+TransportistaConstantesFunciones.SCHEMA+".transportista.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN transportista.TipoViaTransporte WHERE transportista.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);
			transportistas=transportistaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportistas;

	}

	public List<ParametroFacturacionDefecto> getParametroFacturacionDefectos(Connexion connexion,TipoViaTransporte tipoviatransporte)throws SQLException,Exception {

		List<ParametroFacturacionDefecto> parametrofacturaciondefectos= new ArrayList<ParametroFacturacionDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte ON "+ParametroFacturacionDefectoConstantesFunciones.SCHEMA+".parametro_facturacion_defecto.id_tipo_via_transporte="+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id WHERE "+TipoViaTransporteConstantesFunciones.SCHEMA+".tipo_via_transporte.id="+String.valueOf(tipoviatransporte.getId());
			} else {
				sQuery=" INNER JOIN parametrofacturaciondefecto.TipoViaTransporte WHERE parametrofacturaciondefecto.TipoViaTransporte.id="+String.valueOf(tipoviatransporte.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFacturacionDefectoDataAccess parametrofacturaciondefectoDataAccess=new ParametroFacturacionDefectoDataAccess();

			parametrofacturaciondefectoDataAccess.setConnexionType(this.connexionType);
			parametrofacturaciondefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrofacturaciondefectos=parametrofacturaciondefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofacturaciondefectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoViaTransporte tipoviatransporte) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoviatransporte.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoviatransporte.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoviatransporte.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoviatransporte.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoviatransporte.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoviatransporte.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoviatransporte.getId());
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
	
	public void setIsNewIsChangedFalseTipoViaTransporte(TipoViaTransporte tipoviatransporte)throws Exception  {		
		tipoviatransporte.setIsNew(false);
		tipoviatransporte.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoViaTransportes(List<TipoViaTransporte> tipoviatransportes)throws Exception  {				
		for(TipoViaTransporte tipoviatransporte:tipoviatransportes) {
			tipoviatransporte.setIsNew(false);
			tipoviatransporte.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoViaTransporte(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
