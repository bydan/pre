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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoParamFactuDescuentoConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoParamFactuDescuentoDataAccess extends  TipoParamFactuDescuentoDataAccessAdditional{ //TipoParamFactuDescuentoDataAccessAdditional,DataAccessHelper<TipoParamFactuDescuento>
	//static Logger logger = Logger.getLogger(TipoParamFactuDescuentoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_param_factu_descuento";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoparamfactudescuento from "+TipoParamFactuDescuentoConstantesFunciones.SPERSISTENCENAME+" tipoparamfactudescuento";
	public static String QUERYSELECTNATIVE="select "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuDescuentoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".id,"+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".version_row,"+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+".nombre from "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME;//+" as "+TipoParamFactuDescuentoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+"."+TipoParamFactuDescuentoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPARAMFACTUDESCUENTO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPARAMFACTUDESCUENTO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPARAMFACTUDESCUENTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPARAMFACTUDESCUENTO_SELECT(?,?)";
	
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
	
	
	protected TipoParamFactuDescuentoDataAccessAdditional tipoparamfactudescuentoDataAccessAdditional=null;
	
	public TipoParamFactuDescuentoDataAccessAdditional getTipoParamFactuDescuentoDataAccessAdditional() {
		return this.tipoparamfactudescuentoDataAccessAdditional;
	}
	
	public void setTipoParamFactuDescuentoDataAccessAdditional(TipoParamFactuDescuentoDataAccessAdditional tipoparamfactudescuentoDataAccessAdditional) {
		try {
			this.tipoparamfactudescuentoDataAccessAdditional=tipoparamfactudescuentoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoParamFactuDescuentoDataAccess() {
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
		TipoParamFactuDescuentoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoParamFactuDescuentoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoParamFactuDescuentoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoParamFactuDescuentoOriginal(TipoParamFactuDescuento tipoparamfactudescuento)throws Exception  {
		tipoparamfactudescuento.setTipoParamFactuDescuentoOriginal((TipoParamFactuDescuento)tipoparamfactudescuento.clone());		
	}
	
	public void setTipoParamFactuDescuentosOriginal(List<TipoParamFactuDescuento> tipoparamfactudescuentos)throws Exception  {
		
		for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos){
			tipoparamfactudescuento.setTipoParamFactuDescuentoOriginal((TipoParamFactuDescuento)tipoparamfactudescuento.clone());
		}
	}
	
	public static void setTipoParamFactuDescuentoOriginalStatic(TipoParamFactuDescuento tipoparamfactudescuento)throws Exception  {
		tipoparamfactudescuento.setTipoParamFactuDescuentoOriginal((TipoParamFactuDescuento)tipoparamfactudescuento.clone());		
	}
	
	public static void setTipoParamFactuDescuentosOriginalStatic(List<TipoParamFactuDescuento> tipoparamfactudescuentos)throws Exception  {
		
		for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos){
			tipoparamfactudescuento.setTipoParamFactuDescuentoOriginal((TipoParamFactuDescuento)tipoparamfactudescuento.clone());
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
	
	public  TipoParamFactuDescuento getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		
		
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
	
	public  TipoParamFactuDescuento getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoParamFactuDescuento.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoParamFactuDescuentoOriginal(new TipoParamFactuDescuento());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuDescuento("",entity,resultSet); 
				
				//entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuDescuento(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoParamFactuDescuento getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();
				
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
	
	public  TipoParamFactuDescuento getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuDescuento.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoParamFactuDescuentoOriginal(new TipoParamFactuDescuento());
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoParamFactuDescuento("",entity,resultSet);    
				
				//entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoParamFactuDescuento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoParamFactuDescuento
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoParamFactuDescuento.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoParamFactuDescuento(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoParamFactuDescuento> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		
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
	
	public  List<TipoParamFactuDescuento> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuDescuento();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuDescuento("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuDescuentoOriginal( new TipoParamFactuDescuento());
      	    	//entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuDescuentos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuDescuento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuDescuento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
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
	
	public  List<TipoParamFactuDescuento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuDescuento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuDescuento();
					//entity.setMapTipoParamFactuDescuento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoParamFactuDescuentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuDescuento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuDescuentoDataAccess.getEntityTipoParamFactuDescuento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuDescuentoOriginal( new TipoParamFactuDescuento());
					////entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuDescuentos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuDescuento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoParamFactuDescuento getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
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
	
	public  TipoParamFactuDescuento getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuDescuento();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoParamFactuDescuento();
					//entity.setMapTipoParamFactuDescuento(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoParamFactuDescuentoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoParamFactuDescuento().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         		
					entity=TipoParamFactuDescuentoDataAccess.getEntityTipoParamFactuDescuento("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoParamFactuDescuentoOriginal( new TipoParamFactuDescuento());
					////entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuDescuento(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuDescuento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoParamFactuDescuento getEntityTipoParamFactuDescuento(String strPrefijo,TipoParamFactuDescuento entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoParamFactuDescuento.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoParamFactuDescuento.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoParamFactuDescuentoDataAccess.setFieldReflectionTipoParamFactuDescuento(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoParamFactuDescuento=TipoParamFactuDescuentoConstantesFunciones.getTodosTiposColumnasTipoParamFactuDescuento();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoParamFactuDescuento) {
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
							field = TipoParamFactuDescuento.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoParamFactuDescuento.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoParamFactuDescuentoDataAccess.setFieldReflectionTipoParamFactuDescuento(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoParamFactuDescuento(Field field,String strPrefijo,String sColumn,TipoParamFactuDescuento entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoParamFactuDescuentoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoParamFactuDescuentoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoParamFactuDescuentoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuDescuento>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoParamFactuDescuento();
					entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoParamFactuDescuento("",entity,resultSet);
					
					//entity.setTipoParamFactuDescuentoOriginal( new TipoParamFactuDescuento());
					//entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoParamFactuDescuentos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuDescuento(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoParamFactuDescuento>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoParamFactuDescuentoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoParamFactuDescuentoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoParamFactuDescuento> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
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
	
	public  List<TipoParamFactuDescuento> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuDescuento();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuDescuento("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuDescuentoOriginal( new TipoParamFactuDescuento());
      	    	//entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoParamFactuDescuentos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoParamFactuDescuento(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoParamFactuDescuento> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
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
	
	public  List<TipoParamFactuDescuento> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoParamFactuDescuento> entities = new  ArrayList<TipoParamFactuDescuento>();
		TipoParamFactuDescuento entity = new TipoParamFactuDescuento();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoParamFactuDescuento();
      	    	entity=super.getEntity("",entity,resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoParamFactuDescuento("",entity,resultSet);
      	    	
				//entity.setTipoParamFactuDescuentoOriginal( new TipoParamFactuDescuento());
      	    	//entity.setTipoParamFactuDescuentoOriginal(super.getEntity("",entity.getTipoParamFactuDescuentoOriginal(),resultSet,TipoParamFactuDescuentoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoParamFactuDescuentoOriginal(this.getEntityTipoParamFactuDescuento("",entity.getTipoParamFactuDescuentoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoParamFactuDescuentos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoParamFactuDescuento getEntityTipoParamFactuDescuento(String strPrefijo,TipoParamFactuDescuento entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuDescuentoConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoParamFactuDescuentoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoParamFactuDescuento(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoParamFactuDescuento entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoParamFactuDescuentoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoParamFactuDescuentoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoParamFactuDescuentoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoParamFactuDescuentoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoParamFactuDescuentoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoParamFactuDescuentoDataAccess.TABLENAME,TipoParamFactuDescuentoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoParamFactuDescuentoDataAccess.setTipoParamFactuDescuentoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<ParametroFactuPrincipal> getParametroFactuPrincipals(Connexion connexion,TipoParamFactuDescuento tipoparamfactudescuento)throws SQLException,Exception {

		List<ParametroFactuPrincipal> parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+".tipo_param_factu_descuento ON "+ParametroFactuPrincipalConstantesFunciones.SCHEMA+".parametro_factu_principal.id_tipo_param_factu_descuento="+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+".tipo_param_factu_descuento.id WHERE "+TipoParamFactuDescuentoConstantesFunciones.SCHEMA+".tipo_param_factu_descuento.id="+String.valueOf(tipoparamfactudescuento.getId());
			} else {
				sQuery=" INNER JOIN parametrofactuprincipal.TipoParamFactuDescuento WHERE parametrofactuprincipal.TipoParamFactuDescuento.id="+String.valueOf(tipoparamfactudescuento.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroFactuPrincipalDataAccess parametrofactuprincipalDataAccess=new ParametroFactuPrincipalDataAccess();

			parametrofactuprincipalDataAccess.setConnexionType(this.connexionType);
			parametrofactuprincipalDataAccess.setParameterDbType(this.parameterDbType);
			parametrofactuprincipals=parametrofactuprincipalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrofactuprincipals;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoParamFactuDescuento tipoparamfactudescuento) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoparamfactudescuento.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipoparamfactudescuento.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoparamfactudescuento.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoparamfactudescuento.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoparamfactudescuento.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoparamfactudescuento.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoparamfactudescuento.getId());
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
	
	public void setIsNewIsChangedFalseTipoParamFactuDescuento(TipoParamFactuDescuento tipoparamfactudescuento)throws Exception  {		
		tipoparamfactudescuento.setIsNew(false);
		tipoparamfactudescuento.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoParamFactuDescuentos(List<TipoParamFactuDescuento> tipoparamfactudescuentos)throws Exception  {				
		for(TipoParamFactuDescuento tipoparamfactudescuento:tipoparamfactudescuentos) {
			tipoparamfactudescuento.setIsNew(false);
			tipoparamfactudescuento.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoParamFactuDescuento(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
