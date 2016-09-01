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
import com.bydan.erp.nomina.util.*;//PrestamoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class PrestamoDataAccess extends  PrestamoDataAccessAdditional{ //PrestamoDataAccessAdditional,DataAccessHelper<Prestamo>
	//static Logger logger = Logger.getLogger(PrestamoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="prestamo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_tipo_prestamo,id_tipo_cuota,id_asiento_contable,codigo,numero_pre_impreso,fecha,monto,numero_cuotas,tasa,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_prestamo=?,id_tipo_cuota=?,id_asiento_contable=?,codigo=?,numero_pre_impreso=?,fecha=?,monto=?,numero_cuotas=?,tasa=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select prestamo from "+PrestamoConstantesFunciones.SPERSISTENCENAME+" prestamo";
	public static String QUERYSELECTNATIVE="select "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".version_row,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_empresa,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_empleado,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_tipo_prestamo,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_tipo_cuota,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id_asiento_contable,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".codigo,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".numero_pre_impreso,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".fecha,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".monto,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".numero_cuotas,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".tasa,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".descripcion from "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME;//+" as "+PrestamoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".id,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".version_row,"+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+".codigo from "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME;//+" as "+PrestamoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PrestamoConstantesFunciones.SCHEMA+"."+PrestamoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_prestamo=?,id_tipo_cuota=?,id_asiento_contable=?,codigo=?,numero_pre_impreso=?,fecha=?,monto=?,numero_cuotas=?,tasa=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESTAMO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESTAMO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESTAMO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESTAMO_SELECT(?,?)";
	
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
	
	
	protected PrestamoDataAccessAdditional prestamoDataAccessAdditional=null;
	
	public PrestamoDataAccessAdditional getPrestamoDataAccessAdditional() {
		return this.prestamoDataAccessAdditional;
	}
	
	public void setPrestamoDataAccessAdditional(PrestamoDataAccessAdditional prestamoDataAccessAdditional) {
		try {
			this.prestamoDataAccessAdditional=prestamoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PrestamoDataAccess() {
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
		PrestamoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PrestamoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PrestamoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPrestamoOriginal(Prestamo prestamo)throws Exception  {
		prestamo.setPrestamoOriginal((Prestamo)prestamo.clone());		
	}
	
	public void setPrestamosOriginal(List<Prestamo> prestamos)throws Exception  {
		
		for(Prestamo prestamo:prestamos){
			prestamo.setPrestamoOriginal((Prestamo)prestamo.clone());
		}
	}
	
	public static void setPrestamoOriginalStatic(Prestamo prestamo)throws Exception  {
		prestamo.setPrestamoOriginal((Prestamo)prestamo.clone());		
	}
	
	public static void setPrestamosOriginalStatic(List<Prestamo> prestamos)throws Exception  {
		
		for(Prestamo prestamo:prestamos){
			prestamo.setPrestamoOriginal((Prestamo)prestamo.clone());
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
	
	public  Prestamo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Prestamo entity = new Prestamo();		
		
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
	
	public  Prestamo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Prestamo entity = new Prestamo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.Prestamo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPrestamoOriginal(new Prestamo());
      	    	entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPrestamo("",entity,resultSet); 
				
				//entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePrestamo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Prestamo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Prestamo entity = new Prestamo();
				
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
	
	public  Prestamo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Prestamo entity = new Prestamo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Prestamo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPrestamoOriginal(new Prestamo());
      	    	entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPrestamo("",entity,resultSet);    
				
				//entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePrestamo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Prestamo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Prestamo entity = new Prestamo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.Prestamo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePrestamo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Prestamo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		
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
	
	public  List<Prestamo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Prestamo();
      	    	entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrestamo("",entity,resultSet);
      	    	
				//entity.setPrestamoOriginal( new Prestamo());
      	    	//entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrestamos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Prestamo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
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
	
	public  List<Prestamo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Prestamo();
				
				if(conMapGenerico) {
					entity.inicializarMapPrestamo();
					//entity.setMapPrestamo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPrestamoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPrestamo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         		
					entity=PrestamoDataAccess.getEntityPrestamo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPrestamoOriginal( new Prestamo());
					////entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
					////entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrestamos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Prestamo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Prestamo entity = new Prestamo();		  
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
	
	public  Prestamo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Prestamo entity = new Prestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Prestamo();
				
				if(conMapGenerico) {
					entity.inicializarMapPrestamo();
					//entity.setMapPrestamo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPrestamoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPrestamo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         		
					entity=PrestamoDataAccess.getEntityPrestamo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPrestamoOriginal( new Prestamo());
					////entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
					////entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePrestamo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Prestamo getEntityPrestamo(String strPrefijo,Prestamo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Prestamo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Prestamo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PrestamoDataAccess.setFieldReflectionPrestamo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPrestamo=PrestamoConstantesFunciones.getTodosTiposColumnasPrestamo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPrestamo) {
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
							field = Prestamo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Prestamo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PrestamoDataAccess.setFieldReflectionPrestamo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPrestamo(Field field,String strPrefijo,String sColumn,Prestamo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PrestamoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrestamoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PrestamoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrestamoConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrestamoConstantesFunciones.IDTIPOPRESTAMO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrestamoConstantesFunciones.IDTIPOCUOTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrestamoConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PrestamoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PrestamoConstantesFunciones.NUMEROPREIMPRESO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PrestamoConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PrestamoConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PrestamoConstantesFunciones.NUMEROCUOTAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PrestamoConstantesFunciones.TASA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PrestamoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Prestamo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Prestamo();
					entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPrestamo("",entity,resultSet);
					
					//entity.setPrestamoOriginal( new Prestamo());
					//entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
					//entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePrestamos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Prestamo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PrestamoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PrestamoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Prestamo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
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
	
	public  List<Prestamo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Prestamo();
      	    	entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrestamo("",entity,resultSet);
      	    	
				//entity.setPrestamoOriginal( new Prestamo());
      	    	//entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePrestamos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPrestamo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Prestamo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
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
	
	public  List<Prestamo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Prestamo> entities = new  ArrayList<Prestamo>();
		Prestamo entity = new Prestamo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Prestamo();
      	    	entity=super.getEntity("",entity,resultSet,PrestamoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPrestamo("",entity,resultSet);
      	    	
				//entity.setPrestamoOriginal( new Prestamo());
      	    	//entity.setPrestamoOriginal(super.getEntity("",entity.getPrestamoOriginal(),resultSet,PrestamoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPrestamoOriginal(this.getEntityPrestamo("",entity.getPrestamoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePrestamos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Prestamo getEntityPrestamo(String strPrefijo,Prestamo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PrestamoConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PrestamoConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_prestamo(resultSet.getLong(strPrefijo+PrestamoConstantesFunciones.IDTIPOPRESTAMO));
				entity.setid_tipo_cuota(resultSet.getLong(strPrefijo+PrestamoConstantesFunciones.IDTIPOCUOTA));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+PrestamoConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setcodigo(resultSet.getString(strPrefijo+PrestamoConstantesFunciones.CODIGO));
				entity.setnumero_pre_impreso(resultSet.getString(strPrefijo+PrestamoConstantesFunciones.NUMEROPREIMPRESO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PrestamoConstantesFunciones.FECHA).getTime()));
				entity.setmonto(resultSet.getDouble(strPrefijo+PrestamoConstantesFunciones.MONTO));
				entity.setnumero_cuotas(resultSet.getInt(strPrefijo+PrestamoConstantesFunciones.NUMEROCUOTAS));
				entity.settasa(resultSet.getDouble(strPrefijo+PrestamoConstantesFunciones.TASA));
				entity.setdescripcion(resultSet.getString(strPrefijo+PrestamoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+PrestamoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPrestamo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Prestamo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PrestamoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PrestamoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PrestamoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PrestamoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PrestamoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PrestamoDataAccess.TABLENAME,PrestamoDataAccess.ISWITHSTOREPROCEDURES);
			
			PrestamoDataAccess.setPrestamoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Prestamo relprestamo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relprestamo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,Prestamo relprestamo)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relprestamo.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoPrestamo getTipoPrestamo(Connexion connexion,Prestamo relprestamo)throws SQLException,Exception {

		TipoPrestamo tipoprestamo= new TipoPrestamo();

		try {
			TipoPrestamoDataAccess tipoprestamoDataAccess=new TipoPrestamoDataAccess();

			tipoprestamoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprestamoDataAccess.setConnexionType(this.connexionType);
			tipoprestamoDataAccess.setParameterDbType(this.parameterDbType);

			tipoprestamo=tipoprestamoDataAccess.getEntity(connexion,relprestamo.getid_tipo_prestamo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprestamo;

	}

	public TipoCuota getTipoCuota(Connexion connexion,Prestamo relprestamo)throws SQLException,Exception {

		TipoCuota tipocuota= new TipoCuota();

		try {
			TipoCuotaDataAccess tipocuotaDataAccess=new TipoCuotaDataAccess();

			tipocuotaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuotaDataAccess.setConnexionType(this.connexionType);
			tipocuotaDataAccess.setParameterDbType(this.parameterDbType);

			tipocuota=tipocuotaDataAccess.getEntity(connexion,relprestamo.getid_tipo_cuota());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuota;

	}

	public AsientoContable getAsientoContable(Connexion connexion,Prestamo relprestamo)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relprestamo.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}


		
		public List<AbonoPrestamo> getAbonoPrestamos(Connexion connexion,Prestamo prestamo)throws SQLException,Exception {

		List<AbonoPrestamo> abonoprestamos= new ArrayList<AbonoPrestamo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PrestamoConstantesFunciones.SCHEMA+".prestamo ON "+AbonoPrestamoConstantesFunciones.SCHEMA+".abono_prestamo.id_prestamo="+PrestamoConstantesFunciones.SCHEMA+".prestamo.id WHERE "+PrestamoConstantesFunciones.SCHEMA+".prestamo.id="+String.valueOf(prestamo.getId());
			} else {
				sQuery=" INNER JOIN abonoprestamo.Prestamo WHERE abonoprestamo.Prestamo.id="+String.valueOf(prestamo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AbonoPrestamoDataAccess abonoprestamoDataAccess=new AbonoPrestamoDataAccess();

			abonoprestamoDataAccess.setConnexionType(this.connexionType);
			abonoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return abonoprestamos;

	}

	public List<Cuota> getCuotas(Connexion connexion,Prestamo prestamo)throws SQLException,Exception {

		List<Cuota> cuotas= new ArrayList<Cuota>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PrestamoConstantesFunciones.SCHEMA+".prestamo ON "+CuotaConstantesFunciones.SCHEMA+".cuota.id_prestamo="+PrestamoConstantesFunciones.SCHEMA+".prestamo.id WHERE "+PrestamoConstantesFunciones.SCHEMA+".prestamo.id="+String.valueOf(prestamo.getId());
			} else {
				sQuery=" INNER JOIN cuota.Prestamo WHERE cuota.Prestamo.id="+String.valueOf(prestamo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuotaDataAccess cuotaDataAccess=new CuotaDataAccess();

			cuotaDataAccess.setConnexionType(this.connexionType);
			cuotaDataAccess.setParameterDbType(this.parameterDbType);
			cuotas=cuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuotas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Prestamo prestamo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!prestamo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(prestamo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(prestamo.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_prestamo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_prestamo.setValue(prestamo.getid_tipo_prestamo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_prestamo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuota=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuota.setValue(prestamo.getid_tipo_cuota());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuota);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(prestamo.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(prestamo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_pre_impreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_pre_impreso.setValue(prestamo.getnumero_pre_impreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_pre_impreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(prestamo.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto=new ParameterValue<Double>();
					parameterMaintenanceValuemonto.setValue(prestamo.getmonto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cuotas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cuotas.setValue(prestamo.getnumero_cuotas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuotas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetasa=new ParameterValue<Double>();
					parameterMaintenanceValuetasa.setValue(prestamo.gettasa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetasa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(prestamo.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!prestamo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(prestamo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(prestamo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(prestamo.getId());
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
	
	public void setIsNewIsChangedFalsePrestamo(Prestamo prestamo)throws Exception  {		
		prestamo.setIsNew(false);
		prestamo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePrestamos(List<Prestamo> prestamos)throws Exception  {				
		for(Prestamo prestamo:prestamos) {
			prestamo.setIsNew(false);
			prestamo.setIsChanged(false);
		}
	}
	
	public void generarExportarPrestamo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
