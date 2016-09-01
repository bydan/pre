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
import com.bydan.erp.contabilidad.util.*;//SubGrupoParametroFormularioIvaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class SubGrupoParametroFormularioIvaDataAccess extends  DataAccessHelper<SubGrupoParametroFormularioIva>{ //SubGrupoParametroFormularioIvaDataAccessAdditional,DataAccessHelper<SubGrupoParametroFormularioIva>
	//static Logger logger = Logger.getLogger(SubGrupoParametroFormularioIvaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="sub_grupo_parametro_formulario_iva";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+"(id_empresa,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+" set id_empresa=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select subgrupoparametroformularioiva from "+SubGrupoParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" subgrupoparametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+" set id_empresa=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SUBGRUPOPARAMETROFORMULARIOIVA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SUBGRUPOPARAMETROFORMULARIOIVA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SUBGRUPOPARAMETROFORMULARIOIVA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SUBGRUPOPARAMETROFORMULARIOIVA_SELECT(?,?)";
	
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
	
	
	public SubGrupoParametroFormularioIvaDataAccess() {
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
		SubGrupoParametroFormularioIvaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SubGrupoParametroFormularioIvaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SubGrupoParametroFormularioIvaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSubGrupoParametroFormularioIvaOriginal(SubGrupoParametroFormularioIva subgrupoparametroformularioiva)throws Exception  {
		subgrupoparametroformularioiva.setSubGrupoParametroFormularioIvaOriginal((SubGrupoParametroFormularioIva)subgrupoparametroformularioiva.clone());		
	}
	
	public void setSubGrupoParametroFormularioIvasOriginal(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas)throws Exception  {
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:subgrupoparametroformularioivas){
			subgrupoparametroformularioiva.setSubGrupoParametroFormularioIvaOriginal((SubGrupoParametroFormularioIva)subgrupoparametroformularioiva.clone());
		}
	}
	
	public static void setSubGrupoParametroFormularioIvaOriginalStatic(SubGrupoParametroFormularioIva subgrupoparametroformularioiva)throws Exception  {
		subgrupoparametroformularioiva.setSubGrupoParametroFormularioIvaOriginal((SubGrupoParametroFormularioIva)subgrupoparametroformularioiva.clone());		
	}
	
	public static void setSubGrupoParametroFormularioIvasOriginalStatic(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas)throws Exception  {
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:subgrupoparametroformularioivas){
			subgrupoparametroformularioiva.setSubGrupoParametroFormularioIvaOriginal((SubGrupoParametroFormularioIva)subgrupoparametroformularioiva.clone());
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
	
	public  SubGrupoParametroFormularioIva getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		
		
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
	
	public  SubGrupoParametroFormularioIva getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.SubGrupoParametroFormularioIva.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSubGrupoParametroFormularioIvaOriginal(new SubGrupoParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubGrupoParametroFormularioIva("",entity,resultSet); 
				
				//entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSubGrupoParametroFormularioIva(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  SubGrupoParametroFormularioIva getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();
				
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
	
	public  SubGrupoParametroFormularioIva getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.SubGrupoParametroFormularioIva.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSubGrupoParametroFormularioIvaOriginal(new SubGrupoParametroFormularioIva());
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySubGrupoParametroFormularioIva("",entity,resultSet);    
				
				//entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSubGrupoParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //SubGrupoParametroFormularioIva
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.SubGrupoParametroFormularioIva.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSubGrupoParametroFormularioIva(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<SubGrupoParametroFormularioIva> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		
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
	
	public  List<SubGrupoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubGrupoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setSubGrupoParametroFormularioIvaOriginal( new SubGrupoParametroFormularioIva());
      	    	//entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubGrupoParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<SubGrupoParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
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
	
	public  List<SubGrupoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapSubGrupoParametroFormularioIva();
					//entity.setMapSubGrupoParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSubGrupoParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubGrupoParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=SubGrupoParametroFormularioIvaDataAccess.getEntitySubGrupoParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubGrupoParametroFormularioIvaOriginal( new SubGrupoParametroFormularioIva());
					////entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSubGrupoParametroFormularioIvas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public SubGrupoParametroFormularioIva getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
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
	
	public  SubGrupoParametroFormularioIva getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoParametroFormularioIva();
				
				if(conMapGenerico) {
					entity.inicializarMapSubGrupoParametroFormularioIva();
					//entity.setMapSubGrupoParametroFormularioIva(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSubGrupoParametroFormularioIvaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSubGrupoParametroFormularioIva().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=SubGrupoParametroFormularioIvaDataAccess.getEntitySubGrupoParametroFormularioIva("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSubGrupoParametroFormularioIvaOriginal( new SubGrupoParametroFormularioIva());
					////entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					////entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSubGrupoParametroFormularioIva(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static SubGrupoParametroFormularioIva getEntitySubGrupoParametroFormularioIva(String strPrefijo,SubGrupoParametroFormularioIva entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = SubGrupoParametroFormularioIva.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = SubGrupoParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SubGrupoParametroFormularioIvaDataAccess.setFieldReflectionSubGrupoParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSubGrupoParametroFormularioIva=SubGrupoParametroFormularioIvaConstantesFunciones.getTodosTiposColumnasSubGrupoParametroFormularioIva();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSubGrupoParametroFormularioIva) {
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
							field = SubGrupoParametroFormularioIva.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = SubGrupoParametroFormularioIva.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SubGrupoParametroFormularioIvaDataAccess.setFieldReflectionSubGrupoParametroFormularioIva(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSubGrupoParametroFormularioIva(Field field,String strPrefijo,String sColumn,SubGrupoParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SubGrupoParametroFormularioIvaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SubGrupoParametroFormularioIvaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubGrupoParametroFormularioIva>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new SubGrupoParametroFormularioIva();
					entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySubGrupoParametroFormularioIva("",entity,resultSet);
					
					//entity.setSubGrupoParametroFormularioIvaOriginal( new SubGrupoParametroFormularioIva());
					//entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
					//entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSubGrupoParametroFormularioIvas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<SubGrupoParametroFormularioIva>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SubGrupoParametroFormularioIvaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SubGrupoParametroFormularioIvaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<SubGrupoParametroFormularioIva> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
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
	
	public  List<SubGrupoParametroFormularioIva> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<SubGrupoParametroFormularioIva> entities = new  ArrayList<SubGrupoParametroFormularioIva>();
		SubGrupoParametroFormularioIva entity = new SubGrupoParametroFormularioIva();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new SubGrupoParametroFormularioIva();
      	    	entity=super.getEntity("",entity,resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySubGrupoParametroFormularioIva("",entity,resultSet);
      	    	
				//entity.setSubGrupoParametroFormularioIvaOriginal( new SubGrupoParametroFormularioIva());
      	    	//entity.setSubGrupoParametroFormularioIvaOriginal(super.getEntity("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet,SubGrupoParametroFormularioIvaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSubGrupoParametroFormularioIvaOriginal(this.getEntitySubGrupoParametroFormularioIva("",entity.getSubGrupoParametroFormularioIvaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSubGrupoParametroFormularioIvas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSubGrupoParametroFormularioIva(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public SubGrupoParametroFormularioIva getEntitySubGrupoParametroFormularioIva(String strPrefijo,SubGrupoParametroFormularioIva entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSubGrupoParametroFormularioIva(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(SubGrupoParametroFormularioIva entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SubGrupoParametroFormularioIvaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SubGrupoParametroFormularioIvaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SubGrupoParametroFormularioIvaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SubGrupoParametroFormularioIvaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SubGrupoParametroFormularioIvaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SubGrupoParametroFormularioIvaDataAccess.TABLENAME,SubGrupoParametroFormularioIvaDataAccess.ISWITHSTOREPROCEDURES);
			
			SubGrupoParametroFormularioIvaDataAccess.setSubGrupoParametroFormularioIvaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,SubGrupoParametroFormularioIva relsubgrupoparametroformularioiva)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relsubgrupoparametroformularioiva.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ParametroFormularioIva> getParametroFormularioIvas(Connexion connexion,SubGrupoParametroFormularioIva subgrupoparametroformularioiva)throws SQLException,Exception {

		List<ParametroFormularioIva> parametroformularioivas= new ArrayList<ParametroFormularioIva>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".sub_grupo_parametro_formulario_iva ON "+ParametroFormularioIvaConstantesFunciones.SCHEMA+".parametro_formulario_iva.id_sub_grupo_parametro_formulario_iva="+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".sub_grupo_parametro_formulario_iva.id WHERE "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+".sub_grupo_parametro_formulario_iva.id="+String.valueOf(subgrupoparametroformularioiva.getId());
			} else {
				sQuery=" INNER JOIN parametroformularioiva.SubGrupoParametroFormularioIva WHERE parametroformularioiva.SubGrupoParametroFormularioIva.id="+String.valueOf(subgrupoparametroformularioiva.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,SubGrupoParametroFormularioIva subgrupoparametroformularioiva) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!subgrupoparametroformularioiva.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(subgrupoparametroformularioiva.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(subgrupoparametroformularioiva.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!subgrupoparametroformularioiva.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(subgrupoparametroformularioiva.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(subgrupoparametroformularioiva.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(subgrupoparametroformularioiva.getId());
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
	
	public void setIsNewIsChangedFalseSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva)throws Exception  {		
		subgrupoparametroformularioiva.setIsNew(false);
		subgrupoparametroformularioiva.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSubGrupoParametroFormularioIvas(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas)throws Exception  {				
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva:subgrupoparametroformularioivas) {
			subgrupoparametroformularioiva.setIsNew(false);
			subgrupoparametroformularioiva.setIsChanged(false);
		}
	}
	
	public void generarExportarSubGrupoParametroFormularioIva(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
