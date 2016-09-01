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
package com.bydan.erp.importaciones.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.importaciones.util.LiquidacionImporConstantesFunciones;
import com.bydan.erp.importaciones.util.LiquidacionImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.LiquidacionImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class LiquidacionImporConstantesFunciones extends LiquidacionImporConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="LiquidacionImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LiquidacionImpor"+LiquidacionImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LiquidacionImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LiquidacionImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LiquidacionImporConstantesFunciones.SCHEMA+"_"+LiquidacionImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LiquidacionImporConstantesFunciones.SCHEMA+"_"+LiquidacionImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LiquidacionImporConstantesFunciones.SCHEMA+"_"+LiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LiquidacionImporConstantesFunciones.SCHEMA+"_"+LiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LiquidacionImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LiquidacionImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LiquidacionImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LiquidacionImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LiquidacionImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LiquidacionImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Liquidacion Impores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Liquidacion Impor";
	public static final String SCLASSWEBTITULO_LOWER="Liquidacion Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LiquidacionImpor";
	public static final String OBJECTNAME="liquidacionimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="liquidacion_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select liquidacionimpor from "+LiquidacionImporConstantesFunciones.SPERSISTENCENAME+" liquidacionimpor";
	public static String QUERYSELECTNATIVE="select "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".version_row,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_empresa,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_sucursal,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_centro_costo,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_cuenta_contable,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_pais,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".id_puerto,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".nombre,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".descripcion,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".fecha,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".fecha_liquidacion,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".flete,"+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME+".tipo from "+LiquidacionImporConstantesFunciones.SCHEMA+"."+LiquidacionImporConstantesFunciones.TABLENAME;//+" as "+LiquidacionImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LiquidacionImporConstantesFuncionesAdditional liquidacionimporConstantesFuncionesAdditional=null;
	
	public LiquidacionImporConstantesFuncionesAdditional getLiquidacionImporConstantesFuncionesAdditional() {
		return this.liquidacionimporConstantesFuncionesAdditional;
	}
	
	public void setLiquidacionImporConstantesFuncionesAdditional(LiquidacionImporConstantesFuncionesAdditional liquidacionimporConstantesFuncionesAdditional) {
		try {
			this.liquidacionimporConstantesFuncionesAdditional=liquidacionimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDPAIS= "id_pais";
    public static final String IDPUERTO= "id_puerto";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHA= "fecha";
    public static final String FECHALIQUIDACION= "fecha_liquidacion";
    public static final String FLETE= "flete";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDPUERTO= "Puerto";
		public static final String LABEL_IDPUERTO_LOWER= "Puerto";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHALIQUIDACION= "Fecha Liquacion";
		public static final String LABEL_FECHALIQUIDACION_LOWER= "Fecha Liquidacion";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getLiquidacionImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.IDPAIS)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.IDPUERTO)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_IDPUERTO;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.NOMBRE)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.DESCRIPCION)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.FECHA)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.FECHALIQUIDACION)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_FECHALIQUIDACION;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.FLETE)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(LiquidacionImporConstantesFunciones.TIPO)) {sLabelColumna=LiquidacionImporConstantesFunciones.LABEL_TIPO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getLiquidacionImporDescripcion(LiquidacionImpor liquidacionimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(liquidacionimpor !=null/* && liquidacionimpor.getId()!=0*/) {
			sDescripcion=liquidacionimpor.getnombre();//liquidacionimporliquidacionimpor.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getLiquidacionImporDescripcionDetallado(LiquidacionImpor liquidacionimpor) {
		String sDescripcion="";
			
		sDescripcion+=LiquidacionImporConstantesFunciones.ID+"=";
		sDescripcion+=liquidacionimpor.getId().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=liquidacionimpor.getVersionRow().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=liquidacionimpor.getid_empresa().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=liquidacionimpor.getid_sucursal().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=liquidacionimpor.getid_centro_costo().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=liquidacionimpor.getid_cuenta_contable().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.IDPAIS+"=";
		sDescripcion+=liquidacionimpor.getid_pais().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.IDPUERTO+"=";
		sDescripcion+=liquidacionimpor.getid_puerto().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.NOMBRE+"=";
		sDescripcion+=liquidacionimpor.getnombre()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=liquidacionimpor.getdescripcion()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.FECHA+"=";
		sDescripcion+=liquidacionimpor.getfecha().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.FECHALIQUIDACION+"=";
		sDescripcion+=liquidacionimpor.getfecha_liquidacion().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.FLETE+"=";
		sDescripcion+=liquidacionimpor.getflete().toString()+",";
		sDescripcion+=LiquidacionImporConstantesFunciones.TIPO+"=";
		sDescripcion+=liquidacionimpor.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setLiquidacionImporDescripcion(LiquidacionImpor liquidacionimpor,String sValor) throws Exception {			
		if(liquidacionimpor !=null) {
			liquidacionimpor.setnombre(sValor);;//liquidacionimporliquidacionimpor.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getPuertoDescripcion(Puerto puerto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(puerto!=null/*&&puerto.getId()>0*/) {
			sDescripcion=PuertoConstantesFunciones.getPuertoDescripcion(puerto);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdPuerto")) {
			sNombreIndice="Tipo=  Por Puerto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPuerto(Long id_puerto) {
		String sDetalleIndice=" Parametros->";
		if(id_puerto!=null) {sDetalleIndice+=" Codigo Unico De Puerto="+id_puerto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLiquidacionImpor(LiquidacionImpor liquidacionimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		liquidacionimpor.setnombre(liquidacionimpor.getnombre().trim());
		liquidacionimpor.setdescripcion(liquidacionimpor.getdescripcion().trim());
		liquidacionimpor.settipo(liquidacionimpor.gettipo().trim());
	}
	
	public static void quitarEspaciosLiquidacionImpors(List<LiquidacionImpor> liquidacionimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LiquidacionImpor liquidacionimpor: liquidacionimpors) {
			liquidacionimpor.setnombre(liquidacionimpor.getnombre().trim());
			liquidacionimpor.setdescripcion(liquidacionimpor.getdescripcion().trim());
			liquidacionimpor.settipo(liquidacionimpor.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLiquidacionImpor(LiquidacionImpor liquidacionimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && liquidacionimpor.getConCambioAuxiliar()) {
			liquidacionimpor.setIsDeleted(liquidacionimpor.getIsDeletedAuxiliar());	
			liquidacionimpor.setIsNew(liquidacionimpor.getIsNewAuxiliar());	
			liquidacionimpor.setIsChanged(liquidacionimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			liquidacionimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			liquidacionimpor.setIsDeletedAuxiliar(false);	
			liquidacionimpor.setIsNewAuxiliar(false);	
			liquidacionimpor.setIsChangedAuxiliar(false);
			
			liquidacionimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLiquidacionImpors(List<LiquidacionImpor> liquidacionimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LiquidacionImpor liquidacionimpor : liquidacionimpors) {
			if(conAsignarBase && liquidacionimpor.getConCambioAuxiliar()) {
				liquidacionimpor.setIsDeleted(liquidacionimpor.getIsDeletedAuxiliar());	
				liquidacionimpor.setIsNew(liquidacionimpor.getIsNewAuxiliar());	
				liquidacionimpor.setIsChanged(liquidacionimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				liquidacionimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				liquidacionimpor.setIsDeletedAuxiliar(false);	
				liquidacionimpor.setIsNewAuxiliar(false);	
				liquidacionimpor.setIsChangedAuxiliar(false);
				
				liquidacionimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLiquidacionImpor(LiquidacionImpor liquidacionimpor,Boolean conEnteros) throws Exception  {
		liquidacionimpor.setflete(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLiquidacionImpors(List<LiquidacionImpor> liquidacionimpors,Boolean conEnteros) throws Exception  {
		
		for(LiquidacionImpor liquidacionimpor: liquidacionimpors) {
			liquidacionimpor.setflete(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLiquidacionImpor(List<LiquidacionImpor> liquidacionimpors,LiquidacionImpor liquidacionimporAux) throws Exception  {
		LiquidacionImporConstantesFunciones.InicializarValoresLiquidacionImpor(liquidacionimporAux,true);
		
		for(LiquidacionImpor liquidacionimpor: liquidacionimpors) {
			if(liquidacionimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			liquidacionimporAux.setflete(liquidacionimporAux.getflete()+liquidacionimpor.getflete());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LiquidacionImporConstantesFunciones.getArrayColumnasGlobalesLiquidacionImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LiquidacionImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LiquidacionImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LiquidacionImporConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLiquidacionImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LiquidacionImpor> liquidacionimpors,LiquidacionImpor liquidacionimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LiquidacionImpor liquidacionimporAux: liquidacionimpors) {
			if(liquidacionimporAux!=null && liquidacionimpor!=null) {
				if((liquidacionimporAux.getId()==null && liquidacionimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(liquidacionimporAux.getId()!=null && liquidacionimpor.getId()!=null){
					if(liquidacionimporAux.getId().equals(liquidacionimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLiquidacionImpor(List<LiquidacionImpor> liquidacionimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double fleteTotal=0.0;
	
		for(LiquidacionImpor liquidacionimpor: liquidacionimpors) {			
			if(liquidacionimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			fleteTotal+=liquidacionimpor.getflete();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(LiquidacionImporConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLiquidacionImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_ID, LiquidacionImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_VERSIONROW, LiquidacionImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_IDEMPRESA, LiquidacionImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL, LiquidacionImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO, LiquidacionImporConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_IDCUENTACONTABLE, LiquidacionImporConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_IDPAIS, LiquidacionImporConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_IDPUERTO, LiquidacionImporConstantesFunciones.IDPUERTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_NOMBRE, LiquidacionImporConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_DESCRIPCION, LiquidacionImporConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_FECHA, LiquidacionImporConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_FECHALIQUIDACION, LiquidacionImporConstantesFunciones.FECHALIQUIDACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_FLETE, LiquidacionImporConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LiquidacionImporConstantesFunciones.LABEL_TIPO, LiquidacionImporConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLiquidacionImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.IDPUERTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.FECHALIQUIDACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LiquidacionImporConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLiquidacionImpor() throws Exception  {
		return LiquidacionImporConstantesFunciones.getTiposSeleccionarLiquidacionImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLiquidacionImpor(Boolean conFk) throws Exception  {
		return LiquidacionImporConstantesFunciones.getTiposSeleccionarLiquidacionImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLiquidacionImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_IDPUERTO);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_IDPUERTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_FECHALIQUIDACION);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_FECHALIQUIDACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LiquidacionImporConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(LiquidacionImporConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLiquidacionImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLiquidacionImpor(LiquidacionImpor liquidacionimporAux) throws Exception {
		
			liquidacionimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(liquidacionimporAux.getEmpresa()));
			liquidacionimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(liquidacionimporAux.getSucursal()));
			liquidacionimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(liquidacionimporAux.getCentroCosto()));
			liquidacionimporAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(liquidacionimporAux.getCuentaContable()));
			liquidacionimporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(liquidacionimporAux.getPais()));
			liquidacionimporAux.setpuerto_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(liquidacionimporAux.getPuerto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLiquidacionImpor(List<LiquidacionImpor> liquidacionimporsTemp) throws Exception {
		for(LiquidacionImpor liquidacionimporAux:liquidacionimporsTemp) {
			
			liquidacionimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(liquidacionimporAux.getEmpresa()));
			liquidacionimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(liquidacionimporAux.getSucursal()));
			liquidacionimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(liquidacionimporAux.getCentroCosto()));
			liquidacionimporAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(liquidacionimporAux.getCuentaContable()));
			liquidacionimporAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(liquidacionimporAux.getPais()));
			liquidacionimporAux.setpuerto_descripcion(PuertoConstantesFunciones.getPuertoDescripcion(liquidacionimporAux.getPuerto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Puerto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Puerto.class)) {
						classes.add(new Classe(Puerto.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLiquidacionImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Puerto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Puerto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LiquidacionImporConstantesFunciones.getClassesRelationshipsOfLiquidacionImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleLiquidacionImpor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleLiquidacionImpor.class)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLiquidacionImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LiquidacionImporConstantesFunciones.getClassesRelationshipsFromStringsOfLiquidacionImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLiquidacionImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleLiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleLiquidacionImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleLiquidacionImpor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(LiquidacionImpor liquidacionimpor,List<LiquidacionImpor> liquidacionimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LiquidacionImpor liquidacionimporEncontrado=null;
			
			for(LiquidacionImpor liquidacionimporLocal:liquidacionimpors) {
				if(liquidacionimporLocal.getId().equals(liquidacionimpor.getId())) {
					liquidacionimporEncontrado=liquidacionimporLocal;
					
					liquidacionimporLocal.setIsChanged(liquidacionimpor.getIsChanged());
					liquidacionimporLocal.setIsNew(liquidacionimpor.getIsNew());
					liquidacionimporLocal.setIsDeleted(liquidacionimpor.getIsDeleted());
					
					liquidacionimporLocal.setGeneralEntityOriginal(liquidacionimpor.getGeneralEntityOriginal());
					
					liquidacionimporLocal.setId(liquidacionimpor.getId());	
					liquidacionimporLocal.setVersionRow(liquidacionimpor.getVersionRow());	
					liquidacionimporLocal.setid_empresa(liquidacionimpor.getid_empresa());	
					liquidacionimporLocal.setid_sucursal(liquidacionimpor.getid_sucursal());	
					liquidacionimporLocal.setid_centro_costo(liquidacionimpor.getid_centro_costo());	
					liquidacionimporLocal.setid_cuenta_contable(liquidacionimpor.getid_cuenta_contable());	
					liquidacionimporLocal.setid_pais(liquidacionimpor.getid_pais());	
					liquidacionimporLocal.setid_puerto(liquidacionimpor.getid_puerto());	
					liquidacionimporLocal.setnombre(liquidacionimpor.getnombre());	
					liquidacionimporLocal.setdescripcion(liquidacionimpor.getdescripcion());	
					liquidacionimporLocal.setfecha(liquidacionimpor.getfecha());	
					liquidacionimporLocal.setfecha_liquidacion(liquidacionimpor.getfecha_liquidacion());	
					liquidacionimporLocal.setflete(liquidacionimpor.getflete());	
					liquidacionimporLocal.settipo(liquidacionimpor.gettipo());	
					
					
					liquidacionimporLocal.setDetalleLiquidacionImpors(liquidacionimpor.getDetalleLiquidacionImpors());
					
					existe=true;
					break;
				}
			}
			
			if(!liquidacionimpor.getIsDeleted()) {
				if(!existe) {
					liquidacionimpors.add(liquidacionimpor);
				}
			} else {
				if(liquidacionimporEncontrado!=null && permiteQuitar)  {
					liquidacionimpors.remove(liquidacionimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LiquidacionImpor liquidacionimpor,List<LiquidacionImpor> liquidacionimpors) throws Exception {
		try	{			
			for(LiquidacionImpor liquidacionimporLocal:liquidacionimpors) {
				if(liquidacionimporLocal.getId().equals(liquidacionimpor.getId())) {
					liquidacionimporLocal.setIsSelected(liquidacionimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLiquidacionImpor(List<LiquidacionImpor> liquidacionimporsAux) throws Exception {
		//this.liquidacionimporsAux=liquidacionimporsAux;
		
		for(LiquidacionImpor liquidacionimporAux:liquidacionimporsAux) {
			if(liquidacionimporAux.getIsChanged()) {
				liquidacionimporAux.setIsChanged(false);
			}		
			
			if(liquidacionimporAux.getIsNew()) {
				liquidacionimporAux.setIsNew(false);
			}	
			
			if(liquidacionimporAux.getIsDeleted()) {
				liquidacionimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLiquidacionImpor(LiquidacionImpor liquidacionimporAux) throws Exception {
		//this.liquidacionimporAux=liquidacionimporAux;
		
			if(liquidacionimporAux.getIsChanged()) {
				liquidacionimporAux.setIsChanged(false);
			}		
			
			if(liquidacionimporAux.getIsNew()) {
				liquidacionimporAux.setIsNew(false);
			}	
			
			if(liquidacionimporAux.getIsDeleted()) {
				liquidacionimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LiquidacionImpor liquidacionimporAsignar,LiquidacionImpor liquidacionimpor) throws Exception {
		liquidacionimporAsignar.setId(liquidacionimpor.getId());	
		liquidacionimporAsignar.setVersionRow(liquidacionimpor.getVersionRow());	
		liquidacionimporAsignar.setid_empresa(liquidacionimpor.getid_empresa());
		liquidacionimporAsignar.setempresa_descripcion(liquidacionimpor.getempresa_descripcion());	
		liquidacionimporAsignar.setid_sucursal(liquidacionimpor.getid_sucursal());
		liquidacionimporAsignar.setsucursal_descripcion(liquidacionimpor.getsucursal_descripcion());	
		liquidacionimporAsignar.setid_centro_costo(liquidacionimpor.getid_centro_costo());
		liquidacionimporAsignar.setcentrocosto_descripcion(liquidacionimpor.getcentrocosto_descripcion());	
		liquidacionimporAsignar.setid_cuenta_contable(liquidacionimpor.getid_cuenta_contable());
		liquidacionimporAsignar.setcuentacontable_descripcion(liquidacionimpor.getcuentacontable_descripcion());	
		liquidacionimporAsignar.setid_pais(liquidacionimpor.getid_pais());
		liquidacionimporAsignar.setpais_descripcion(liquidacionimpor.getpais_descripcion());	
		liquidacionimporAsignar.setid_puerto(liquidacionimpor.getid_puerto());
		liquidacionimporAsignar.setpuerto_descripcion(liquidacionimpor.getpuerto_descripcion());	
		liquidacionimporAsignar.setnombre(liquidacionimpor.getnombre());	
		liquidacionimporAsignar.setdescripcion(liquidacionimpor.getdescripcion());	
		liquidacionimporAsignar.setfecha(liquidacionimpor.getfecha());	
		liquidacionimporAsignar.setfecha_liquidacion(liquidacionimpor.getfecha_liquidacion());	
		liquidacionimporAsignar.setflete(liquidacionimpor.getflete());	
		liquidacionimporAsignar.settipo(liquidacionimpor.gettipo());	
	}
	
	public static void inicializarLiquidacionImpor(LiquidacionImpor liquidacionimpor) throws Exception {
		try {
				liquidacionimpor.setId(0L);	
					
				liquidacionimpor.setid_empresa(-1L);	
				liquidacionimpor.setid_sucursal(-1L);	
				liquidacionimpor.setid_centro_costo(null);	
				liquidacionimpor.setid_cuenta_contable(-1L);	
				liquidacionimpor.setid_pais(-1L);	
				liquidacionimpor.setid_puerto(-1L);	
				liquidacionimpor.setnombre("");	
				liquidacionimpor.setdescripcion("");	
				liquidacionimpor.setfecha(new Date());	
				liquidacionimpor.setfecha_liquidacion(new Date());	
				liquidacionimpor.setflete(0.0);	
				liquidacionimpor.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLiquidacionImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_IDPUERTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_FECHALIQUIDACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LiquidacionImporConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLiquidacionImpor(String sTipo,Row row,Workbook workbook,LiquidacionImpor liquidacionimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getpuerto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getfecha_liquidacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(liquidacionimpor.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLiquidacionImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLiquidacionImpor() {
		return this.sFinalQueryLiquidacionImpor;
	}
	
	public void setsFinalQueryLiquidacionImpor(String sFinalQueryLiquidacionImpor) {
		this.sFinalQueryLiquidacionImpor= sFinalQueryLiquidacionImpor;
	}
	
	public Border resaltarSeleccionarLiquidacionImpor=null;
	
	public Border setResaltarSeleccionarLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLiquidacionImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLiquidacionImpor() {
		return this.resaltarSeleccionarLiquidacionImpor;
	}
	
	public void setResaltarSeleccionarLiquidacionImpor(Border borderResaltarSeleccionarLiquidacionImpor) {
		this.resaltarSeleccionarLiquidacionImpor= borderResaltarSeleccionarLiquidacionImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLiquidacionImpor=null;
	public Boolean mostraridLiquidacionImpor=true;
	public Boolean activaridLiquidacionImpor=true;

	public Border resaltarid_empresaLiquidacionImpor=null;
	public Boolean mostrarid_empresaLiquidacionImpor=true;
	public Boolean activarid_empresaLiquidacionImpor=true;
	public Boolean cargarid_empresaLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalLiquidacionImpor=null;
	public Boolean mostrarid_sucursalLiquidacionImpor=true;
	public Boolean activarid_sucursalLiquidacionImpor=true;
	public Boolean cargarid_sucursalLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_centro_costoLiquidacionImpor=null;
	public Boolean mostrarid_centro_costoLiquidacionImpor=true;
	public Boolean activarid_centro_costoLiquidacionImpor=true;
	public Boolean cargarid_centro_costoLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableLiquidacionImpor=null;
	public Boolean mostrarid_cuenta_contableLiquidacionImpor=true;
	public Boolean activarid_cuenta_contableLiquidacionImpor=true;
	public Boolean cargarid_cuenta_contableLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_paisLiquidacionImpor=null;
	public Boolean mostrarid_paisLiquidacionImpor=true;
	public Boolean activarid_paisLiquidacionImpor=true;
	public Boolean cargarid_paisLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarid_puertoLiquidacionImpor=null;
	public Boolean mostrarid_puertoLiquidacionImpor=true;
	public Boolean activarid_puertoLiquidacionImpor=true;
	public Boolean cargarid_puertoLiquidacionImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_puertoLiquidacionImpor=false;//ConEventDepend=true

	public Border resaltarnombreLiquidacionImpor=null;
	public Boolean mostrarnombreLiquidacionImpor=true;
	public Boolean activarnombreLiquidacionImpor=true;

	public Border resaltardescripcionLiquidacionImpor=null;
	public Boolean mostrardescripcionLiquidacionImpor=true;
	public Boolean activardescripcionLiquidacionImpor=true;

	public Border resaltarfechaLiquidacionImpor=null;
	public Boolean mostrarfechaLiquidacionImpor=true;
	public Boolean activarfechaLiquidacionImpor=false;

	public Border resaltarfecha_liquidacionLiquidacionImpor=null;
	public Boolean mostrarfecha_liquidacionLiquidacionImpor=true;
	public Boolean activarfecha_liquidacionLiquidacionImpor=false;

	public Border resaltarfleteLiquidacionImpor=null;
	public Boolean mostrarfleteLiquidacionImpor=true;
	public Boolean activarfleteLiquidacionImpor=true;

	public Border resaltartipoLiquidacionImpor=null;
	public Boolean mostrartipoLiquidacionImpor=true;
	public Boolean activartipoLiquidacionImpor=true;

	
	

	public Border setResaltaridLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltaridLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLiquidacionImpor() {
		return this.resaltaridLiquidacionImpor;
	}

	public void setResaltaridLiquidacionImpor(Border borderResaltar) {
		this.resaltaridLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostraridLiquidacionImpor() {
		return this.mostraridLiquidacionImpor;
	}

	public void setMostraridLiquidacionImpor(Boolean mostraridLiquidacionImpor) {
		this.mostraridLiquidacionImpor= mostraridLiquidacionImpor;
	}

	public Boolean getActivaridLiquidacionImpor() {
		return this.activaridLiquidacionImpor;
	}

	public void setActivaridLiquidacionImpor(Boolean activaridLiquidacionImpor) {
		this.activaridLiquidacionImpor= activaridLiquidacionImpor;
	}

	public Border setResaltarid_empresaLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLiquidacionImpor() {
		return this.resaltarid_empresaLiquidacionImpor;
	}

	public void setResaltarid_empresaLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_empresaLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaLiquidacionImpor() {
		return this.mostrarid_empresaLiquidacionImpor;
	}

	public void setMostrarid_empresaLiquidacionImpor(Boolean mostrarid_empresaLiquidacionImpor) {
		this.mostrarid_empresaLiquidacionImpor= mostrarid_empresaLiquidacionImpor;
	}

	public Boolean getActivarid_empresaLiquidacionImpor() {
		return this.activarid_empresaLiquidacionImpor;
	}

	public void setActivarid_empresaLiquidacionImpor(Boolean activarid_empresaLiquidacionImpor) {
		this.activarid_empresaLiquidacionImpor= activarid_empresaLiquidacionImpor;
	}

	public Boolean getCargarid_empresaLiquidacionImpor() {
		return this.cargarid_empresaLiquidacionImpor;
	}

	public void setCargarid_empresaLiquidacionImpor(Boolean cargarid_empresaLiquidacionImpor) {
		this.cargarid_empresaLiquidacionImpor= cargarid_empresaLiquidacionImpor;
	}

	public Border setResaltarid_sucursalLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalLiquidacionImpor() {
		return this.resaltarid_sucursalLiquidacionImpor;
	}

	public void setResaltarid_sucursalLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_sucursalLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalLiquidacionImpor() {
		return this.mostrarid_sucursalLiquidacionImpor;
	}

	public void setMostrarid_sucursalLiquidacionImpor(Boolean mostrarid_sucursalLiquidacionImpor) {
		this.mostrarid_sucursalLiquidacionImpor= mostrarid_sucursalLiquidacionImpor;
	}

	public Boolean getActivarid_sucursalLiquidacionImpor() {
		return this.activarid_sucursalLiquidacionImpor;
	}

	public void setActivarid_sucursalLiquidacionImpor(Boolean activarid_sucursalLiquidacionImpor) {
		this.activarid_sucursalLiquidacionImpor= activarid_sucursalLiquidacionImpor;
	}

	public Boolean getCargarid_sucursalLiquidacionImpor() {
		return this.cargarid_sucursalLiquidacionImpor;
	}

	public void setCargarid_sucursalLiquidacionImpor(Boolean cargarid_sucursalLiquidacionImpor) {
		this.cargarid_sucursalLiquidacionImpor= cargarid_sucursalLiquidacionImpor;
	}

	public Border setResaltarid_centro_costoLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoLiquidacionImpor() {
		return this.resaltarid_centro_costoLiquidacionImpor;
	}

	public void setResaltarid_centro_costoLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_centro_costoLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoLiquidacionImpor() {
		return this.mostrarid_centro_costoLiquidacionImpor;
	}

	public void setMostrarid_centro_costoLiquidacionImpor(Boolean mostrarid_centro_costoLiquidacionImpor) {
		this.mostrarid_centro_costoLiquidacionImpor= mostrarid_centro_costoLiquidacionImpor;
	}

	public Boolean getActivarid_centro_costoLiquidacionImpor() {
		return this.activarid_centro_costoLiquidacionImpor;
	}

	public void setActivarid_centro_costoLiquidacionImpor(Boolean activarid_centro_costoLiquidacionImpor) {
		this.activarid_centro_costoLiquidacionImpor= activarid_centro_costoLiquidacionImpor;
	}

	public Boolean getCargarid_centro_costoLiquidacionImpor() {
		return this.cargarid_centro_costoLiquidacionImpor;
	}

	public void setCargarid_centro_costoLiquidacionImpor(Boolean cargarid_centro_costoLiquidacionImpor) {
		this.cargarid_centro_costoLiquidacionImpor= cargarid_centro_costoLiquidacionImpor;
	}

	public Border setResaltarid_cuenta_contableLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableLiquidacionImpor() {
		return this.resaltarid_cuenta_contableLiquidacionImpor;
	}

	public void setResaltarid_cuenta_contableLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_cuenta_contableLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableLiquidacionImpor() {
		return this.mostrarid_cuenta_contableLiquidacionImpor;
	}

	public void setMostrarid_cuenta_contableLiquidacionImpor(Boolean mostrarid_cuenta_contableLiquidacionImpor) {
		this.mostrarid_cuenta_contableLiquidacionImpor= mostrarid_cuenta_contableLiquidacionImpor;
	}

	public Boolean getActivarid_cuenta_contableLiquidacionImpor() {
		return this.activarid_cuenta_contableLiquidacionImpor;
	}

	public void setActivarid_cuenta_contableLiquidacionImpor(Boolean activarid_cuenta_contableLiquidacionImpor) {
		this.activarid_cuenta_contableLiquidacionImpor= activarid_cuenta_contableLiquidacionImpor;
	}

	public Boolean getCargarid_cuenta_contableLiquidacionImpor() {
		return this.cargarid_cuenta_contableLiquidacionImpor;
	}

	public void setCargarid_cuenta_contableLiquidacionImpor(Boolean cargarid_cuenta_contableLiquidacionImpor) {
		this.cargarid_cuenta_contableLiquidacionImpor= cargarid_cuenta_contableLiquidacionImpor;
	}

	public Border setResaltarid_paisLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_paisLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisLiquidacionImpor() {
		return this.resaltarid_paisLiquidacionImpor;
	}

	public void setResaltarid_paisLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_paisLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_paisLiquidacionImpor() {
		return this.mostrarid_paisLiquidacionImpor;
	}

	public void setMostrarid_paisLiquidacionImpor(Boolean mostrarid_paisLiquidacionImpor) {
		this.mostrarid_paisLiquidacionImpor= mostrarid_paisLiquidacionImpor;
	}

	public Boolean getActivarid_paisLiquidacionImpor() {
		return this.activarid_paisLiquidacionImpor;
	}

	public void setActivarid_paisLiquidacionImpor(Boolean activarid_paisLiquidacionImpor) {
		this.activarid_paisLiquidacionImpor= activarid_paisLiquidacionImpor;
	}

	public Boolean getCargarid_paisLiquidacionImpor() {
		return this.cargarid_paisLiquidacionImpor;
	}

	public void setCargarid_paisLiquidacionImpor(Boolean cargarid_paisLiquidacionImpor) {
		this.cargarid_paisLiquidacionImpor= cargarid_paisLiquidacionImpor;
	}

	public Border setResaltarid_puertoLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarid_puertoLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_puertoLiquidacionImpor() {
		return this.resaltarid_puertoLiquidacionImpor;
	}

	public void setResaltarid_puertoLiquidacionImpor(Border borderResaltar) {
		this.resaltarid_puertoLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarid_puertoLiquidacionImpor() {
		return this.mostrarid_puertoLiquidacionImpor;
	}

	public void setMostrarid_puertoLiquidacionImpor(Boolean mostrarid_puertoLiquidacionImpor) {
		this.mostrarid_puertoLiquidacionImpor= mostrarid_puertoLiquidacionImpor;
	}

	public Boolean getActivarid_puertoLiquidacionImpor() {
		return this.activarid_puertoLiquidacionImpor;
	}

	public void setActivarid_puertoLiquidacionImpor(Boolean activarid_puertoLiquidacionImpor) {
		this.activarid_puertoLiquidacionImpor= activarid_puertoLiquidacionImpor;
	}

	public Boolean getCargarid_puertoLiquidacionImpor() {
		return this.cargarid_puertoLiquidacionImpor;
	}

	public void setCargarid_puertoLiquidacionImpor(Boolean cargarid_puertoLiquidacionImpor) {
		this.cargarid_puertoLiquidacionImpor= cargarid_puertoLiquidacionImpor;
	}

	public Border setResaltarnombreLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarnombreLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreLiquidacionImpor() {
		return this.resaltarnombreLiquidacionImpor;
	}

	public void setResaltarnombreLiquidacionImpor(Border borderResaltar) {
		this.resaltarnombreLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarnombreLiquidacionImpor() {
		return this.mostrarnombreLiquidacionImpor;
	}

	public void setMostrarnombreLiquidacionImpor(Boolean mostrarnombreLiquidacionImpor) {
		this.mostrarnombreLiquidacionImpor= mostrarnombreLiquidacionImpor;
	}

	public Boolean getActivarnombreLiquidacionImpor() {
		return this.activarnombreLiquidacionImpor;
	}

	public void setActivarnombreLiquidacionImpor(Boolean activarnombreLiquidacionImpor) {
		this.activarnombreLiquidacionImpor= activarnombreLiquidacionImpor;
	}

	public Border setResaltardescripcionLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltardescripcionLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionLiquidacionImpor() {
		return this.resaltardescripcionLiquidacionImpor;
	}

	public void setResaltardescripcionLiquidacionImpor(Border borderResaltar) {
		this.resaltardescripcionLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrardescripcionLiquidacionImpor() {
		return this.mostrardescripcionLiquidacionImpor;
	}

	public void setMostrardescripcionLiquidacionImpor(Boolean mostrardescripcionLiquidacionImpor) {
		this.mostrardescripcionLiquidacionImpor= mostrardescripcionLiquidacionImpor;
	}

	public Boolean getActivardescripcionLiquidacionImpor() {
		return this.activardescripcionLiquidacionImpor;
	}

	public void setActivardescripcionLiquidacionImpor(Boolean activardescripcionLiquidacionImpor) {
		this.activardescripcionLiquidacionImpor= activardescripcionLiquidacionImpor;
	}

	public Border setResaltarfechaLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarfechaLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaLiquidacionImpor() {
		return this.resaltarfechaLiquidacionImpor;
	}

	public void setResaltarfechaLiquidacionImpor(Border borderResaltar) {
		this.resaltarfechaLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarfechaLiquidacionImpor() {
		return this.mostrarfechaLiquidacionImpor;
	}

	public void setMostrarfechaLiquidacionImpor(Boolean mostrarfechaLiquidacionImpor) {
		this.mostrarfechaLiquidacionImpor= mostrarfechaLiquidacionImpor;
	}

	public Boolean getActivarfechaLiquidacionImpor() {
		return this.activarfechaLiquidacionImpor;
	}

	public void setActivarfechaLiquidacionImpor(Boolean activarfechaLiquidacionImpor) {
		this.activarfechaLiquidacionImpor= activarfechaLiquidacionImpor;
	}

	public Border setResaltarfecha_liquidacionLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarfecha_liquidacionLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_liquidacionLiquidacionImpor() {
		return this.resaltarfecha_liquidacionLiquidacionImpor;
	}

	public void setResaltarfecha_liquidacionLiquidacionImpor(Border borderResaltar) {
		this.resaltarfecha_liquidacionLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarfecha_liquidacionLiquidacionImpor() {
		return this.mostrarfecha_liquidacionLiquidacionImpor;
	}

	public void setMostrarfecha_liquidacionLiquidacionImpor(Boolean mostrarfecha_liquidacionLiquidacionImpor) {
		this.mostrarfecha_liquidacionLiquidacionImpor= mostrarfecha_liquidacionLiquidacionImpor;
	}

	public Boolean getActivarfecha_liquidacionLiquidacionImpor() {
		return this.activarfecha_liquidacionLiquidacionImpor;
	}

	public void setActivarfecha_liquidacionLiquidacionImpor(Boolean activarfecha_liquidacionLiquidacionImpor) {
		this.activarfecha_liquidacionLiquidacionImpor= activarfecha_liquidacionLiquidacionImpor;
	}

	public Border setResaltarfleteLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltarfleteLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteLiquidacionImpor() {
		return this.resaltarfleteLiquidacionImpor;
	}

	public void setResaltarfleteLiquidacionImpor(Border borderResaltar) {
		this.resaltarfleteLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrarfleteLiquidacionImpor() {
		return this.mostrarfleteLiquidacionImpor;
	}

	public void setMostrarfleteLiquidacionImpor(Boolean mostrarfleteLiquidacionImpor) {
		this.mostrarfleteLiquidacionImpor= mostrarfleteLiquidacionImpor;
	}

	public Boolean getActivarfleteLiquidacionImpor() {
		return this.activarfleteLiquidacionImpor;
	}

	public void setActivarfleteLiquidacionImpor(Boolean activarfleteLiquidacionImpor) {
		this.activarfleteLiquidacionImpor= activarfleteLiquidacionImpor;
	}

	public Border setResaltartipoLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltar);
		
		this.resaltartipoLiquidacionImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoLiquidacionImpor() {
		return this.resaltartipoLiquidacionImpor;
	}

	public void setResaltartipoLiquidacionImpor(Border borderResaltar) {
		this.resaltartipoLiquidacionImpor= borderResaltar;
	}

	public Boolean getMostrartipoLiquidacionImpor() {
		return this.mostrartipoLiquidacionImpor;
	}

	public void setMostrartipoLiquidacionImpor(Boolean mostrartipoLiquidacionImpor) {
		this.mostrartipoLiquidacionImpor= mostrartipoLiquidacionImpor;
	}

	public Boolean getActivartipoLiquidacionImpor() {
		return this.activartipoLiquidacionImpor;
	}

	public void setActivartipoLiquidacionImpor(Boolean activartipoLiquidacionImpor) {
		this.activartipoLiquidacionImpor= activartipoLiquidacionImpor;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridLiquidacionImpor(esInicial);
		this.setMostrarid_empresaLiquidacionImpor(esInicial);
		this.setMostrarid_sucursalLiquidacionImpor(esInicial);
		this.setMostrarid_centro_costoLiquidacionImpor(esInicial);
		this.setMostrarid_cuenta_contableLiquidacionImpor(esInicial);
		this.setMostrarid_paisLiquidacionImpor(esInicial);
		this.setMostrarid_puertoLiquidacionImpor(esInicial);
		this.setMostrarnombreLiquidacionImpor(esInicial);
		this.setMostrardescripcionLiquidacionImpor(esInicial);
		this.setMostrarfechaLiquidacionImpor(esInicial);
		this.setMostrarfecha_liquidacionLiquidacionImpor(esInicial);
		this.setMostrarfleteLiquidacionImpor(esInicial);
		this.setMostrartipoLiquidacionImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.ID)) {
				this.setMostraridLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDPUERTO)) {
				this.setMostrarid_puertoLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FECHA)) {
				this.setMostrarfechaLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FECHALIQUIDACION)) {
				this.setMostrarfecha_liquidacionLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FLETE)) {
				this.setMostrarfleteLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.TIPO)) {
				this.setMostrartipoLiquidacionImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridLiquidacionImpor(esInicial);
		this.setActivarid_empresaLiquidacionImpor(esInicial);
		this.setActivarid_sucursalLiquidacionImpor(esInicial);
		this.setActivarid_centro_costoLiquidacionImpor(esInicial);
		this.setActivarid_cuenta_contableLiquidacionImpor(esInicial);
		this.setActivarid_paisLiquidacionImpor(esInicial);
		this.setActivarid_puertoLiquidacionImpor(esInicial);
		this.setActivarnombreLiquidacionImpor(esInicial);
		this.setActivardescripcionLiquidacionImpor(esInicial);
		this.setActivarfechaLiquidacionImpor(esInicial);
		this.setActivarfecha_liquidacionLiquidacionImpor(esInicial);
		this.setActivarfleteLiquidacionImpor(esInicial);
		this.setActivartipoLiquidacionImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.ID)) {
				this.setActivaridLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDPUERTO)) {
				this.setActivarid_puertoLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.NOMBRE)) {
				this.setActivarnombreLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FECHA)) {
				this.setActivarfechaLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FECHALIQUIDACION)) {
				this.setActivarfecha_liquidacionLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FLETE)) {
				this.setActivarfleteLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.TIPO)) {
				this.setActivartipoLiquidacionImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLiquidacionImpor(esInicial);
		this.setResaltarid_empresaLiquidacionImpor(esInicial);
		this.setResaltarid_sucursalLiquidacionImpor(esInicial);
		this.setResaltarid_centro_costoLiquidacionImpor(esInicial);
		this.setResaltarid_cuenta_contableLiquidacionImpor(esInicial);
		this.setResaltarid_paisLiquidacionImpor(esInicial);
		this.setResaltarid_puertoLiquidacionImpor(esInicial);
		this.setResaltarnombreLiquidacionImpor(esInicial);
		this.setResaltardescripcionLiquidacionImpor(esInicial);
		this.setResaltarfechaLiquidacionImpor(esInicial);
		this.setResaltarfecha_liquidacionLiquidacionImpor(esInicial);
		this.setResaltarfleteLiquidacionImpor(esInicial);
		this.setResaltartipoLiquidacionImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.ID)) {
				this.setResaltaridLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.IDPUERTO)) {
				this.setResaltarid_puertoLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FECHA)) {
				this.setResaltarfechaLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FECHALIQUIDACION)) {
				this.setResaltarfecha_liquidacionLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.FLETE)) {
				this.setResaltarfleteLiquidacionImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(LiquidacionImporConstantesFunciones.TIPO)) {
				this.setResaltartipoLiquidacionImpor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleLiquidacionImporLiquidacionImpor=null;

	public Border getResaltarDetalleLiquidacionImporLiquidacionImpor() {
		return this.resaltarDetalleLiquidacionImporLiquidacionImpor;
	}

	public void setResaltarDetalleLiquidacionImporLiquidacionImpor(Border borderResaltarDetalleLiquidacionImpor) {
		if(borderResaltarDetalleLiquidacionImpor!=null) {
			this.resaltarDetalleLiquidacionImporLiquidacionImpor= borderResaltarDetalleLiquidacionImpor;
		}
	}

	public Border setResaltarDetalleLiquidacionImporLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleLiquidacionImpor=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//liquidacionimporBeanSwingJInternalFrame.jTtoolBarLiquidacionImpor.setBorder(borderResaltarDetalleLiquidacionImpor);
			
		this.resaltarDetalleLiquidacionImporLiquidacionImpor= borderResaltarDetalleLiquidacionImpor;

		 return borderResaltarDetalleLiquidacionImpor;
	}



	public Boolean mostrarDetalleLiquidacionImporLiquidacionImpor=true;

	public Boolean getMostrarDetalleLiquidacionImporLiquidacionImpor() {
		return this.mostrarDetalleLiquidacionImporLiquidacionImpor;
	}

	public void setMostrarDetalleLiquidacionImporLiquidacionImpor(Boolean visibilidadResaltarDetalleLiquidacionImpor) {
		this.mostrarDetalleLiquidacionImporLiquidacionImpor= visibilidadResaltarDetalleLiquidacionImpor;
	}



	public Boolean activarDetalleLiquidacionImporLiquidacionImpor=true;

	public Boolean gethabilitarResaltarDetalleLiquidacionImporLiquidacionImpor() {
		return this.activarDetalleLiquidacionImporLiquidacionImpor;
	}

	public void setActivarDetalleLiquidacionImporLiquidacionImpor(Boolean habilitarResaltarDetalleLiquidacionImpor) {
		this.activarDetalleLiquidacionImporLiquidacionImpor= habilitarResaltarDetalleLiquidacionImpor;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetalleLiquidacionImporLiquidacionImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setMostrarDetalleLiquidacionImporLiquidacionImpor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetalleLiquidacionImporLiquidacionImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setActivarDetalleLiquidacionImporLiquidacionImpor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleLiquidacionImporLiquidacionImpor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleLiquidacionImpor.class)) {
				this.setResaltarDetalleLiquidacionImporLiquidacionImpor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCentroCostoLiquidacionImpor=true;

	public Boolean getMostrarFK_IdCentroCostoLiquidacionImpor() {
		return this.mostrarFK_IdCentroCostoLiquidacionImpor;
	}

	public void setMostrarFK_IdCentroCostoLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableLiquidacionImpor=true;

	public Boolean getMostrarFK_IdCuentaContableLiquidacionImpor() {
		return this.mostrarFK_IdCuentaContableLiquidacionImpor;
	}

	public void setMostrarFK_IdCuentaContableLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaLiquidacionImpor=true;

	public Boolean getMostrarFK_IdEmpresaLiquidacionImpor() {
		return this.mostrarFK_IdEmpresaLiquidacionImpor;
	}

	public void setMostrarFK_IdEmpresaLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisLiquidacionImpor=true;

	public Boolean getMostrarFK_IdPaisLiquidacionImpor() {
		return this.mostrarFK_IdPaisLiquidacionImpor;
	}

	public void setMostrarFK_IdPaisLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPuertoLiquidacionImpor=true;

	public Boolean getMostrarFK_IdPuertoLiquidacionImpor() {
		return this.mostrarFK_IdPuertoLiquidacionImpor;
	}

	public void setMostrarFK_IdPuertoLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPuertoLiquidacionImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalLiquidacionImpor=true;

	public Boolean getMostrarFK_IdSucursalLiquidacionImpor() {
		return this.mostrarFK_IdSucursalLiquidacionImpor;
	}

	public void setMostrarFK_IdSucursalLiquidacionImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalLiquidacionImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoLiquidacionImpor=true;

	public Boolean getActivarFK_IdCentroCostoLiquidacionImpor() {
		return this.activarFK_IdCentroCostoLiquidacionImpor;
	}

	public void setActivarFK_IdCentroCostoLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableLiquidacionImpor=true;

	public Boolean getActivarFK_IdCuentaContableLiquidacionImpor() {
		return this.activarFK_IdCuentaContableLiquidacionImpor;
	}

	public void setActivarFK_IdCuentaContableLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaLiquidacionImpor=true;

	public Boolean getActivarFK_IdEmpresaLiquidacionImpor() {
		return this.activarFK_IdEmpresaLiquidacionImpor;
	}

	public void setActivarFK_IdEmpresaLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisLiquidacionImpor=true;

	public Boolean getActivarFK_IdPaisLiquidacionImpor() {
		return this.activarFK_IdPaisLiquidacionImpor;
	}

	public void setActivarFK_IdPaisLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPaisLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPuertoLiquidacionImpor=true;

	public Boolean getActivarFK_IdPuertoLiquidacionImpor() {
		return this.activarFK_IdPuertoLiquidacionImpor;
	}

	public void setActivarFK_IdPuertoLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPuertoLiquidacionImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalLiquidacionImpor=true;

	public Boolean getActivarFK_IdSucursalLiquidacionImpor() {
		return this.activarFK_IdSucursalLiquidacionImpor;
	}

	public void setActivarFK_IdSucursalLiquidacionImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalLiquidacionImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoLiquidacionImpor=null;

	public Border getResaltarFK_IdCentroCostoLiquidacionImpor() {
		return this.resaltarFK_IdCentroCostoLiquidacionImpor;
	}

	public void setResaltarFK_IdCentroCostoLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableLiquidacionImpor=null;

	public Border getResaltarFK_IdCuentaContableLiquidacionImpor() {
		return this.resaltarFK_IdCuentaContableLiquidacionImpor;
	}

	public void setResaltarFK_IdCuentaContableLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaLiquidacionImpor=null;

	public Border getResaltarFK_IdEmpresaLiquidacionImpor() {
		return this.resaltarFK_IdEmpresaLiquidacionImpor;
	}

	public void setResaltarFK_IdEmpresaLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdPaisLiquidacionImpor=null;

	public Border getResaltarFK_IdPaisLiquidacionImpor() {
		return this.resaltarFK_IdPaisLiquidacionImpor;
	}

	public void setResaltarFK_IdPaisLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdPaisLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdPaisLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdPuertoLiquidacionImpor=null;

	public Border getResaltarFK_IdPuertoLiquidacionImpor() {
		return this.resaltarFK_IdPuertoLiquidacionImpor;
	}

	public void setResaltarFK_IdPuertoLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdPuertoLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdPuertoLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPuertoLiquidacionImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalLiquidacionImpor=null;

	public Border getResaltarFK_IdSucursalLiquidacionImpor() {
		return this.resaltarFK_IdSucursalLiquidacionImpor;
	}

	public void setResaltarFK_IdSucursalLiquidacionImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalLiquidacionImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalLiquidacionImpor(ParametroGeneralUsuario parametroGeneralUsuario/*LiquidacionImporBeanSwingJInternalFrame liquidacionimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalLiquidacionImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}