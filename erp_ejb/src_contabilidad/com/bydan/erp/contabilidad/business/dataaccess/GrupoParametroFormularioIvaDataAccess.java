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
import com.bydan.erp.contabilidad.util.*;//GrupoParametroFormularioIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class GrupoParametroFormularioIvaDataAccess extends  DataAccessHelper<GrupoParametroFormularioIva>{ //GrupoParametroFormularioIvaDataAccessAdditional,DataAccessHelper<GrupoParametroFormularioIva>
	//static Logger logger = Logger.getLogger(GrupoParametroFormularioIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="grupo_parametro_formulario_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+"(id_empresa,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+" set id_empresa=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select grupoparametroformularioiva from "+GrupoParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" grupoparametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+" set id_empresa=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GRUPOPARAMETROFORMULARIOIVA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GRUPOPARAMETROFORMULARIOIVA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GRUPOPARAMETROFORMULARIOIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GRUPOPARAMETROFORMULARIOIVA_SELECT(?,?)";
	
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
	
	
	public GrupoParametroFormularioIvaDataAccess() {
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
		GrupoParametroFormularioIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GrupoParametroFormularioIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GrupoParametroFormularioIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGrupoParametroFormularioIvaOriginal(GrupoParametroFormularioIva grupoparametroformularioiva)throws Exception  {
		grupoparametroformularioiva.setGrupoParametroFormularioIvaOriginal((GrupoParametroFormularioIva)grupoparametroformularioiva.clone());		
	}
	
	public void setGrupoParametroFormularioIvasOriginal(List<GrupoParametroFormularioIva> grupoparametroformularioivas)throws Exception  {
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva:grupoparametroformularioivas){
			grupoparametroformularioiva.setGrupoParametroFormularioIvaOriginal((GrupoParametroFormularioIva)grupoparametroformularioiva.clone());
		}
	}
	
	public static void setGrupoParametroFormularioIvaOriginalStatic(GrupoParametroFormularioIva grupoparametroformularioiva)throws Exception  {
		grupoparametroformularioiva.setGrupoParametroFormularioIvaOriginal((GrupoParametroFormularioIva)grupoparametroformularioiva.clone());		
	}
	
	public static void setGrupoParametroFormularioIvasOriginalStatic(List<GrupoParametroFormularioIva> grupoparametroformularioivas)throws Exception  {
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva:grupoparametroformularioivas){
			grupoparametroformularioiva.setGrupoParametroFormularioIvaOriginal((GrupoParametroFormularioIva)grupoparametroformularioiva.clone());
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
	
	public  GrupoParametroFormularioIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		
		
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
	
	public  GrupoParametroFormularioIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.GrupoParametroFormularioIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGrupoParametroFormularioIvaOriginal(new GrupoParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoParametroFormularioIva("",entity,resultSet); 
				
				//entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoParametroFormularioIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GrupoParametroFormularioIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();
				
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
	
	public  GrupoParametroFormularioIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.GrupoParametroFormularioIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGrupoParametroFormularioIvaOriginal(new GrupoParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoParametroFormularioIva("",entity,resultSet);    
				
				//entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GrupoParametroFormularioIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.GrupoParametroFormularioIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGrupoParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GrupoParametroFormularioIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		
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
	
	public  List<GrupoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setGrupoParametroFormularioIvaOriginal( new GrupoParametroFormularioIva());
      	    	//entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
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
	
	public  List<GrupoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoParametroFormularioIva();
					//entity.setMapGrupoParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGrupoParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=GrupoParametroFormularioIvaDataAccess.getEntityGrupoParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGrupoParametroFormularioIvaOriginal( new GrupoParametroFormularioIva());
					////entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoParametroFormularioIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GrupoParametroFormularioIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
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
	
	public  GrupoParametroFormularioIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoParametroFormularioIva();
					//entity.setMapGrupoParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGrupoParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=GrupoParametroFormularioIvaDataAccess.getEntityGrupoParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGrupoParametroFormularioIvaOriginal( new GrupoParametroFormularioIva());
					////entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGrupoParametroFormularioIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GrupoParametroFormularioIva getEntityGrupoParametroFormularioIva(String strPrefijo,GrupoParametroFormularioIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GrupoParametroFormularioIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GrupoParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GrupoParametroFormularioIvaDataAccess.setFieldReflectionGrupoParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGrupoParametroFormularioIva=GrupoParametroFormularioIvaConstantesFunciones.getTodosTiposColumnasGrupoParametroFormularioIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGrupoParametroFormularioIva) {
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
							field = GrupoParametroFormularioIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GrupoParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GrupoParametroFormularioIvaDataAccess.setFieldReflectionGrupoParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGrupoParametroFormularioIva(Field field,String strPrefijo,String sColumn,GrupoParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GrupoParametroFormularioIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoParametroFormularioIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoParametroFormularioIvaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoParametroFormularioIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GrupoParametroFormularioIva();
					entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGrupoParametroFormularioIva("",entity,resultSet);
					
					//entity.setGrupoParametroFormularioIvaOriginal( new GrupoParametroFormularioIva());
					//entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGrupoParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoParametroFormularioIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GrupoParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
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
	
	public  List<GrupoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoParametroFormularioIva> entities = new  ArrayList<GrupoParametroFormularioIva>();
		GrupoParametroFormularioIva entity = new GrupoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setGrupoParametroFormularioIvaOriginal( new GrupoParametroFormularioIva());
      	    	//entity.setGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet,GrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoParametroFormularioIvaOriginal(this.getEntityGrupoParametroFormularioIva("",entity.getGrupoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGrupoParametroFormularioIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public GrupoParametroFormularioIva getEntityGrupoParametroFormularioIva(String strPrefijo,GrupoParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+GrupoParametroFormularioIvaConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+GrupoParametroFormularioIvaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGrupoParametroFormularioIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GrupoParametroFormularioIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GrupoParametroFormularioIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GrupoParametroFormularioIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GrupoParametroFormularioIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GrupoParametroFormularioIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GrupoParametroFormularioIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GrupoParametroFormularioIvaDataAccess.TABLENAME,GrupoParametroFormularioIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			GrupoParametroFormularioIvaDataAccess.setGrupoParametroFormularioIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GrupoParametroFormularioIva relgrupoparametroformularioiva)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relgrupoparametroformularioiva.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ParametroFormularioIva> getParametroFormularioIvas(Connexion connexion,GrupoParametroFormularioIva grupoparametroformularioiva)throws SQLException,Exception {

		List<ParametroFormularioIva> parametroformularioivas= new ArrayList<ParametroFormularioIva>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".grupo_parametro_formulario_iva ON "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id_grupo_parametro_formulario_iva="+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".grupo_parametro_formulario_iva.id WHERE "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".grupo_parametro_formulario_iva.id="+String.valueOf(grupoparametroformularioiva.getId());
			} else {
				sQuery=" INNER JOIN parametroformularioiva.GrupoParametroFormularioIva WHERE parametroformularioiva.GrupoParametroFormularioIva.id="+String.valueOf(grupoparametroformularioiva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFormularioIvaDataAccess parametroformularioivaDataAccess=new ParametroFormularioIvaDataAccess();

			parametroformularioivaDataAccess.setConnexionType(this.connexionType);
			parametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroformularioivas;

	}

	public List<FormularioIva> getFormularioIvas(Connexion connexion,GrupoParametroFormularioIva grupoparametroformularioiva)throws SQLException,Exception {

		List<FormularioIva> formularioivas= new ArrayList<FormularioIva>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".grupo_parametro_formulario_iva ON "+FormularioIvaConstantesFunciones.SCHEMA+".formulario_iva.id_grupo_parametro_formulario_iva="+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".grupo_parametro_formulario_iva.id WHERE "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".grupo_parametro_formulario_iva.id="+String.valueOf(grupoparametroformularioiva.getId());
			} else {
				sQuery=" INNER JOIN formularioiva.GrupoParametroFormularioIva WHERE formularioiva.GrupoParametroFormularioIva.id="+String.valueOf(grupoparametroformularioiva.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormularioIvaDataAccess formularioivaDataAccess=new FormularioIvaDataAccess();

			formularioivaDataAccess.setConnexionType(this.connexionType);
			formularioivaDataAccess.setParameterDbType(this.parameterDbType);
			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formularioivas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GrupoParametroFormularioIva grupoparametroformularioiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!grupoparametroformularioiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(grupoparametroformularioiva.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(grupoparametroformularioiva.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!grupoparametroformularioiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(grupoparametroformularioiva.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(grupoparametroformularioiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(grupoparametroformularioiva.getId());
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
	
	public void setIsNewIsChangedFalseGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva)throws Exception  {		
		grupoparametroformularioiva.setIsNew(false);
		grupoparametroformularioiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGrupoParametroFormularioIvas(List<GrupoParametroFormularioIva> grupoparametroformularioivas)throws Exception  {				
		for(GrupoParametroFormularioIva grupoparametroformularioiva:grupoparametroformularioivas) {
			grupoparametroformularioiva.setIsNew(false);
			grupoparametroformularioiva.setIsChanged(false);
		}
	}
	
	public void generarExportarGrupoParametroFormularioIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
