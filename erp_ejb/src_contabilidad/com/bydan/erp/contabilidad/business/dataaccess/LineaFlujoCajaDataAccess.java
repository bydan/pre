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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//LineaFlujoCajaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class LineaFlujoCajaDataAccess extends  LineaFlujoCajaDataAccessAdditional{ //LineaFlujoCajaDataAccessAdditional,DataAccessHelper<LineaFlujoCaja>
	//static Logger logger = Logger.getLogger(LineaFlujoCajaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="linea_flujo_caja";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_grupo_flujo_caja,codigo,nombre,id_tipo_linea_flujo_caja,es_consolidado,esta_proyeccion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_grupo_flujo_caja=?,codigo=?,nombre=?,id_tipo_linea_flujo_caja=?,es_consolidado=?,esta_proyeccion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select lineaflujocaja from "+LineaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" lineaflujocaja";
	public static String QUERYSELECTNATIVE="select "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id_tipo_grupo_flujo_caja,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".codigo,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".nombre,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id_tipo_linea_flujo_caja,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".es_consolidado,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".esta_proyeccion from "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+LineaFlujoCajaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".codigo from "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+LineaFlujoCajaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_grupo_flujo_caja=?,codigo=?,nombre=?,id_tipo_linea_flujo_caja=?,es_consolidado=?,esta_proyeccion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_LINEAFLUJOCAJA_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_LINEAFLUJOCAJA_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_LINEAFLUJOCAJA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_LINEAFLUJOCAJA_SELECT(?,?)";
	
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
	
	
	protected LineaFlujoCajaDataAccessAdditional lineaflujocajaDataAccessAdditional=null;
	
	public LineaFlujoCajaDataAccessAdditional getLineaFlujoCajaDataAccessAdditional() {
		return this.lineaflujocajaDataAccessAdditional;
	}
	
	public void setLineaFlujoCajaDataAccessAdditional(LineaFlujoCajaDataAccessAdditional lineaflujocajaDataAccessAdditional) {
		try {
			this.lineaflujocajaDataAccessAdditional=lineaflujocajaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public LineaFlujoCajaDataAccess() {
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
		LineaFlujoCajaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		LineaFlujoCajaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		LineaFlujoCajaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setLineaFlujoCajaOriginal(LineaFlujoCaja lineaflujocaja)throws Exception  {
		lineaflujocaja.setLineaFlujoCajaOriginal((LineaFlujoCaja)lineaflujocaja.clone());		
	}
	
	public void setLineaFlujoCajasOriginal(List<LineaFlujoCaja> lineaflujocajas)throws Exception  {
		
		for(LineaFlujoCaja lineaflujocaja:lineaflujocajas){
			lineaflujocaja.setLineaFlujoCajaOriginal((LineaFlujoCaja)lineaflujocaja.clone());
		}
	}
	
	public static void setLineaFlujoCajaOriginalStatic(LineaFlujoCaja lineaflujocaja)throws Exception  {
		lineaflujocaja.setLineaFlujoCajaOriginal((LineaFlujoCaja)lineaflujocaja.clone());		
	}
	
	public static void setLineaFlujoCajasOriginalStatic(List<LineaFlujoCaja> lineaflujocajas)throws Exception  {
		
		for(LineaFlujoCaja lineaflujocaja:lineaflujocajas){
			lineaflujocaja.setLineaFlujoCajaOriginal((LineaFlujoCaja)lineaflujocaja.clone());
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
	
	public  LineaFlujoCaja getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		LineaFlujoCaja entity = new LineaFlujoCaja();		
		
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
	
	public  LineaFlujoCaja getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		LineaFlujoCaja entity = new LineaFlujoCaja();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.LineaFlujoCaja.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setLineaFlujoCajaOriginal(new LineaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLineaFlujoCaja("",entity,resultSet); 
				
				//entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseLineaFlujoCaja(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  LineaFlujoCaja getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LineaFlujoCaja entity = new LineaFlujoCaja();
				
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
	
	public  LineaFlujoCaja getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		LineaFlujoCaja entity = new LineaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.LineaFlujoCaja.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setLineaFlujoCajaOriginal(new LineaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityLineaFlujoCaja("",entity,resultSet);    
				
				//entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseLineaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //LineaFlujoCaja
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		LineaFlujoCaja entity = new LineaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.LineaFlujoCaja.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseLineaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<LineaFlujoCaja> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		
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
	
	public  List<LineaFlujoCaja> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LineaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLineaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setLineaFlujoCajaOriginal( new LineaFlujoCaja());
      	    	//entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLineaFlujoCajas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LineaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
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
	
	public  List<LineaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LineaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapLineaFlujoCaja();
					//entity.setMapLineaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapLineaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLineaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=LineaFlujoCajaDataAccess.getEntityLineaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLineaFlujoCajaOriginal( new LineaFlujoCaja());
					////entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLineaFlujoCajas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public LineaFlujoCaja getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
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
	
	public  LineaFlujoCaja getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LineaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapLineaFlujoCaja();
					//entity.setMapLineaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapLineaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapLineaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=LineaFlujoCajaDataAccess.getEntityLineaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setLineaFlujoCajaOriginal( new LineaFlujoCaja());
					////entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseLineaFlujoCaja(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static LineaFlujoCaja getEntityLineaFlujoCaja(String strPrefijo,LineaFlujoCaja entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = LineaFlujoCaja.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = LineaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					LineaFlujoCajaDataAccess.setFieldReflectionLineaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasLineaFlujoCaja=LineaFlujoCajaConstantesFunciones.getTodosTiposColumnasLineaFlujoCaja();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasLineaFlujoCaja) {
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
							field = LineaFlujoCaja.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = LineaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						LineaFlujoCajaDataAccess.setFieldReflectionLineaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionLineaFlujoCaja(Field field,String strPrefijo,String sColumn,LineaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case LineaFlujoCajaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case LineaFlujoCajaConstantesFunciones.ESTAPROYECCION:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LineaFlujoCaja>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new LineaFlujoCaja();
					entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityLineaFlujoCaja("",entity,resultSet);
					
					//entity.setLineaFlujoCajaOriginal( new LineaFlujoCaja());
					//entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					//entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseLineaFlujoCajas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<LineaFlujoCaja>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=LineaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,LineaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<LineaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
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
	
	public  List<LineaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LineaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLineaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setLineaFlujoCajaOriginal( new LineaFlujoCaja());
      	    	//entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseLineaFlujoCajas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarLineaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<LineaFlujoCaja> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
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
	
	public  List<LineaFlujoCaja> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<LineaFlujoCaja> entities = new  ArrayList<LineaFlujoCaja>();
		LineaFlujoCaja entity = new LineaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new LineaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityLineaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setLineaFlujoCajaOriginal( new LineaFlujoCaja());
      	    	//entity.setLineaFlujoCajaOriginal(super.getEntity("",entity.getLineaFlujoCajaOriginal(),resultSet,LineaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setLineaFlujoCajaOriginal(this.getEntityLineaFlujoCaja("",entity.getLineaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseLineaFlujoCajas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public LineaFlujoCaja getEntityLineaFlujoCaja(String strPrefijo,LineaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+LineaFlujoCajaConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_grupo_flujo_caja(resultSet.getLong(strPrefijo+LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA));
				entity.setcodigo(resultSet.getString(strPrefijo+LineaFlujoCajaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+LineaFlujoCajaConstantesFunciones.NOMBRE));
				entity.setid_tipo_linea_flujo_caja(resultSet.getLong(strPrefijo+LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA));
				entity.setes_consolidado(resultSet.getBoolean(strPrefijo+LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO));
				entity.setesta_proyeccion(resultSet.getBoolean(strPrefijo+LineaFlujoCajaConstantesFunciones.ESTAPROYECCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+LineaFlujoCajaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowLineaFlujoCaja(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(LineaFlujoCaja entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=LineaFlujoCajaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=LineaFlujoCajaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=LineaFlujoCajaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=LineaFlujoCajaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(LineaFlujoCajaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,LineaFlujoCajaDataAccess.TABLENAME,LineaFlujoCajaDataAccess.ISWITHSTOREPROCEDURES);
			
			LineaFlujoCajaDataAccess.setLineaFlujoCajaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,LineaFlujoCaja rellineaflujocaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,rellineaflujocaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoGrupoFlujoCaja getTipoGrupoFlujoCaja(Connexion connexion,LineaFlujoCaja rellineaflujocaja)throws SQLException,Exception {

		TipoGrupoFlujoCaja tipogrupoflujocaja= new TipoGrupoFlujoCaja();

		try {
			TipoGrupoFlujoCajaDataAccess tipogrupoflujocajaDataAccess=new TipoGrupoFlujoCajaDataAccess();

			tipogrupoflujocajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogrupoflujocajaDataAccess.setConnexionType(this.connexionType);
			tipogrupoflujocajaDataAccess.setParameterDbType(this.parameterDbType);

			tipogrupoflujocaja=tipogrupoflujocajaDataAccess.getEntity(connexion,rellineaflujocaja.getid_tipo_grupo_flujo_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogrupoflujocaja;

	}

	public TipoLineaFlujoCaja getTipoLineaFlujoCaja(Connexion connexion,LineaFlujoCaja rellineaflujocaja)throws SQLException,Exception {

		TipoLineaFlujoCaja tipolineaflujocaja= new TipoLineaFlujoCaja();

		try {
			TipoLineaFlujoCajaDataAccess tipolineaflujocajaDataAccess=new TipoLineaFlujoCajaDataAccess();

			tipolineaflujocajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipolineaflujocajaDataAccess.setConnexionType(this.connexionType);
			tipolineaflujocajaDataAccess.setParameterDbType(this.parameterDbType);

			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion,rellineaflujocaja.getid_tipo_linea_flujo_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipolineaflujocaja;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,LineaFlujoCaja lineaflujocaja) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!lineaflujocaja.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(lineaflujocaja.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_grupo_flujo_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_grupo_flujo_caja.setValue(lineaflujocaja.getid_tipo_grupo_flujo_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_grupo_flujo_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(lineaflujocaja.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(lineaflujocaja.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_linea_flujo_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_linea_flujo_caja.setValue(lineaflujocaja.getid_tipo_linea_flujo_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_linea_flujo_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_consolidado=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_consolidado.setValue(lineaflujocaja.getes_consolidado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_consolidado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_proyeccion=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_proyeccion.setValue(lineaflujocaja.getesta_proyeccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_proyeccion);
					parametersTemp.add(parameterMaintenance);
					
						if(!lineaflujocaja.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(lineaflujocaja.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(lineaflujocaja.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(lineaflujocaja.getId());
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
	
	public void setIsNewIsChangedFalseLineaFlujoCaja(LineaFlujoCaja lineaflujocaja)throws Exception  {		
		lineaflujocaja.setIsNew(false);
		lineaflujocaja.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseLineaFlujoCajas(List<LineaFlujoCaja> lineaflujocajas)throws Exception  {				
		for(LineaFlujoCaja lineaflujocaja:lineaflujocajas) {
			lineaflujocaja.setIsNew(false);
			lineaflujocaja.setIsChanged(false);
		}
	}
	
	public void generarExportarLineaFlujoCaja(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
