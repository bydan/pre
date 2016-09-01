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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//AbonoPrestamoConstantesFunciones;










@SuppressWarnings("unused")
final public class AbonoPrestamoDataAccess extends  AbonoPrestamoDataAccessAdditional{ //AbonoPrestamoDataAccessAdditional,DataAccessHelper<AbonoPrestamo>
	//static Logger logger = Logger.getLogger(AbonoPrestamoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="abono_prestamo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+"(version_row,id_prestamo,numero,monto_capital,monto_interes,valor,fecha_vencimiento,codigo_quincena)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_prestamo=?,numero=?,monto_capital=?,monto_interes=?,valor=?,fecha_vencimiento=?,codigo_quincena=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select abonoprestamo from "+AbonoPrestamoConstantesFunciones.SPERSISTENCENAME+" abonoprestamo";
	public static String QUERYSELECTNATIVE="select "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".id,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".version_row,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".id_prestamo,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".numero,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".monto_capital,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".monto_interes,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".valor,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".codigo_quincena from "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME;//+" as "+AbonoPrestamoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".id,"+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+".version_row from "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME;//+" as "+AbonoPrestamoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+AbonoPrestamoConstantesFunciones.SCHEMA+"."+AbonoPrestamoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_prestamo=?,numero=?,monto_capital=?,monto_interes=?,valor=?,fecha_vencimiento=?,codigo_quincena=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ABONOPRESTAMO_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ABONOPRESTAMO_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ABONOPRESTAMO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ABONOPRESTAMO_SELECT(?,?)";
	
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
	
	
	protected AbonoPrestamoDataAccessAdditional abonoprestamoDataAccessAdditional=null;
	
	public AbonoPrestamoDataAccessAdditional getAbonoPrestamoDataAccessAdditional() {
		return this.abonoprestamoDataAccessAdditional;
	}
	
	public void setAbonoPrestamoDataAccessAdditional(AbonoPrestamoDataAccessAdditional abonoprestamoDataAccessAdditional) {
		try {
			this.abonoprestamoDataAccessAdditional=abonoprestamoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public AbonoPrestamoDataAccess() {
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
		AbonoPrestamoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		AbonoPrestamoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		AbonoPrestamoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setAbonoPrestamoOriginal(AbonoPrestamo abonoprestamo)throws Exception  {
		abonoprestamo.setAbonoPrestamoOriginal((AbonoPrestamo)abonoprestamo.clone());		
	}
	
	public void setAbonoPrestamosOriginal(List<AbonoPrestamo> abonoprestamos)throws Exception  {
		
		for(AbonoPrestamo abonoprestamo:abonoprestamos){
			abonoprestamo.setAbonoPrestamoOriginal((AbonoPrestamo)abonoprestamo.clone());
		}
	}
	
	public static void setAbonoPrestamoOriginalStatic(AbonoPrestamo abonoprestamo)throws Exception  {
		abonoprestamo.setAbonoPrestamoOriginal((AbonoPrestamo)abonoprestamo.clone());		
	}
	
	public static void setAbonoPrestamosOriginalStatic(List<AbonoPrestamo> abonoprestamos)throws Exception  {
		
		for(AbonoPrestamo abonoprestamo:abonoprestamos){
			abonoprestamo.setAbonoPrestamoOriginal((AbonoPrestamo)abonoprestamo.clone());
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
	
	public  AbonoPrestamo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		AbonoPrestamo entity = new AbonoPrestamo();		
		
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
	
	public  AbonoPrestamo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		AbonoPrestamo entity = new AbonoPrestamo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.AbonoPrestamo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setAbonoPrestamoOriginal(new AbonoPrestamo());
      	    	entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAbonoPrestamo("",entity,resultSet); 
				
				//entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseAbonoPrestamo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  AbonoPrestamo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AbonoPrestamo entity = new AbonoPrestamo();
				
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
	
	public  AbonoPrestamo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		AbonoPrestamo entity = new AbonoPrestamo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AbonoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AbonoPrestamo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setAbonoPrestamoOriginal(new AbonoPrestamo());
      	    	entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityAbonoPrestamo("",entity,resultSet);    
				
				//entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseAbonoPrestamo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //AbonoPrestamo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		AbonoPrestamo entity = new AbonoPrestamo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AbonoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.AbonoPrestamo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseAbonoPrestamo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<AbonoPrestamo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		
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
	
	public  List<AbonoPrestamo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AbonoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AbonoPrestamo();
      	    	entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAbonoPrestamo("",entity,resultSet);
      	    	
				//entity.setAbonoPrestamoOriginal( new AbonoPrestamo());
      	    	//entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAbonoPrestamos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAbonoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AbonoPrestamo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
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
	
	public  List<AbonoPrestamo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AbonoPrestamo();
				
				if(conMapGenerico) {
					entity.inicializarMapAbonoPrestamo();
					//entity.setMapAbonoPrestamo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapAbonoPrestamoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAbonoPrestamo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         		
					entity=AbonoPrestamoDataAccess.getEntityAbonoPrestamo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAbonoPrestamoOriginal( new AbonoPrestamo());
					////entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
					////entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAbonoPrestamos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAbonoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public AbonoPrestamo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AbonoPrestamo entity = new AbonoPrestamo();		  
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
	
	public  AbonoPrestamo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AbonoPrestamo();
				
				if(conMapGenerico) {
					entity.inicializarMapAbonoPrestamo();
					//entity.setMapAbonoPrestamo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapAbonoPrestamoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapAbonoPrestamo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         		
					entity=AbonoPrestamoDataAccess.getEntityAbonoPrestamo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setAbonoPrestamoOriginal( new AbonoPrestamo());
					////entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
					////entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseAbonoPrestamo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAbonoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static AbonoPrestamo getEntityAbonoPrestamo(String strPrefijo,AbonoPrestamo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = AbonoPrestamo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = AbonoPrestamo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					AbonoPrestamoDataAccess.setFieldReflectionAbonoPrestamo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasAbonoPrestamo=AbonoPrestamoConstantesFunciones.getTodosTiposColumnasAbonoPrestamo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasAbonoPrestamo) {
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
							field = AbonoPrestamo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = AbonoPrestamo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						AbonoPrestamoDataAccess.setFieldReflectionAbonoPrestamo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionAbonoPrestamo(Field field,String strPrefijo,String sColumn,AbonoPrestamo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case AbonoPrestamoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.IDPRESTAMO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.MONTOCAPITAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.MONTOINTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case AbonoPrestamoConstantesFunciones.CODIGOQUINCENA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AbonoPrestamo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AbonoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new AbonoPrestamo();
					entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityAbonoPrestamo("",entity,resultSet);
					
					//entity.setAbonoPrestamoOriginal( new AbonoPrestamo());
					//entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
					//entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseAbonoPrestamos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAbonoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<AbonoPrestamo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=AbonoPrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,AbonoPrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<AbonoPrestamo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
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
	
	public  List<AbonoPrestamo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AbonoPrestamo();
      	    	entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAbonoPrestamo("",entity,resultSet);
      	    	
				//entity.setAbonoPrestamoOriginal( new AbonoPrestamo());
      	    	//entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseAbonoPrestamos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarAbonoPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<AbonoPrestamo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
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
	
	public  List<AbonoPrestamo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<AbonoPrestamo> entities = new  ArrayList<AbonoPrestamo>();
		AbonoPrestamo entity = new AbonoPrestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new AbonoPrestamo();
      	    	entity=super.getEntity("",entity,resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityAbonoPrestamo("",entity,resultSet);
      	    	
				//entity.setAbonoPrestamoOriginal( new AbonoPrestamo());
      	    	//entity.setAbonoPrestamoOriginal(super.getEntity("",entity.getAbonoPrestamoOriginal(),resultSet,AbonoPrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setAbonoPrestamoOriginal(this.getEntityAbonoPrestamo("",entity.getAbonoPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseAbonoPrestamos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public AbonoPrestamo getEntityAbonoPrestamo(String strPrefijo,AbonoPrestamo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_prestamo(resultSet.getLong(strPrefijo+AbonoPrestamoConstantesFunciones.IDPRESTAMO));
				entity.setnumero(resultSet.getInt(strPrefijo+AbonoPrestamoConstantesFunciones.NUMERO));
				entity.setmonto_capital(resultSet.getDouble(strPrefijo+AbonoPrestamoConstantesFunciones.MONTOCAPITAL));
				entity.setmonto_interes(resultSet.getDouble(strPrefijo+AbonoPrestamoConstantesFunciones.MONTOINTERES));
				entity.setvalor(resultSet.getDouble(strPrefijo+AbonoPrestamoConstantesFunciones.VALOR));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setcodigo_quincena(resultSet.getString(strPrefijo+AbonoPrestamoConstantesFunciones.CODIGOQUINCENA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowAbonoPrestamo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(AbonoPrestamo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=AbonoPrestamoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=AbonoPrestamoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=AbonoPrestamoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=AbonoPrestamoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(AbonoPrestamoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,AbonoPrestamoDataAccess.TABLENAME,AbonoPrestamoDataAccess.ISWITHSTOREPROCEDURES);
			
			AbonoPrestamoDataAccess.setAbonoPrestamoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Prestamo getPrestamo(Connexion connexion,AbonoPrestamo relabonoprestamo)throws SQLException,Exception {

		Prestamo prestamo= new Prestamo();

		try {
			PrestamoDataAccess prestamoDataAccess=new PrestamoDataAccess();

			prestamoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			prestamoDataAccess.setConnexionType(this.connexionType);
			prestamoDataAccess.setParameterDbType(this.parameterDbType);

			prestamo=prestamoDataAccess.getEntity(connexion,relabonoprestamo.getid_prestamo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return prestamo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,AbonoPrestamo abonoprestamo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!abonoprestamo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_prestamo=new ParameterValue<Long>();
					parameterMaintenanceValueid_prestamo.setValue(abonoprestamo.getid_prestamo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_prestamo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero.setValue(abonoprestamo.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_capital=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_capital.setValue(abonoprestamo.getmonto_capital());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_capital);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_interes=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_interes.setValue(abonoprestamo.getmonto_interes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_interes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(abonoprestamo.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(abonoprestamo.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_quincena=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_quincena.setValue(abonoprestamo.getcodigo_quincena());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_quincena);
					parametersTemp.add(parameterMaintenance);
					
						if(!abonoprestamo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(abonoprestamo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(abonoprestamo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(abonoprestamo.getId());
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
	
	public void setIsNewIsChangedFalseAbonoPrestamo(AbonoPrestamo abonoprestamo)throws Exception  {		
		abonoprestamo.setIsNew(false);
		abonoprestamo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseAbonoPrestamos(List<AbonoPrestamo> abonoprestamos)throws Exception  {				
		for(AbonoPrestamo abonoprestamo:abonoprestamos) {
			abonoprestamo.setIsNew(false);
			abonoprestamo.setIsChanged(false);
		}
	}
	
	public void generarExportarAbonoPrestamo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
