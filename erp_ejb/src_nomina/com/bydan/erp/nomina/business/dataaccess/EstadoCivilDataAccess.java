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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//EstadoCivilConstantesFunciones;


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class EstadoCivilDataAccess extends  EstadoCivilDataAccessAdditional{ //EstadoCivilDataAccessAdditional,DataAccessHelper<EstadoCivil>
	//static Logger logger = Logger.getLogger(EstadoCivilDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_civil";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadocivil from "+EstadoCivilConstantesFunciones.SPERSISTENCENAME+" estadocivil";
	public static String QUERYSELECTNATIVE="select "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".id,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".version_row,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".codigo,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".nombre from "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME;//+" as "+EstadoCivilConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".id,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".version_row,"+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+".codigo from "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME;//+" as "+EstadoCivilConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoCivilConstantesFunciones.SCHEMA+"."+EstadoCivilConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOCIVIL_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOCIVIL_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOCIVIL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOCIVIL_SELECT(?,?)";
	
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
	
	
	protected EstadoCivilDataAccessAdditional estadocivilDataAccessAdditional=null;
	
	public EstadoCivilDataAccessAdditional getEstadoCivilDataAccessAdditional() {
		return this.estadocivilDataAccessAdditional;
	}
	
	public void setEstadoCivilDataAccessAdditional(EstadoCivilDataAccessAdditional estadocivilDataAccessAdditional) {
		try {
			this.estadocivilDataAccessAdditional=estadocivilDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EstadoCivilDataAccess() {
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
		EstadoCivilDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoCivilDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoCivilDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoCivilOriginal(EstadoCivil estadocivil)throws Exception  {
		estadocivil.setEstadoCivilOriginal((EstadoCivil)estadocivil.clone());		
	}
	
	public void setEstadoCivilsOriginal(List<EstadoCivil> estadocivils)throws Exception  {
		
		for(EstadoCivil estadocivil:estadocivils){
			estadocivil.setEstadoCivilOriginal((EstadoCivil)estadocivil.clone());
		}
	}
	
	public static void setEstadoCivilOriginalStatic(EstadoCivil estadocivil)throws Exception  {
		estadocivil.setEstadoCivilOriginal((EstadoCivil)estadocivil.clone());		
	}
	
	public static void setEstadoCivilsOriginalStatic(List<EstadoCivil> estadocivils)throws Exception  {
		
		for(EstadoCivil estadocivil:estadocivils){
			estadocivil.setEstadoCivilOriginal((EstadoCivil)estadocivil.clone());
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
	
	public  EstadoCivil getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoCivil entity = new EstadoCivil();		
		
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
	
	public  EstadoCivil getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoCivil entity = new EstadoCivil();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EstadoCivil.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoCivilOriginal(new EstadoCivil());
      	    	entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoCivil("",entity,resultSet); 
				
				//entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoCivil(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoCivil getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoCivil entity = new EstadoCivil();
				
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
	
	public  EstadoCivil getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoCivil entity = new EstadoCivil();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCivilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoCivil.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoCivilOriginal(new EstadoCivil());
      	    	entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoCivil("",entity,resultSet);    
				
				//entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoCivil(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoCivil
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoCivil entity = new EstadoCivil();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCivilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EstadoCivil.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoCivil(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoCivil> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		
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
	
	public  List<EstadoCivil> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCivilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCivil();
      	    	entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoCivil("",entity,resultSet);
      	    	
				//entity.setEstadoCivilOriginal( new EstadoCivil());
      	    	//entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoCivils(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCivil(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoCivil> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
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
	
	public  List<EstadoCivil> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCivil();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoCivil();
					//entity.setMapEstadoCivil(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoCivilValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoCivil().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         		
					entity=EstadoCivilDataAccess.getEntityEstadoCivil("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoCivilOriginal( new EstadoCivil());
					////entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoCivils(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCivil(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoCivil getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoCivil entity = new EstadoCivil();		  
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
	
	public  EstadoCivil getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCivil();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoCivil();
					//entity.setMapEstadoCivil(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoCivilValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoCivil().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         		
					entity=EstadoCivilDataAccess.getEntityEstadoCivil("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoCivilOriginal( new EstadoCivil());
					////entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoCivil(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCivil(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoCivil getEntityEstadoCivil(String strPrefijo,EstadoCivil entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoCivil.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoCivil.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoCivilDataAccess.setFieldReflectionEstadoCivil(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoCivil=EstadoCivilConstantesFunciones.getTodosTiposColumnasEstadoCivil();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoCivil) {
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
							field = EstadoCivil.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoCivil.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoCivilDataAccess.setFieldReflectionEstadoCivil(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoCivil(Field field,String strPrefijo,String sColumn,EstadoCivil entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoCivilConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoCivilConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoCivilConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoCivilConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoCivil>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCivilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoCivil();
					entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoCivil("",entity,resultSet);
					
					//entity.setEstadoCivilOriginal( new EstadoCivil());
					//entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoCivils(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCivil(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoCivil>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoCivilDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCivilDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoCivil> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
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
	
	public  List<EstadoCivil> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCivil();
      	    	entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoCivil("",entity,resultSet);
      	    	
				//entity.setEstadoCivilOriginal( new EstadoCivil());
      	    	//entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoCivils(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCivil(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoCivil> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
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
	
	public  List<EstadoCivil> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoCivil> entities = new  ArrayList<EstadoCivil>();
		EstadoCivil entity = new EstadoCivil();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCivil();
      	    	entity=super.getEntity("",entity,resultSet,EstadoCivilDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoCivil("",entity,resultSet);
      	    	
				//entity.setEstadoCivilOriginal( new EstadoCivil());
      	    	//entity.setEstadoCivilOriginal(super.getEntity("",entity.getEstadoCivilOriginal(),resultSet,EstadoCivilDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCivilOriginal(this.getEntityEstadoCivil("",entity.getEstadoCivilOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoCivils(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EstadoCivil getEntityEstadoCivil(String strPrefijo,EstadoCivil entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoCivilConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoCivilConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoCivilConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoCivil(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoCivil entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoCivilDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoCivilDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoCivilDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoCivilDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoCivilConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoCivilDataAccess.TABLENAME,EstadoCivilDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoCivilDataAccess.setEstadoCivilOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Cliente> getClientes(Connexion connexion,EstadoCivil estadocivil)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_estado_civil="+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id WHERE "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id="+String.valueOf(estadocivil.getId());
			} else {
				sQuery=" INNER JOIN cliente.EstadoCivil WHERE cliente.EstadoCivil.id="+String.valueOf(estadocivil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<CargaFamiliar_NM> getCargaFamiliar_NMs(Connexion connexion,EstadoCivil estadocivil)throws SQLException,Exception {

		List<CargaFamiliar_NM> cargafamiliar_nms= new ArrayList<CargaFamiliar_NM>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil ON "+CargaFamiliar_NMConstantesFunciones.SCHEMA+".carga_familiar__n_m.id_estado_civil="+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id WHERE "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id="+String.valueOf(estadocivil.getId());
			} else {
				sQuery=" INNER JOIN cargafamiliar_nm.EstadoCivil WHERE cargafamiliar_nm.EstadoCivil.id="+String.valueOf(estadocivil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargaFamiliar_NMDataAccess cargafamiliar_nmDataAccess=new CargaFamiliar_NMDataAccess();

			cargafamiliar_nmDataAccess.setConnexionType(this.connexionType);
			cargafamiliar_nmDataAccess.setParameterDbType(this.parameterDbType);
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargafamiliar_nms;

	}

	public List<SubCliente> getSubClientes(Connexion connexion,EstadoCivil estadocivil)throws SQLException,Exception {

		List<SubCliente> subclientes= new ArrayList<SubCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil ON "+SubClienteConstantesFunciones.SCHEMA+".sub_cliente.id_estado_civil="+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id WHERE "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id="+String.valueOf(estadocivil.getId());
			} else {
				sQuery=" INNER JOIN subcliente.EstadoCivil WHERE subcliente.EstadoCivil.id="+String.valueOf(estadocivil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);
			subclientes=subclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subclientes;

	}

	public List<Empleado> getEmpleados(Connexion connexion,EstadoCivil estadocivil)throws SQLException,Exception {

		List<Empleado> empleados= new ArrayList<Empleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil ON "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id_estado_civil="+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id WHERE "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id="+String.valueOf(estadocivil.getId());
			} else {
				sQuery=" INNER JOIN empleado.EstadoCivil WHERE empleado.EstadoCivil.id="+String.valueOf(estadocivil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleados;

	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos(Connexion connexion,EstadoCivil estadocivil)throws SQLException,Exception {

		List<ParametroCarteraDefecto> parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil ON "+ParametroCarteraDefectoConstantesFunciones.SCHEMA+".parametro_cartera_defecto.id_estado_civil="+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id WHERE "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id="+String.valueOf(estadocivil.getId());
			} else {
				sQuery=" INNER JOIN parametrocarteradefecto.EstadoCivil WHERE parametrocarteradefecto.EstadoCivil.id="+String.valueOf(estadocivil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroCarteraDefectoDataAccess parametrocarteradefectoDataAccess=new ParametroCarteraDefectoDataAccess();

			parametrocarteradefectoDataAccess.setConnexionType(this.connexionType);
			parametrocarteradefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocarteradefectos=parametrocarteradefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocarteradefectos;

	}

	public List<CargaFamiliar> getCargaFamiliars(Connexion connexion,EstadoCivil estadocivil)throws SQLException,Exception {

		List<CargaFamiliar> cargafamiliars= new ArrayList<CargaFamiliar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil ON "+CargaFamiliarConstantesFunciones.SCHEMA+".carga_familiar.id_estado_civil="+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id WHERE "+EstadoCivilConstantesFunciones.SCHEMA+".estado_civil.id="+String.valueOf(estadocivil.getId());
			} else {
				sQuery=" INNER JOIN cargafamiliar.EstadoCivil WHERE cargafamiliar.EstadoCivil.id="+String.valueOf(estadocivil.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CargaFamiliarDataAccess cargafamiliarDataAccess=new CargaFamiliarDataAccess();

			cargafamiliarDataAccess.setConnexionType(this.connexionType);
			cargafamiliarDataAccess.setParameterDbType(this.parameterDbType);
			cargafamiliars=cargafamiliarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargafamiliars;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoCivil estadocivil) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadocivil.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadocivil.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadocivil.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadocivil.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadocivil.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadocivil.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadocivil.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadocivil.getId());
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
	
	public void setIsNewIsChangedFalseEstadoCivil(EstadoCivil estadocivil)throws Exception  {		
		estadocivil.setIsNew(false);
		estadocivil.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoCivils(List<EstadoCivil> estadocivils)throws Exception  {				
		for(EstadoCivil estadocivil:estadocivils) {
			estadocivil.setIsNew(false);
			estadocivil.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoCivil(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
