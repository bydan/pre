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
import com.bydan.erp.facturacion.util.*;//DetalleGuiaRemisionConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetalleGuiaRemisionDataAccess extends  DetalleGuiaRemisionDataAccessAdditional{ //DetalleGuiaRemisionDataAccessAdditional,DataAccessHelper<DetalleGuiaRemision>
	//static Logger logger = Logger.getLogger(DetalleGuiaRemisionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_guia_remision";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_guia_remision,id_bodega,id_producto,id_unidad,id_centro_costo,cantidad_envases,cantidad_auxiliar,descripcion,cantidad,monto,precio,porcentaje_descuento,descuento,descuento2,descuento3,porcentaje_iva,iva,total_descuento,total_impuesto,sub_total,total,lote,lote_cliente,orden_compra,area,medidas,acabado,acabado2)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_guia_remision=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad_envases=?,cantidad_auxiliar=?,descripcion=?,cantidad=?,monto=?,precio=?,porcentaje_descuento=?,descuento=?,descuento2=?,descuento3=?,porcentaje_iva=?,iva=?,total_descuento=?,total_impuesto=?,sub_total=?,total=?,lote=?,lote_cliente=?,orden_compra=?,area=?,medidas=?,acabado=?,acabado2=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleguiaremision from "+DetalleGuiaRemisionConstantesFunciones.SPERSISTENCENAME+" detalleguiaremision";
	public static String QUERYSELECTNATIVE="select "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".version_row,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_periodo,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_guia_remision,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_bodega,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_producto,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_unidad,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".cantidad_envases,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".cantidad_auxiliar,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descripcion,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".cantidad,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".monto,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".precio,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".porcentaje_descuento,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descuento,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descuento2,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".descuento3,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".porcentaje_iva,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".iva,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".total_descuento,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".total_impuesto,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".sub_total,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".total,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".lote,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".lote_cliente,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".orden_compra,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".area,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".medidas,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".acabado,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".acabado2 from "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME;//+" as "+DetalleGuiaRemisionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".id,"+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+".version_row from "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME;//+" as "+DetalleGuiaRemisionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleGuiaRemisionConstantesFunciones.SCHEMA+"."+DetalleGuiaRemisionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_guia_remision=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad_envases=?,cantidad_auxiliar=?,descripcion=?,cantidad=?,monto=?,precio=?,porcentaje_descuento=?,descuento=?,descuento2=?,descuento3=?,porcentaje_iva=?,iva=?,total_descuento=?,total_impuesto=?,sub_total=?,total=?,lote=?,lote_cliente=?,orden_compra=?,area=?,medidas=?,acabado=?,acabado2=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEGUIAREMISION_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEGUIAREMISION_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEGUIAREMISION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEGUIAREMISION_SELECT(?,?)";
	
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
	
	
	protected DetalleGuiaRemisionDataAccessAdditional detalleguiaremisionDataAccessAdditional=null;
	
	public DetalleGuiaRemisionDataAccessAdditional getDetalleGuiaRemisionDataAccessAdditional() {
		return this.detalleguiaremisionDataAccessAdditional;
	}
	
	public void setDetalleGuiaRemisionDataAccessAdditional(DetalleGuiaRemisionDataAccessAdditional detalleguiaremisionDataAccessAdditional) {
		try {
			this.detalleguiaremisionDataAccessAdditional=detalleguiaremisionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleGuiaRemisionDataAccess() {
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
		DetalleGuiaRemisionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleGuiaRemisionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleGuiaRemisionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleGuiaRemisionOriginal(DetalleGuiaRemision detalleguiaremision)throws Exception  {
		detalleguiaremision.setDetalleGuiaRemisionOriginal((DetalleGuiaRemision)detalleguiaremision.clone());		
	}
	
	public void setDetalleGuiaRemisionsOriginal(List<DetalleGuiaRemision> detalleguiaremisions)throws Exception  {
		
		for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions){
			detalleguiaremision.setDetalleGuiaRemisionOriginal((DetalleGuiaRemision)detalleguiaremision.clone());
		}
	}
	
	public static void setDetalleGuiaRemisionOriginalStatic(DetalleGuiaRemision detalleguiaremision)throws Exception  {
		detalleguiaremision.setDetalleGuiaRemisionOriginal((DetalleGuiaRemision)detalleguiaremision.clone());		
	}
	
	public static void setDetalleGuiaRemisionsOriginalStatic(List<DetalleGuiaRemision> detalleguiaremisions)throws Exception  {
		
		for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions){
			detalleguiaremision.setDetalleGuiaRemisionOriginal((DetalleGuiaRemision)detalleguiaremision.clone());
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
	
	public  DetalleGuiaRemision getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		
		
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
	
	public  DetalleGuiaRemision getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.DetalleGuiaRemision.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleGuiaRemisionOriginal(new DetalleGuiaRemision());
      	    	entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleGuiaRemision("",entity,resultSet); 
				
				//entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleGuiaRemision(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleGuiaRemision getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleGuiaRemision entity = new DetalleGuiaRemision();
				
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
	
	public  DetalleGuiaRemision getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleGuiaRemision entity = new DetalleGuiaRemision();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleGuiaRemision.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleGuiaRemisionOriginal(new DetalleGuiaRemision());
      	    	entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleGuiaRemision("",entity,resultSet);    
				
				//entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleGuiaRemision(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleGuiaRemision
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleGuiaRemision entity = new DetalleGuiaRemision();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.DetalleGuiaRemision.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleGuiaRemision(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleGuiaRemision> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		
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
	
	public  List<DetalleGuiaRemision> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGuiaRemision();
      	    	entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleGuiaRemision("",entity,resultSet);
      	    	
				//entity.setDetalleGuiaRemisionOriginal( new DetalleGuiaRemision());
      	    	//entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleGuiaRemisions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleGuiaRemision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
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
	
	public  List<DetalleGuiaRemision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGuiaRemision();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleGuiaRemision();
					//entity.setMapDetalleGuiaRemision(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleGuiaRemisionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleGuiaRemision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         		
					entity=DetalleGuiaRemisionDataAccess.getEntityDetalleGuiaRemision("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleGuiaRemisionOriginal( new DetalleGuiaRemision());
					////entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleGuiaRemisions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleGuiaRemision getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
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
	
	public  DetalleGuiaRemision getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGuiaRemision();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleGuiaRemision();
					//entity.setMapDetalleGuiaRemision(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleGuiaRemisionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleGuiaRemision().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         		
					entity=DetalleGuiaRemisionDataAccess.getEntityDetalleGuiaRemision("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleGuiaRemisionOriginal( new DetalleGuiaRemision());
					////entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleGuiaRemision(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleGuiaRemision getEntityDetalleGuiaRemision(String strPrefijo,DetalleGuiaRemision entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleGuiaRemision.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleGuiaRemision.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleGuiaRemisionDataAccess.setFieldReflectionDetalleGuiaRemision(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleGuiaRemision=DetalleGuiaRemisionConstantesFunciones.getTodosTiposColumnasDetalleGuiaRemision();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleGuiaRemision) {
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
							field = DetalleGuiaRemision.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleGuiaRemision.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleGuiaRemisionDataAccess.setFieldReflectionDetalleGuiaRemision(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleGuiaRemision(Field field,String strPrefijo,String sColumn,DetalleGuiaRemision entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleGuiaRemisionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.DESCUENTO2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.DESCUENTO3:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.AREA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.MEDIDAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.ACABADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleGuiaRemisionConstantesFunciones.ACABADO2:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleGuiaRemision>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleGuiaRemision();
					entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleGuiaRemision("",entity,resultSet);
					
					//entity.setDetalleGuiaRemisionOriginal( new DetalleGuiaRemision());
					//entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleGuiaRemisions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleGuiaRemision>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleGuiaRemisionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleGuiaRemisionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleGuiaRemision> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
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
	
	public  List<DetalleGuiaRemision> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGuiaRemision();
      	    	entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleGuiaRemision("",entity,resultSet);
      	    	
				//entity.setDetalleGuiaRemisionOriginal( new DetalleGuiaRemision());
      	    	//entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleGuiaRemisions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleGuiaRemision(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleGuiaRemision> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
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
	
	public  List<DetalleGuiaRemision> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleGuiaRemision> entities = new  ArrayList<DetalleGuiaRemision>();
		DetalleGuiaRemision entity = new DetalleGuiaRemision();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleGuiaRemision();
      	    	entity=super.getEntity("",entity,resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleGuiaRemision("",entity,resultSet);
      	    	
				//entity.setDetalleGuiaRemisionOriginal( new DetalleGuiaRemision());
      	    	//entity.setDetalleGuiaRemisionOriginal(super.getEntity("",entity.getDetalleGuiaRemisionOriginal(),resultSet,DetalleGuiaRemisionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleGuiaRemisionOriginal(this.getEntityDetalleGuiaRemision("",entity.getDetalleGuiaRemisionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleGuiaRemisions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleGuiaRemision getEntityDetalleGuiaRemision(String strPrefijo,DetalleGuiaRemision entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDPERIODO));
				entity.setid_guia_remision(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDGUIAREMISION));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDUNIDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setcantidad_envases(resultSet.getInt(strPrefijo+DetalleGuiaRemisionConstantesFunciones.CANTIDADENVASES));
				entity.setcantidad_auxiliar(resultSet.getInt(strPrefijo+DetalleGuiaRemisionConstantesFunciones.CANTIDADAUXILIAR));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.DESCRIPCION));
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleGuiaRemisionConstantesFunciones.CANTIDAD));
				entity.setmonto(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.MONTO));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.PRECIO));
				entity.setporcentaje_descuento(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.PORCENTAJEDESCUENTO));
				entity.setdescuento(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.DESCUENTO));
				entity.setdescuento2(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.DESCUENTO2));
				entity.setdescuento3(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.DESCUENTO3));
				entity.setporcentaje_iva(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.PORCENTAJEIVA));
				entity.setiva(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.IVA));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.TOTALDESCUENTO));
				entity.settotal_impuesto(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.TOTALIMPUESTO));
				entity.setsub_total(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+DetalleGuiaRemisionConstantesFunciones.TOTAL));
				entity.setlote(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.LOTE));
				entity.setlote_cliente(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.LOTECLIENTE));
				entity.setorden_compra(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.ORDENCOMPRA));
				entity.setarea(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.AREA));
				entity.setmedidas(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.MEDIDAS));
				entity.setacabado(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.ACABADO));
				entity.setacabado2(resultSet.getString(strPrefijo+DetalleGuiaRemisionConstantesFunciones.ACABADO2));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleGuiaRemision(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleGuiaRemision entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleGuiaRemisionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleGuiaRemisionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleGuiaRemisionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleGuiaRemisionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleGuiaRemisionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleGuiaRemisionDataAccess.TABLENAME,DetalleGuiaRemisionDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleGuiaRemisionDataAccess.setDetalleGuiaRemisionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleguiaremision.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleguiaremision.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleguiaremision.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleguiaremision.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public GuiaRemision getGuiaRemision(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		GuiaRemision guiaremision= new GuiaRemision();

		try {
			GuiaRemisionDataAccess guiaremisionDataAccess=new GuiaRemisionDataAccess();

			guiaremisionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			guiaremisionDataAccess.setConnexionType(this.connexionType);
			guiaremisionDataAccess.setParameterDbType(this.parameterDbType);

			guiaremision=guiaremisionDataAccess.getEntity(connexion,reldetalleguiaremision.getid_guia_remision());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return guiaremision;

	}

	public Bodega getBodega(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalleguiaremision.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleguiaremision.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalleguiaremision.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleGuiaRemision reldetalleguiaremision)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetalleguiaremision.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleGuiaRemision detalleguiaremision) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleguiaremision.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleguiaremision.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleguiaremision.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleguiaremision.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleguiaremision.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_guia_remision=new ParameterValue<Long>();
					parameterMaintenanceValueid_guia_remision.setValue(detalleguiaremision.getid_guia_remision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_guia_remision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detalleguiaremision.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleguiaremision.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalleguiaremision.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detalleguiaremision.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_envases=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_envases.setValue(detalleguiaremision.getcantidad_envases());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_envases);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_auxiliar=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_auxiliar.setValue(detalleguiaremision.getcantidad_auxiliar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_auxiliar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleguiaremision.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalleguiaremision.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto=new ParameterValue<Double>();
					parameterMaintenanceValuemonto.setValue(detalleguiaremision.getmonto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detalleguiaremision.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_descuento=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_descuento.setValue(detalleguiaremision.getporcentaje_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(detalleguiaremision.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento2=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento2.setValue(detalleguiaremision.getdescuento2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento3=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento3.setValue(detalleguiaremision.getdescuento3());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento3);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_iva=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_iva.setValue(detalleguiaremision.getporcentaje_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(detalleguiaremision.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(detalleguiaremision.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_impuesto=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_impuesto.setValue(detalleguiaremision.gettotal_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(detalleguiaremision.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detalleguiaremision.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(detalleguiaremision.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote_cliente=new ParameterValue<String>();
					parameterMaintenanceValuelote_cliente.setValue(detalleguiaremision.getlote_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorden_compra=new ParameterValue<String>();
					parameterMaintenanceValueorden_compra.setValue(detalleguiaremision.getorden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuearea=new ParameterValue<String>();
					parameterMaintenanceValuearea.setValue(detalleguiaremision.getarea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemedidas=new ParameterValue<String>();
					parameterMaintenanceValuemedidas.setValue(detalleguiaremision.getmedidas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemedidas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueacabado=new ParameterValue<String>();
					parameterMaintenanceValueacabado.setValue(detalleguiaremision.getacabado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueacabado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueacabado2=new ParameterValue<String>();
					parameterMaintenanceValueacabado2.setValue(detalleguiaremision.getacabado2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueacabado2);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleguiaremision.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleguiaremision.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleguiaremision.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleguiaremision.getId());
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
	
	public void setIsNewIsChangedFalseDetalleGuiaRemision(DetalleGuiaRemision detalleguiaremision)throws Exception  {		
		detalleguiaremision.setIsNew(false);
		detalleguiaremision.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleGuiaRemisions(List<DetalleGuiaRemision> detalleguiaremisions)throws Exception  {				
		for(DetalleGuiaRemision detalleguiaremision:detalleguiaremisions) {
			detalleguiaremision.setIsNew(false);
			detalleguiaremision.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleGuiaRemision(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
