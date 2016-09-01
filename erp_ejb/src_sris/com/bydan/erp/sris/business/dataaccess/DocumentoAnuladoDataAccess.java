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
package com.bydan.erp.sris.business.dataaccess;

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

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.util.*;//DocumentoAnuladoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DocumentoAnuladoDataAccess extends  DocumentoAnuladoDataAccessAdditional{ //DocumentoAnuladoDataAccessAdditional,DataAccessHelper<DocumentoAnulado>
	//static Logger logger = Logger.getLogger(DocumentoAnuladoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="documento_anulado";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_periodo_declara,id_modulo,id_tipo_comprobante,numero,serie,autorizacion,fecha_anulacion)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_periodo_declara=?,id_modulo=?,id_tipo_comprobante=?,numero=?,serie=?,autorizacion=?,fecha_anulacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select documentoanulado from "+DocumentoAnuladoConstantesFunciones.SPERSISTENCENAME+" documentoanulado";
	public static String QUERYSELECTNATIVE="select "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".version_row,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_empresa,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_periodo_declara,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_modulo,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".numero,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".serie,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".autorizacion,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".fecha_anulacion from "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME;//+" as "+DocumentoAnuladoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".id,"+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+".version_row from "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME;//+" as "+DocumentoAnuladoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DocumentoAnuladoConstantesFunciones.SCHEMA+"."+DocumentoAnuladoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_periodo_declara=?,id_modulo=?,id_tipo_comprobante=?,numero=?,serie=?,autorizacion=?,fecha_anulacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DOCUMENTOANULADO_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DOCUMENTOANULADO_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DOCUMENTOANULADO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DOCUMENTOANULADO_SELECT(?,?)";
	
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
	
	
	protected DocumentoAnuladoDataAccessAdditional documentoanuladoDataAccessAdditional=null;
	
	public DocumentoAnuladoDataAccessAdditional getDocumentoAnuladoDataAccessAdditional() {
		return this.documentoanuladoDataAccessAdditional;
	}
	
	public void setDocumentoAnuladoDataAccessAdditional(DocumentoAnuladoDataAccessAdditional documentoanuladoDataAccessAdditional) {
		try {
			this.documentoanuladoDataAccessAdditional=documentoanuladoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DocumentoAnuladoDataAccess() {
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
		DocumentoAnuladoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DocumentoAnuladoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DocumentoAnuladoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDocumentoAnuladoOriginal(DocumentoAnulado documentoanulado)throws Exception  {
		documentoanulado.setDocumentoAnuladoOriginal((DocumentoAnulado)documentoanulado.clone());		
	}
	
	public void setDocumentoAnuladosOriginal(List<DocumentoAnulado> documentoanulados)throws Exception  {
		
		for(DocumentoAnulado documentoanulado:documentoanulados){
			documentoanulado.setDocumentoAnuladoOriginal((DocumentoAnulado)documentoanulado.clone());
		}
	}
	
	public static void setDocumentoAnuladoOriginalStatic(DocumentoAnulado documentoanulado)throws Exception  {
		documentoanulado.setDocumentoAnuladoOriginal((DocumentoAnulado)documentoanulado.clone());		
	}
	
	public static void setDocumentoAnuladosOriginalStatic(List<DocumentoAnulado> documentoanulados)throws Exception  {
		
		for(DocumentoAnulado documentoanulado:documentoanulados){
			documentoanulado.setDocumentoAnuladoOriginal((DocumentoAnulado)documentoanulado.clone());
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
	
	public  DocumentoAnulado getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DocumentoAnulado entity = new DocumentoAnulado();		
		
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
	
	public  DocumentoAnulado getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DocumentoAnulado entity = new DocumentoAnulado();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Sris.DocumentoAnulado.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDocumentoAnuladoOriginal(new DocumentoAnulado());
      	    	entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDocumentoAnulado("",entity,resultSet); 
				
				//entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDocumentoAnulado(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DocumentoAnulado getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DocumentoAnulado entity = new DocumentoAnulado();
				
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
	
	public  DocumentoAnulado getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DocumentoAnulado entity = new DocumentoAnulado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DocumentoAnuladoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.DocumentoAnulado.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDocumentoAnuladoOriginal(new DocumentoAnulado());
      	    	entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDocumentoAnulado("",entity,resultSet);    
				
				//entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDocumentoAnulado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DocumentoAnulado
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DocumentoAnulado entity = new DocumentoAnulado();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DocumentoAnuladoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.DocumentoAnulado.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDocumentoAnulado(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DocumentoAnulado> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		
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
	
	public  List<DocumentoAnulado> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DocumentoAnuladoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DocumentoAnulado();
      	    	entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDocumentoAnulado("",entity,resultSet);
      	    	
				//entity.setDocumentoAnuladoOriginal( new DocumentoAnulado());
      	    	//entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDocumentoAnulados(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDocumentoAnulado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DocumentoAnulado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
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
	
	public  List<DocumentoAnulado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DocumentoAnulado();
				
				if(conMapGenerico) {
					entity.inicializarMapDocumentoAnulado();
					//entity.setMapDocumentoAnulado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDocumentoAnuladoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDocumentoAnulado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         		
					entity=DocumentoAnuladoDataAccess.getEntityDocumentoAnulado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDocumentoAnuladoOriginal( new DocumentoAnulado());
					////entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
					////entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDocumentoAnulados(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDocumentoAnulado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DocumentoAnulado getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DocumentoAnulado entity = new DocumentoAnulado();		  
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
	
	public  DocumentoAnulado getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DocumentoAnulado();
				
				if(conMapGenerico) {
					entity.inicializarMapDocumentoAnulado();
					//entity.setMapDocumentoAnulado(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDocumentoAnuladoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDocumentoAnulado().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         		
					entity=DocumentoAnuladoDataAccess.getEntityDocumentoAnulado("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDocumentoAnuladoOriginal( new DocumentoAnulado());
					////entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
					////entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDocumentoAnulado(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDocumentoAnulado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DocumentoAnulado getEntityDocumentoAnulado(String strPrefijo,DocumentoAnulado entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DocumentoAnulado.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DocumentoAnulado.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DocumentoAnuladoDataAccess.setFieldReflectionDocumentoAnulado(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDocumentoAnulado=DocumentoAnuladoConstantesFunciones.getTodosTiposColumnasDocumentoAnulado();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDocumentoAnulado) {
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
							field = DocumentoAnulado.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DocumentoAnulado.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DocumentoAnuladoDataAccess.setFieldReflectionDocumentoAnulado(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDocumentoAnulado(Field field,String strPrefijo,String sColumn,DocumentoAnulado entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DocumentoAnuladoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.SERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.AUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DocumentoAnuladoConstantesFunciones.FECHAANULACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DocumentoAnulado>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DocumentoAnuladoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DocumentoAnulado();
					entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDocumentoAnulado("",entity,resultSet);
					
					//entity.setDocumentoAnuladoOriginal( new DocumentoAnulado());
					//entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
					//entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDocumentoAnulados(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDocumentoAnulado(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DocumentoAnulado>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DocumentoAnuladoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DocumentoAnuladoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DocumentoAnulado> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
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
	
	public  List<DocumentoAnulado> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DocumentoAnulado();
      	    	entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDocumentoAnulado("",entity,resultSet);
      	    	
				//entity.setDocumentoAnuladoOriginal( new DocumentoAnulado());
      	    	//entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDocumentoAnulados(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDocumentoAnulado(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DocumentoAnulado> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
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
	
	public  List<DocumentoAnulado> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DocumentoAnulado> entities = new  ArrayList<DocumentoAnulado>();
		DocumentoAnulado entity = new DocumentoAnulado();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DocumentoAnulado();
      	    	entity=super.getEntity("",entity,resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDocumentoAnulado("",entity,resultSet);
      	    	
				//entity.setDocumentoAnuladoOriginal( new DocumentoAnulado());
      	    	//entity.setDocumentoAnuladoOriginal(super.getEntity("",entity.getDocumentoAnuladoOriginal(),resultSet,DocumentoAnuladoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDocumentoAnuladoOriginal(this.getEntityDocumentoAnulado("",entity.getDocumentoAnuladoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDocumentoAnulados(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DocumentoAnulado getEntityDocumentoAnulado(String strPrefijo,DocumentoAnulado entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DocumentoAnuladoConstantesFunciones.IDEMPRESA));
				entity.setid_periodo_declara(resultSet.getLong(strPrefijo+DocumentoAnuladoConstantesFunciones.IDPERIODODECLARA));
				entity.setid_modulo(resultSet.getLong(strPrefijo+DocumentoAnuladoConstantesFunciones.IDMODULO));
				entity.setid_tipo_comprobante(resultSet.getLong(strPrefijo+DocumentoAnuladoConstantesFunciones.IDTIPOCOMPROBANTE));
				entity.setnumero(resultSet.getString(strPrefijo+DocumentoAnuladoConstantesFunciones.NUMERO));
				entity.setserie(resultSet.getString(strPrefijo+DocumentoAnuladoConstantesFunciones.SERIE));
				entity.setautorizacion(resultSet.getString(strPrefijo+DocumentoAnuladoConstantesFunciones.AUTORIZACION));
				entity.setfecha_anulacion(new Date(resultSet.getDate(strPrefijo+DocumentoAnuladoConstantesFunciones.FECHAANULACION).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDocumentoAnulado(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DocumentoAnulado entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DocumentoAnuladoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DocumentoAnuladoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DocumentoAnuladoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DocumentoAnuladoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DocumentoAnuladoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DocumentoAnuladoDataAccess.TABLENAME,DocumentoAnuladoDataAccess.ISWITHSTOREPROCEDURES);
			
			DocumentoAnuladoDataAccess.setDocumentoAnuladoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DocumentoAnulado reldocumentoanulado)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldocumentoanulado.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,DocumentoAnulado reldocumentoanulado)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,reldocumentoanulado.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public Modulo getModulo(Connexion connexion,DocumentoAnulado reldocumentoanulado)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reldocumentoanulado.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoComprobante getTipoComprobante(Connexion connexion,DocumentoAnulado reldocumentoanulado)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,reldocumentoanulado.getid_tipo_comprobante());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DocumentoAnulado documentoanulado) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!documentoanulado.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(documentoanulado.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo_declara=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo_declara.setValue(documentoanulado.getid_periodo_declara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo_declara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(documentoanulado.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_comprobante=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_comprobante.setValue(documentoanulado.getid_tipo_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(documentoanulado.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie=new ParameterValue<String>();
					parameterMaintenanceValueserie.setValue(documentoanulado.getserie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautorizacion=new ParameterValue<String>();
					parameterMaintenanceValueautorizacion.setValue(documentoanulado.getautorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_anulacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_anulacion.setValue(documentoanulado.getfecha_anulacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_anulacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!documentoanulado.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(documentoanulado.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(documentoanulado.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(documentoanulado.getId());
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
	
	public void setIsNewIsChangedFalseDocumentoAnulado(DocumentoAnulado documentoanulado)throws Exception  {		
		documentoanulado.setIsNew(false);
		documentoanulado.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDocumentoAnulados(List<DocumentoAnulado> documentoanulados)throws Exception  {				
		for(DocumentoAnulado documentoanulado:documentoanulados) {
			documentoanulado.setIsNew(false);
			documentoanulado.setIsChanged(false);
		}
	}
	
	public void generarExportarDocumentoAnulado(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
