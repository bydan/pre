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
import com.bydan.erp.facturacion.util.*;//PresupuestoVentasLineasConstantesFunciones;


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
final public class PresupuestoVentasLineasDataAccess extends  PresupuestoVentasLineasDataAccessAdditional{ //PresupuestoVentasLineasDataAccessAdditional,DataAccessHelper<PresupuestoVentasLineas>
	//static Logger logger = Logger.getLogger(PresupuestoVentasLineasDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presupuesto_ventas_lineas";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_vendedor,id_pais,id_ciudad,id_zona,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,precio,cantidad,valor,porcentaje,cantidad_total,valor_total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_vendedor=?,id_pais=?,id_ciudad=?,id_zona=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,precio=?,cantidad=?,valor=?,porcentaje=?,cantidad_total=?,valor_total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presupuestoventaslineas from "+PresupuestoVentasLineasConstantesFunciones.SPERSISTENCENAME+" presupuestoventaslineas";
	public static String QUERYSELECTNATIVE="select "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".version_row,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_vendedor,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_pais,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_ciudad,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_zona,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea_grupo,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea_categoria,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id_linea_marca,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".precio,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".cantidad,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".valor,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".cantidad_total,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".valor_total from "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasLineasConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+".version_row from "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasLineasConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+"."+PresupuestoVentasLineasConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_vendedor=?,id_pais=?,id_ciudad=?,id_zona=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,precio=?,cantidad=?,valor=?,porcentaje=?,cantidad_total=?,valor_total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPUESTOVENTASLINEAS_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPUESTOVENTASLINEAS_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPUESTOVENTASLINEAS_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPUESTOVENTASLINEAS_SELECT(?,?)";
	
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
	
	
	protected PresupuestoVentasLineasDataAccessAdditional presupuestoventaslineasDataAccessAdditional=null;
	
	public PresupuestoVentasLineasDataAccessAdditional getPresupuestoVentasLineasDataAccessAdditional() {
		return this.presupuestoventaslineasDataAccessAdditional;
	}
	
	public void setPresupuestoVentasLineasDataAccessAdditional(PresupuestoVentasLineasDataAccessAdditional presupuestoventaslineasDataAccessAdditional) {
		try {
			this.presupuestoventaslineasDataAccessAdditional=presupuestoventaslineasDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresupuestoVentasLineasDataAccess() {
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
		PresupuestoVentasLineasDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresupuestoVentasLineasDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresupuestoVentasLineasDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPresupuestoVentasLineasOriginal(PresupuestoVentasLineas presupuestoventaslineas)throws Exception  {
		presupuestoventaslineas.setPresupuestoVentasLineasOriginal((PresupuestoVentasLineas)presupuestoventaslineas.clone());		
	}
	
	public void setPresupuestoVentasLineassOriginal(List<PresupuestoVentasLineas> presupuestoventaslineass)throws Exception  {
		
		for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass){
			presupuestoventaslineas.setPresupuestoVentasLineasOriginal((PresupuestoVentasLineas)presupuestoventaslineas.clone());
		}
	}
	
	public static void setPresupuestoVentasLineasOriginalStatic(PresupuestoVentasLineas presupuestoventaslineas)throws Exception  {
		presupuestoventaslineas.setPresupuestoVentasLineasOriginal((PresupuestoVentasLineas)presupuestoventaslineas.clone());		
	}
	
	public static void setPresupuestoVentasLineassOriginalStatic(List<PresupuestoVentasLineas> presupuestoventaslineass)throws Exception  {
		
		for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass){
			presupuestoventaslineas.setPresupuestoVentasLineasOriginal((PresupuestoVentasLineas)presupuestoventaslineas.clone());
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
	
	public  PresupuestoVentasLineas getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		
		
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
	
	public  PresupuestoVentasLineas getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.PresupuestoVentasLineas.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresupuestoVentasLineasOriginal(new PresupuestoVentasLineas());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoVentasLineas("",entity,resultSet); 
				
				//entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoVentasLineas(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresupuestoVentasLineas getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();
				
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
	
	public  PresupuestoVentasLineas getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasLineasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PresupuestoVentasLineas.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresupuestoVentasLineasOriginal(new PresupuestoVentasLineas());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoVentasLineas("",entity,resultSet);    
				
				//entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoVentasLineas(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresupuestoVentasLineas
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasLineasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PresupuestoVentasLineas.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePresupuestoVentasLineas(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresupuestoVentasLineas> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		
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
	
	public  List<PresupuestoVentasLineas> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasLineasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasLineas();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentasLineas("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasLineasOriginal( new PresupuestoVentasLineas());
      	    	//entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasLineass(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasLineas(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoVentasLineas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
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
	
	public  List<PresupuestoVentasLineas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasLineas();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoVentasLineas();
					//entity.setMapPresupuestoVentasLineas(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresupuestoVentasLineasValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoVentasLineas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoVentasLineasDataAccess.getEntityPresupuestoVentasLineas("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoVentasLineasOriginal( new PresupuestoVentasLineas());
					////entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasLineass(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasLineas(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresupuestoVentasLineas getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
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
	
	public  PresupuestoVentasLineas getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasLineas();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoVentasLineas();
					//entity.setMapPresupuestoVentasLineas(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresupuestoVentasLineasValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoVentasLineas().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoVentasLineasDataAccess.getEntityPresupuestoVentasLineas("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoVentasLineasOriginal( new PresupuestoVentasLineas());
					////entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasLineas(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasLineas(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresupuestoVentasLineas getEntityPresupuestoVentasLineas(String strPrefijo,PresupuestoVentasLineas entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresupuestoVentasLineas.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresupuestoVentasLineas.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresupuestoVentasLineasDataAccess.setFieldReflectionPresupuestoVentasLineas(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresupuestoVentasLineas=PresupuestoVentasLineasConstantesFunciones.getTodosTiposColumnasPresupuestoVentasLineas();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresupuestoVentasLineas) {
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
							field = PresupuestoVentasLineas.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresupuestoVentasLineas.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresupuestoVentasLineasDataAccess.setFieldReflectionPresupuestoVentasLineas(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresupuestoVentasLineas(Field field,String strPrefijo,String sColumn,PresupuestoVentasLineas entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresupuestoVentasLineasConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresupuestoVentasLineasConstantesFunciones.VALORTOTAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoVentasLineas>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasLineasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PresupuestoVentasLineas();
					entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresupuestoVentasLineas("",entity,resultSet);
					
					//entity.setPresupuestoVentasLineasOriginal( new PresupuestoVentasLineas());
					//entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
					//entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresupuestoVentasLineass(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasLineas(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoVentasLineas>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasLineasDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasLineasDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PresupuestoVentasLineas> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
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
	
	public  List<PresupuestoVentasLineas> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasLineas();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentasLineas("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasLineasOriginal( new PresupuestoVentasLineas());
      	    	//entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresupuestoVentasLineass(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasLineas(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoVentasLineas> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
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
	
	public  List<PresupuestoVentasLineas> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasLineas> entities = new  ArrayList<PresupuestoVentasLineas>();
		PresupuestoVentasLineas entity = new PresupuestoVentasLineas();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasLineas();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentasLineas("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasLineasOriginal( new PresupuestoVentasLineas());
      	    	//entity.setPresupuestoVentasLineasOriginal(super.getEntity("",entity.getPresupuestoVentasLineasOriginal(),resultSet,PresupuestoVentasLineasDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasLineasOriginal(this.getEntityPresupuestoVentasLineas("",entity.getPresupuestoVentasLineasOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasLineass(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresupuestoVentasLineas getEntityPresupuestoVentasLineas(String strPrefijo,PresupuestoVentasLineas entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDPERIODO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDVENDEDOR));
				entity.setid_pais(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDZONA));if(resultSet.wasNull()) {entity.setid_zona(null); }
				entity.setid_linea(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDLINEAGRUPO));if(resultSet.wasNull()) {entity.setid_linea_grupo(null); }
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDLINEACATEGORIA));if(resultSet.wasNull()) {entity.setid_linea_categoria(null); }
				entity.setid_linea_marca(resultSet.getLong(strPrefijo+PresupuestoVentasLineasConstantesFunciones.IDLINEAMARCA));if(resultSet.wasNull()) {entity.setid_linea_marca(null); }
				entity.setprecio(resultSet.getDouble(strPrefijo+PresupuestoVentasLineasConstantesFunciones.PRECIO));
				entity.setcantidad(resultSet.getInt(strPrefijo+PresupuestoVentasLineasConstantesFunciones.CANTIDAD));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresupuestoVentasLineasConstantesFunciones.VALOR));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+PresupuestoVentasLineasConstantesFunciones.PORCENTAJE));
				entity.setcantidad_total(resultSet.getInt(strPrefijo+PresupuestoVentasLineasConstantesFunciones.CANTIDADTOTAL));
				entity.setvalor_total(resultSet.getDouble(strPrefijo+PresupuestoVentasLineasConstantesFunciones.VALORTOTAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresupuestoVentasLineas(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresupuestoVentasLineas entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresupuestoVentasLineasDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresupuestoVentasLineasDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresupuestoVentasLineasDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresupuestoVentasLineasDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresupuestoVentasLineasConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresupuestoVentasLineasDataAccess.TABLENAME,PresupuestoVentasLineasDataAccess.ISWITHSTOREPROCEDURES);
			
			PresupuestoVentasLineasDataAccess.setPresupuestoVentasLineasOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Vendedor getVendedor(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Pais getPais(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}

	public Linea getLinea(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,PresupuestoVentasLineas relpresupuestoventaslineas)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relpresupuestoventaslineas.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresupuestoVentasLineas presupuestoventaslineas) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presupuestoventaslineas.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presupuestoventaslineas.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(presupuestoventaslineas.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(presupuestoventaslineas.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(presupuestoventaslineas.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(presupuestoventaslineas.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(presupuestoventaslineas.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(presupuestoventaslineas.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(presupuestoventaslineas.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(presupuestoventaslineas.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(presupuestoventaslineas.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(presupuestoventaslineas.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_marca=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_marca.setValue(presupuestoventaslineas.getid_linea_marca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_marca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(presupuestoventaslineas.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(presupuestoventaslineas.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presupuestoventaslineas.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(presupuestoventaslineas.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_total=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_total.setValue(presupuestoventaslineas.getcantidad_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_total=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_total.setValue(presupuestoventaslineas.getvalor_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_total);
					parametersTemp.add(parameterMaintenance);
					
						if(!presupuestoventaslineas.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presupuestoventaslineas.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presupuestoventaslineas.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presupuestoventaslineas.getId());
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
	
	public void setIsNewIsChangedFalsePresupuestoVentasLineas(PresupuestoVentasLineas presupuestoventaslineas)throws Exception  {		
		presupuestoventaslineas.setIsNew(false);
		presupuestoventaslineas.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresupuestoVentasLineass(List<PresupuestoVentasLineas> presupuestoventaslineass)throws Exception  {				
		for(PresupuestoVentasLineas presupuestoventaslineas:presupuestoventaslineass) {
			presupuestoventaslineas.setIsNew(false);
			presupuestoventaslineas.setIsChanged(false);
		}
	}
	
	public void generarExportarPresupuestoVentasLineas(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
