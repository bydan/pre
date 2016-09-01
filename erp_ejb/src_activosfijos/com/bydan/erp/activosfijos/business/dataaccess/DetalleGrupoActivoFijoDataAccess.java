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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//DetalleGrupoActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class DetalleGrupoActivoFijoDataAccess extends  DetalleGrupoActivoFijoDataAccessAdditional{ //DetalleGrupoActivoFijoDataAccessAdditional,DataAccessHelper<DetalleGrupoActivoFijo>
	//static Logger logger = Logger.getLogger(DetalleGrupoActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_grupo_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,siglas,id_cuenta_contable_costo_original,id_cuenta_contable_depre_normal,id_cuenta_contable_depre_gasto_normal)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,siglas=?,id_cuenta_contable_costo_original=?,id_cuenta_contable_depre_normal=?,id_cuenta_contable_depre_gasto_normal=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detallegrupoactivofijo from "+DetalleGrupoActivoFijoConstantesFunciones.SPERSISTENCENAME+" detallegrupoactivofijo";
	public static String QUERYSELECTNATIVE="select "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".codigo,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".nombre,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".siglas,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_original,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_cuenta_contable_depre_normal,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_cuenta_contable_depre_gasto_normal from "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".codigo from "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,siglas=?,id_cuenta_contable_costo_original=?,id_cuenta_contable_depre_normal=?,id_cuenta_contable_depre_gasto_normal=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEGRUPOACTIVOFIJO_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEGRUPOACTIVOFIJO_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEGRUPOACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEGRUPOACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected DetalleGrupoActivoFijoDataAccessAdditional detallegrupoactivofijoDataAccessAdditional=null;
	
	public DetalleGrupoActivoFijoDataAccessAdditional getDetalleGrupoActivoFijoDataAccessAdditional() {
		return this.detallegrupoactivofijoDataAccessAdditional;
	}
	
	public void setDetalleGrupoActivoFijoDataAccessAdditional(DetalleGrupoActivoFijoDataAccessAdditional detallegrupoactivofijoDataAccessAdditional) {
		try {
			this.detallegrupoactivofijoDataAccessAdditional=detallegrupoactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleGrupoActivoFijoDataAccess() {
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
		DetalleGrupoActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleGrupoActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleGrupoActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleGrupoActivoFijoOriginal(DetalleGrupoActivoFijo detallegrupoactivofijo)throws Exception  {
		detallegrupoactivofijo.setDetalleGrupoActivoFijoOriginal((DetalleGrupoActivoFijo)detallegrupoactivofijo.clone());		
	}
	
	public void setDetalleGrupoActivoFijosOriginal(List<DetalleGrupoActivoFijo> detallegrupoactivofijos)throws Exception  {
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos){
			detallegrupoactivofijo.setDetalleGrupoActivoFijoOriginal((DetalleGrupoActivoFijo)detallegrupoactivofijo.clone());
		}
	}
	
	public static void setDetalleGrupoActivoFijoOriginalStatic(DetalleGrupoActivoFijo detallegrupoactivofijo)throws Exception  {
		detallegrupoactivofijo.setDetalleGrupoActivoFijoOriginal((DetalleGrupoActivoFijo)detallegrupoactivofijo.clone());		
	}
	
	public static void setDetalleGrupoActivoFijosOriginalStatic(List<DetalleGrupoActivoFijo> detallegrupoactivofijos)throws Exception  {
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos){
			detallegrupoactivofijo.setDetalleGrupoActivoFijoOriginal((DetalleGrupoActivoFijo)detallegrupoactivofijo.clone());
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
	
	public  DetalleGrupoActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		
		
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
	
	public  DetalleGrupoActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.DetalleGrupoActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleGrupoActivoFijoOriginal(new DetalleGrupoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleGrupoActivoFijo("",entity,resultSet); 
				
				//entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleGrupoActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleGrupoActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();
				
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
	
	public  DetalleGrupoActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.DetalleGrupoActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleGrupoActivoFijoOriginal(new DetalleGrupoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleGrupoActivoFijo("",entity,resultSet);    
				
				//entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleGrupoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleGrupoActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.DetalleGrupoActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleGrupoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleGrupoActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		
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
	
	public  List<DetalleGrupoActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGrupoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleGrupoActivoFijo("",entity,resultSet);
      	    	
				//entity.setDetalleGrupoActivoFijoOriginal( new DetalleGrupoActivoFijo());
      	    	//entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleGrupoActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleGrupoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
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
	
	public  List<DetalleGrupoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGrupoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleGrupoActivoFijo();
					//entity.setMapDetalleGrupoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleGrupoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleGrupoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleGrupoActivoFijoDataAccess.getEntityDetalleGrupoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleGrupoActivoFijoOriginal( new DetalleGrupoActivoFijo());
					////entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleGrupoActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleGrupoActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
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
	
	public  DetalleGrupoActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGrupoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleGrupoActivoFijo();
					//entity.setMapDetalleGrupoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleGrupoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleGrupoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=DetalleGrupoActivoFijoDataAccess.getEntityDetalleGrupoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleGrupoActivoFijoOriginal( new DetalleGrupoActivoFijo());
					////entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleGrupoActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleGrupoActivoFijo getEntityDetalleGrupoActivoFijo(String strPrefijo,DetalleGrupoActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleGrupoActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleGrupoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleGrupoActivoFijoDataAccess.setFieldReflectionDetalleGrupoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleGrupoActivoFijo=DetalleGrupoActivoFijoConstantesFunciones.getTodosTiposColumnasDetalleGrupoActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleGrupoActivoFijo) {
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
							field = DetalleGrupoActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleGrupoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleGrupoActivoFijoDataAccess.setFieldReflectionDetalleGrupoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleGrupoActivoFijo(Field field,String strPrefijo,String sColumn,DetalleGrupoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleGrupoActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.SIGLAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleGrupoActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleGrupoActivoFijo();
					entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleGrupoActivoFijo("",entity,resultSet);
					
					//entity.setDetalleGrupoActivoFijoOriginal( new DetalleGrupoActivoFijo());
					//entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleGrupoActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleGrupoActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleGrupoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGrupoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleGrupoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
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
	
	public  List<DetalleGrupoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGrupoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleGrupoActivoFijo("",entity,resultSet);
      	    	
				//entity.setDetalleGrupoActivoFijoOriginal( new DetalleGrupoActivoFijo());
      	    	//entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleGrupoActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGrupoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleGrupoActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
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
	
	public  List<DetalleGrupoActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGrupoActivoFijo> entities = new  ArrayList<DetalleGrupoActivoFijo>();
		DetalleGrupoActivoFijo entity = new DetalleGrupoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGrupoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleGrupoActivoFijo("",entity,resultSet);
      	    	
				//entity.setDetalleGrupoActivoFijoOriginal( new DetalleGrupoActivoFijo());
      	    	//entity.setDetalleGrupoActivoFijoOriginal(super.getEntity("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet,DetalleGrupoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGrupoActivoFijoOriginal(this.getEntityDetalleGrupoActivoFijo("",entity.getDetalleGrupoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleGrupoActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleGrupoActivoFijo getEntityDetalleGrupoActivoFijo(String strPrefijo,DetalleGrupoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.NOMBRE));
				entity.setsiglas(resultSet.getString(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.SIGLAS));
				entity.setid_cuenta_contable_costo_original(resultSet.getLong(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL));if(resultSet.wasNull()) {entity.setid_cuenta_contable_costo_original(null); }
				entity.setid_cuenta_contable_depre_normal(resultSet.getLong(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL));if(resultSet.wasNull()) {entity.setid_cuenta_contable_depre_normal(null); }
				entity.setid_cuenta_contable_depre_gasto_normal(resultSet.getLong(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL));if(resultSet.wasNull()) {entity.setid_cuenta_contable_depre_gasto_normal(null); }
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+DetalleGrupoActivoFijoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleGrupoActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleGrupoActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleGrupoActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleGrupoActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleGrupoActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleGrupoActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleGrupoActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleGrupoActivoFijoDataAccess.TABLENAME,DetalleGrupoActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleGrupoActivoFijoDataAccess.setDetalleGrupoActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleGrupoActivoFijo reldetallegrupoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetallegrupoactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public CuentaContable getCuentaContableCostoOriginal(Connexion connexion,DetalleGrupoActivoFijo reldetallegrupoactivofijo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallegrupoactivofijo.getid_cuenta_contable_costo_original());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDepreNormal(Connexion connexion,DetalleGrupoActivoFijo reldetallegrupoactivofijo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallegrupoactivofijo.getid_cuenta_contable_depre_normal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDepreGastoNormal(Connexion connexion,DetalleGrupoActivoFijo reldetallegrupoactivofijo)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reldetallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<DetalleActivoFijo> getDetalleActivoFijos(Connexion connexion,DetalleGrupoActivoFijo detallegrupoactivofijo)throws SQLException,Exception {

		List<DetalleActivoFijo> detalleactivofijos= new ArrayList<DetalleActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo ON "+DetalleActivoFijoConstantesFunciones.SCHEMA+".detalle_activo_fijo.id_detalle_grupo_activo_fijo="+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id WHERE "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id="+String.valueOf(detallegrupoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN detalleactivofijo.DetalleGrupoActivoFijo WHERE detalleactivofijo.DetalleGrupoActivoFijo.id="+String.valueOf(detallegrupoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			detalleactivofijos=detalleactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijos;

	}

	public List<CuentaContaDetaGrupoActi> getCuentaContaDetaGrupoActis(Connexion connexion,DetalleGrupoActivoFijo detallegrupoactivofijo)throws SQLException,Exception {

		List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis= new ArrayList<CuentaContaDetaGrupoActi>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo ON "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+".cuenta_conta_deta_grupo_acti.id_detalle_grupo_activo_fijo="+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id WHERE "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id="+String.valueOf(detallegrupoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN cuentacontadetagrupoacti.DetalleGrupoActivoFijo WHERE cuentacontadetagrupoacti.DetalleGrupoActivoFijo.id="+String.valueOf(detallegrupoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContaDetaGrupoActiDataAccess cuentacontadetagrupoactiDataAccess=new CuentaContaDetaGrupoActiDataAccess();

			cuentacontadetagrupoactiDataAccess.setConnexionType(this.connexionType);
			cuentacontadetagrupoactiDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontadetagrupoactis;

	}

	public List<SubGrupoActivoFijo> getSubGrupoActivoFijos(Connexion connexion,DetalleGrupoActivoFijo detallegrupoactivofijo)throws SQLException,Exception {

		List<SubGrupoActivoFijo> subgrupoactivofijos= new ArrayList<SubGrupoActivoFijo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo ON "+SubGrupoActivoFijoConstantesFunciones.SCHEMA+".sub_grupo_activo_fijo.id_detalle_grupo_activo_fijo="+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id WHERE "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id="+String.valueOf(detallegrupoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN subgrupoactivofijo.DetalleGrupoActivoFijo WHERE subgrupoactivofijo.DetalleGrupoActivoFijo.id="+String.valueOf(detallegrupoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SubGrupoActivoFijoDataAccess subgrupoactivofijoDataAccess=new SubGrupoActivoFijoDataAccess();

			subgrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			subgrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			subgrupoactivofijos=subgrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subgrupoactivofijos;

	}

	public List<GastoDepreciacion> getGastoDepreciacions(Connexion connexion,DetalleGrupoActivoFijo detallegrupoactivofijo)throws SQLException,Exception {

		List<GastoDepreciacion> gastodepreciacions= new ArrayList<GastoDepreciacion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo ON "+GastoDepreciacionConstantesFunciones.SCHEMA+".gasto_depreciacion.id_detalle_grupo_activo_fijo="+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id WHERE "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+".detalle_grupo_activo_fijo.id="+String.valueOf(detallegrupoactivofijo.getId());
			} else {
				sQuery=" INNER JOIN gastodepreciacion.DetalleGrupoActivoFijo WHERE gastodepreciacion.DetalleGrupoActivoFijo.id="+String.valueOf(detallegrupoactivofijo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GastoDepreciacionDataAccess gastodepreciacionDataAccess=new GastoDepreciacionDataAccess();

			gastodepreciacionDataAccess.setConnexionType(this.connexionType);
			gastodepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return gastodepreciacions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleGrupoActivoFijo detallegrupoactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detallegrupoactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detallegrupoactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(detallegrupoactivofijo.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(detallegrupoactivofijo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas=new ParameterValue<String>();
					parameterMaintenanceValuesiglas.setValue(detallegrupoactivofijo.getsiglas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_original=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_original.setValue(detallegrupoactivofijo.getid_cuenta_contable_costo_original());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_original);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_depre_normal=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_depre_normal.setValue(detallegrupoactivofijo.getid_cuenta_contable_depre_normal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_depre_normal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_depre_gasto_normal=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_depre_gasto_normal.setValue(detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_depre_gasto_normal);
					parametersTemp.add(parameterMaintenance);
					
						if(!detallegrupoactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detallegrupoactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detallegrupoactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detallegrupoactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo)throws Exception  {		
		detallegrupoactivofijo.setIsNew(false);
		detallegrupoactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleGrupoActivoFijos(List<DetalleGrupoActivoFijo> detallegrupoactivofijos)throws Exception  {				
		for(DetalleGrupoActivoFijo detallegrupoactivofijo:detallegrupoactivofijos) {
			detallegrupoactivofijo.setIsNew(false);
			detallegrupoactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleGrupoActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
