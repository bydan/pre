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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.RequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.RequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RequisicionConstantesFunciones extends RequisicionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Requisicion";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Requisicion"+RequisicionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RequisicionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RequisicionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RequisicionConstantesFunciones.SCHEMA+"_"+RequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RequisicionConstantesFunciones.SCHEMA+"_"+RequisicionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RequisicionConstantesFunciones.SCHEMA+"_"+RequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RequisicionConstantesFunciones.SCHEMA+"_"+RequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RequisicionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RequisicionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RequisicionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RequisicionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RequisicionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Requisiciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Requisicion";
	public static final String SCLASSWEBTITULO_LOWER="Requisicion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Requisicion";
	public static final String OBJECTNAME="requisicion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="requisicion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select requisicion from "+RequisicionConstantesFunciones.SPERSISTENCENAME+" requisicion";
	public static String QUERYSELECTNATIVE="select "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".version_row,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_empresa,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_sucursal,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".numero_secuencial,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_tipo_requisicion,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".fecha,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".hora,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_empleado,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_estado_requisicion,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_formato,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_bodega_solicitar,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".descripcion,"+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME+".id_bodega_solicita from "+RequisicionConstantesFunciones.SCHEMA+"."+RequisicionConstantesFunciones.TABLENAME;//+" as "+RequisicionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected RequisicionConstantesFuncionesAdditional requisicionConstantesFuncionesAdditional=null;
	
	public RequisicionConstantesFuncionesAdditional getRequisicionConstantesFuncionesAdditional() {
		return this.requisicionConstantesFuncionesAdditional;
	}
	
	public void setRequisicionConstantesFuncionesAdditional(RequisicionConstantesFuncionesAdditional requisicionConstantesFuncionesAdditional) {
		try {
			this.requisicionConstantesFuncionesAdditional=requisicionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String IDTIPOREQUISICION= "id_tipo_requisicion";
    public static final String FECHA= "fecha";
    public static final String HORA= "hora";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTADOREQUISICION= "id_estado_requisicion";
    public static final String IDFORMATO= "id_formato";
    public static final String IDBODEGASOLICITAR= "id_bodega_solicitar";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDBODEGASOLICITA= "id_bodega_solicita";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_IDTIPOREQUISICION= "Tipo";
		public static final String LABEL_IDTIPOREQUISICION_LOWER= "Tipo Requisicion";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTADOREQUISICION= "Estado";
		public static final String LABEL_IDESTADOREQUISICION_LOWER= "Estado Requisicion";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDBODEGASOLICITAR= "Bode Solicitar";
		public static final String LABEL_IDBODEGASOLICITAR_LOWER= "Bodega Solicitar";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDBODEGASOLICITA= "Bode Solicita";
		public static final String LABEL_IDBODEGASOLICITA_LOWER= "Bodega Solicita";
	
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getRequisicionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDEMPRESA)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDTIPOREQUISICION)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDTIPOREQUISICION;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.FECHA)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.HORA)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_HORA;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDEMPLEADO)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDESTADOREQUISICION)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDESTADOREQUISICION;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDFORMATO)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDBODEGASOLICITAR)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITAR;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.DESCRIPCION)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(RequisicionConstantesFunciones.IDBODEGASOLICITA)) {sLabelColumna=RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRequisicionDescripcion(Requisicion requisicion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(requisicion !=null/* && requisicion.getId()!=0*/) {
			sDescripcion=requisicion.getnumero_secuencial();//requisicionrequisicion.getnumero_secuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRequisicionDescripcionDetallado(Requisicion requisicion) {
		String sDescripcion="";
			
		sDescripcion+=RequisicionConstantesFunciones.ID+"=";
		sDescripcion+=requisicion.getId().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=requisicion.getVersionRow().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=requisicion.getid_empresa().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=requisicion.getid_sucursal().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=requisicion.getnumero_secuencial()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDTIPOREQUISICION+"=";
		sDescripcion+=requisicion.getid_tipo_requisicion().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.FECHA+"=";
		sDescripcion+=requisicion.getfecha().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.HORA+"=";
		sDescripcion+=requisicion.gethora().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=requisicion.getid_empleado().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDESTADOREQUISICION+"=";
		sDescripcion+=requisicion.getid_estado_requisicion().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=requisicion.getid_formato().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDBODEGASOLICITAR+"=";
		sDescripcion+=requisicion.getid_bodega_solicitar().toString()+",";
		sDescripcion+=RequisicionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=requisicion.getdescripcion()+",";
		sDescripcion+=RequisicionConstantesFunciones.IDBODEGASOLICITA+"=";
		sDescripcion+=requisicion.getid_bodega_solicita().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRequisicionDescripcion(Requisicion requisicion,String sValor) throws Exception {			
		if(requisicion !=null) {
			requisicion.setnumero_secuencial(sValor);;//requisicionrequisicion.getnumero_secuencial().trim();
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

	public static String getTipoRequisicionDescripcion(TipoRequisicion tiporequisicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporequisicion!=null/*&&tiporequisicion.getId()>0*/) {
			sDescripcion=TipoRequisicionConstantesFunciones.getTipoRequisicionDescripcion(tiporequisicion);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEstadoRequisicionDescripcion(EstadoRequisicion estadorequisicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadorequisicion!=null/*&&estadorequisicion.getId()>0*/) {
			sDescripcion=EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(estadorequisicion);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getBodegaSolicitarDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getBodegaSolicitaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por No Secuencial";
		} else if(sNombreIndice.equals("FK_IdBodegaSolicita")) {
			sNombreIndice="Tipo=  Por Bode Solicita";
		} else if(sNombreIndice.equals("FK_IdBodegaSolicitar")) {
			sNombreIndice="Tipo=  Por Bode Solicitar";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoRequisicion")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoRequisicion")) {
			sNombreIndice="Tipo=  Por Tipo";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String numero_secuencial) {
		String sDetalleIndice=" Parametros->";
		if(numero_secuencial!=null) {sDetalleIndice+=" No Secuencial="+numero_secuencial;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaSolicita(Long id_bodega_solicita) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_solicita!=null) {sDetalleIndice+=" Codigo Unico De Bode Solicita="+id_bodega_solicita.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaSolicitar(Long id_bodega_solicitar) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_solicitar!=null) {sDetalleIndice+=" Codigo Unico De Bode Solicitar="+id_bodega_solicitar.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoRequisicion(Long id_estado_requisicion) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_requisicion!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_requisicion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRequisicion(Long id_tipo_requisicion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_requisicion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_tipo_requisicion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRequisicion(Requisicion requisicion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		requisicion.setnumero_secuencial(requisicion.getnumero_secuencial().trim());
		requisicion.setdescripcion(requisicion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosRequisicions(List<Requisicion> requisicions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Requisicion requisicion: requisicions) {
			requisicion.setnumero_secuencial(requisicion.getnumero_secuencial().trim());
			requisicion.setdescripcion(requisicion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRequisicion(Requisicion requisicion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && requisicion.getConCambioAuxiliar()) {
			requisicion.setIsDeleted(requisicion.getIsDeletedAuxiliar());	
			requisicion.setIsNew(requisicion.getIsNewAuxiliar());	
			requisicion.setIsChanged(requisicion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			requisicion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			requisicion.setIsDeletedAuxiliar(false);	
			requisicion.setIsNewAuxiliar(false);	
			requisicion.setIsChangedAuxiliar(false);
			
			requisicion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRequisicions(List<Requisicion> requisicions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Requisicion requisicion : requisicions) {
			if(conAsignarBase && requisicion.getConCambioAuxiliar()) {
				requisicion.setIsDeleted(requisicion.getIsDeletedAuxiliar());	
				requisicion.setIsNew(requisicion.getIsNewAuxiliar());	
				requisicion.setIsChanged(requisicion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				requisicion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				requisicion.setIsDeletedAuxiliar(false);	
				requisicion.setIsNewAuxiliar(false);	
				requisicion.setIsChangedAuxiliar(false);
				
				requisicion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRequisicion(Requisicion requisicion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRequisicions(List<Requisicion> requisicions,Boolean conEnteros) throws Exception  {
		
		for(Requisicion requisicion: requisicions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRequisicion(List<Requisicion> requisicions,Requisicion requisicionAux) throws Exception  {
		RequisicionConstantesFunciones.InicializarValoresRequisicion(requisicionAux,true);
		
		for(Requisicion requisicion: requisicions) {
			if(requisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RequisicionConstantesFunciones.getArrayColumnasGlobalesRequisicion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRequisicion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRequisicion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Requisicion> requisicions,Requisicion requisicion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Requisicion requisicionAux: requisicions) {
			if(requisicionAux!=null && requisicion!=null) {
				if((requisicionAux.getId()==null && requisicion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(requisicionAux.getId()!=null && requisicion.getId()!=null){
					if(requisicionAux.getId().equals(requisicion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRequisicion(List<Requisicion> requisicions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Requisicion requisicion: requisicions) {			
			if(requisicion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRequisicion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_ID, RequisicionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_VERSIONROW, RequisicionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDEMPRESA, RequisicionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDSUCURSAL, RequisicionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_NUMEROSECUENCIAL, RequisicionConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDTIPOREQUISICION, RequisicionConstantesFunciones.IDTIPOREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_FECHA, RequisicionConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_HORA, RequisicionConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDEMPLEADO, RequisicionConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDESTADOREQUISICION, RequisicionConstantesFunciones.IDESTADOREQUISICION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDFORMATO, RequisicionConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITAR, RequisicionConstantesFunciones.IDBODEGASOLICITAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_DESCRIPCION, RequisicionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITA, RequisicionConstantesFunciones.IDBODEGASOLICITA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRequisicion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDTIPOREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDESTADOREQUISICION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDBODEGASOLICITAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionConstantesFunciones.IDBODEGASOLICITA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRequisicion() throws Exception  {
		return RequisicionConstantesFunciones.getTiposSeleccionarRequisicion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRequisicion(Boolean conFk) throws Exception  {
		return RequisicionConstantesFunciones.getTiposSeleccionarRequisicion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRequisicion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDTIPOREQUISICION);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDTIPOREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDESTADOREQUISICION);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDESTADOREQUISICION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITAR);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITA);
			reporte.setsDescripcion(RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRequisicion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRequisicion(Requisicion requisicionAux) throws Exception {
		
			requisicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(requisicionAux.getEmpresa()));
			requisicionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(requisicionAux.getSucursal()));
			requisicionAux.settiporequisicion_descripcion(TipoRequisicionConstantesFunciones.getTipoRequisicionDescripcion(requisicionAux.getTipoRequisicion()));
			requisicionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(requisicionAux.getEmpleado()));
			requisicionAux.setestadorequisicion_descripcion(EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(requisicionAux.getEstadoRequisicion()));
			requisicionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(requisicionAux.getFormato()));
			requisicionAux.setbodegasolicitar_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(requisicionAux.getBodegaSolicitar()));
			requisicionAux.setbodegasolicita_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(requisicionAux.getBodegaSolicita()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRequisicion(List<Requisicion> requisicionsTemp) throws Exception {
		for(Requisicion requisicionAux:requisicionsTemp) {
			
			requisicionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(requisicionAux.getEmpresa()));
			requisicionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(requisicionAux.getSucursal()));
			requisicionAux.settiporequisicion_descripcion(TipoRequisicionConstantesFunciones.getTipoRequisicionDescripcion(requisicionAux.getTipoRequisicion()));
			requisicionAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(requisicionAux.getEmpleado()));
			requisicionAux.setestadorequisicion_descripcion(EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(requisicionAux.getEstadoRequisicion()));
			requisicionAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(requisicionAux.getFormato()));
			requisicionAux.setbodegasolicitar_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(requisicionAux.getBodegaSolicitar()));
			requisicionAux.setbodegasolicita_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(requisicionAux.getBodegaSolicita()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoRequisicion.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(EstadoRequisicion.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Bodega.class));
				
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
					if(clas.clas.equals(TipoRequisicion.class)) {
						classes.add(new Classe(TipoRequisicion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoRequisicion.class)) {
						classes.add(new Classe(EstadoRequisicion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRequisicion.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRequisicion.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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

					if(TipoRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRequisicion.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRequisicion.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RequisicionConstantesFunciones.getClassesRelationshipsOfRequisicion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleRequisicion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleRequisicion.class)) {
						classes.add(new Classe(DetalleRequisicion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RequisicionConstantesFunciones.getClassesRelationshipsFromStringsOfRequisicion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRequisicion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRequisicion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRequisicion.class)); continue;
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
	public static void actualizarLista(Requisicion requisicion,List<Requisicion> requisicions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Requisicion requisicionEncontrado=null;
			
			for(Requisicion requisicionLocal:requisicions) {
				if(requisicionLocal.getId().equals(requisicion.getId())) {
					requisicionEncontrado=requisicionLocal;
					
					requisicionLocal.setIsChanged(requisicion.getIsChanged());
					requisicionLocal.setIsNew(requisicion.getIsNew());
					requisicionLocal.setIsDeleted(requisicion.getIsDeleted());
					
					requisicionLocal.setGeneralEntityOriginal(requisicion.getGeneralEntityOriginal());
					
					requisicionLocal.setId(requisicion.getId());	
					requisicionLocal.setVersionRow(requisicion.getVersionRow());	
					requisicionLocal.setid_empresa(requisicion.getid_empresa());	
					requisicionLocal.setid_sucursal(requisicion.getid_sucursal());	
					requisicionLocal.setnumero_secuencial(requisicion.getnumero_secuencial());	
					requisicionLocal.setid_tipo_requisicion(requisicion.getid_tipo_requisicion());	
					requisicionLocal.setfecha(requisicion.getfecha());	
					requisicionLocal.sethora(requisicion.gethora());	
					requisicionLocal.setid_empleado(requisicion.getid_empleado());	
					requisicionLocal.setid_estado_requisicion(requisicion.getid_estado_requisicion());	
					requisicionLocal.setid_formato(requisicion.getid_formato());	
					requisicionLocal.setid_bodega_solicitar(requisicion.getid_bodega_solicitar());	
					requisicionLocal.setdescripcion(requisicion.getdescripcion());	
					requisicionLocal.setid_bodega_solicita(requisicion.getid_bodega_solicita());	
					
					
					requisicionLocal.setDetalleRequisicions(requisicion.getDetalleRequisicions());
					
					existe=true;
					break;
				}
			}
			
			if(!requisicion.getIsDeleted()) {
				if(!existe) {
					requisicions.add(requisicion);
				}
			} else {
				if(requisicionEncontrado!=null && permiteQuitar)  {
					requisicions.remove(requisicionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Requisicion requisicion,List<Requisicion> requisicions) throws Exception {
		try	{			
			for(Requisicion requisicionLocal:requisicions) {
				if(requisicionLocal.getId().equals(requisicion.getId())) {
					requisicionLocal.setIsSelected(requisicion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRequisicion(List<Requisicion> requisicionsAux) throws Exception {
		//this.requisicionsAux=requisicionsAux;
		
		for(Requisicion requisicionAux:requisicionsAux) {
			if(requisicionAux.getIsChanged()) {
				requisicionAux.setIsChanged(false);
			}		
			
			if(requisicionAux.getIsNew()) {
				requisicionAux.setIsNew(false);
			}	
			
			if(requisicionAux.getIsDeleted()) {
				requisicionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRequisicion(Requisicion requisicionAux) throws Exception {
		//this.requisicionAux=requisicionAux;
		
			if(requisicionAux.getIsChanged()) {
				requisicionAux.setIsChanged(false);
			}		
			
			if(requisicionAux.getIsNew()) {
				requisicionAux.setIsNew(false);
			}	
			
			if(requisicionAux.getIsDeleted()) {
				requisicionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Requisicion requisicionAsignar,Requisicion requisicion) throws Exception {
		requisicionAsignar.setId(requisicion.getId());	
		requisicionAsignar.setVersionRow(requisicion.getVersionRow());	
		requisicionAsignar.setid_empresa(requisicion.getid_empresa());
		requisicionAsignar.setempresa_descripcion(requisicion.getempresa_descripcion());	
		requisicionAsignar.setid_sucursal(requisicion.getid_sucursal());
		requisicionAsignar.setsucursal_descripcion(requisicion.getsucursal_descripcion());	
		requisicionAsignar.setnumero_secuencial(requisicion.getnumero_secuencial());	
		requisicionAsignar.setid_tipo_requisicion(requisicion.getid_tipo_requisicion());
		requisicionAsignar.settiporequisicion_descripcion(requisicion.gettiporequisicion_descripcion());	
		requisicionAsignar.setfecha(requisicion.getfecha());	
		requisicionAsignar.sethora(requisicion.gethora());	
		requisicionAsignar.setid_empleado(requisicion.getid_empleado());
		requisicionAsignar.setempleado_descripcion(requisicion.getempleado_descripcion());	
		requisicionAsignar.setid_estado_requisicion(requisicion.getid_estado_requisicion());
		requisicionAsignar.setestadorequisicion_descripcion(requisicion.getestadorequisicion_descripcion());	
		requisicionAsignar.setid_formato(requisicion.getid_formato());
		requisicionAsignar.setformato_descripcion(requisicion.getformato_descripcion());	
		requisicionAsignar.setid_bodega_solicitar(requisicion.getid_bodega_solicitar());
		requisicionAsignar.setbodegasolicitar_descripcion(requisicion.getbodegasolicitar_descripcion());	
		requisicionAsignar.setdescripcion(requisicion.getdescripcion());	
		requisicionAsignar.setid_bodega_solicita(requisicion.getid_bodega_solicita());
		requisicionAsignar.setbodegasolicita_descripcion(requisicion.getbodegasolicita_descripcion());	
	}
	
	public static void inicializarRequisicion(Requisicion requisicion) throws Exception {
		try {
				requisicion.setId(0L);	
					
				requisicion.setid_empresa(-1L);	
				requisicion.setid_sucursal(-1L);	
				requisicion.setnumero_secuencial("");	
				requisicion.setid_tipo_requisicion(-1L);	
				requisicion.setfecha(new Date());	
				requisicion.sethora(new Time((new Date()).getTime()));	
				requisicion.setid_empleado(-1L);	
				requisicion.setid_estado_requisicion(-1L);	
				requisicion.setid_formato(-1L);	
				requisicion.setid_bodega_solicitar(-1L);	
				requisicion.setdescripcion("");	
				requisicion.setid_bodega_solicita(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRequisicion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDTIPOREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDESTADOREQUISICION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionConstantesFunciones.LABEL_IDBODEGASOLICITA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRequisicion(String sTipo,Row row,Workbook workbook,Requisicion requisicion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.gettiporequisicion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getestadorequisicion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getbodegasolicitar_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicion.getbodegasolicita_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRequisicion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRequisicion() {
		return this.sFinalQueryRequisicion;
	}
	
	public void setsFinalQueryRequisicion(String sFinalQueryRequisicion) {
		this.sFinalQueryRequisicion= sFinalQueryRequisicion;
	}
	
	public Border resaltarSeleccionarRequisicion=null;
	
	public Border setResaltarSeleccionarRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRequisicion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRequisicion() {
		return this.resaltarSeleccionarRequisicion;
	}
	
	public void setResaltarSeleccionarRequisicion(Border borderResaltarSeleccionarRequisicion) {
		this.resaltarSeleccionarRequisicion= borderResaltarSeleccionarRequisicion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRequisicion=null;
	public Boolean mostraridRequisicion=true;
	public Boolean activaridRequisicion=true;

	public Border resaltarid_empresaRequisicion=null;
	public Boolean mostrarid_empresaRequisicion=true;
	public Boolean activarid_empresaRequisicion=true;
	public Boolean cargarid_empresaRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRequisicion=false;//ConEventDepend=true

	public Border resaltarid_sucursalRequisicion=null;
	public Boolean mostrarid_sucursalRequisicion=true;
	public Boolean activarid_sucursalRequisicion=true;
	public Boolean cargarid_sucursalRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRequisicion=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialRequisicion=null;
	public Boolean mostrarnumero_secuencialRequisicion=true;
	public Boolean activarnumero_secuencialRequisicion=true;

	public Border resaltarid_tipo_requisicionRequisicion=null;
	public Boolean mostrarid_tipo_requisicionRequisicion=true;
	public Boolean activarid_tipo_requisicionRequisicion=true;
	public Boolean cargarid_tipo_requisicionRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_requisicionRequisicion=false;//ConEventDepend=true

	public Border resaltarfechaRequisicion=null;
	public Boolean mostrarfechaRequisicion=true;
	public Boolean activarfechaRequisicion=true;

	public Border resaltarhoraRequisicion=null;
	public Boolean mostrarhoraRequisicion=true;
	public Boolean activarhoraRequisicion=true;

	public Border resaltarid_empleadoRequisicion=null;
	public Boolean mostrarid_empleadoRequisicion=true;
	public Boolean activarid_empleadoRequisicion=true;
	public Boolean cargarid_empleadoRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoRequisicion=false;//ConEventDepend=true

	public Border resaltarid_estado_requisicionRequisicion=null;
	public Boolean mostrarid_estado_requisicionRequisicion=true;
	public Boolean activarid_estado_requisicionRequisicion=true;
	public Boolean cargarid_estado_requisicionRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_requisicionRequisicion=false;//ConEventDepend=true

	public Border resaltarid_formatoRequisicion=null;
	public Boolean mostrarid_formatoRequisicion=true;
	public Boolean activarid_formatoRequisicion=true;
	public Boolean cargarid_formatoRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoRequisicion=false;//ConEventDepend=true

	public Border resaltarid_bodega_solicitarRequisicion=null;
	public Boolean mostrarid_bodega_solicitarRequisicion=true;
	public Boolean activarid_bodega_solicitarRequisicion=true;
	public Boolean cargarid_bodega_solicitarRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_solicitarRequisicion=false;//ConEventDepend=true

	public Border resaltardescripcionRequisicion=null;
	public Boolean mostrardescripcionRequisicion=true;
	public Boolean activardescripcionRequisicion=true;

	public Border resaltarid_bodega_solicitaRequisicion=null;
	public Boolean mostrarid_bodega_solicitaRequisicion=true;
	public Boolean activarid_bodega_solicitaRequisicion=true;
	public Boolean cargarid_bodega_solicitaRequisicion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_solicitaRequisicion=false;//ConEventDepend=true

	
	

	public Border setResaltaridRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltaridRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRequisicion() {
		return this.resaltaridRequisicion;
	}

	public void setResaltaridRequisicion(Border borderResaltar) {
		this.resaltaridRequisicion= borderResaltar;
	}

	public Boolean getMostraridRequisicion() {
		return this.mostraridRequisicion;
	}

	public void setMostraridRequisicion(Boolean mostraridRequisicion) {
		this.mostraridRequisicion= mostraridRequisicion;
	}

	public Boolean getActivaridRequisicion() {
		return this.activaridRequisicion;
	}

	public void setActivaridRequisicion(Boolean activaridRequisicion) {
		this.activaridRequisicion= activaridRequisicion;
	}

	public Border setResaltarid_empresaRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_empresaRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRequisicion() {
		return this.resaltarid_empresaRequisicion;
	}

	public void setResaltarid_empresaRequisicion(Border borderResaltar) {
		this.resaltarid_empresaRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_empresaRequisicion() {
		return this.mostrarid_empresaRequisicion;
	}

	public void setMostrarid_empresaRequisicion(Boolean mostrarid_empresaRequisicion) {
		this.mostrarid_empresaRequisicion= mostrarid_empresaRequisicion;
	}

	public Boolean getActivarid_empresaRequisicion() {
		return this.activarid_empresaRequisicion;
	}

	public void setActivarid_empresaRequisicion(Boolean activarid_empresaRequisicion) {
		this.activarid_empresaRequisicion= activarid_empresaRequisicion;
	}

	public Boolean getCargarid_empresaRequisicion() {
		return this.cargarid_empresaRequisicion;
	}

	public void setCargarid_empresaRequisicion(Boolean cargarid_empresaRequisicion) {
		this.cargarid_empresaRequisicion= cargarid_empresaRequisicion;
	}

	public Border setResaltarid_sucursalRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRequisicion() {
		return this.resaltarid_sucursalRequisicion;
	}

	public void setResaltarid_sucursalRequisicion(Border borderResaltar) {
		this.resaltarid_sucursalRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRequisicion() {
		return this.mostrarid_sucursalRequisicion;
	}

	public void setMostrarid_sucursalRequisicion(Boolean mostrarid_sucursalRequisicion) {
		this.mostrarid_sucursalRequisicion= mostrarid_sucursalRequisicion;
	}

	public Boolean getActivarid_sucursalRequisicion() {
		return this.activarid_sucursalRequisicion;
	}

	public void setActivarid_sucursalRequisicion(Boolean activarid_sucursalRequisicion) {
		this.activarid_sucursalRequisicion= activarid_sucursalRequisicion;
	}

	public Boolean getCargarid_sucursalRequisicion() {
		return this.cargarid_sucursalRequisicion;
	}

	public void setCargarid_sucursalRequisicion(Boolean cargarid_sucursalRequisicion) {
		this.cargarid_sucursalRequisicion= cargarid_sucursalRequisicion;
	}

	public Border setResaltarnumero_secuencialRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialRequisicion() {
		return this.resaltarnumero_secuencialRequisicion;
	}

	public void setResaltarnumero_secuencialRequisicion(Border borderResaltar) {
		this.resaltarnumero_secuencialRequisicion= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialRequisicion() {
		return this.mostrarnumero_secuencialRequisicion;
	}

	public void setMostrarnumero_secuencialRequisicion(Boolean mostrarnumero_secuencialRequisicion) {
		this.mostrarnumero_secuencialRequisicion= mostrarnumero_secuencialRequisicion;
	}

	public Boolean getActivarnumero_secuencialRequisicion() {
		return this.activarnumero_secuencialRequisicion;
	}

	public void setActivarnumero_secuencialRequisicion(Boolean activarnumero_secuencialRequisicion) {
		this.activarnumero_secuencialRequisicion= activarnumero_secuencialRequisicion;
	}

	public Border setResaltarid_tipo_requisicionRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_tipo_requisicionRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_requisicionRequisicion() {
		return this.resaltarid_tipo_requisicionRequisicion;
	}

	public void setResaltarid_tipo_requisicionRequisicion(Border borderResaltar) {
		this.resaltarid_tipo_requisicionRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_tipo_requisicionRequisicion() {
		return this.mostrarid_tipo_requisicionRequisicion;
	}

	public void setMostrarid_tipo_requisicionRequisicion(Boolean mostrarid_tipo_requisicionRequisicion) {
		this.mostrarid_tipo_requisicionRequisicion= mostrarid_tipo_requisicionRequisicion;
	}

	public Boolean getActivarid_tipo_requisicionRequisicion() {
		return this.activarid_tipo_requisicionRequisicion;
	}

	public void setActivarid_tipo_requisicionRequisicion(Boolean activarid_tipo_requisicionRequisicion) {
		this.activarid_tipo_requisicionRequisicion= activarid_tipo_requisicionRequisicion;
	}

	public Boolean getCargarid_tipo_requisicionRequisicion() {
		return this.cargarid_tipo_requisicionRequisicion;
	}

	public void setCargarid_tipo_requisicionRequisicion(Boolean cargarid_tipo_requisicionRequisicion) {
		this.cargarid_tipo_requisicionRequisicion= cargarid_tipo_requisicionRequisicion;
	}

	public Border setResaltarfechaRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarfechaRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaRequisicion() {
		return this.resaltarfechaRequisicion;
	}

	public void setResaltarfechaRequisicion(Border borderResaltar) {
		this.resaltarfechaRequisicion= borderResaltar;
	}

	public Boolean getMostrarfechaRequisicion() {
		return this.mostrarfechaRequisicion;
	}

	public void setMostrarfechaRequisicion(Boolean mostrarfechaRequisicion) {
		this.mostrarfechaRequisicion= mostrarfechaRequisicion;
	}

	public Boolean getActivarfechaRequisicion() {
		return this.activarfechaRequisicion;
	}

	public void setActivarfechaRequisicion(Boolean activarfechaRequisicion) {
		this.activarfechaRequisicion= activarfechaRequisicion;
	}

	public Border setResaltarhoraRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarhoraRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraRequisicion() {
		return this.resaltarhoraRequisicion;
	}

	public void setResaltarhoraRequisicion(Border borderResaltar) {
		this.resaltarhoraRequisicion= borderResaltar;
	}

	public Boolean getMostrarhoraRequisicion() {
		return this.mostrarhoraRequisicion;
	}

	public void setMostrarhoraRequisicion(Boolean mostrarhoraRequisicion) {
		this.mostrarhoraRequisicion= mostrarhoraRequisicion;
	}

	public Boolean getActivarhoraRequisicion() {
		return this.activarhoraRequisicion;
	}

	public void setActivarhoraRequisicion(Boolean activarhoraRequisicion) {
		this.activarhoraRequisicion= activarhoraRequisicion;
	}

	public Border setResaltarid_empleadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_empleadoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoRequisicion() {
		return this.resaltarid_empleadoRequisicion;
	}

	public void setResaltarid_empleadoRequisicion(Border borderResaltar) {
		this.resaltarid_empleadoRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_empleadoRequisicion() {
		return this.mostrarid_empleadoRequisicion;
	}

	public void setMostrarid_empleadoRequisicion(Boolean mostrarid_empleadoRequisicion) {
		this.mostrarid_empleadoRequisicion= mostrarid_empleadoRequisicion;
	}

	public Boolean getActivarid_empleadoRequisicion() {
		return this.activarid_empleadoRequisicion;
	}

	public void setActivarid_empleadoRequisicion(Boolean activarid_empleadoRequisicion) {
		this.activarid_empleadoRequisicion= activarid_empleadoRequisicion;
	}

	public Boolean getCargarid_empleadoRequisicion() {
		return this.cargarid_empleadoRequisicion;
	}

	public void setCargarid_empleadoRequisicion(Boolean cargarid_empleadoRequisicion) {
		this.cargarid_empleadoRequisicion= cargarid_empleadoRequisicion;
	}

	public Border setResaltarid_estado_requisicionRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_estado_requisicionRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_requisicionRequisicion() {
		return this.resaltarid_estado_requisicionRequisicion;
	}

	public void setResaltarid_estado_requisicionRequisicion(Border borderResaltar) {
		this.resaltarid_estado_requisicionRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_estado_requisicionRequisicion() {
		return this.mostrarid_estado_requisicionRequisicion;
	}

	public void setMostrarid_estado_requisicionRequisicion(Boolean mostrarid_estado_requisicionRequisicion) {
		this.mostrarid_estado_requisicionRequisicion= mostrarid_estado_requisicionRequisicion;
	}

	public Boolean getActivarid_estado_requisicionRequisicion() {
		return this.activarid_estado_requisicionRequisicion;
	}

	public void setActivarid_estado_requisicionRequisicion(Boolean activarid_estado_requisicionRequisicion) {
		this.activarid_estado_requisicionRequisicion= activarid_estado_requisicionRequisicion;
	}

	public Boolean getCargarid_estado_requisicionRequisicion() {
		return this.cargarid_estado_requisicionRequisicion;
	}

	public void setCargarid_estado_requisicionRequisicion(Boolean cargarid_estado_requisicionRequisicion) {
		this.cargarid_estado_requisicionRequisicion= cargarid_estado_requisicionRequisicion;
	}

	public Border setResaltarid_formatoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_formatoRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoRequisicion() {
		return this.resaltarid_formatoRequisicion;
	}

	public void setResaltarid_formatoRequisicion(Border borderResaltar) {
		this.resaltarid_formatoRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_formatoRequisicion() {
		return this.mostrarid_formatoRequisicion;
	}

	public void setMostrarid_formatoRequisicion(Boolean mostrarid_formatoRequisicion) {
		this.mostrarid_formatoRequisicion= mostrarid_formatoRequisicion;
	}

	public Boolean getActivarid_formatoRequisicion() {
		return this.activarid_formatoRequisicion;
	}

	public void setActivarid_formatoRequisicion(Boolean activarid_formatoRequisicion) {
		this.activarid_formatoRequisicion= activarid_formatoRequisicion;
	}

	public Boolean getCargarid_formatoRequisicion() {
		return this.cargarid_formatoRequisicion;
	}

	public void setCargarid_formatoRequisicion(Boolean cargarid_formatoRequisicion) {
		this.cargarid_formatoRequisicion= cargarid_formatoRequisicion;
	}

	public Border setResaltarid_bodega_solicitarRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_bodega_solicitarRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_solicitarRequisicion() {
		return this.resaltarid_bodega_solicitarRequisicion;
	}

	public void setResaltarid_bodega_solicitarRequisicion(Border borderResaltar) {
		this.resaltarid_bodega_solicitarRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_bodega_solicitarRequisicion() {
		return this.mostrarid_bodega_solicitarRequisicion;
	}

	public void setMostrarid_bodega_solicitarRequisicion(Boolean mostrarid_bodega_solicitarRequisicion) {
		this.mostrarid_bodega_solicitarRequisicion= mostrarid_bodega_solicitarRequisicion;
	}

	public Boolean getActivarid_bodega_solicitarRequisicion() {
		return this.activarid_bodega_solicitarRequisicion;
	}

	public void setActivarid_bodega_solicitarRequisicion(Boolean activarid_bodega_solicitarRequisicion) {
		this.activarid_bodega_solicitarRequisicion= activarid_bodega_solicitarRequisicion;
	}

	public Boolean getCargarid_bodega_solicitarRequisicion() {
		return this.cargarid_bodega_solicitarRequisicion;
	}

	public void setCargarid_bodega_solicitarRequisicion(Boolean cargarid_bodega_solicitarRequisicion) {
		this.cargarid_bodega_solicitarRequisicion= cargarid_bodega_solicitarRequisicion;
	}

	public Border setResaltardescripcionRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltardescripcionRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionRequisicion() {
		return this.resaltardescripcionRequisicion;
	}

	public void setResaltardescripcionRequisicion(Border borderResaltar) {
		this.resaltardescripcionRequisicion= borderResaltar;
	}

	public Boolean getMostrardescripcionRequisicion() {
		return this.mostrardescripcionRequisicion;
	}

	public void setMostrardescripcionRequisicion(Boolean mostrardescripcionRequisicion) {
		this.mostrardescripcionRequisicion= mostrardescripcionRequisicion;
	}

	public Boolean getActivardescripcionRequisicion() {
		return this.activardescripcionRequisicion;
	}

	public void setActivardescripcionRequisicion(Boolean activardescripcionRequisicion) {
		this.activardescripcionRequisicion= activardescripcionRequisicion;
	}

	public Border setResaltarid_bodega_solicitaRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltar);
		
		this.resaltarid_bodega_solicitaRequisicion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_solicitaRequisicion() {
		return this.resaltarid_bodega_solicitaRequisicion;
	}

	public void setResaltarid_bodega_solicitaRequisicion(Border borderResaltar) {
		this.resaltarid_bodega_solicitaRequisicion= borderResaltar;
	}

	public Boolean getMostrarid_bodega_solicitaRequisicion() {
		return this.mostrarid_bodega_solicitaRequisicion;
	}

	public void setMostrarid_bodega_solicitaRequisicion(Boolean mostrarid_bodega_solicitaRequisicion) {
		this.mostrarid_bodega_solicitaRequisicion= mostrarid_bodega_solicitaRequisicion;
	}

	public Boolean getActivarid_bodega_solicitaRequisicion() {
		return this.activarid_bodega_solicitaRequisicion;
	}

	public void setActivarid_bodega_solicitaRequisicion(Boolean activarid_bodega_solicitaRequisicion) {
		this.activarid_bodega_solicitaRequisicion= activarid_bodega_solicitaRequisicion;
	}

	public Boolean getCargarid_bodega_solicitaRequisicion() {
		return this.cargarid_bodega_solicitaRequisicion;
	}

	public void setCargarid_bodega_solicitaRequisicion(Boolean cargarid_bodega_solicitaRequisicion) {
		this.cargarid_bodega_solicitaRequisicion= cargarid_bodega_solicitaRequisicion;
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
		
		
		this.setMostraridRequisicion(esInicial);
		this.setMostrarid_empresaRequisicion(esInicial);
		this.setMostrarid_sucursalRequisicion(esInicial);
		this.setMostrarnumero_secuencialRequisicion(esInicial);
		this.setMostrarid_tipo_requisicionRequisicion(esInicial);
		this.setMostrarfechaRequisicion(esInicial);
		this.setMostrarhoraRequisicion(esInicial);
		this.setMostrarid_empleadoRequisicion(esInicial);
		this.setMostrarid_estado_requisicionRequisicion(esInicial);
		this.setMostrarid_formatoRequisicion(esInicial);
		this.setMostrarid_bodega_solicitarRequisicion(esInicial);
		this.setMostrardescripcionRequisicion(esInicial);
		this.setMostrarid_bodega_solicitaRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RequisicionConstantesFunciones.ID)) {
				this.setMostraridRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDTIPOREQUISICION)) {
				this.setMostrarid_tipo_requisicionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.FECHA)) {
				this.setMostrarfechaRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.HORA)) {
				this.setMostrarhoraRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDESTADOREQUISICION)) {
				this.setMostrarid_estado_requisicionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDBODEGASOLICITAR)) {
				this.setMostrarid_bodega_solicitarRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDBODEGASOLICITA)) {
				this.setMostrarid_bodega_solicitaRequisicion(esAsigna);
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
		
		
		this.setActivaridRequisicion(esInicial);
		this.setActivarid_empresaRequisicion(esInicial);
		this.setActivarid_sucursalRequisicion(esInicial);
		this.setActivarnumero_secuencialRequisicion(esInicial);
		this.setActivarid_tipo_requisicionRequisicion(esInicial);
		this.setActivarfechaRequisicion(esInicial);
		this.setActivarhoraRequisicion(esInicial);
		this.setActivarid_empleadoRequisicion(esInicial);
		this.setActivarid_estado_requisicionRequisicion(esInicial);
		this.setActivarid_formatoRequisicion(esInicial);
		this.setActivarid_bodega_solicitarRequisicion(esInicial);
		this.setActivardescripcionRequisicion(esInicial);
		this.setActivarid_bodega_solicitaRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RequisicionConstantesFunciones.ID)) {
				this.setActivaridRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDTIPOREQUISICION)) {
				this.setActivarid_tipo_requisicionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.FECHA)) {
				this.setActivarfechaRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.HORA)) {
				this.setActivarhoraRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDESTADOREQUISICION)) {
				this.setActivarid_estado_requisicionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDBODEGASOLICITAR)) {
				this.setActivarid_bodega_solicitarRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDBODEGASOLICITA)) {
				this.setActivarid_bodega_solicitaRequisicion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRequisicion(esInicial);
		this.setResaltarid_empresaRequisicion(esInicial);
		this.setResaltarid_sucursalRequisicion(esInicial);
		this.setResaltarnumero_secuencialRequisicion(esInicial);
		this.setResaltarid_tipo_requisicionRequisicion(esInicial);
		this.setResaltarfechaRequisicion(esInicial);
		this.setResaltarhoraRequisicion(esInicial);
		this.setResaltarid_empleadoRequisicion(esInicial);
		this.setResaltarid_estado_requisicionRequisicion(esInicial);
		this.setResaltarid_formatoRequisicion(esInicial);
		this.setResaltarid_bodega_solicitarRequisicion(esInicial);
		this.setResaltardescripcionRequisicion(esInicial);
		this.setResaltarid_bodega_solicitaRequisicion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RequisicionConstantesFunciones.ID)) {
				this.setResaltaridRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDTIPOREQUISICION)) {
				this.setResaltarid_tipo_requisicionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.FECHA)) {
				this.setResaltarfechaRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.HORA)) {
				this.setResaltarhoraRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDESTADOREQUISICION)) {
				this.setResaltarid_estado_requisicionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDBODEGASOLICITAR)) {
				this.setResaltarid_bodega_solicitarRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionRequisicion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionConstantesFunciones.IDBODEGASOLICITA)) {
				this.setResaltarid_bodega_solicitaRequisicion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleRequisicionRequisicion=null;

	public Border getResaltarDetalleRequisicionRequisicion() {
		return this.resaltarDetalleRequisicionRequisicion;
	}

	public void setResaltarDetalleRequisicionRequisicion(Border borderResaltarDetalleRequisicion) {
		if(borderResaltarDetalleRequisicion!=null) {
			this.resaltarDetalleRequisicionRequisicion= borderResaltarDetalleRequisicion;
		}
	}

	public Border setResaltarDetalleRequisicionRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleRequisicion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//requisicionBeanSwingJInternalFrame.jTtoolBarRequisicion.setBorder(borderResaltarDetalleRequisicion);
			
		this.resaltarDetalleRequisicionRequisicion= borderResaltarDetalleRequisicion;

		 return borderResaltarDetalleRequisicion;
	}



	public Boolean mostrarDetalleRequisicionRequisicion=true;

	public Boolean getMostrarDetalleRequisicionRequisicion() {
		return this.mostrarDetalleRequisicionRequisicion;
	}

	public void setMostrarDetalleRequisicionRequisicion(Boolean visibilidadResaltarDetalleRequisicion) {
		this.mostrarDetalleRequisicionRequisicion= visibilidadResaltarDetalleRequisicion;
	}



	public Boolean activarDetalleRequisicionRequisicion=true;

	public Boolean gethabilitarResaltarDetalleRequisicionRequisicion() {
		return this.activarDetalleRequisicionRequisicion;
	}

	public void setActivarDetalleRequisicionRequisicion(Boolean habilitarResaltarDetalleRequisicion) {
		this.activarDetalleRequisicionRequisicion= habilitarResaltarDetalleRequisicion;
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

		this.setMostrarDetalleRequisicionRequisicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRequisicion.class)) {
				this.setMostrarDetalleRequisicionRequisicion(esAsigna);
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

		this.setActivarDetalleRequisicionRequisicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRequisicion.class)) {
				this.setActivarDetalleRequisicionRequisicion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleRequisicionRequisicion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRequisicion.class)) {
				this.setResaltarDetalleRequisicionRequisicion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoRequisicion=true;

	public Boolean getMostrarBusquedaPorCodigoRequisicion() {
		return this.mostrarBusquedaPorCodigoRequisicion;
	}

	public void setMostrarBusquedaPorCodigoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaSolicitaRequisicion=true;

	public Boolean getMostrarFK_IdBodegaSolicitaRequisicion() {
		return this.mostrarFK_IdBodegaSolicitaRequisicion;
	}

	public void setMostrarFK_IdBodegaSolicitaRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaSolicitaRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaSolicitarRequisicion=true;

	public Boolean getMostrarFK_IdBodegaSolicitarRequisicion() {
		return this.mostrarFK_IdBodegaSolicitarRequisicion;
	}

	public void setMostrarFK_IdBodegaSolicitarRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaSolicitarRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoRequisicion=true;

	public Boolean getMostrarFK_IdEmpleadoRequisicion() {
		return this.mostrarFK_IdEmpleadoRequisicion;
	}

	public void setMostrarFK_IdEmpleadoRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRequisicion=true;

	public Boolean getMostrarFK_IdEmpresaRequisicion() {
		return this.mostrarFK_IdEmpresaRequisicion;
	}

	public void setMostrarFK_IdEmpresaRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRequisicion=true;

	public Boolean getMostrarFK_IdSucursalRequisicion() {
		return this.mostrarFK_IdSucursalRequisicion;
	}

	public void setMostrarFK_IdSucursalRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRequisicion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRequisicionRequisicion=true;

	public Boolean getMostrarFK_IdTipoRequisicionRequisicion() {
		return this.mostrarFK_IdTipoRequisicionRequisicion;
	}

	public void setMostrarFK_IdTipoRequisicionRequisicion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRequisicionRequisicion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoRequisicion=true;

	public Boolean getActivarBusquedaPorCodigoRequisicion() {
		return this.activarBusquedaPorCodigoRequisicion;
	}

	public void setActivarBusquedaPorCodigoRequisicion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaSolicitaRequisicion=true;

	public Boolean getActivarFK_IdBodegaSolicitaRequisicion() {
		return this.activarFK_IdBodegaSolicitaRequisicion;
	}

	public void setActivarFK_IdBodegaSolicitaRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaSolicitaRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaSolicitarRequisicion=true;

	public Boolean getActivarFK_IdBodegaSolicitarRequisicion() {
		return this.activarFK_IdBodegaSolicitarRequisicion;
	}

	public void setActivarFK_IdBodegaSolicitarRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaSolicitarRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoRequisicion=true;

	public Boolean getActivarFK_IdEmpleadoRequisicion() {
		return this.activarFK_IdEmpleadoRequisicion;
	}

	public void setActivarFK_IdEmpleadoRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRequisicion=true;

	public Boolean getActivarFK_IdEmpresaRequisicion() {
		return this.activarFK_IdEmpresaRequisicion;
	}

	public void setActivarFK_IdEmpresaRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRequisicion=true;

	public Boolean getActivarFK_IdSucursalRequisicion() {
		return this.activarFK_IdSucursalRequisicion;
	}

	public void setActivarFK_IdSucursalRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRequisicion= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRequisicionRequisicion=true;

	public Boolean getActivarFK_IdTipoRequisicionRequisicion() {
		return this.activarFK_IdTipoRequisicionRequisicion;
	}

	public void setActivarFK_IdTipoRequisicionRequisicion(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRequisicionRequisicion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoRequisicion=null;

	public Border getResaltarBusquedaPorCodigoRequisicion() {
		return this.resaltarBusquedaPorCodigoRequisicion;
	}

	public void setResaltarBusquedaPorCodigoRequisicion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoRequisicion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdBodegaSolicitaRequisicion=null;

	public Border getResaltarFK_IdBodegaSolicitaRequisicion() {
		return this.resaltarFK_IdBodegaSolicitaRequisicion;
	}

	public void setResaltarFK_IdBodegaSolicitaRequisicion(Border borderResaltar) {
		this.resaltarFK_IdBodegaSolicitaRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdBodegaSolicitaRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaSolicitaRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdBodegaSolicitarRequisicion=null;

	public Border getResaltarFK_IdBodegaSolicitarRequisicion() {
		return this.resaltarFK_IdBodegaSolicitarRequisicion;
	}

	public void setResaltarFK_IdBodegaSolicitarRequisicion(Border borderResaltar) {
		this.resaltarFK_IdBodegaSolicitarRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdBodegaSolicitarRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaSolicitarRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoRequisicion=null;

	public Border getResaltarFK_IdEmpleadoRequisicion() {
		return this.resaltarFK_IdEmpleadoRequisicion;
	}

	public void setResaltarFK_IdEmpleadoRequisicion(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRequisicion=null;

	public Border getResaltarFK_IdEmpresaRequisicion() {
		return this.resaltarFK_IdEmpresaRequisicion;
	}

	public void setResaltarFK_IdEmpresaRequisicion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRequisicion=null;

	public Border getResaltarFK_IdSucursalRequisicion() {
		return this.resaltarFK_IdSucursalRequisicion;
	}

	public void setResaltarFK_IdSucursalRequisicion(Border borderResaltar) {
		this.resaltarFK_IdSucursalRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRequisicion= borderResaltar;
	}

	public Border resaltarFK_IdTipoRequisicionRequisicion=null;

	public Border getResaltarFK_IdTipoRequisicionRequisicion() {
		return this.resaltarFK_IdTipoRequisicionRequisicion;
	}

	public void setResaltarFK_IdTipoRequisicionRequisicion(Border borderResaltar) {
		this.resaltarFK_IdTipoRequisicionRequisicion= borderResaltar;
	}

	public void setResaltarFK_IdTipoRequisicionRequisicion(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionBeanSwingJInternalFrame requisicionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRequisicionRequisicion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}