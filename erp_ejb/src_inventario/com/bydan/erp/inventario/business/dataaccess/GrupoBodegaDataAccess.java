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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//GrupoBodegaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class GrupoBodegaDataAccess extends  GrupoBodegaDataAccessAdditional{ //GrupoBodegaDataAccessAdditional,DataAccessHelper<GrupoBodega>
	//static Logger logger = Logger.getLogger(GrupoBodegaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="grupo_bodega";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,ruc,direccion,telefono,id_pais,id_ciudad,id_centro_costo,id_empleado,descripcion,id_cuenta_contable_inventario,id_cuenta_contable_costo,id_cuenta_contable_venta,id_cuenta_contable_descuento,id_cuenta_contable_devolucion,id_cuenta_contable_debito,id_cuenta_contable_credito,id_cuenta_contable_produccion,id_cuenta_contable_bonifica,id_cuenta_contable_costo_bonifica)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,ruc=?,direccion=?,telefono=?,id_pais=?,id_ciudad=?,id_centro_costo=?,id_empleado=?,descripcion=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cuenta_contable_produccion=?,id_cuenta_contable_bonifica=?,id_cuenta_contable_costo_bonifica=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select grupobodega from "+GrupoBodegaConstantesFunciones.SPERSISTENCENAME+" grupobodega";
	public static String QUERYSELECTNATIVE="select "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".version_row,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_empresa,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".codigo,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".nombre,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".ruc,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".direccion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".telefono,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_pais,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_ciudad,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_centro_costo,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_empleado,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".descripcion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_bonifica,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_bonifica from "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME;//+" as "+GrupoBodegaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".id,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".version_row,"+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+".codigo from "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME;//+" as "+GrupoBodegaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+GrupoBodegaConstantesFunciones.SCHEMA+"."+GrupoBodegaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,ruc=?,direccion=?,telefono=?,id_pais=?,id_ciudad=?,id_centro_costo=?,id_empleado=?,descripcion=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cuenta_contable_produccion=?,id_cuenta_contable_bonifica=?,id_cuenta_contable_costo_bonifica=?";
	
	public static String STOREPROCEDUREINSERT="call SP_GRUPOBODEGA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_GRUPOBODEGA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_GRUPOBODEGA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_GRUPOBODEGA_SELECT(?,?)";
	
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
	
	
	protected GrupoBodegaDataAccessAdditional grupobodegaDataAccessAdditional=null;
	
	public GrupoBodegaDataAccessAdditional getGrupoBodegaDataAccessAdditional() {
		return this.grupobodegaDataAccessAdditional;
	}
	
	public void setGrupoBodegaDataAccessAdditional(GrupoBodegaDataAccessAdditional grupobodegaDataAccessAdditional) {
		try {
			this.grupobodegaDataAccessAdditional=grupobodegaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public GrupoBodegaDataAccess() {
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
		GrupoBodegaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		GrupoBodegaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		GrupoBodegaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setGrupoBodegaOriginal(GrupoBodega grupobodega)throws Exception  {
		grupobodega.setGrupoBodegaOriginal((GrupoBodega)grupobodega.clone());		
	}
	
	public void setGrupoBodegasOriginal(List<GrupoBodega> grupobodegas)throws Exception  {
		
		for(GrupoBodega grupobodega:grupobodegas){
			grupobodega.setGrupoBodegaOriginal((GrupoBodega)grupobodega.clone());
		}
	}
	
	public static void setGrupoBodegaOriginalStatic(GrupoBodega grupobodega)throws Exception  {
		grupobodega.setGrupoBodegaOriginal((GrupoBodega)grupobodega.clone());		
	}
	
	public static void setGrupoBodegasOriginalStatic(List<GrupoBodega> grupobodegas)throws Exception  {
		
		for(GrupoBodega grupobodega:grupobodegas){
			grupobodega.setGrupoBodegaOriginal((GrupoBodega)grupobodega.clone());
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
	
	public  GrupoBodega getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoBodega entity = new GrupoBodega();		
		
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
	
	public  GrupoBodega getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		GrupoBodega entity = new GrupoBodega();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.GrupoBodega.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setGrupoBodegaOriginal(new GrupoBodega());
      	    	entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoBodega("",entity,resultSet); 
				
				//entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoBodega(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  GrupoBodega getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoBodega entity = new GrupoBodega();
				
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
	
	public  GrupoBodega getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		GrupoBodega entity = new GrupoBodega();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoBodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.GrupoBodega.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setGrupoBodegaOriginal(new GrupoBodega());
      	    	entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityGrupoBodega("",entity,resultSet);    
				
				//entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseGrupoBodega(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //GrupoBodega
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		GrupoBodega entity = new GrupoBodega();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoBodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.GrupoBodega.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseGrupoBodega(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<GrupoBodega> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		
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
	
	public  List<GrupoBodega> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoBodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoBodega();
      	    	entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoBodega("",entity,resultSet);
      	    	
				//entity.setGrupoBodegaOriginal( new GrupoBodega());
      	    	//entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoBodegas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoBodega(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoBodega> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
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
	
	public  List<GrupoBodega> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoBodega();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoBodega();
					//entity.setMapGrupoBodega(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapGrupoBodegaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoBodega().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         		
					entity=GrupoBodegaDataAccess.getEntityGrupoBodega("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGrupoBodegaOriginal( new GrupoBodega());
					////entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
					////entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoBodegas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoBodega(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public GrupoBodega getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoBodega entity = new GrupoBodega();		  
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
	
	public  GrupoBodega getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoBodega();
				
				if(conMapGenerico) {
					entity.inicializarMapGrupoBodega();
					//entity.setMapGrupoBodega(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapGrupoBodegaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapGrupoBodega().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         		
					entity=GrupoBodegaDataAccess.getEntityGrupoBodega("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setGrupoBodegaOriginal( new GrupoBodega());
					////entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
					////entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseGrupoBodega(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoBodega(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static GrupoBodega getEntityGrupoBodega(String strPrefijo,GrupoBodega entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = GrupoBodega.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = GrupoBodega.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					GrupoBodegaDataAccess.setFieldReflectionGrupoBodega(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasGrupoBodega=GrupoBodegaConstantesFunciones.getTodosTiposColumnasGrupoBodega();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasGrupoBodega) {
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
							field = GrupoBodega.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = GrupoBodega.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						GrupoBodegaDataAccess.setFieldReflectionGrupoBodega(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionGrupoBodega(Field field,String strPrefijo,String sColumn,GrupoBodega entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case GrupoBodegaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoBodega>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoBodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new GrupoBodega();
					entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityGrupoBodega("",entity,resultSet);
					
					//entity.setGrupoBodegaOriginal( new GrupoBodega());
					//entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
					//entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseGrupoBodegas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoBodega(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<GrupoBodega>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=GrupoBodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,GrupoBodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<GrupoBodega> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
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
	
	public  List<GrupoBodega> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoBodega();
      	    	entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoBodega("",entity,resultSet);
      	    	
				//entity.setGrupoBodegaOriginal( new GrupoBodega());
      	    	//entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseGrupoBodegas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarGrupoBodega(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<GrupoBodega> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
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
	
	public  List<GrupoBodega> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<GrupoBodega> entities = new  ArrayList<GrupoBodega>();
		GrupoBodega entity = new GrupoBodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new GrupoBodega();
      	    	entity=super.getEntity("",entity,resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityGrupoBodega("",entity,resultSet);
      	    	
				//entity.setGrupoBodegaOriginal( new GrupoBodega());
      	    	//entity.setGrupoBodegaOriginal(super.getEntity("",entity.getGrupoBodegaOriginal(),resultSet,GrupoBodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setGrupoBodegaOriginal(this.getEntityGrupoBodega("",entity.getGrupoBodegaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseGrupoBodegas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public GrupoBodega getEntityGrupoBodega(String strPrefijo,GrupoBodega entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.NOMBRE));
				entity.setruc(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.RUC));
				entity.setdireccion(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.TELEFONO));
				entity.setid_pais(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCIUDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_empleado(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDEMPLEADO));
				entity.setdescripcion(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.DESCRIPCION));
				entity.setid_cuenta_contable_inventario(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO));
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTO));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEVENTA));
				entity.setid_cuenta_contable_descuento(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO));
				entity.setid_cuenta_contable_devolucion(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEDEBITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_debito(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setid_cuenta_contable_produccion(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION));
				entity.setid_cuenta_contable_bonifica(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA));
				entity.setid_cuenta_contable_costo_bonifica(resultSet.getLong(strPrefijo+GrupoBodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+GrupoBodegaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowGrupoBodega(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(GrupoBodega entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=GrupoBodegaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=GrupoBodegaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=GrupoBodegaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=GrupoBodegaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(GrupoBodegaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,GrupoBodegaDataAccess.TABLENAME,GrupoBodegaDataAccess.ISWITHSTOREPROCEDURES);
			
			GrupoBodegaDataAccess.setGrupoBodegaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relgrupobodega.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Pais getPais(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relgrupobodega.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relgrupobodega.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relgrupobodega.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Empleado getEmpleado(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relgrupobodega.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public CuentaContable getCuentaContableInventario(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDescuento(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDevolucion(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_devolucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableProduccion(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_produccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableBonifica(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_bonifica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCostoBonifica(Connexion connexion,GrupoBodega relgrupobodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relgrupobodega.getid_cuenta_contable_costo_bonifica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<Bodega> getBodegas(Connexion connexion,GrupoBodega grupobodega)throws SQLException,Exception {

		List<Bodega> bodegas= new ArrayList<Bodega>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega ON "+BodegaConstantesFunciones.SCHEMA+".bodega.id_grupo_bodega="+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega.id WHERE "+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega.id="+String.valueOf(grupobodega.getId());
			} else {
				sQuery=" INNER JOIN bodega.GrupoBodega WHERE bodega.GrupoBodega.id="+String.valueOf(grupobodega.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);
			bodegas=bodegaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodegas;

	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos(Connexion connexion,GrupoBodega grupobodega)throws SQLException,Exception {

		List<ParametroInventarioDefecto> parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega ON "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+".parametro_inventario_defecto.id_grupo_bodega="+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega.id WHERE "+GrupoBodegaConstantesFunciones.SCHEMA+".grupo_bodega.id="+String.valueOf(grupobodega.getId());
			} else {
				sQuery=" INNER JOIN parametroinventariodefecto.GrupoBodega WHERE parametroinventariodefecto.GrupoBodega.id="+String.valueOf(grupobodega.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroInventarioDefectoDataAccess parametroinventariodefectoDataAccess=new ParametroInventarioDefectoDataAccess();

			parametroinventariodefectoDataAccess.setConnexionType(this.connexionType);
			parametroinventariodefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroinventariodefectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,GrupoBodega grupobodega) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!grupobodega.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(grupobodega.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(grupobodega.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(grupobodega.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(grupobodega.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(grupobodega.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(grupobodega.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(grupobodega.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(grupobodega.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(grupobodega.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(grupobodega.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(grupobodega.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario.setValue(grupobodega.getid_cuenta_contable_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(grupobodega.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(grupobodega.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_descuento.setValue(grupobodega.getid_cuenta_contable_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_devolucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_devolucion.setValue(grupobodega.getid_cuenta_contable_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(grupobodega.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(grupobodega.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_produccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_produccion.setValue(grupobodega.getid_cuenta_contable_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_bonifica=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_bonifica.setValue(grupobodega.getid_cuenta_contable_bonifica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_bonifica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_bonifica=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_bonifica.setValue(grupobodega.getid_cuenta_contable_costo_bonifica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_bonifica);
					parametersTemp.add(parameterMaintenance);
					
						if(!grupobodega.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(grupobodega.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(grupobodega.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(grupobodega.getId());
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
	
	public void setIsNewIsChangedFalseGrupoBodega(GrupoBodega grupobodega)throws Exception  {		
		grupobodega.setIsNew(false);
		grupobodega.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseGrupoBodegas(List<GrupoBodega> grupobodegas)throws Exception  {				
		for(GrupoBodega grupobodega:grupobodegas) {
			grupobodega.setIsNew(false);
			grupobodega.setIsChanged(false);
		}
	}
	
	public void generarExportarGrupoBodega(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
