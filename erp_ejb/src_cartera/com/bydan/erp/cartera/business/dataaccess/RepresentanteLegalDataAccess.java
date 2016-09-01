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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//RepresentanteLegalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class RepresentanteLegalDataAccess extends  RepresentanteLegalDataAccessAdditional{ //RepresentanteLegalDataAccessAdditional,DataAccessHelper<RepresentanteLegal>
	//static Logger logger = Logger.getLogger(RepresentanteLegalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="representantelegal";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+"(version_row,idcliente,idvalorclientedocumento,id_pais,idciudad,identificacion,apellidopaterno,apellidomaterno,primernombre,segundonombre,direccion,telefono,telefonocodigoarea,extension,telefonomovil,montoaurorizado,email,estaactivo)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclientedocumento=?,id_pais=?,idciudad=?,identificacion=?,apellidopaterno=?,apellidomaterno=?,primernombre=?,segundonombre=?,direccion=?,telefono=?,telefonocodigoarea=?,extension=?,telefonomovil=?,montoaurorizado=?,email=?,estaactivo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select representantelegal from "+RepresentanteLegalConstantesFunciones.SPERSISTENCENAME+" representantelegal";
	public static String QUERYSELECTNATIVE="select "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".id,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".version_row,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".idcliente,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".idvalorclientedocumento,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".id_pais,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".idciudad,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".identificacion,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".apellidopaterno,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".apellidomaterno,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".primernombre,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".segundonombre,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".direccion,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".telefono,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".telefonocodigoarea,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".extension,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".telefonomovil,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".montoaurorizado,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".email,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".estaactivo from "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME;//+" as "+RepresentanteLegalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".id,"+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+".version_row from "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME;//+" as "+RepresentanteLegalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RepresentanteLegalConstantesFunciones.SCHEMA+"."+RepresentanteLegalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,idcliente=?,idvalorclientedocumento=?,id_pais=?,idciudad=?,identificacion=?,apellidopaterno=?,apellidomaterno=?,primernombre=?,segundonombre=?,direccion=?,telefono=?,telefonocodigoarea=?,extension=?,telefonomovil=?,montoaurorizado=?,email=?,estaactivo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REPRESENTANTELEGAL_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REPRESENTANTELEGAL_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REPRESENTANTELEGAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REPRESENTANTELEGAL_SELECT(?,?)";
	
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
	
	
	protected RepresentanteLegalDataAccessAdditional representantelegalDataAccessAdditional=null;
	
	public RepresentanteLegalDataAccessAdditional getRepresentanteLegalDataAccessAdditional() {
		return this.representantelegalDataAccessAdditional;
	}
	
	public void setRepresentanteLegalDataAccessAdditional(RepresentanteLegalDataAccessAdditional representantelegalDataAccessAdditional) {
		try {
			this.representantelegalDataAccessAdditional=representantelegalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RepresentanteLegalDataAccess() {
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
		RepresentanteLegalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RepresentanteLegalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RepresentanteLegalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRepresentanteLegalOriginal(RepresentanteLegal representantelegal)throws Exception  {
		representantelegal.setRepresentanteLegalOriginal((RepresentanteLegal)representantelegal.clone());		
	}
	
	public void setRepresentanteLegalsOriginal(List<RepresentanteLegal> representantelegals)throws Exception  {
		
		for(RepresentanteLegal representantelegal:representantelegals){
			representantelegal.setRepresentanteLegalOriginal((RepresentanteLegal)representantelegal.clone());
		}
	}
	
	public static void setRepresentanteLegalOriginalStatic(RepresentanteLegal representantelegal)throws Exception  {
		representantelegal.setRepresentanteLegalOriginal((RepresentanteLegal)representantelegal.clone());		
	}
	
	public static void setRepresentanteLegalsOriginalStatic(List<RepresentanteLegal> representantelegals)throws Exception  {
		
		for(RepresentanteLegal representantelegal:representantelegals){
			representantelegal.setRepresentanteLegalOriginal((RepresentanteLegal)representantelegal.clone());
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
	
	public  RepresentanteLegal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RepresentanteLegal entity = new RepresentanteLegal();		
		
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
	
	public  RepresentanteLegal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RepresentanteLegal entity = new RepresentanteLegal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.RepresentanteLegal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRepresentanteLegalOriginal(new RepresentanteLegal());
      	    	entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRepresentanteLegal("",entity,resultSet); 
				
				//entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRepresentanteLegal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RepresentanteLegal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RepresentanteLegal entity = new RepresentanteLegal();
				
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
	
	public  RepresentanteLegal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RepresentanteLegal entity = new RepresentanteLegal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RepresentanteLegalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RepresentanteLegal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRepresentanteLegalOriginal(new RepresentanteLegal());
      	    	entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRepresentanteLegal("",entity,resultSet);    
				
				//entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRepresentanteLegal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RepresentanteLegal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RepresentanteLegal entity = new RepresentanteLegal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RepresentanteLegalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.RepresentanteLegal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRepresentanteLegal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RepresentanteLegal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		
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
	
	public  List<RepresentanteLegal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RepresentanteLegalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RepresentanteLegal();
      	    	entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRepresentanteLegal("",entity,resultSet);
      	    	
				//entity.setRepresentanteLegalOriginal( new RepresentanteLegal());
      	    	//entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRepresentanteLegals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRepresentanteLegal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RepresentanteLegal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
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
	
	public  List<RepresentanteLegal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RepresentanteLegal();
				
				if(conMapGenerico) {
					entity.inicializarMapRepresentanteLegal();
					//entity.setMapRepresentanteLegal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRepresentanteLegalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRepresentanteLegal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         		
					entity=RepresentanteLegalDataAccess.getEntityRepresentanteLegal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRepresentanteLegalOriginal( new RepresentanteLegal());
					////entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
					////entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRepresentanteLegals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRepresentanteLegal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RepresentanteLegal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RepresentanteLegal entity = new RepresentanteLegal();		  
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
	
	public  RepresentanteLegal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RepresentanteLegal();
				
				if(conMapGenerico) {
					entity.inicializarMapRepresentanteLegal();
					//entity.setMapRepresentanteLegal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRepresentanteLegalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRepresentanteLegal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         		
					entity=RepresentanteLegalDataAccess.getEntityRepresentanteLegal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRepresentanteLegalOriginal( new RepresentanteLegal());
					////entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
					////entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRepresentanteLegal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRepresentanteLegal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RepresentanteLegal getEntityRepresentanteLegal(String strPrefijo,RepresentanteLegal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RepresentanteLegal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RepresentanteLegal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RepresentanteLegalDataAccess.setFieldReflectionRepresentanteLegal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRepresentanteLegal=RepresentanteLegalConstantesFunciones.getTodosTiposColumnasRepresentanteLegal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRepresentanteLegal) {
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
							field = RepresentanteLegal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RepresentanteLegal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RepresentanteLegalDataAccess.setFieldReflectionRepresentanteLegal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRepresentanteLegal(Field field,String strPrefijo,String sColumn,RepresentanteLegal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RepresentanteLegalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.IDENTIFICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.APELLIDOPATERNO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.APELLIDOMATERNO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.PRIMERNOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.EXTENSION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.TELEFONOMOVIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.MONTOAURORIZADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RepresentanteLegalConstantesFunciones.ESTAACTIVO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RepresentanteLegal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RepresentanteLegalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RepresentanteLegal();
					entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRepresentanteLegal("",entity,resultSet);
					
					//entity.setRepresentanteLegalOriginal( new RepresentanteLegal());
					//entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
					//entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRepresentanteLegals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRepresentanteLegal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RepresentanteLegal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RepresentanteLegalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RepresentanteLegalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RepresentanteLegal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
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
	
	public  List<RepresentanteLegal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RepresentanteLegal();
      	    	entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRepresentanteLegal("",entity,resultSet);
      	    	
				//entity.setRepresentanteLegalOriginal( new RepresentanteLegal());
      	    	//entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRepresentanteLegals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRepresentanteLegal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RepresentanteLegal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
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
	
	public  List<RepresentanteLegal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RepresentanteLegal> entities = new  ArrayList<RepresentanteLegal>();
		RepresentanteLegal entity = new RepresentanteLegal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RepresentanteLegal();
      	    	entity=super.getEntity("",entity,resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRepresentanteLegal("",entity,resultSet);
      	    	
				//entity.setRepresentanteLegalOriginal( new RepresentanteLegal());
      	    	//entity.setRepresentanteLegalOriginal(super.getEntity("",entity.getRepresentanteLegalOriginal(),resultSet,RepresentanteLegalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRepresentanteLegalOriginal(this.getEntityRepresentanteLegal("",entity.getRepresentanteLegalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRepresentanteLegals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RepresentanteLegal getEntityRepresentanteLegal(String strPrefijo,RepresentanteLegal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setidcliente(resultSet.getLong(strPrefijo+RepresentanteLegalConstantesFunciones.IDCLIENTE));
				entity.setidvalorclientedocumento(resultSet.getLong(strPrefijo+RepresentanteLegalConstantesFunciones.IDTIPOIDENTIFICACION));
				entity.setid_pais(resultSet.getLong(strPrefijo+RepresentanteLegalConstantesFunciones.IDPAIS));
				entity.setidciudad(resultSet.getLong(strPrefijo+RepresentanteLegalConstantesFunciones.IDCIUDAD));
				entity.setidentificacion(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.IDENTIFICACION));
				entity.setapellidopaterno(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.APELLIDOPATERNO));
				entity.setapellidomaterno(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.APELLIDOMATERNO));
				entity.setprimernombre(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.PRIMERNOMBRE));
				entity.setsegundonombre(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.SEGUNDONOMBRE));
				entity.setdireccion(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.TELEFONO));
				entity.settelefonocodigoarea(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.TELEFONOCODIGOAREA));
				entity.setextension(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.EXTENSION));
				entity.settelefonomovil(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.TELEFONOMOVIL));
				entity.setmontoaurorizado(resultSet.getDouble(strPrefijo+RepresentanteLegalConstantesFunciones.MONTOAURORIZADO));
				entity.setemail(resultSet.getString(strPrefijo+RepresentanteLegalConstantesFunciones.EMAIL));
				entity.setestaactivo(resultSet.getBoolean(strPrefijo+RepresentanteLegalConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRepresentanteLegal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RepresentanteLegal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RepresentanteLegalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RepresentanteLegalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RepresentanteLegalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RepresentanteLegalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RepresentanteLegalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RepresentanteLegalDataAccess.TABLENAME,RepresentanteLegalDataAccess.ISWITHSTOREPROCEDURES);
			
			RepresentanteLegalDataAccess.setRepresentanteLegalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,RepresentanteLegal relrepresentantelegal)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relrepresentantelegal.getidcliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoIdentificacion getTipoIdentificacion(Connexion connexion,RepresentanteLegal relrepresentantelegal)throws SQLException,Exception {

		TipoIdentificacion tipoidentificacion= new TipoIdentificacion();

		try {
			TipoIdentificacionDataAccess tipoidentificacionDataAccess=new TipoIdentificacionDataAccess();

			tipoidentificacionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);

			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,relrepresentantelegal.getidvalorclientedocumento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoidentificacion;

	}

	public Pais getPais(Connexion connexion,RepresentanteLegal relrepresentantelegal)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relrepresentantelegal.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,RepresentanteLegal relrepresentantelegal)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relrepresentantelegal.getidciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RepresentanteLegal representantelegal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!representantelegal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidcliente=new ParameterValue<Long>();
					parameterMaintenanceValueidcliente.setValue(representantelegal.getidcliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidcliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidvalorclientedocumento=new ParameterValue<Long>();
					parameterMaintenanceValueidvalorclientedocumento.setValue(representantelegal.getidvalorclientedocumento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidvalorclientedocumento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(representantelegal.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueidciudad=new ParameterValue<Long>();
					parameterMaintenanceValueidciudad.setValue(representantelegal.getidciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueidentificacion=new ParameterValue<String>();
					parameterMaintenanceValueidentificacion.setValue(representantelegal.getidentificacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueidentificacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellidopaterno=new ParameterValue<String>();
					parameterMaintenanceValueapellidopaterno.setValue(representantelegal.getapellidopaterno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellidopaterno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueapellidomaterno=new ParameterValue<String>();
					parameterMaintenanceValueapellidomaterno.setValue(representantelegal.getapellidomaterno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueapellidomaterno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueprimernombre=new ParameterValue<String>();
					parameterMaintenanceValueprimernombre.setValue(representantelegal.getprimernombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprimernombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesegundonombre=new ParameterValue<String>();
					parameterMaintenanceValuesegundonombre.setValue(representantelegal.getsegundonombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesegundonombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(representantelegal.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(representantelegal.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonocodigoarea=new ParameterValue<String>();
					parameterMaintenanceValuetelefonocodigoarea.setValue(representantelegal.gettelefonocodigoarea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonocodigoarea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueextension=new ParameterValue<String>();
					parameterMaintenanceValueextension.setValue(representantelegal.getextension());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueextension);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefonomovil=new ParameterValue<String>();
					parameterMaintenanceValuetelefonomovil.setValue(representantelegal.gettelefonomovil());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefonomovil);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemontoaurorizado=new ParameterValue<Double>();
					parameterMaintenanceValuemontoaurorizado.setValue(representantelegal.getmontoaurorizado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemontoaurorizado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueemail=new ParameterValue<String>();
					parameterMaintenanceValueemail.setValue(representantelegal.getemail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueestaactivo=new ParameterValue<Boolean>();
					parameterMaintenanceValueestaactivo.setValue(representantelegal.getestaactivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestaactivo);
					parametersTemp.add(parameterMaintenance);
					
						if(!representantelegal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(representantelegal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(representantelegal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(representantelegal.getId());
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
	
	public void setIsNewIsChangedFalseRepresentanteLegal(RepresentanteLegal representantelegal)throws Exception  {		
		representantelegal.setIsNew(false);
		representantelegal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRepresentanteLegals(List<RepresentanteLegal> representantelegals)throws Exception  {				
		for(RepresentanteLegal representantelegal:representantelegals) {
			representantelegal.setIsNew(false);
			representantelegal.setIsChanged(false);
		}
	}
	
	public void generarExportarRepresentanteLegal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
