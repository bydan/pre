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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//PresupuestoVentasConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class PresupuestoVentasDataAccess extends  PresupuestoVentasDataAccessAdditional{ //PresupuestoVentasDataAccessAdditional,DataAccessHelper<PresupuestoVentas>
	//static Logger logger = Logger.getLogger(PresupuestoVentasDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presupuesto_ventas";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_vendedor,id_pais,id_ciudad,id_zona,id_producto,precio,cantidad,valor,porcentaje,cantidad_total,valor_total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_vendedor=?,id_pais=?,id_ciudad=?,id_zona=?,id_producto=?,precio=?,cantidad=?,valor=?,porcentaje=?,cantidad_total=?,valor_total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presupuestoventas from "+PresupuestoVentasConstantesFunciones.SPERSISTENCENAME+" presupuestoventas";
	public static String QUERYSELECTNATIVE="select "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".version_row,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_vendedor,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_pais,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_ciudad,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_zona,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id_producto,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".precio,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".cantidad,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".valor,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".cantidad_total,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".valor_total from "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+".version_row from "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresupuestoVentasConstantesFunciones.SCHEMA+"."+PresupuestoVentasConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_vendedor=?,id_pais=?,id_ciudad=?,id_zona=?,id_producto=?,precio=?,cantidad=?,valor=?,porcentaje=?,cantidad_total=?,valor_total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPUESTOVENTAS_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPUESTOVENTAS_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPUESTOVENTAS_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPUESTOVENTAS_SELECT(?,?)";
	
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
	
	
	protected PresupuestoVentasDataAccessAdditional presupuestoventasDataAccessAdditional=null;
	
	public PresupuestoVentasDataAccessAdditional getPresupuestoVentasDataAccessAdditional() {
		return this.presupuestoventasDataAccessAdditional;
	}
	
	public void setPresupuestoVentasDataAccessAdditional(PresupuestoVentasDataAccessAdditional presupuestoventasDataAccessAdditional) {
		try {
			this.presupuestoventasDataAccessAdditional=presupuestoventasDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresupuestoVentasDataAccess() {
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
		PresupuestoVentasDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresupuestoVentasDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresupuestoVentasDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresupuestoVentasOriginal(PresupuestoVentas presupuestoventas)throws Exception  {
		presupuestoventas.setPresupuestoVentasOriginal((PresupuestoVentas)presupuestoventas.clone());		
	}
	
	public void setPresupuestoVentassOriginal(List<PresupuestoVentas> presupuestoventass)throws Exception  {
		
		for(PresupuestoVentas presupuestoventas:presupuestoventass){
			presupuestoventas.setPresupuestoVentasOriginal((PresupuestoVentas)presupuestoventas.clone());
		}
	}
	
	public static void setPresupuestoVentasOriginalStatic(PresupuestoVentas presupuestoventas)throws Exception  {
		presupuestoventas.setPresupuestoVentasOriginal((PresupuestoVentas)presupuestoventas.clone());		
	}
	
	public static void setPresupuestoVentassOriginalStatic(List<PresupuestoVentas> presupuestoventass)throws Exception  {
		
		for(PresupuestoVentas presupuestoventas:presupuestoventass){
			presupuestoventas.setPresupuestoVentasOriginal((PresupuestoVentas)presupuestoventas.clone());
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
	
	public  PresupuestoVentas getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoVentas entity = new PresupuestoVentas();		
		
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
	
	public  PresupuestoVentas getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoVentas entity = new PresupuestoVentas();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.PresupuestoVentas.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresupuestoVentasOriginal(new PresupuestoVentas());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoVentas("",entity,resultSet); 
				
				//entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoVentas(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresupuestoVentas getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoVentas entity = new PresupuestoVentas();
				
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
	
	public  PresupuestoVentas getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoVentas entity = new PresupuestoVentas();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PresupuestoVentas.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresupuestoVentasOriginal(new PresupuestoVentas());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoVentas("",entity,resultSet);    
				
				//entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoVentas(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresupuestoVentas
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresupuestoVentas entity = new PresupuestoVentas();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PresupuestoVentas.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresupuestoVentas(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresupuestoVentas> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		
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
	
	public  List<PresupuestoVentas> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentas();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentas("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasOriginal( new PresupuestoVentas());
      	    	//entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentass(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentas(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoVentas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
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
	
	public  List<PresupuestoVentas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentas();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoVentas();
					//entity.setMapPresupuestoVentas(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresupuestoVentasValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoVentas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoVentasDataAccess.getEntityPresupuestoVentas("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoVentasOriginal( new PresupuestoVentas());
					////entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentass(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentas(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresupuestoVentas getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoVentas entity = new PresupuestoVentas();		  
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
	
	public  PresupuestoVentas getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentas();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoVentas();
					//entity.setMapPresupuestoVentas(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresupuestoVentasValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoVentas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoVentasDataAccess.getEntityPresupuestoVentas("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoVentasOriginal( new PresupuestoVentas());
					////entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentas(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentas(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresupuestoVentas getEntityPresupuestoVentas(String strPrefijo,PresupuestoVentas entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresupuestoVentas.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresupuestoVentas.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresupuestoVentasDataAccess.setFieldReflectionPresupuestoVentas(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresupuestoVentas=PresupuestoVentasConstantesFunciones.getTodosTiposColumnasPresupuestoVentas();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresupuestoVentas) {
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
							field = PresupuestoVentas.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresupuestoVentas.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresupuestoVentasDataAccess.setFieldReflectionPresupuestoVentas(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresupuestoVentas(Field field,String strPrefijo,String sColumn,PresupuestoVentas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresupuestoVentasConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.CANTIDADTOTAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresupuestoVentasConstantesFunciones.VALORTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoVentas>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresupuestoVentas();
					entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresupuestoVentas("",entity,resultSet);
					
					//entity.setPresupuestoVentasOriginal( new PresupuestoVentas());
					//entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
					//entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresupuestoVentass(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentas(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoVentas>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresupuestoVentas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
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
	
	public  List<PresupuestoVentas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentas();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentas("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasOriginal( new PresupuestoVentas());
      	    	//entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresupuestoVentass(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentas(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoVentas> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
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
	
	public  List<PresupuestoVentas> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentas> entities = new  ArrayList<PresupuestoVentas>();
		PresupuestoVentas entity = new PresupuestoVentas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentas();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentas("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasOriginal( new PresupuestoVentas());
      	    	//entity.setPresupuestoVentasOriginal(super.getEntity("",entity.getPresupuestoVentasOriginal(),resultSet,PresupuestoVentasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasOriginal(this.getEntityPresupuestoVentas("",entity.getPresupuestoVentasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentass(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresupuestoVentas getEntityPresupuestoVentas(String strPrefijo,PresupuestoVentas entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDPERIODO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDVENDEDOR));
				entity.setid_pais(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDZONA));if(resultSet.wasNull()) {entity.setid_zona(null); }
				entity.setid_producto(resultSet.getLong(strPrefijo+PresupuestoVentasConstantesFunciones.IDPRODUCTO));
				entity.setprecio(resultSet.getDouble(strPrefijo+PresupuestoVentasConstantesFunciones.PRECIO));
				entity.setcantidad(resultSet.getInt(strPrefijo+PresupuestoVentasConstantesFunciones.CANTIDAD));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresupuestoVentasConstantesFunciones.VALOR));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+PresupuestoVentasConstantesFunciones.PORCENTAJE));
				entity.setcantidad_total(resultSet.getInt(strPrefijo+PresupuestoVentasConstantesFunciones.CANTIDADTOTAL));
				entity.setvalor_total(resultSet.getDouble(strPrefijo+PresupuestoVentasConstantesFunciones.VALORTOTAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresupuestoVentas(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresupuestoVentas entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresupuestoVentasDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresupuestoVentasDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresupuestoVentasDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresupuestoVentasDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresupuestoVentasConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresupuestoVentasDataAccess.TABLENAME,PresupuestoVentasDataAccess.ISWITHSTOREPROCEDURES);
			
			PresupuestoVentasDataAccess.setPresupuestoVentasOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresupuestoventas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpresupuestoventas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpresupuestoventas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpresupuestoventas.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Vendedor getVendedor(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relpresupuestoventas.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Pais getPais(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relpresupuestoventas.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relpresupuestoventas.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relpresupuestoventas.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public Producto getProducto(Connexion connexion,PresupuestoVentas relpresupuestoventas)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relpresupuestoventas.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresupuestoVentas presupuestoventas) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presupuestoventas.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presupuestoventas.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(presupuestoventas.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(presupuestoventas.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(presupuestoventas.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(presupuestoventas.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(presupuestoventas.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(presupuestoventas.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(presupuestoventas.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(presupuestoventas.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(presupuestoventas.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(presupuestoventas.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presupuestoventas.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(presupuestoventas.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_total=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_total.setValue(presupuestoventas.getcantidad_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_total=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_total.setValue(presupuestoventas.getvalor_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_total);
					parametersTemp.add(parameterMaintenance);
					
						if(!presupuestoventas.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presupuestoventas.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presupuestoventas.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presupuestoventas.getId());
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
	
	public void setIsNewIsChangedFalsePresupuestoVentas(PresupuestoVentas presupuestoventas)throws Exception  {		
		presupuestoventas.setIsNew(false);
		presupuestoventas.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresupuestoVentass(List<PresupuestoVentas> presupuestoventass)throws Exception  {				
		for(PresupuestoVentas presupuestoventas:presupuestoventass) {
			presupuestoventas.setIsNew(false);
			presupuestoventas.setIsChanged(false);
		}
	}
	
	public void generarExportarPresupuestoVentas(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
