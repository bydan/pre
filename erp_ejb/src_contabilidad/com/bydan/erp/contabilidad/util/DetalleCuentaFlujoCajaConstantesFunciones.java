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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleCuentaFlujoCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleCuentaFlujoCajaConstantesFunciones extends DetalleCuentaFlujoCajaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleCuentaFlujoCaja";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleCuentaFlujoCaja"+DetalleCuentaFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleCuentaFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleCuentaFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleCuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"_"+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleCuentaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleCuentaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleCuentaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleCuentaFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleCuentaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleCuentaFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Cuenta Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Cuenta Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Cuenta Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleCuentaFlujoCaja";
	public static final String OBJECTNAME="detallecuentaflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="detalle_cuenta_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallecuentaflujocaja from "+DetalleCuentaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" detallecuentaflujocaja";
	public static String QUERYSELECTNATIVE="select "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id_tipo_operacion,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_flujo_caja,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME+".esta_activo from "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+"."+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+DetalleCuentaFlujoCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleCuentaFlujoCajaConstantesFuncionesAdditional detallecuentaflujocajaConstantesFuncionesAdditional=null;
	
	public DetalleCuentaFlujoCajaConstantesFuncionesAdditional getDetalleCuentaFlujoCajaConstantesFuncionesAdditional() {
		return this.detallecuentaflujocajaConstantesFuncionesAdditional;
	}
	
	public void setDetalleCuentaFlujoCajaConstantesFuncionesAdditional(DetalleCuentaFlujoCajaConstantesFuncionesAdditional detallecuentaflujocajaConstantesFuncionesAdditional) {
		try {
			this.detallecuentaflujocajaConstantesFuncionesAdditional=detallecuentaflujocajaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDTIPOOPERACION= "id_tipo_operacion";
    public static final String IDCUENTAFLUJOCAJA= "id_cuenta_flujo_caja";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDTIPOOPERACION= "Tipo Operacion";
		public static final String LABEL_IDTIPOOPERACION_LOWER= "Tipo Operacion";
    	public static final String LABEL_IDCUENTAFLUJOCAJA= "Cuenta Flujo Caja";
		public static final String LABEL_IDCUENTAFLUJOCAJA_LOWER= "Cuenta Flujo Caja";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
	
	public static String getDetalleCuentaFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION)) {sLabelColumna=DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDTIPOOPERACION;}
		if(sNombreColumna.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA)) {sLabelColumna=DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTAFLUJOCAJA;}
		if(sNombreColumna.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=DetalleCuentaFlujoCajaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getesta_activoDescripcion(DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detallecuentaflujocaja.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detallecuentaflujocaja.getId(),detallecuentaflujocaja.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getDetalleCuentaFlujoCajaDescripcion(DetalleCuentaFlujoCaja detallecuentaflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallecuentaflujocaja !=null/* && detallecuentaflujocaja.getId()!=0*/) {
			if(detallecuentaflujocaja.getId()!=null) {
				sDescripcion=detallecuentaflujocaja.getId().toString();
			}//detallecuentaflujocajadetallecuentaflujocaja.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleCuentaFlujoCajaDescripcionDetallado(DetalleCuentaFlujoCaja detallecuentaflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=DetalleCuentaFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=detallecuentaflujocaja.getId().toString()+",";
		sDescripcion+=DetalleCuentaFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallecuentaflujocaja.getVersionRow().toString()+",";
		sDescripcion+=DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION+"=";
		sDescripcion+=detallecuentaflujocaja.getid_tipo_operacion().toString()+",";
		sDescripcion+=DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA+"=";
		sDescripcion+=detallecuentaflujocaja.getid_cuenta_flujo_caja().toString()+",";
		sDescripcion+=DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=detallecuentaflujocaja.getid_cuenta_contable().toString()+",";
		sDescripcion+=DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=detallecuentaflujocaja.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleCuentaFlujoCajaDescripcion(DetalleCuentaFlujoCaja detallecuentaflujocaja,String sValor) throws Exception {			
		if(detallecuentaflujocaja !=null) {
			//detallecuentaflujocajadetallecuentaflujocaja.getId().toString();
		}		
	}
	
		

	public static String getTipoOperacionDescripcion(TipoOperacion tipooperacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipooperacion!=null/*&&tipooperacion.getId()>0*/) {
			sDescripcion=TipoOperacionConstantesFunciones.getTipoOperacionDescripcion(tipooperacion);
		}

		return sDescripcion;
	}

	public static String getCuentaFlujoCajaDescripcion(CuentaFlujoCaja cuentaflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentaflujocaja!=null/*&&cuentaflujocaja.getId()>0*/) {
			sDescripcion=CuentaFlujoCajaConstantesFunciones.getCuentaFlujoCajaDescripcion(cuentaflujocaja);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaFlujoCaja")) {
			sNombreIndice="Tipo=  Por Cuenta Flujo Caja";
		} else if(sNombreIndice.equals("FK_IdTipoOperacion")) {
			sNombreIndice="Tipo=  Por Tipo Operacion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaFlujoCaja(Long id_cuenta_flujo_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_flujo_caja!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Flujo Caja="+id_cuenta_flujo_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoOperacion(Long id_tipo_operacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_operacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Operacion="+id_tipo_operacion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja: detallecuentaflujocajas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallecuentaflujocaja.getConCambioAuxiliar()) {
			detallecuentaflujocaja.setIsDeleted(detallecuentaflujocaja.getIsDeletedAuxiliar());	
			detallecuentaflujocaja.setIsNew(detallecuentaflujocaja.getIsNewAuxiliar());	
			detallecuentaflujocaja.setIsChanged(detallecuentaflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallecuentaflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallecuentaflujocaja.setIsDeletedAuxiliar(false);	
			detallecuentaflujocaja.setIsNewAuxiliar(false);	
			detallecuentaflujocaja.setIsChangedAuxiliar(false);
			
			detallecuentaflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja : detallecuentaflujocajas) {
			if(conAsignarBase && detallecuentaflujocaja.getConCambioAuxiliar()) {
				detallecuentaflujocaja.setIsDeleted(detallecuentaflujocaja.getIsDeletedAuxiliar());	
				detallecuentaflujocaja.setIsNew(detallecuentaflujocaja.getIsNewAuxiliar());	
				detallecuentaflujocaja.setIsChanged(detallecuentaflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallecuentaflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallecuentaflujocaja.setIsDeletedAuxiliar(false);	
				detallecuentaflujocaja.setIsNewAuxiliar(false);	
				detallecuentaflujocaja.setIsChangedAuxiliar(false);
				
				detallecuentaflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleCuentaFlujoCajas(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,Boolean conEnteros) throws Exception  {
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja: detallecuentaflujocajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleCuentaFlujoCaja(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,DetalleCuentaFlujoCaja detallecuentaflujocajaAux) throws Exception  {
		DetalleCuentaFlujoCajaConstantesFunciones.InicializarValoresDetalleCuentaFlujoCaja(detallecuentaflujocajaAux,true);
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja: detallecuentaflujocajas) {
			if(detallecuentaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCuentaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleCuentaFlujoCajaConstantesFunciones.getArrayColumnasGlobalesDetalleCuentaFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleCuentaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleCuentaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,DetalleCuentaFlujoCaja detallecuentaflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocajaAux: detallecuentaflujocajas) {
			if(detallecuentaflujocajaAux!=null && detallecuentaflujocaja!=null) {
				if((detallecuentaflujocajaAux.getId()==null && detallecuentaflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallecuentaflujocajaAux.getId()!=null && detallecuentaflujocaja.getId()!=null){
					if(detallecuentaflujocajaAux.getId().equals(detallecuentaflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleCuentaFlujoCaja(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleCuentaFlujoCaja detallecuentaflujocaja: detallecuentaflujocajas) {			
			if(detallecuentaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleCuentaFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleCuentaFlujoCajaConstantesFunciones.LABEL_ID, DetalleCuentaFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCuentaFlujoCajaConstantesFunciones.LABEL_VERSIONROW, DetalleCuentaFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDTIPOOPERACION, DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTAFLUJOCAJA, DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE, DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleCuentaFlujoCajaConstantesFunciones.LABEL_ESTAACTIVO, DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleCuentaFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleCuentaFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCuentaFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCuentaFlujoCaja() throws Exception  {
		return DetalleCuentaFlujoCajaConstantesFunciones.getTiposSeleccionarDetalleCuentaFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCuentaFlujoCaja(Boolean conFk) throws Exception  {
		return DetalleCuentaFlujoCajaConstantesFunciones.getTiposSeleccionarDetalleCuentaFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleCuentaFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDTIPOOPERACION);
			reporte.setsDescripcion(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDTIPOOPERACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTAFLUJOCAJA);
			reporte.setsDescripcion(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTAFLUJOCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleCuentaFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocajaAux) throws Exception {
		
			detallecuentaflujocajaAux.settipooperacion_descripcion(TipoOperacionConstantesFunciones.getTipoOperacionDescripcion(detallecuentaflujocajaAux.getTipoOperacion()));
			detallecuentaflujocajaAux.setcuentaflujocaja_descripcion(CuentaFlujoCajaConstantesFunciones.getCuentaFlujoCajaDescripcion(detallecuentaflujocajaAux.getCuentaFlujoCaja()));
			detallecuentaflujocajaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallecuentaflujocajaAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(List<DetalleCuentaFlujoCaja> detallecuentaflujocajasTemp) throws Exception {
		for(DetalleCuentaFlujoCaja detallecuentaflujocajaAux:detallecuentaflujocajasTemp) {
			
			detallecuentaflujocajaAux.settipooperacion_descripcion(TipoOperacionConstantesFunciones.getTipoOperacionDescripcion(detallecuentaflujocajaAux.getTipoOperacion()));
			detallecuentaflujocajaAux.setcuentaflujocaja_descripcion(CuentaFlujoCajaConstantesFunciones.getCuentaFlujoCajaDescripcion(detallecuentaflujocajaAux.getCuentaFlujoCaja()));
			detallecuentaflujocajaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallecuentaflujocajaAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TipoOperacion.class));
				classes.add(new Classe(CuentaFlujoCaja.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoOperacion.class)) {
						classes.add(new Classe(TipoOperacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaFlujoCaja.class)) {
						classes.add(new Classe(CuentaFlujoCaja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleCuentaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoOperacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoOperacion.class)); continue;
					}

					if(CuentaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaFlujoCaja.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TipoOperacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoOperacion.class)); continue;
					}

					if(CuentaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaFlujoCaja.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCuentaFlujoCajaConstantesFunciones.getClassesRelationshipsOfDetalleCuentaFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCuentaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleCuentaFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleCuentaFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleCuentaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(DetalleCuentaFlujoCaja detallecuentaflujocaja,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleCuentaFlujoCaja detallecuentaflujocajaEncontrado=null;
			
			for(DetalleCuentaFlujoCaja detallecuentaflujocajaLocal:detallecuentaflujocajas) {
				if(detallecuentaflujocajaLocal.getId().equals(detallecuentaflujocaja.getId())) {
					detallecuentaflujocajaEncontrado=detallecuentaflujocajaLocal;
					
					detallecuentaflujocajaLocal.setIsChanged(detallecuentaflujocaja.getIsChanged());
					detallecuentaflujocajaLocal.setIsNew(detallecuentaflujocaja.getIsNew());
					detallecuentaflujocajaLocal.setIsDeleted(detallecuentaflujocaja.getIsDeleted());
					
					detallecuentaflujocajaLocal.setGeneralEntityOriginal(detallecuentaflujocaja.getGeneralEntityOriginal());
					
					detallecuentaflujocajaLocal.setId(detallecuentaflujocaja.getId());	
					detallecuentaflujocajaLocal.setVersionRow(detallecuentaflujocaja.getVersionRow());	
					detallecuentaflujocajaLocal.setid_tipo_operacion(detallecuentaflujocaja.getid_tipo_operacion());	
					detallecuentaflujocajaLocal.setid_cuenta_flujo_caja(detallecuentaflujocaja.getid_cuenta_flujo_caja());	
					detallecuentaflujocajaLocal.setid_cuenta_contable(detallecuentaflujocaja.getid_cuenta_contable());	
					detallecuentaflujocajaLocal.setesta_activo(detallecuentaflujocaja.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallecuentaflujocaja.getIsDeleted()) {
				if(!existe) {
					detallecuentaflujocajas.add(detallecuentaflujocaja);
				}
			} else {
				if(detallecuentaflujocajaEncontrado!=null && permiteQuitar)  {
					detallecuentaflujocajas.remove(detallecuentaflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleCuentaFlujoCaja detallecuentaflujocaja,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas) throws Exception {
		try	{			
			for(DetalleCuentaFlujoCaja detallecuentaflujocajaLocal:detallecuentaflujocajas) {
				if(detallecuentaflujocajaLocal.getId().equals(detallecuentaflujocaja.getId())) {
					detallecuentaflujocajaLocal.setIsSelected(detallecuentaflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleCuentaFlujoCaja(List<DetalleCuentaFlujoCaja> detallecuentaflujocajasAux) throws Exception {
		//this.detallecuentaflujocajasAux=detallecuentaflujocajasAux;
		
		for(DetalleCuentaFlujoCaja detallecuentaflujocajaAux:detallecuentaflujocajasAux) {
			if(detallecuentaflujocajaAux.getIsChanged()) {
				detallecuentaflujocajaAux.setIsChanged(false);
			}		
			
			if(detallecuentaflujocajaAux.getIsNew()) {
				detallecuentaflujocajaAux.setIsNew(false);
			}	
			
			if(detallecuentaflujocajaAux.getIsDeleted()) {
				detallecuentaflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocajaAux) throws Exception {
		//this.detallecuentaflujocajaAux=detallecuentaflujocajaAux;
		
			if(detallecuentaflujocajaAux.getIsChanged()) {
				detallecuentaflujocajaAux.setIsChanged(false);
			}		
			
			if(detallecuentaflujocajaAux.getIsNew()) {
				detallecuentaflujocajaAux.setIsNew(false);
			}	
			
			if(detallecuentaflujocajaAux.getIsDeleted()) {
				detallecuentaflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleCuentaFlujoCaja detallecuentaflujocajaAsignar,DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		detallecuentaflujocajaAsignar.setId(detallecuentaflujocaja.getId());	
		detallecuentaflujocajaAsignar.setVersionRow(detallecuentaflujocaja.getVersionRow());	
		detallecuentaflujocajaAsignar.setid_tipo_operacion(detallecuentaflujocaja.getid_tipo_operacion());
		detallecuentaflujocajaAsignar.settipooperacion_descripcion(detallecuentaflujocaja.gettipooperacion_descripcion());	
		detallecuentaflujocajaAsignar.setid_cuenta_flujo_caja(detallecuentaflujocaja.getid_cuenta_flujo_caja());
		detallecuentaflujocajaAsignar.setcuentaflujocaja_descripcion(detallecuentaflujocaja.getcuentaflujocaja_descripcion());	
		detallecuentaflujocajaAsignar.setid_cuenta_contable(detallecuentaflujocaja.getid_cuenta_contable());
		detallecuentaflujocajaAsignar.setcuentacontable_descripcion(detallecuentaflujocaja.getcuentacontable_descripcion());	
		detallecuentaflujocajaAsignar.setesta_activo(detallecuentaflujocaja.getesta_activo());	
	}
	
	public static void inicializarDetalleCuentaFlujoCaja(DetalleCuentaFlujoCaja detallecuentaflujocaja) throws Exception {
		try {
				detallecuentaflujocaja.setId(0L);	
					
				detallecuentaflujocaja.setid_tipo_operacion(-1L);	
				detallecuentaflujocaja.setid_cuenta_flujo_caja(-1L);	
				detallecuentaflujocaja.setid_cuenta_contable(-1L);	
				detallecuentaflujocaja.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleCuentaFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDTIPOOPERACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTAFLUJOCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleCuentaFlujoCajaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleCuentaFlujoCaja(String sTipo,Row row,Workbook workbook,DetalleCuentaFlujoCaja detallecuentaflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecuentaflujocaja.gettipooperacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecuentaflujocaja.getcuentaflujocaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallecuentaflujocaja.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detallecuentaflujocaja.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleCuentaFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleCuentaFlujoCaja() {
		return this.sFinalQueryDetalleCuentaFlujoCaja;
	}
	
	public void setsFinalQueryDetalleCuentaFlujoCaja(String sFinalQueryDetalleCuentaFlujoCaja) {
		this.sFinalQueryDetalleCuentaFlujoCaja= sFinalQueryDetalleCuentaFlujoCaja;
	}
	
	public Border resaltarSeleccionarDetalleCuentaFlujoCaja=null;
	
	public Border setResaltarSeleccionarDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallecuentaflujocajaBeanSwingJInternalFrame.jTtoolBarDetalleCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleCuentaFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleCuentaFlujoCaja() {
		return this.resaltarSeleccionarDetalleCuentaFlujoCaja;
	}
	
	public void setResaltarSeleccionarDetalleCuentaFlujoCaja(Border borderResaltarSeleccionarDetalleCuentaFlujoCaja) {
		this.resaltarSeleccionarDetalleCuentaFlujoCaja= borderResaltarSeleccionarDetalleCuentaFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleCuentaFlujoCaja=null;
	public Boolean mostraridDetalleCuentaFlujoCaja=true;
	public Boolean activaridDetalleCuentaFlujoCaja=true;

	public Border resaltarid_tipo_operacionDetalleCuentaFlujoCaja=null;
	public Boolean mostrarid_tipo_operacionDetalleCuentaFlujoCaja=true;
	public Boolean activarid_tipo_operacionDetalleCuentaFlujoCaja=true;
	public Boolean cargarid_tipo_operacionDetalleCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_operacionDetalleCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja=null;
	public Boolean mostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja=true;
	public Boolean activarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja=true;
	public Boolean cargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_flujo_cajaDetalleCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableDetalleCuentaFlujoCaja=null;
	public Boolean mostrarid_cuenta_contableDetalleCuentaFlujoCaja=true;
	public Boolean activarid_cuenta_contableDetalleCuentaFlujoCaja=true;
	public Boolean cargarid_cuenta_contableDetalleCuentaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableDetalleCuentaFlujoCaja=false;//ConEventDepend=true

	public Border resaltaresta_activoDetalleCuentaFlujoCaja=null;
	public Boolean mostraresta_activoDetalleCuentaFlujoCaja=true;
	public Boolean activaresta_activoDetalleCuentaFlujoCaja=true;

	
	

	public Border setResaltaridDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecuentaflujocajaBeanSwingJInternalFrame.jTtoolBarDetalleCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridDetalleCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleCuentaFlujoCaja() {
		return this.resaltaridDetalleCuentaFlujoCaja;
	}

	public void setResaltaridDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltaridDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridDetalleCuentaFlujoCaja() {
		return this.mostraridDetalleCuentaFlujoCaja;
	}

	public void setMostraridDetalleCuentaFlujoCaja(Boolean mostraridDetalleCuentaFlujoCaja) {
		this.mostraridDetalleCuentaFlujoCaja= mostraridDetalleCuentaFlujoCaja;
	}

	public Boolean getActivaridDetalleCuentaFlujoCaja() {
		return this.activaridDetalleCuentaFlujoCaja;
	}

	public void setActivaridDetalleCuentaFlujoCaja(Boolean activaridDetalleCuentaFlujoCaja) {
		this.activaridDetalleCuentaFlujoCaja= activaridDetalleCuentaFlujoCaja;
	}

	public Border setResaltarid_tipo_operacionDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecuentaflujocajaBeanSwingJInternalFrame.jTtoolBarDetalleCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_tipo_operacionDetalleCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_operacionDetalleCuentaFlujoCaja() {
		return this.resaltarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public void setResaltarid_tipo_operacionDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_tipo_operacionDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_tipo_operacionDetalleCuentaFlujoCaja() {
		return this.mostrarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public void setMostrarid_tipo_operacionDetalleCuentaFlujoCaja(Boolean mostrarid_tipo_operacionDetalleCuentaFlujoCaja) {
		this.mostrarid_tipo_operacionDetalleCuentaFlujoCaja= mostrarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public Boolean getActivarid_tipo_operacionDetalleCuentaFlujoCaja() {
		return this.activarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public void setActivarid_tipo_operacionDetalleCuentaFlujoCaja(Boolean activarid_tipo_operacionDetalleCuentaFlujoCaja) {
		this.activarid_tipo_operacionDetalleCuentaFlujoCaja= activarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public Boolean getCargarid_tipo_operacionDetalleCuentaFlujoCaja() {
		return this.cargarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public void setCargarid_tipo_operacionDetalleCuentaFlujoCaja(Boolean cargarid_tipo_operacionDetalleCuentaFlujoCaja) {
		this.cargarid_tipo_operacionDetalleCuentaFlujoCaja= cargarid_tipo_operacionDetalleCuentaFlujoCaja;
	}

	public Border setResaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecuentaflujocajaBeanSwingJInternalFrame.jTtoolBarDetalleCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja() {
		return this.resaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public void setResaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja() {
		return this.mostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public void setMostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(Boolean mostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja) {
		this.mostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja= mostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public Boolean getActivarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja() {
		return this.activarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public void setActivarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(Boolean activarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja) {
		this.activarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja= activarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public Boolean getCargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja() {
		return this.cargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public void setCargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(Boolean cargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja) {
		this.cargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja= cargarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja;
	}

	public Border setResaltarid_cuenta_contableDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecuentaflujocajaBeanSwingJInternalFrame.jTtoolBarDetalleCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableDetalleCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableDetalleCuentaFlujoCaja() {
		return this.resaltarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public void setResaltarid_cuenta_contableDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarid_cuenta_contableDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableDetalleCuentaFlujoCaja() {
		return this.mostrarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public void setMostrarid_cuenta_contableDetalleCuentaFlujoCaja(Boolean mostrarid_cuenta_contableDetalleCuentaFlujoCaja) {
		this.mostrarid_cuenta_contableDetalleCuentaFlujoCaja= mostrarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public Boolean getActivarid_cuenta_contableDetalleCuentaFlujoCaja() {
		return this.activarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public void setActivarid_cuenta_contableDetalleCuentaFlujoCaja(Boolean activarid_cuenta_contableDetalleCuentaFlujoCaja) {
		this.activarid_cuenta_contableDetalleCuentaFlujoCaja= activarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public Boolean getCargarid_cuenta_contableDetalleCuentaFlujoCaja() {
		return this.cargarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public void setCargarid_cuenta_contableDetalleCuentaFlujoCaja(Boolean cargarid_cuenta_contableDetalleCuentaFlujoCaja) {
		this.cargarid_cuenta_contableDetalleCuentaFlujoCaja= cargarid_cuenta_contableDetalleCuentaFlujoCaja;
	}

	public Border setResaltaresta_activoDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallecuentaflujocajaBeanSwingJInternalFrame.jTtoolBarDetalleCuentaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaresta_activoDetalleCuentaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoDetalleCuentaFlujoCaja() {
		return this.resaltaresta_activoDetalleCuentaFlujoCaja;
	}

	public void setResaltaresta_activoDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltaresta_activoDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Boolean getMostraresta_activoDetalleCuentaFlujoCaja() {
		return this.mostraresta_activoDetalleCuentaFlujoCaja;
	}

	public void setMostraresta_activoDetalleCuentaFlujoCaja(Boolean mostraresta_activoDetalleCuentaFlujoCaja) {
		this.mostraresta_activoDetalleCuentaFlujoCaja= mostraresta_activoDetalleCuentaFlujoCaja;
	}

	public Boolean getActivaresta_activoDetalleCuentaFlujoCaja() {
		return this.activaresta_activoDetalleCuentaFlujoCaja;
	}

	public void setActivaresta_activoDetalleCuentaFlujoCaja(Boolean activaresta_activoDetalleCuentaFlujoCaja) {
		this.activaresta_activoDetalleCuentaFlujoCaja= activaresta_activoDetalleCuentaFlujoCaja;
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
		
		
		this.setMostraridDetalleCuentaFlujoCaja(esInicial);
		this.setMostrarid_tipo_operacionDetalleCuentaFlujoCaja(esInicial);
		this.setMostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(esInicial);
		this.setMostrarid_cuenta_contableDetalleCuentaFlujoCaja(esInicial);
		this.setMostraresta_activoDetalleCuentaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION)) {
				this.setMostrarid_tipo_operacionDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA)) {
				this.setMostrarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoDetalleCuentaFlujoCaja(esAsigna);
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
		
		
		this.setActivaridDetalleCuentaFlujoCaja(esInicial);
		this.setActivarid_tipo_operacionDetalleCuentaFlujoCaja(esInicial);
		this.setActivarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(esInicial);
		this.setActivarid_cuenta_contableDetalleCuentaFlujoCaja(esInicial);
		this.setActivaresta_activoDetalleCuentaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION)) {
				this.setActivarid_tipo_operacionDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA)) {
				this.setActivarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleCuentaFlujoCaja(esInicial);
		this.setResaltarid_tipo_operacionDetalleCuentaFlujoCaja(esInicial);
		this.setResaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(esInicial);
		this.setResaltarid_cuenta_contableDetalleCuentaFlujoCaja(esInicial);
		this.setResaltaresta_activoDetalleCuentaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDTIPOOPERACION)) {
				this.setResaltarid_tipo_operacionDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTAFLUJOCAJA)) {
				this.setResaltarid_cuenta_flujo_cajaDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleCuentaFlujoCajaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoDetalleCuentaFlujoCaja(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableDetalleCuentaFlujoCaja=true;

	public Boolean getMostrarFK_IdCuentaContableDetalleCuentaFlujoCaja() {
		return this.mostrarFK_IdCuentaContableDetalleCuentaFlujoCaja;
	}

	public void setMostrarFK_IdCuentaContableDetalleCuentaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDetalleCuentaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja=true;

	public Boolean getMostrarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja() {
		return this.mostrarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja;
	}

	public void setMostrarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoOperacionDetalleCuentaFlujoCaja=true;

	public Boolean getMostrarFK_IdTipoOperacionDetalleCuentaFlujoCaja() {
		return this.mostrarFK_IdTipoOperacionDetalleCuentaFlujoCaja;
	}

	public void setMostrarFK_IdTipoOperacionDetalleCuentaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoOperacionDetalleCuentaFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableDetalleCuentaFlujoCaja=true;

	public Boolean getActivarFK_IdCuentaContableDetalleCuentaFlujoCaja() {
		return this.activarFK_IdCuentaContableDetalleCuentaFlujoCaja;
	}

	public void setActivarFK_IdCuentaContableDetalleCuentaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDetalleCuentaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja=true;

	public Boolean getActivarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja() {
		return this.activarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja;
	}

	public void setActivarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoOperacionDetalleCuentaFlujoCaja=true;

	public Boolean getActivarFK_IdTipoOperacionDetalleCuentaFlujoCaja() {
		return this.activarFK_IdTipoOperacionDetalleCuentaFlujoCaja;
	}

	public void setActivarFK_IdTipoOperacionDetalleCuentaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdTipoOperacionDetalleCuentaFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableDetalleCuentaFlujoCaja=null;

	public Border getResaltarFK_IdCuentaContableDetalleCuentaFlujoCaja() {
		return this.resaltarFK_IdCuentaContableDetalleCuentaFlujoCaja;
	}

	public void setResaltarFK_IdCuentaContableDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDetalleCuentaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja=null;

	public Border getResaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja() {
		return this.resaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja;
	}

	public void setResaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaFlujoCajaDetalleCuentaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja=null;

	public Border getResaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja() {
		return this.resaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja;
	}

	public void setResaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleCuentaFlujoCajaBeanSwingJInternalFrame detallecuentaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoOperacionDetalleCuentaFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}