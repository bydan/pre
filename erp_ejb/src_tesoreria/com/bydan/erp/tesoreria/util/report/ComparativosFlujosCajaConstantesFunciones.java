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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ComparativosFlujosCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComparativosFlujosCajaConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ComparativosFlujosCaja";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComparativosFlujosCaja"+ComparativosFlujosCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComparativosFlujosCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComparativosFlujosCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComparativosFlujosCajaConstantesFunciones.SCHEMA+"_"+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComparativosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComparativosFlujosCajaConstantesFunciones.SCHEMA+"_"+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComparativosFlujosCajaConstantesFunciones.SCHEMA+"_"+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComparativosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComparativosFlujosCajaConstantesFunciones.SCHEMA+"_"+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComparativosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComparativosFlujosCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComparativosFlujosCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComparativosFlujosCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComparativosFlujosCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComparativosFlujosCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComparativosFlujosCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comparativos Flujos Cajas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comparativos Flujos Caja";
	public static final String SCLASSWEBTITULO_LOWER="Comparativos Flujos Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComparativosFlujosCaja";
	public static final String OBJECTNAME="comparativosflujoscaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="comparativos_flujos_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comparativosflujoscaja from "+ComparativosFlujosCajaConstantesFunciones.SPERSISTENCENAME+" comparativosflujoscaja";
	public static String QUERYSELECTNATIVE="select "+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".id,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".version_row,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".id_empresa,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".id_ejercicio,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".nombre_centro_actividad,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".tipo_movimiento,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".saldo_actual,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".saldo_acumulado,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".saldo_pres_actual,"+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME+".saldo_pres_acumulado from "+ComparativosFlujosCajaConstantesFunciones.SCHEMA+"."+ComparativosFlujosCajaConstantesFunciones.TABLENAME;//+" as "+ComparativosFlujosCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String NOMBRECENTROACTIVIDAD= "nombre_centro_actividad";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String SALDOACTUAL= "saldo_actual";
    public static final String SALDOACUMULADO= "saldo_acumulado";
    public static final String SALDOPRESACTUAL= "saldo_pres_actual";
    public static final String SALDOPRESACUMULADO= "saldo_pres_acumulado";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_NOMBRECENTROACTIVIDAD= "Nombre Centro Activad";
		public static final String LABEL_NOMBRECENTROACTIVIDAD_LOWER= "Nombre Centro Actividad";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_SALDOACTUAL= "Saldo Actual";
		public static final String LABEL_SALDOACTUAL_LOWER= "Saldo Actual";
    	public static final String LABEL_SALDOACUMULADO= "Saldo Acumulado";
		public static final String LABEL_SALDOACUMULADO_LOWER= "Saldo Acumulado";
    	public static final String LABEL_SALDOPRESACTUAL= "Saldo Pres Actual";
		public static final String LABEL_SALDOPRESACTUAL_LOWER= "Saldo Pres Actual";
    	public static final String LABEL_SALDOPRESACUMULADO= "Saldo Pres Acumulado";
		public static final String LABEL_SALDOPRESACUMULADO_LOWER= "Saldo Pres Acumulado";
	
		
		
		
		
	public static final String SREGEXNOMBRE_CENTRO_ACTIVIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CENTRO_ACTIVIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getComparativosFlujosCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL;}
		if(sNombreColumna.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO)) {sLabelColumna=ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getComparativosFlujosCajaDescripcion(ComparativosFlujosCaja comparativosflujoscaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comparativosflujoscaja !=null/* && comparativosflujoscaja.getId()!=0*/) {
			sDescripcion=comparativosflujoscaja.getnombre_centro_actividad();//comparativosflujoscajacomparativosflujoscaja.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComparativosFlujosCajaDescripcionDetallado(ComparativosFlujosCaja comparativosflujoscaja) {
		String sDescripcion="";
			
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.ID+"=";
		sDescripcion+=comparativosflujoscaja.getId().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comparativosflujoscaja.getVersionRow().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comparativosflujoscaja.getid_empresa().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=comparativosflujoscaja.getid_ejercicio().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD+"=";
		sDescripcion+=comparativosflujoscaja.getnombre_centro_actividad()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=comparativosflujoscaja.gettipo_movimiento()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL+"=";
		sDescripcion+=comparativosflujoscaja.getsaldo_actual().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO+"=";
		sDescripcion+=comparativosflujoscaja.getsaldo_acumulado().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL+"=";
		sDescripcion+=comparativosflujoscaja.getsaldo_pres_actual().toString()+",";
		sDescripcion+=ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO+"=";
		sDescripcion+=comparativosflujoscaja.getsaldo_pres_acumulado().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setComparativosFlujosCajaDescripcion(ComparativosFlujosCaja comparativosflujoscaja,String sValor) throws Exception {			
		if(comparativosflujoscaja !=null) {
			comparativosflujoscaja.setnombre_centro_actividad(sValor);//comparativosflujoscajacomparativosflujoscaja.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaComparativosFlujosCaja")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaComparativosFlujosCaja(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comparativosflujoscaja.setnombre_centro_actividad(comparativosflujoscaja.getnombre_centro_actividad().trim());
		comparativosflujoscaja.settipo_movimiento(comparativosflujoscaja.gettipo_movimiento().trim());
	}
	
	public static void quitarEspaciosComparativosFlujosCajas(List<ComparativosFlujosCaja> comparativosflujoscajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComparativosFlujosCaja comparativosflujoscaja: comparativosflujoscajas) {
			comparativosflujoscaja.setnombre_centro_actividad(comparativosflujoscaja.getnombre_centro_actividad().trim());
			comparativosflujoscaja.settipo_movimiento(comparativosflujoscaja.gettipo_movimiento().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comparativosflujoscaja.getConCambioAuxiliar()) {
			comparativosflujoscaja.setIsDeleted(comparativosflujoscaja.getIsDeletedAuxiliar());	
			comparativosflujoscaja.setIsNew(comparativosflujoscaja.getIsNewAuxiliar());	
			comparativosflujoscaja.setIsChanged(comparativosflujoscaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comparativosflujoscaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comparativosflujoscaja.setIsDeletedAuxiliar(false);	
			comparativosflujoscaja.setIsNewAuxiliar(false);	
			comparativosflujoscaja.setIsChangedAuxiliar(false);
			
			comparativosflujoscaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComparativosFlujosCajas(List<ComparativosFlujosCaja> comparativosflujoscajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComparativosFlujosCaja comparativosflujoscaja : comparativosflujoscajas) {
			if(conAsignarBase && comparativosflujoscaja.getConCambioAuxiliar()) {
				comparativosflujoscaja.setIsDeleted(comparativosflujoscaja.getIsDeletedAuxiliar());	
				comparativosflujoscaja.setIsNew(comparativosflujoscaja.getIsNewAuxiliar());	
				comparativosflujoscaja.setIsChanged(comparativosflujoscaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comparativosflujoscaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comparativosflujoscaja.setIsDeletedAuxiliar(false);	
				comparativosflujoscaja.setIsNewAuxiliar(false);	
				comparativosflujoscaja.setIsChangedAuxiliar(false);
				
				comparativosflujoscaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscaja,Boolean conEnteros) throws Exception  {
		comparativosflujoscaja.setsaldo_actual(0.0);
		comparativosflujoscaja.setsaldo_acumulado(0.0);
		comparativosflujoscaja.setsaldo_pres_actual(0.0);
		comparativosflujoscaja.setsaldo_pres_acumulado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComparativosFlujosCajas(List<ComparativosFlujosCaja> comparativosflujoscajas,Boolean conEnteros) throws Exception  {
		
		for(ComparativosFlujosCaja comparativosflujoscaja: comparativosflujoscajas) {
			comparativosflujoscaja.setsaldo_actual(0.0);
			comparativosflujoscaja.setsaldo_acumulado(0.0);
			comparativosflujoscaja.setsaldo_pres_actual(0.0);
			comparativosflujoscaja.setsaldo_pres_acumulado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComparativosFlujosCaja(List<ComparativosFlujosCaja> comparativosflujoscajas,ComparativosFlujosCaja comparativosflujoscajaAux) throws Exception  {
		ComparativosFlujosCajaConstantesFunciones.InicializarValoresComparativosFlujosCaja(comparativosflujoscajaAux,true);
		
		for(ComparativosFlujosCaja comparativosflujoscaja: comparativosflujoscajas) {
			if(comparativosflujoscaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comparativosflujoscajaAux.setsaldo_actual(comparativosflujoscajaAux.getsaldo_actual()+comparativosflujoscaja.getsaldo_actual());			
			comparativosflujoscajaAux.setsaldo_acumulado(comparativosflujoscajaAux.getsaldo_acumulado()+comparativosflujoscaja.getsaldo_acumulado());			
			comparativosflujoscajaAux.setsaldo_pres_actual(comparativosflujoscajaAux.getsaldo_pres_actual()+comparativosflujoscaja.getsaldo_pres_actual());			
			comparativosflujoscajaAux.setsaldo_pres_acumulado(comparativosflujoscajaAux.getsaldo_pres_acumulado()+comparativosflujoscaja.getsaldo_pres_acumulado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComparativosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComparativosFlujosCajaConstantesFunciones.getArrayColumnasGlobalesComparativosFlujosCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComparativosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComparativosFlujosCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComparativosFlujosCaja> comparativosflujoscajas,ComparativosFlujosCaja comparativosflujoscaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComparativosFlujosCaja comparativosflujoscajaAux: comparativosflujoscajas) {
			if(comparativosflujoscajaAux!=null && comparativosflujoscaja!=null) {
				if((comparativosflujoscajaAux.getId()==null && comparativosflujoscaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comparativosflujoscajaAux.getId()!=null && comparativosflujoscaja.getId()!=null){
					if(comparativosflujoscajaAux.getId().equals(comparativosflujoscaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComparativosFlujosCaja(List<ComparativosFlujosCaja> comparativosflujoscajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldo_actualTotal=0.0;
		Double saldo_acumuladoTotal=0.0;
		Double saldo_pres_actualTotal=0.0;
		Double saldo_pres_acumuladoTotal=0.0;
	
		for(ComparativosFlujosCaja comparativosflujoscaja: comparativosflujoscajas) {			
			if(comparativosflujoscaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldo_actualTotal+=comparativosflujoscaja.getsaldo_actual();
			saldo_acumuladoTotal+=comparativosflujoscaja.getsaldo_acumulado();
			saldo_pres_actualTotal+=comparativosflujoscaja.getsaldo_pres_actual();
			saldo_pres_acumuladoTotal+=comparativosflujoscaja.getsaldo_pres_acumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL);
		datoGeneral.setdValorDouble(saldo_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO);
		datoGeneral.setdValorDouble(saldo_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL);
		datoGeneral.setdValorDouble(saldo_pres_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO);
		datoGeneral.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO);
		datoGeneral.setdValorDouble(saldo_pres_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComparativosFlujosCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_ID, ComparativosFlujosCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_VERSIONROW, ComparativosFlujosCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD, ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_TIPOMOVIMIENTO, ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL, ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO, ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL, ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO, ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComparativosFlujosCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComparativosFlujosCaja() throws Exception  {
		return ComparativosFlujosCajaConstantesFunciones.getTiposSeleccionarComparativosFlujosCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComparativosFlujosCaja(Boolean conFk) throws Exception  {
		return ComparativosFlujosCajaConstantesFunciones.getTiposSeleccionarComparativosFlujosCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComparativosFlujosCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO);
			reporte.setsDescripcion(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComparativosFlujosCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscajaAux) throws Exception {
		
			comparativosflujoscajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comparativosflujoscajaAux.getEmpresa()));
			comparativosflujoscajaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comparativosflujoscajaAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComparativosFlujosCaja(List<ComparativosFlujosCaja> comparativosflujoscajasTemp) throws Exception {
		for(ComparativosFlujosCaja comparativosflujoscajaAux:comparativosflujoscajasTemp) {
			
			comparativosflujoscajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comparativosflujoscajaAux.getEmpresa()));
			comparativosflujoscajaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(comparativosflujoscajaAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComparativosFlujosCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComparativosFlujosCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComparativosFlujosCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComparativosFlujosCajaConstantesFunciones.getClassesRelationshipsOfComparativosFlujosCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComparativosFlujosCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComparativosFlujosCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComparativosFlujosCajaConstantesFunciones.getClassesRelationshipsFromStringsOfComparativosFlujosCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComparativosFlujosCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComparativosFlujosCaja comparativosflujoscaja,List<ComparativosFlujosCaja> comparativosflujoscajas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComparativosFlujosCaja comparativosflujoscaja,List<ComparativosFlujosCaja> comparativosflujoscajas) throws Exception {
		try	{			
			for(ComparativosFlujosCaja comparativosflujoscajaLocal:comparativosflujoscajas) {
				if(comparativosflujoscajaLocal.getId().equals(comparativosflujoscaja.getId())) {
					comparativosflujoscajaLocal.setIsSelected(comparativosflujoscaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComparativosFlujosCaja(List<ComparativosFlujosCaja> comparativosflujoscajasAux) throws Exception {
		//this.comparativosflujoscajasAux=comparativosflujoscajasAux;
		
		for(ComparativosFlujosCaja comparativosflujoscajaAux:comparativosflujoscajasAux) {
			if(comparativosflujoscajaAux.getIsChanged()) {
				comparativosflujoscajaAux.setIsChanged(false);
			}		
			
			if(comparativosflujoscajaAux.getIsNew()) {
				comparativosflujoscajaAux.setIsNew(false);
			}	
			
			if(comparativosflujoscajaAux.getIsDeleted()) {
				comparativosflujoscajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscajaAux) throws Exception {
		//this.comparativosflujoscajaAux=comparativosflujoscajaAux;
		
			if(comparativosflujoscajaAux.getIsChanged()) {
				comparativosflujoscajaAux.setIsChanged(false);
			}		
			
			if(comparativosflujoscajaAux.getIsNew()) {
				comparativosflujoscajaAux.setIsNew(false);
			}	
			
			if(comparativosflujoscajaAux.getIsDeleted()) {
				comparativosflujoscajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComparativosFlujosCaja comparativosflujoscajaAsignar,ComparativosFlujosCaja comparativosflujoscaja) throws Exception {
		comparativosflujoscajaAsignar.setId(comparativosflujoscaja.getId());	
		comparativosflujoscajaAsignar.setVersionRow(comparativosflujoscaja.getVersionRow());	
		comparativosflujoscajaAsignar.setnombre_centro_actividad(comparativosflujoscaja.getnombre_centro_actividad());	
		comparativosflujoscajaAsignar.settipo_movimiento(comparativosflujoscaja.gettipo_movimiento());	
		comparativosflujoscajaAsignar.setsaldo_actual(comparativosflujoscaja.getsaldo_actual());	
		comparativosflujoscajaAsignar.setsaldo_acumulado(comparativosflujoscaja.getsaldo_acumulado());	
		comparativosflujoscajaAsignar.setsaldo_pres_actual(comparativosflujoscaja.getsaldo_pres_actual());	
		comparativosflujoscajaAsignar.setsaldo_pres_acumulado(comparativosflujoscaja.getsaldo_pres_acumulado());	
	}
	
	public static void inicializarComparativosFlujosCaja(ComparativosFlujosCaja comparativosflujoscaja) throws Exception {
		try {
				comparativosflujoscaja.setId(0L);	
					
				comparativosflujoscaja.setnombre_centro_actividad("");	
				comparativosflujoscaja.settipo_movimiento("");	
				comparativosflujoscaja.setsaldo_actual(0.0);	
				comparativosflujoscaja.setsaldo_acumulado(0.0);	
				comparativosflujoscaja.setsaldo_pres_actual(0.0);	
				comparativosflujoscaja.setsaldo_pres_acumulado(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComparativosFlujosCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_NOMBRECENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOACUMULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComparativosFlujosCajaConstantesFunciones.LABEL_SALDOPRESACUMULADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComparativosFlujosCaja(String sTipo,Row row,Workbook workbook,ComparativosFlujosCaja comparativosflujoscaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getnombre_centro_actividad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getsaldo_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getsaldo_acumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getsaldo_pres_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comparativosflujoscaja.getsaldo_pres_acumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComparativosFlujosCaja="";
	
	public String getsFinalQueryComparativosFlujosCaja() {
		return this.sFinalQueryComparativosFlujosCaja;
	}
	
	public void setsFinalQueryComparativosFlujosCaja(String sFinalQueryComparativosFlujosCaja) {
		this.sFinalQueryComparativosFlujosCaja= sFinalQueryComparativosFlujosCaja;
	}
	
	public Border resaltarSeleccionarComparativosFlujosCaja=null;
	
	public Border setResaltarSeleccionarComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComparativosFlujosCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComparativosFlujosCaja() {
		return this.resaltarSeleccionarComparativosFlujosCaja;
	}
	
	public void setResaltarSeleccionarComparativosFlujosCaja(Border borderResaltarSeleccionarComparativosFlujosCaja) {
		this.resaltarSeleccionarComparativosFlujosCaja= borderResaltarSeleccionarComparativosFlujosCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComparativosFlujosCaja=null;
	public Boolean mostraridComparativosFlujosCaja=true;
	public Boolean activaridComparativosFlujosCaja=true;

	public Border resaltarid_empresaComparativosFlujosCaja=null;
	public Boolean mostrarid_empresaComparativosFlujosCaja=true;
	public Boolean activarid_empresaComparativosFlujosCaja=true;
	public Boolean cargarid_empresaComparativosFlujosCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComparativosFlujosCaja=false;//ConEventDepend=true

	public Border resaltarid_ejercicioComparativosFlujosCaja=null;
	public Boolean mostrarid_ejercicioComparativosFlujosCaja=true;
	public Boolean activarid_ejercicioComparativosFlujosCaja=true;
	public Boolean cargarid_ejercicioComparativosFlujosCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioComparativosFlujosCaja=false;//ConEventDepend=true

	public Border resaltarnombre_centro_actividadComparativosFlujosCaja=null;
	public Boolean mostrarnombre_centro_actividadComparativosFlujosCaja=true;
	public Boolean activarnombre_centro_actividadComparativosFlujosCaja=true;

	public Border resaltartipo_movimientoComparativosFlujosCaja=null;
	public Boolean mostrartipo_movimientoComparativosFlujosCaja=true;
	public Boolean activartipo_movimientoComparativosFlujosCaja=true;

	public Border resaltarsaldo_actualComparativosFlujosCaja=null;
	public Boolean mostrarsaldo_actualComparativosFlujosCaja=true;
	public Boolean activarsaldo_actualComparativosFlujosCaja=true;

	public Border resaltarsaldo_acumuladoComparativosFlujosCaja=null;
	public Boolean mostrarsaldo_acumuladoComparativosFlujosCaja=true;
	public Boolean activarsaldo_acumuladoComparativosFlujosCaja=true;

	public Border resaltarsaldo_pres_actualComparativosFlujosCaja=null;
	public Boolean mostrarsaldo_pres_actualComparativosFlujosCaja=true;
	public Boolean activarsaldo_pres_actualComparativosFlujosCaja=true;

	public Border resaltarsaldo_pres_acumuladoComparativosFlujosCaja=null;
	public Boolean mostrarsaldo_pres_acumuladoComparativosFlujosCaja=true;
	public Boolean activarsaldo_pres_acumuladoComparativosFlujosCaja=true;

	
	

	public Border setResaltaridComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltaridComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComparativosFlujosCaja() {
		return this.resaltaridComparativosFlujosCaja;
	}

	public void setResaltaridComparativosFlujosCaja(Border borderResaltar) {
		this.resaltaridComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostraridComparativosFlujosCaja() {
		return this.mostraridComparativosFlujosCaja;
	}

	public void setMostraridComparativosFlujosCaja(Boolean mostraridComparativosFlujosCaja) {
		this.mostraridComparativosFlujosCaja= mostraridComparativosFlujosCaja;
	}

	public Boolean getActivaridComparativosFlujosCaja() {
		return this.activaridComparativosFlujosCaja;
	}

	public void setActivaridComparativosFlujosCaja(Boolean activaridComparativosFlujosCaja) {
		this.activaridComparativosFlujosCaja= activaridComparativosFlujosCaja;
	}

	public Border setResaltarid_empresaComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComparativosFlujosCaja() {
		return this.resaltarid_empresaComparativosFlujosCaja;
	}

	public void setResaltarid_empresaComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarid_empresaComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaComparativosFlujosCaja() {
		return this.mostrarid_empresaComparativosFlujosCaja;
	}

	public void setMostrarid_empresaComparativosFlujosCaja(Boolean mostrarid_empresaComparativosFlujosCaja) {
		this.mostrarid_empresaComparativosFlujosCaja= mostrarid_empresaComparativosFlujosCaja;
	}

	public Boolean getActivarid_empresaComparativosFlujosCaja() {
		return this.activarid_empresaComparativosFlujosCaja;
	}

	public void setActivarid_empresaComparativosFlujosCaja(Boolean activarid_empresaComparativosFlujosCaja) {
		this.activarid_empresaComparativosFlujosCaja= activarid_empresaComparativosFlujosCaja;
	}

	public Boolean getCargarid_empresaComparativosFlujosCaja() {
		return this.cargarid_empresaComparativosFlujosCaja;
	}

	public void setCargarid_empresaComparativosFlujosCaja(Boolean cargarid_empresaComparativosFlujosCaja) {
		this.cargarid_empresaComparativosFlujosCaja= cargarid_empresaComparativosFlujosCaja;
	}

	public Border setResaltarid_ejercicioComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioComparativosFlujosCaja() {
		return this.resaltarid_ejercicioComparativosFlujosCaja;
	}

	public void setResaltarid_ejercicioComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarid_ejercicioComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioComparativosFlujosCaja() {
		return this.mostrarid_ejercicioComparativosFlujosCaja;
	}

	public void setMostrarid_ejercicioComparativosFlujosCaja(Boolean mostrarid_ejercicioComparativosFlujosCaja) {
		this.mostrarid_ejercicioComparativosFlujosCaja= mostrarid_ejercicioComparativosFlujosCaja;
	}

	public Boolean getActivarid_ejercicioComparativosFlujosCaja() {
		return this.activarid_ejercicioComparativosFlujosCaja;
	}

	public void setActivarid_ejercicioComparativosFlujosCaja(Boolean activarid_ejercicioComparativosFlujosCaja) {
		this.activarid_ejercicioComparativosFlujosCaja= activarid_ejercicioComparativosFlujosCaja;
	}

	public Boolean getCargarid_ejercicioComparativosFlujosCaja() {
		return this.cargarid_ejercicioComparativosFlujosCaja;
	}

	public void setCargarid_ejercicioComparativosFlujosCaja(Boolean cargarid_ejercicioComparativosFlujosCaja) {
		this.cargarid_ejercicioComparativosFlujosCaja= cargarid_ejercicioComparativosFlujosCaja;
	}

	public Border setResaltarnombre_centro_actividadComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarnombre_centro_actividadComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_centro_actividadComparativosFlujosCaja() {
		return this.resaltarnombre_centro_actividadComparativosFlujosCaja;
	}

	public void setResaltarnombre_centro_actividadComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarnombre_centro_actividadComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarnombre_centro_actividadComparativosFlujosCaja() {
		return this.mostrarnombre_centro_actividadComparativosFlujosCaja;
	}

	public void setMostrarnombre_centro_actividadComparativosFlujosCaja(Boolean mostrarnombre_centro_actividadComparativosFlujosCaja) {
		this.mostrarnombre_centro_actividadComparativosFlujosCaja= mostrarnombre_centro_actividadComparativosFlujosCaja;
	}

	public Boolean getActivarnombre_centro_actividadComparativosFlujosCaja() {
		return this.activarnombre_centro_actividadComparativosFlujosCaja;
	}

	public void setActivarnombre_centro_actividadComparativosFlujosCaja(Boolean activarnombre_centro_actividadComparativosFlujosCaja) {
		this.activarnombre_centro_actividadComparativosFlujosCaja= activarnombre_centro_actividadComparativosFlujosCaja;
	}

	public Border setResaltartipo_movimientoComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoComparativosFlujosCaja() {
		return this.resaltartipo_movimientoComparativosFlujosCaja;
	}

	public void setResaltartipo_movimientoComparativosFlujosCaja(Border borderResaltar) {
		this.resaltartipo_movimientoComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoComparativosFlujosCaja() {
		return this.mostrartipo_movimientoComparativosFlujosCaja;
	}

	public void setMostrartipo_movimientoComparativosFlujosCaja(Boolean mostrartipo_movimientoComparativosFlujosCaja) {
		this.mostrartipo_movimientoComparativosFlujosCaja= mostrartipo_movimientoComparativosFlujosCaja;
	}

	public Boolean getActivartipo_movimientoComparativosFlujosCaja() {
		return this.activartipo_movimientoComparativosFlujosCaja;
	}

	public void setActivartipo_movimientoComparativosFlujosCaja(Boolean activartipo_movimientoComparativosFlujosCaja) {
		this.activartipo_movimientoComparativosFlujosCaja= activartipo_movimientoComparativosFlujosCaja;
	}

	public Border setResaltarsaldo_actualComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarsaldo_actualComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_actualComparativosFlujosCaja() {
		return this.resaltarsaldo_actualComparativosFlujosCaja;
	}

	public void setResaltarsaldo_actualComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarsaldo_actualComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarsaldo_actualComparativosFlujosCaja() {
		return this.mostrarsaldo_actualComparativosFlujosCaja;
	}

	public void setMostrarsaldo_actualComparativosFlujosCaja(Boolean mostrarsaldo_actualComparativosFlujosCaja) {
		this.mostrarsaldo_actualComparativosFlujosCaja= mostrarsaldo_actualComparativosFlujosCaja;
	}

	public Boolean getActivarsaldo_actualComparativosFlujosCaja() {
		return this.activarsaldo_actualComparativosFlujosCaja;
	}

	public void setActivarsaldo_actualComparativosFlujosCaja(Boolean activarsaldo_actualComparativosFlujosCaja) {
		this.activarsaldo_actualComparativosFlujosCaja= activarsaldo_actualComparativosFlujosCaja;
	}

	public Border setResaltarsaldo_acumuladoComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarsaldo_acumuladoComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_acumuladoComparativosFlujosCaja() {
		return this.resaltarsaldo_acumuladoComparativosFlujosCaja;
	}

	public void setResaltarsaldo_acumuladoComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarsaldo_acumuladoComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarsaldo_acumuladoComparativosFlujosCaja() {
		return this.mostrarsaldo_acumuladoComparativosFlujosCaja;
	}

	public void setMostrarsaldo_acumuladoComparativosFlujosCaja(Boolean mostrarsaldo_acumuladoComparativosFlujosCaja) {
		this.mostrarsaldo_acumuladoComparativosFlujosCaja= mostrarsaldo_acumuladoComparativosFlujosCaja;
	}

	public Boolean getActivarsaldo_acumuladoComparativosFlujosCaja() {
		return this.activarsaldo_acumuladoComparativosFlujosCaja;
	}

	public void setActivarsaldo_acumuladoComparativosFlujosCaja(Boolean activarsaldo_acumuladoComparativosFlujosCaja) {
		this.activarsaldo_acumuladoComparativosFlujosCaja= activarsaldo_acumuladoComparativosFlujosCaja;
	}

	public Border setResaltarsaldo_pres_actualComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarsaldo_pres_actualComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_pres_actualComparativosFlujosCaja() {
		return this.resaltarsaldo_pres_actualComparativosFlujosCaja;
	}

	public void setResaltarsaldo_pres_actualComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarsaldo_pres_actualComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarsaldo_pres_actualComparativosFlujosCaja() {
		return this.mostrarsaldo_pres_actualComparativosFlujosCaja;
	}

	public void setMostrarsaldo_pres_actualComparativosFlujosCaja(Boolean mostrarsaldo_pres_actualComparativosFlujosCaja) {
		this.mostrarsaldo_pres_actualComparativosFlujosCaja= mostrarsaldo_pres_actualComparativosFlujosCaja;
	}

	public Boolean getActivarsaldo_pres_actualComparativosFlujosCaja() {
		return this.activarsaldo_pres_actualComparativosFlujosCaja;
	}

	public void setActivarsaldo_pres_actualComparativosFlujosCaja(Boolean activarsaldo_pres_actualComparativosFlujosCaja) {
		this.activarsaldo_pres_actualComparativosFlujosCaja= activarsaldo_pres_actualComparativosFlujosCaja;
	}

	public Border setResaltarsaldo_pres_acumuladoComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comparativosflujoscajaBeanSwingJInternalFrame.jTtoolBarComparativosFlujosCaja.setBorder(borderResaltar);
		
		this.resaltarsaldo_pres_acumuladoComparativosFlujosCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_pres_acumuladoComparativosFlujosCaja() {
		return this.resaltarsaldo_pres_acumuladoComparativosFlujosCaja;
	}

	public void setResaltarsaldo_pres_acumuladoComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarsaldo_pres_acumuladoComparativosFlujosCaja= borderResaltar;
	}

	public Boolean getMostrarsaldo_pres_acumuladoComparativosFlujosCaja() {
		return this.mostrarsaldo_pres_acumuladoComparativosFlujosCaja;
	}

	public void setMostrarsaldo_pres_acumuladoComparativosFlujosCaja(Boolean mostrarsaldo_pres_acumuladoComparativosFlujosCaja) {
		this.mostrarsaldo_pres_acumuladoComparativosFlujosCaja= mostrarsaldo_pres_acumuladoComparativosFlujosCaja;
	}

	public Boolean getActivarsaldo_pres_acumuladoComparativosFlujosCaja() {
		return this.activarsaldo_pres_acumuladoComparativosFlujosCaja;
	}

	public void setActivarsaldo_pres_acumuladoComparativosFlujosCaja(Boolean activarsaldo_pres_acumuladoComparativosFlujosCaja) {
		this.activarsaldo_pres_acumuladoComparativosFlujosCaja= activarsaldo_pres_acumuladoComparativosFlujosCaja;
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
		
		
		this.setMostraridComparativosFlujosCaja(esInicial);
		this.setMostrarid_empresaComparativosFlujosCaja(esInicial);
		this.setMostrarid_ejercicioComparativosFlujosCaja(esInicial);
		this.setMostrarnombre_centro_actividadComparativosFlujosCaja(esInicial);
		this.setMostrartipo_movimientoComparativosFlujosCaja(esInicial);
		this.setMostrarsaldo_actualComparativosFlujosCaja(esInicial);
		this.setMostrarsaldo_acumuladoComparativosFlujosCaja(esInicial);
		this.setMostrarsaldo_pres_actualComparativosFlujosCaja(esInicial);
		this.setMostrarsaldo_pres_acumuladoComparativosFlujosCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.ID)) {
				this.setMostraridComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD)) {
				this.setMostrarnombre_centro_actividadComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL)) {
				this.setMostrarsaldo_actualComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO)) {
				this.setMostrarsaldo_acumuladoComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL)) {
				this.setMostrarsaldo_pres_actualComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO)) {
				this.setMostrarsaldo_pres_acumuladoComparativosFlujosCaja(esAsigna);
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
		
		
		this.setActivaridComparativosFlujosCaja(esInicial);
		this.setActivarid_empresaComparativosFlujosCaja(esInicial);
		this.setActivarid_ejercicioComparativosFlujosCaja(esInicial);
		this.setActivarnombre_centro_actividadComparativosFlujosCaja(esInicial);
		this.setActivartipo_movimientoComparativosFlujosCaja(esInicial);
		this.setActivarsaldo_actualComparativosFlujosCaja(esInicial);
		this.setActivarsaldo_acumuladoComparativosFlujosCaja(esInicial);
		this.setActivarsaldo_pres_actualComparativosFlujosCaja(esInicial);
		this.setActivarsaldo_pres_acumuladoComparativosFlujosCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.ID)) {
				this.setActivaridComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD)) {
				this.setActivarnombre_centro_actividadComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL)) {
				this.setActivarsaldo_actualComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO)) {
				this.setActivarsaldo_acumuladoComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL)) {
				this.setActivarsaldo_pres_actualComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO)) {
				this.setActivarsaldo_pres_acumuladoComparativosFlujosCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComparativosFlujosCaja(esInicial);
		this.setResaltarid_empresaComparativosFlujosCaja(esInicial);
		this.setResaltarid_ejercicioComparativosFlujosCaja(esInicial);
		this.setResaltarnombre_centro_actividadComparativosFlujosCaja(esInicial);
		this.setResaltartipo_movimientoComparativosFlujosCaja(esInicial);
		this.setResaltarsaldo_actualComparativosFlujosCaja(esInicial);
		this.setResaltarsaldo_acumuladoComparativosFlujosCaja(esInicial);
		this.setResaltarsaldo_pres_actualComparativosFlujosCaja(esInicial);
		this.setResaltarsaldo_pres_acumuladoComparativosFlujosCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.ID)) {
				this.setResaltaridComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.NOMBRECENTROACTIVIDAD)) {
				this.setResaltarnombre_centro_actividadComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACTUAL)) {
				this.setResaltarsaldo_actualComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOACUMULADO)) {
				this.setResaltarsaldo_acumuladoComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACTUAL)) {
				this.setResaltarsaldo_pres_actualComparativosFlujosCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComparativosFlujosCajaConstantesFunciones.SALDOPRESACUMULADO)) {
				this.setResaltarsaldo_pres_acumuladoComparativosFlujosCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComparativosFlujosCajaComparativosFlujosCaja=true;

	public Boolean getMostrarBusquedaComparativosFlujosCajaComparativosFlujosCaja() {
		return this.mostrarBusquedaComparativosFlujosCajaComparativosFlujosCaja;
	}

	public void setMostrarBusquedaComparativosFlujosCajaComparativosFlujosCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComparativosFlujosCajaComparativosFlujosCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComparativosFlujosCajaComparativosFlujosCaja=true;

	public Boolean getActivarBusquedaComparativosFlujosCajaComparativosFlujosCaja() {
		return this.activarBusquedaComparativosFlujosCajaComparativosFlujosCaja;
	}

	public void setActivarBusquedaComparativosFlujosCajaComparativosFlujosCaja(Boolean habilitarResaltar) {
		this.activarBusquedaComparativosFlujosCajaComparativosFlujosCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja=null;

	public Border getResaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja() {
		return this.resaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja;
	}

	public void setResaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja(Border borderResaltar) {
		this.resaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja= borderResaltar;
	}

	public void setResaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ComparativosFlujosCajaBeanSwingJInternalFrame comparativosflujoscajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComparativosFlujosCajaComparativosFlujosCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}