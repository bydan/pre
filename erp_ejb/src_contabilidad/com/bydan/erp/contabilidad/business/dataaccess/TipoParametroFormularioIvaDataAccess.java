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
import com.bydan.erp.contabilidad.util.*;//TipoParametroFormularioIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoParametroFormularioIvaDataAccess extends  TipoParametroFormularioIvaDataAccessAdditional{ //TipoParametroFormularioIvaDataAccessAdditional,DataAccessHelper<TipoParametroFormularioIva>
	//static Logger logger = Logger.getLogger(TipoParametroFormularioIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_parametro_formulario_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+"(id,version_row,nombre,codigo_sri)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,codigo_sri=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoparametroformularioiva from "+TipoParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" tipoparametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".codigo_sri from "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+TipoParametroFormularioIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+TipoParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?,codigo_sri=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPARAMETROFORMULARIOIVA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPARAMETROFORMULARIOIVA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPARAMETROFORMULARIOIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPARAMETROFORMULARIOIVA_SELECT(?,?)";
	
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
	
	
	protected TipoParametroFormularioIvaDataAccessAdditional tipoparametroformularioivaDataAccessAdditional=null;
	
	public TipoParametroFormularioIvaDataAccessAdditional getTipoParametroFormularioIvaDataAccessAdditional() {
		return this.tipoparametroformularioivaDataAccessAdditional;
	}
	
	public void setTipoParametroFormularioIvaDataAccessAdditional(TipoParametroFormularioIvaDataAccessAdditional tipoparametroformularioivaDataAccessAdditional) {
		try {
			this.tipoparametroformularioivaDataAccessAdditional=tipoparametroformularioivaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoParametroFormularioIvaDataAccess() {
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
		TipoParametroFormularioIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoParametroFormularioIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoParametroFormularioIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoParametroFormularioIvaOriginal(TipoParametroFormularioIva tipoparametroformularioiva)throws Exception  {
		tipoparametroformularioiva.setTipoParametroFormularioIvaOriginal((TipoParametroFormularioIva)tipoparametroformularioiva.clone());		
	}
	
	public void setTipoParametroFormularioIvasOriginal(List<TipoParametroFormularioIva> tipoparametroformularioivas)throws Exception  {
		
		for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas){
			tipoparametroformularioiva.setTipoParametroFormularioIvaOriginal((TipoParametroFormularioIva)tipoparametroformularioiva.clone());
		}
	}
	
	public static void setTipoParametroFormularioIvaOriginalStatic(TipoParametroFormularioIva tipoparametroformularioiva)throws Exception  {
		tipoparametroformularioiva.setTipoParametroFormularioIvaOriginal((TipoParametroFormularioIva)tipoparametroformularioiva.clone());		
	}
	
	public static void setTipoParametroFormularioIvasOriginalStatic(List<TipoParametroFormularioIva> tipoparametroformularioivas)throws Exception  {
		
		for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas){
			tipoparametroformularioiva.setTipoParametroFormularioIvaOriginal((TipoParametroFormularioIva)tipoparametroformularioiva.clone());
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
	
	public  TipoParametroFormularioIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		
		
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
	
	public  TipoParametroFormularioIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoParametroFormularioIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoParametroFormularioIvaOriginal(new TipoParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParametroFormularioIva("",entity,resultSet); 
				
				//entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParametroFormularioIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoParametroFormularioIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();
				
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
	
	public  TipoParametroFormularioIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoParametroFormularioIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoParametroFormularioIvaOriginal(new TipoParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParametroFormularioIva("",entity,resultSet);    
				
				//entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoParametroFormularioIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoParametroFormularioIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoParametroFormularioIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		
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
	
	public  List<TipoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setTipoParametroFormularioIvaOriginal( new TipoParametroFormularioIva());
      	    	//entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
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
	
	public  List<TipoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParametroFormularioIva();
					//entity.setMapTipoParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=TipoParametroFormularioIvaDataAccess.getEntityTipoParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParametroFormularioIvaOriginal( new TipoParametroFormularioIva());
					////entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParametroFormularioIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoParametroFormularioIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
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
	
	public  TipoParametroFormularioIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParametroFormularioIva();
					//entity.setMapTipoParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=TipoParametroFormularioIvaDataAccess.getEntityTipoParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParametroFormularioIvaOriginal( new TipoParametroFormularioIva());
					////entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoParametroFormularioIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoParametroFormularioIva getEntityTipoParametroFormularioIva(String strPrefijo,TipoParametroFormularioIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoParametroFormularioIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoParametroFormularioIvaDataAccess.setFieldReflectionTipoParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoParametroFormularioIva=TipoParametroFormularioIvaConstantesFunciones.getTodosTiposColumnasTipoParametroFormularioIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoParametroFormularioIva) {
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
							field = TipoParametroFormularioIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoParametroFormularioIvaDataAccess.setFieldReflectionTipoParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoParametroFormularioIva(Field field,String strPrefijo,String sColumn,TipoParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoParametroFormularioIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoParametroFormularioIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoParametroFormularioIvaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParametroFormularioIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoParametroFormularioIva();
					entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoParametroFormularioIva("",entity,resultSet);
					
					//entity.setTipoParametroFormularioIvaOriginal( new TipoParametroFormularioIva());
					//entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParametroFormularioIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
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
	
	public  List<TipoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setTipoParametroFormularioIvaOriginal( new TipoParametroFormularioIva());
      	    	//entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoParametroFormularioIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParametroFormularioIva> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
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
	
	public  List<TipoParametroFormularioIva> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParametroFormularioIva> entities = new  ArrayList<TipoParametroFormularioIva>();
		TipoParametroFormularioIva entity = new TipoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setTipoParametroFormularioIvaOriginal( new TipoParametroFormularioIva());
      	    	//entity.setTipoParametroFormularioIvaOriginal(super.getEntity("",entity.getTipoParametroFormularioIvaOriginal(),resultSet,TipoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParametroFormularioIvaOriginal(this.getEntityTipoParametroFormularioIva("",entity.getTipoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParametroFormularioIvas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoParametroFormularioIva getEntityTipoParametroFormularioIva(String strPrefijo,TipoParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParametroFormularioIvaConstantesFunciones.NOMBRE));
				entity.setcodigo_sri(resultSet.getString(strPrefijo+TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParametroFormularioIvaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoParametroFormularioIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoParametroFormularioIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoParametroFormularioIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoParametroFormularioIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoParametroFormularioIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoParametroFormularioIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoParametroFormularioIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoParametroFormularioIvaDataAccess.TABLENAME,TipoParametroFormularioIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoParametroFormularioIvaDataAccess.setTipoParametroFormularioIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ParametroFormularioIva> getParametroFormularioIvas(Connexion connexion,TipoParametroFormularioIva tipoparametroformularioiva)throws SQLException,Exception {

		List<ParametroFormularioIva> parametroformularioivas= new ArrayList<ParametroFormularioIva>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+".tipo_parametro_formulario_iva ON "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id_tipo_parametro_formulario_iva="+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+".tipo_parametro_formulario_iva.id WHERE "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+".tipo_parametro_formulario_iva.id="+String.valueOf(tipoparametroformularioiva.getId());
			} else {
				sQuery=" INNER JOIN parametroformularioiva.TipoParametroFormularioIva WHERE parametroformularioiva.TipoParametroFormularioIva.id="+String.valueOf(tipoparametroformularioiva.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoParametroFormularioIva tipoparametroformularioiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoparametroformularioiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoparametroformularioiva.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoparametroformularioiva.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_sri=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_sri.setValue(tipoparametroformularioiva.getcodigo_sri());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_sri);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoparametroformularioiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoparametroformularioiva.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoparametroformularioiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoparametroformularioiva.getId());
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
	
	public void setIsNewIsChangedFalseTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva)throws Exception  {		
		tipoparametroformularioiva.setIsNew(false);
		tipoparametroformularioiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoParametroFormularioIvas(List<TipoParametroFormularioIva> tipoparametroformularioivas)throws Exception  {				
		for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas) {
			tipoparametroformularioiva.setIsNew(false);
			tipoparametroformularioiva.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoParametroFormularioIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
