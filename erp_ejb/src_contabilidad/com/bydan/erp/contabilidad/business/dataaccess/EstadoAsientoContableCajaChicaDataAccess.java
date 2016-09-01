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
import com.bydan.erp.contabilidad.util.*;//EstadoAsientoContableCajaChicaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class EstadoAsientoContableCajaChicaDataAccess extends  DataAccessHelperSinIdGenerated<EstadoAsientoContableCajaChica>{ //EstadoAsientoContableCajaChicaDataAccessAdditional,DataAccessHelper<EstadoAsientoContableCajaChica>
	//static Logger logger = Logger.getLogger(EstadoAsientoContableCajaChicaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_asiento_contable_caja_chica";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadoasientocontablecajachica from "+EstadoAsientoContableCajaChicaConstantesFunciones.SPERSISTENCENAME+" estadoasientocontablecajachica";
	public static String QUERYSELECTNATIVE="select "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".codigo,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".nombre from "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+".codigo from "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+EstadoAsientoContableCajaChicaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOASIENTOCONTABLECAJACHICA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOASIENTOCONTABLECAJACHICA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOASIENTOCONTABLECAJACHICA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOASIENTOCONTABLECAJACHICA_SELECT(?,?)";
	
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
	
	
	public EstadoAsientoContableCajaChicaDataAccess() {
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
		EstadoAsientoContableCajaChicaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoAsientoContableCajaChicaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoAsientoContableCajaChicaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoAsientoContableCajaChicaOriginal(EstadoAsientoContableCajaChica estadoasientocontablecajachica)throws Exception  {
		estadoasientocontablecajachica.setEstadoAsientoContableCajaChicaOriginal((EstadoAsientoContableCajaChica)estadoasientocontablecajachica.clone());		
	}
	
	public void setEstadoAsientoContableCajaChicasOriginal(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas)throws Exception  {
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica:estadoasientocontablecajachicas){
			estadoasientocontablecajachica.setEstadoAsientoContableCajaChicaOriginal((EstadoAsientoContableCajaChica)estadoasientocontablecajachica.clone());
		}
	}
	
	public static void setEstadoAsientoContableCajaChicaOriginalStatic(EstadoAsientoContableCajaChica estadoasientocontablecajachica)throws Exception  {
		estadoasientocontablecajachica.setEstadoAsientoContableCajaChicaOriginal((EstadoAsientoContableCajaChica)estadoasientocontablecajachica.clone());		
	}
	
	public static void setEstadoAsientoContableCajaChicasOriginalStatic(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas)throws Exception  {
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica:estadoasientocontablecajachicas){
			estadoasientocontablecajachica.setEstadoAsientoContableCajaChicaOriginal((EstadoAsientoContableCajaChica)estadoasientocontablecajachica.clone());
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
	
	public  EstadoAsientoContableCajaChica getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		
		
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
	
	public  EstadoAsientoContableCajaChica getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.EstadoAsientoContableCajaChica.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoAsientoContableCajaChicaOriginal(new EstadoAsientoContableCajaChica());
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoAsientoContableCajaChica("",entity,resultSet); 
				
				//entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoAsientoContableCajaChica(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoAsientoContableCajaChica getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();
				
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
	
	public  EstadoAsientoContableCajaChica getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.EstadoAsientoContableCajaChica.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoAsientoContableCajaChicaOriginal(new EstadoAsientoContableCajaChica());
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoAsientoContableCajaChica("",entity,resultSet);    
				
				//entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoAsientoContableCajaChica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoAsientoContableCajaChica
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.EstadoAsientoContableCajaChica.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoAsientoContableCajaChica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoAsientoContableCajaChica> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		
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
	
	public  List<EstadoAsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setEstadoAsientoContableCajaChicaOriginal( new EstadoAsientoContableCajaChica());
      	    	//entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoAsientoContableCajaChicas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoAsientoContableCajaChica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
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
	
	public  List<EstadoAsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContableCajaChica();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoAsientoContableCajaChica();
					//entity.setMapEstadoAsientoContableCajaChica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoAsientoContableCajaChicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoAsientoContableCajaChica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoAsientoContableCajaChicaDataAccess.getEntityEstadoAsientoContableCajaChica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoAsientoContableCajaChicaOriginal( new EstadoAsientoContableCajaChica());
					////entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoAsientoContableCajaChicas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoAsientoContableCajaChica getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
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
	
	public  EstadoAsientoContableCajaChica getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContableCajaChica();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoAsientoContableCajaChica();
					//entity.setMapEstadoAsientoContableCajaChica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoAsientoContableCajaChicaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoAsientoContableCajaChica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=EstadoAsientoContableCajaChicaDataAccess.getEntityEstadoAsientoContableCajaChica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoAsientoContableCajaChicaOriginal( new EstadoAsientoContableCajaChica());
					////entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoAsientoContableCajaChica(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoAsientoContableCajaChica getEntityEstadoAsientoContableCajaChica(String strPrefijo,EstadoAsientoContableCajaChica entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoAsientoContableCajaChica.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoAsientoContableCajaChica.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoAsientoContableCajaChicaDataAccess.setFieldReflectionEstadoAsientoContableCajaChica(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoAsientoContableCajaChica=EstadoAsientoContableCajaChicaConstantesFunciones.getTodosTiposColumnasEstadoAsientoContableCajaChica();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoAsientoContableCajaChica) {
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
							field = EstadoAsientoContableCajaChica.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoAsientoContableCajaChica.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoAsientoContableCajaChicaDataAccess.setFieldReflectionEstadoAsientoContableCajaChica(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoAsientoContableCajaChica(Field field,String strPrefijo,String sColumn,EstadoAsientoContableCajaChica entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoAsientoContableCajaChicaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoAsientoContableCajaChicaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoAsientoContableCajaChica>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoAsientoContableCajaChica();
					entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoAsientoContableCajaChica("",entity,resultSet);
					
					//entity.setEstadoAsientoContableCajaChicaOriginal( new EstadoAsientoContableCajaChica());
					//entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoAsientoContableCajaChicas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoAsientoContableCajaChica>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoAsientoContableCajaChicaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoAsientoContableCajaChicaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoAsientoContableCajaChica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
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
	
	public  List<EstadoAsientoContableCajaChica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoAsientoContableCajaChica> entities = new  ArrayList<EstadoAsientoContableCajaChica>();
		EstadoAsientoContableCajaChica entity = new EstadoAsientoContableCajaChica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoAsientoContableCajaChica();
      	    	entity=super.getEntity("",entity,resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoAsientoContableCajaChica("",entity,resultSet);
      	    	
				//entity.setEstadoAsientoContableCajaChicaOriginal( new EstadoAsientoContableCajaChica());
      	    	//entity.setEstadoAsientoContableCajaChicaOriginal(super.getEntity("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet,EstadoAsientoContableCajaChicaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoAsientoContableCajaChicaOriginal(this.getEntityEstadoAsientoContableCajaChica("",entity.getEstadoAsientoContableCajaChicaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoAsientoContableCajaChicas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoAsientoContableCajaChica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoAsientoContableCajaChica getEntityEstadoAsientoContableCajaChica(String strPrefijo,EstadoAsientoContableCajaChica entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoAsientoContableCajaChica(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoAsientoContableCajaChica entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoAsientoContableCajaChicaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoAsientoContableCajaChicaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoAsientoContableCajaChicaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoAsientoContableCajaChicaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoAsientoContableCajaChicaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoAsientoContableCajaChicaDataAccess.TABLENAME,EstadoAsientoContableCajaChicaDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoAsientoContableCajaChicaDataAccess.setEstadoAsientoContableCajaChicaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<AsientoContableCajaChica> getAsientoContableCajaChicas(Connexion connexion,EstadoAsientoContableCajaChica estadoasientocontablecajachica)throws SQLException,Exception {

		List<AsientoContableCajaChica> asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+".estado_asiento_contable_caja_chica ON "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+".asiento_contable_caja_chica.id_estado_asiento_contable_caja_chica="+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+".estado_asiento_contable_caja_chica.id WHERE "+EstadoAsientoContableCajaChicaConstantesFunciones.SCHEMA+".estado_asiento_contable_caja_chica.id="+String.valueOf(estadoasientocontablecajachica.getId());
			} else {
				sQuery=" INNER JOIN asientocontablecajachica.EstadoAsientoContableCajaChica WHERE asientocontablecajachica.EstadoAsientoContableCajaChica.id="+String.valueOf(estadoasientocontablecajachica.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoAsientoContableCajaChica estadoasientocontablecajachica) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadoasientocontablecajachica.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadoasientocontablecajachica.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadoasientocontablecajachica.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadoasientocontablecajachica.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadoasientocontablecajachica.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadoasientocontablecajachica.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadoasientocontablecajachica.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadoasientocontablecajachica.getId());
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
	
	public void setIsNewIsChangedFalseEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachica)throws Exception  {		
		estadoasientocontablecajachica.setIsNew(false);
		estadoasientocontablecajachica.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoAsientoContableCajaChicas(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas)throws Exception  {				
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica:estadoasientocontablecajachicas) {
			estadoasientocontablecajachica.setIsNew(false);
			estadoasientocontablecajachica.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoAsientoContableCajaChica(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
