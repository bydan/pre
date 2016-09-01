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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.ListadoMovimientosConstantesFunciones;
import com.bydan.erp.cartera.util.report.ListadoMovimientosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.ListadoMovimientosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ListadoMovimientosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ListadoMovimientos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ListadoMovimientos"+ListadoMovimientosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ListadoMovimientosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ListadoMovimientosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ListadoMovimientosConstantesFunciones.SCHEMA+"_"+ListadoMovimientosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ListadoMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ListadoMovimientosConstantesFunciones.SCHEMA+"_"+ListadoMovimientosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ListadoMovimientosConstantesFunciones.SCHEMA+"_"+ListadoMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ListadoMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ListadoMovimientosConstantesFunciones.SCHEMA+"_"+ListadoMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadoMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ListadoMovimientosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ListadoMovimientosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ListadoMovimientosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ListadoMovimientosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ListadoMovimientosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ListadoMovimientosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Listado Movimientoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Listado Movimientos";
	public static final String SCLASSWEBTITULO_LOWER="Listado Movimientos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ListadoMovimientos";
	public static final String OBJECTNAME="listadomovimientos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="listado_movimientos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select listadomovimientos from "+ListadoMovimientosConstantesFunciones.SPERSISTENCENAME+" listadomovimientos";
	public static String QUERYSELECTNATIVE="select "+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".id,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".version_row,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".id_empresa,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".nombre_transaccion,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".fecha_emision,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".fecha_venta,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".numero_comprobante,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".nombre_cliente,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".debito_mone_local,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".credito_mone_local,"+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME+".descripcion from "+ListadoMovimientosConstantesFunciones.SCHEMA+"."+ListadoMovimientosConstantesFunciones.TABLENAME;//+" as "+ListadoMovimientosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENTA= "fecha_venta";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENTA= "Fecha Venta";
		public static final String LABEL_FECHAVENTA_LOWER= "Fecha Venta";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getListadoMovimientosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.IDEMPRESA)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.FECHAEMISION)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.FECHAVENTA)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_FECHAVENTA;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(ListadoMovimientosConstantesFunciones.DESCRIPCION)) {sLabelColumna=ListadoMovimientosConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getListadoMovimientosDescripcion(ListadoMovimientos listadomovimientos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(listadomovimientos !=null/* && listadomovimientos.getId()!=0*/) {
			sDescripcion=listadomovimientos.getfecha_emision_hasta().toString();//listadomovimientoslistadomovimientos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getListadoMovimientosDescripcionDetallado(ListadoMovimientos listadomovimientos) {
		String sDescripcion="";
			
		sDescripcion+=ListadoMovimientosConstantesFunciones.ID+"=";
		sDescripcion+=listadomovimientos.getId().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=listadomovimientos.getVersionRow().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=listadomovimientos.getid_empresa().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=listadomovimientos.getfecha_emision_desde().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=listadomovimientos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=listadomovimientos.getnombre_transaccion()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=listadomovimientos.getfecha_emision().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.FECHAVENTA+"=";
		sDescripcion+=listadomovimientos.getfecha_venta().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=listadomovimientos.getnumero_comprobante()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=listadomovimientos.getnombre_cliente()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=listadomovimientos.getdebito_mone_local().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=listadomovimientos.getcredito_mone_local().toString()+",";
		sDescripcion+=ListadoMovimientosConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=listadomovimientos.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setListadoMovimientosDescripcion(ListadoMovimientos listadomovimientos,String sValor) throws Exception {			
		if(listadomovimientos !=null) {
			//listadomovimientoslistadomovimientos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaListadoMovimientos")) {
			sNombreIndice="Tipo=  Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaListadoMovimientos(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosListadoMovimientos(ListadoMovimientos listadomovimientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		listadomovimientos.setnombre_transaccion(listadomovimientos.getnombre_transaccion().trim());
		listadomovimientos.setnumero_comprobante(listadomovimientos.getnumero_comprobante().trim());
		listadomovimientos.setnombre_cliente(listadomovimientos.getnombre_cliente().trim());
		listadomovimientos.setdescripcion(listadomovimientos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosListadoMovimientoss(List<ListadoMovimientos> listadomovimientoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ListadoMovimientos listadomovimientos: listadomovimientoss) {
			listadomovimientos.setnombre_transaccion(listadomovimientos.getnombre_transaccion().trim());
			listadomovimientos.setnumero_comprobante(listadomovimientos.getnumero_comprobante().trim());
			listadomovimientos.setnombre_cliente(listadomovimientos.getnombre_cliente().trim());
			listadomovimientos.setdescripcion(listadomovimientos.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadoMovimientos(ListadoMovimientos listadomovimientos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && listadomovimientos.getConCambioAuxiliar()) {
			listadomovimientos.setIsDeleted(listadomovimientos.getIsDeletedAuxiliar());	
			listadomovimientos.setIsNew(listadomovimientos.getIsNewAuxiliar());	
			listadomovimientos.setIsChanged(listadomovimientos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			listadomovimientos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			listadomovimientos.setIsDeletedAuxiliar(false);	
			listadomovimientos.setIsNewAuxiliar(false);	
			listadomovimientos.setIsChangedAuxiliar(false);
			
			listadomovimientos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresListadoMovimientoss(List<ListadoMovimientos> listadomovimientoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ListadoMovimientos listadomovimientos : listadomovimientoss) {
			if(conAsignarBase && listadomovimientos.getConCambioAuxiliar()) {
				listadomovimientos.setIsDeleted(listadomovimientos.getIsDeletedAuxiliar());	
				listadomovimientos.setIsNew(listadomovimientos.getIsNewAuxiliar());	
				listadomovimientos.setIsChanged(listadomovimientos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				listadomovimientos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				listadomovimientos.setIsDeletedAuxiliar(false);	
				listadomovimientos.setIsNewAuxiliar(false);	
				listadomovimientos.setIsChangedAuxiliar(false);
				
				listadomovimientos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresListadoMovimientos(ListadoMovimientos listadomovimientos,Boolean conEnteros) throws Exception  {
		listadomovimientos.setdebito_mone_local(0.0);
		listadomovimientos.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresListadoMovimientoss(List<ListadoMovimientos> listadomovimientoss,Boolean conEnteros) throws Exception  {
		
		for(ListadoMovimientos listadomovimientos: listadomovimientoss) {
			listadomovimientos.setdebito_mone_local(0.0);
			listadomovimientos.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaListadoMovimientos(List<ListadoMovimientos> listadomovimientoss,ListadoMovimientos listadomovimientosAux) throws Exception  {
		ListadoMovimientosConstantesFunciones.InicializarValoresListadoMovimientos(listadomovimientosAux,true);
		
		for(ListadoMovimientos listadomovimientos: listadomovimientoss) {
			if(listadomovimientos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			listadomovimientosAux.setdebito_mone_local(listadomovimientosAux.getdebito_mone_local()+listadomovimientos.getdebito_mone_local());			
			listadomovimientosAux.setcredito_mone_local(listadomovimientosAux.getcredito_mone_local()+listadomovimientos.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoMovimientos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ListadoMovimientosConstantesFunciones.getArrayColumnasGlobalesListadoMovimientos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesListadoMovimientos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ListadoMovimientosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ListadoMovimientosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoListadoMovimientos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ListadoMovimientos> listadomovimientoss,ListadoMovimientos listadomovimientos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ListadoMovimientos listadomovimientosAux: listadomovimientoss) {
			if(listadomovimientosAux!=null && listadomovimientos!=null) {
				if((listadomovimientosAux.getId()==null && listadomovimientos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(listadomovimientosAux.getId()!=null && listadomovimientos.getId()!=null){
					if(listadomovimientosAux.getId().equals(listadomovimientos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaListadoMovimientos(List<ListadoMovimientos> listadomovimientoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(ListadoMovimientos listadomovimientos: listadomovimientoss) {			
			if(listadomovimientos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=listadomovimientos.getdebito_mone_local();
			credito_mone_localTotal+=listadomovimientos.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaListadoMovimientos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_ID, ListadoMovimientosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_VERSIONROW, ListadoMovimientosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION, ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISION, ListadoMovimientosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_FECHAVENTA, ListadoMovimientosConstantesFunciones.FECHAVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE, ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_NOMBRECLIENTE, ListadoMovimientosConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL, ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL, ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ListadoMovimientosConstantesFunciones.LABEL_DESCRIPCION, ListadoMovimientosConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasListadoMovimientos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.FECHAVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ListadoMovimientosConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoMovimientos() throws Exception  {
		return ListadoMovimientosConstantesFunciones.getTiposSeleccionarListadoMovimientos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoMovimientos(Boolean conFk) throws Exception  {
		return ListadoMovimientosConstantesFunciones.getTiposSeleccionarListadoMovimientos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarListadoMovimientos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_FECHAVENTA);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_FECHAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ListadoMovimientosConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ListadoMovimientosConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesListadoMovimientos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesListadoMovimientos(ListadoMovimientos listadomovimientosAux) throws Exception {
		
			listadomovimientosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadomovimientosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesListadoMovimientos(List<ListadoMovimientos> listadomovimientossTemp) throws Exception {
		for(ListadoMovimientos listadomovimientosAux:listadomovimientossTemp) {
			
			listadomovimientosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(listadomovimientosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfListadoMovimientos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfListadoMovimientos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadoMovimientos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadoMovimientosConstantesFunciones.getClassesRelationshipsOfListadoMovimientos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfListadoMovimientos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadoMovimientos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ListadoMovimientosConstantesFunciones.getClassesRelationshipsFromStringsOfListadoMovimientos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfListadoMovimientos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ListadoMovimientos listadomovimientos,List<ListadoMovimientos> listadomovimientoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ListadoMovimientos listadomovimientos,List<ListadoMovimientos> listadomovimientoss) throws Exception {
		try	{			
			for(ListadoMovimientos listadomovimientosLocal:listadomovimientoss) {
				if(listadomovimientosLocal.getId().equals(listadomovimientos.getId())) {
					listadomovimientosLocal.setIsSelected(listadomovimientos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesListadoMovimientos(List<ListadoMovimientos> listadomovimientossAux) throws Exception {
		//this.listadomovimientossAux=listadomovimientossAux;
		
		for(ListadoMovimientos listadomovimientosAux:listadomovimientossAux) {
			if(listadomovimientosAux.getIsChanged()) {
				listadomovimientosAux.setIsChanged(false);
			}		
			
			if(listadomovimientosAux.getIsNew()) {
				listadomovimientosAux.setIsNew(false);
			}	
			
			if(listadomovimientosAux.getIsDeleted()) {
				listadomovimientosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesListadoMovimientos(ListadoMovimientos listadomovimientosAux) throws Exception {
		//this.listadomovimientosAux=listadomovimientosAux;
		
			if(listadomovimientosAux.getIsChanged()) {
				listadomovimientosAux.setIsChanged(false);
			}		
			
			if(listadomovimientosAux.getIsNew()) {
				listadomovimientosAux.setIsNew(false);
			}	
			
			if(listadomovimientosAux.getIsDeleted()) {
				listadomovimientosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ListadoMovimientos listadomovimientosAsignar,ListadoMovimientos listadomovimientos) throws Exception {
		listadomovimientosAsignar.setId(listadomovimientos.getId());	
		listadomovimientosAsignar.setVersionRow(listadomovimientos.getVersionRow());	
		listadomovimientosAsignar.setnombre_transaccion(listadomovimientos.getnombre_transaccion());	
		listadomovimientosAsignar.setfecha_emision(listadomovimientos.getfecha_emision());	
		listadomovimientosAsignar.setfecha_venta(listadomovimientos.getfecha_venta());	
		listadomovimientosAsignar.setnumero_comprobante(listadomovimientos.getnumero_comprobante());	
		listadomovimientosAsignar.setnombre_cliente(listadomovimientos.getnombre_cliente());	
		listadomovimientosAsignar.setdebito_mone_local(listadomovimientos.getdebito_mone_local());	
		listadomovimientosAsignar.setcredito_mone_local(listadomovimientos.getcredito_mone_local());	
		listadomovimientosAsignar.setdescripcion(listadomovimientos.getdescripcion());	
	}
	
	public static void inicializarListadoMovimientos(ListadoMovimientos listadomovimientos) throws Exception {
		try {
				listadomovimientos.setId(0L);	
					
				listadomovimientos.setnombre_transaccion("");	
				listadomovimientos.setfecha_emision(new Date());	
				listadomovimientos.setfecha_venta(new Date());	
				listadomovimientos.setnumero_comprobante("");	
				listadomovimientos.setnombre_cliente("");	
				listadomovimientos.setdebito_mone_local(0.0);	
				listadomovimientos.setcredito_mone_local(0.0);	
				listadomovimientos.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderListadoMovimientos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_FECHAVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ListadoMovimientosConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataListadoMovimientos(String sTipo,Row row,Workbook workbook,ListadoMovimientos listadomovimientos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getfecha_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(listadomovimientos.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryListadoMovimientos="";
	
	public String getsFinalQueryListadoMovimientos() {
		return this.sFinalQueryListadoMovimientos;
	}
	
	public void setsFinalQueryListadoMovimientos(String sFinalQueryListadoMovimientos) {
		this.sFinalQueryListadoMovimientos= sFinalQueryListadoMovimientos;
	}
	
	public Border resaltarSeleccionarListadoMovimientos=null;
	
	public Border setResaltarSeleccionarListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarListadoMovimientos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarListadoMovimientos() {
		return this.resaltarSeleccionarListadoMovimientos;
	}
	
	public void setResaltarSeleccionarListadoMovimientos(Border borderResaltarSeleccionarListadoMovimientos) {
		this.resaltarSeleccionarListadoMovimientos= borderResaltarSeleccionarListadoMovimientos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridListadoMovimientos=null;
	public Boolean mostraridListadoMovimientos=true;
	public Boolean activaridListadoMovimientos=true;

	public Border resaltarid_empresaListadoMovimientos=null;
	public Boolean mostrarid_empresaListadoMovimientos=true;
	public Boolean activarid_empresaListadoMovimientos=true;
	public Boolean cargarid_empresaListadoMovimientos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaListadoMovimientos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeListadoMovimientos=null;
	public Boolean mostrarfecha_emision_desdeListadoMovimientos=true;
	public Boolean activarfecha_emision_desdeListadoMovimientos=true;

	public Border resaltarfecha_emision_hastaListadoMovimientos=null;
	public Boolean mostrarfecha_emision_hastaListadoMovimientos=true;
	public Boolean activarfecha_emision_hastaListadoMovimientos=true;

	public Border resaltarnombre_transaccionListadoMovimientos=null;
	public Boolean mostrarnombre_transaccionListadoMovimientos=true;
	public Boolean activarnombre_transaccionListadoMovimientos=true;

	public Border resaltarfecha_emisionListadoMovimientos=null;
	public Boolean mostrarfecha_emisionListadoMovimientos=true;
	public Boolean activarfecha_emisionListadoMovimientos=true;

	public Border resaltarfecha_ventaListadoMovimientos=null;
	public Boolean mostrarfecha_ventaListadoMovimientos=true;
	public Boolean activarfecha_ventaListadoMovimientos=true;

	public Border resaltarnumero_comprobanteListadoMovimientos=null;
	public Boolean mostrarnumero_comprobanteListadoMovimientos=true;
	public Boolean activarnumero_comprobanteListadoMovimientos=true;

	public Border resaltarnombre_clienteListadoMovimientos=null;
	public Boolean mostrarnombre_clienteListadoMovimientos=true;
	public Boolean activarnombre_clienteListadoMovimientos=true;

	public Border resaltardebito_mone_localListadoMovimientos=null;
	public Boolean mostrardebito_mone_localListadoMovimientos=true;
	public Boolean activardebito_mone_localListadoMovimientos=true;

	public Border resaltarcredito_mone_localListadoMovimientos=null;
	public Boolean mostrarcredito_mone_localListadoMovimientos=true;
	public Boolean activarcredito_mone_localListadoMovimientos=true;

	public Border resaltardescripcionListadoMovimientos=null;
	public Boolean mostrardescripcionListadoMovimientos=true;
	public Boolean activardescripcionListadoMovimientos=true;

	
	

	public Border setResaltaridListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltaridListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridListadoMovimientos() {
		return this.resaltaridListadoMovimientos;
	}

	public void setResaltaridListadoMovimientos(Border borderResaltar) {
		this.resaltaridListadoMovimientos= borderResaltar;
	}

	public Boolean getMostraridListadoMovimientos() {
		return this.mostraridListadoMovimientos;
	}

	public void setMostraridListadoMovimientos(Boolean mostraridListadoMovimientos) {
		this.mostraridListadoMovimientos= mostraridListadoMovimientos;
	}

	public Boolean getActivaridListadoMovimientos() {
		return this.activaridListadoMovimientos;
	}

	public void setActivaridListadoMovimientos(Boolean activaridListadoMovimientos) {
		this.activaridListadoMovimientos= activaridListadoMovimientos;
	}

	public Border setResaltarid_empresaListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarid_empresaListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaListadoMovimientos() {
		return this.resaltarid_empresaListadoMovimientos;
	}

	public void setResaltarid_empresaListadoMovimientos(Border borderResaltar) {
		this.resaltarid_empresaListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarid_empresaListadoMovimientos() {
		return this.mostrarid_empresaListadoMovimientos;
	}

	public void setMostrarid_empresaListadoMovimientos(Boolean mostrarid_empresaListadoMovimientos) {
		this.mostrarid_empresaListadoMovimientos= mostrarid_empresaListadoMovimientos;
	}

	public Boolean getActivarid_empresaListadoMovimientos() {
		return this.activarid_empresaListadoMovimientos;
	}

	public void setActivarid_empresaListadoMovimientos(Boolean activarid_empresaListadoMovimientos) {
		this.activarid_empresaListadoMovimientos= activarid_empresaListadoMovimientos;
	}

	public Boolean getCargarid_empresaListadoMovimientos() {
		return this.cargarid_empresaListadoMovimientos;
	}

	public void setCargarid_empresaListadoMovimientos(Boolean cargarid_empresaListadoMovimientos) {
		this.cargarid_empresaListadoMovimientos= cargarid_empresaListadoMovimientos;
	}

	public Border setResaltarfecha_emision_desdeListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeListadoMovimientos() {
		return this.resaltarfecha_emision_desdeListadoMovimientos;
	}

	public void setResaltarfecha_emision_desdeListadoMovimientos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeListadoMovimientos() {
		return this.mostrarfecha_emision_desdeListadoMovimientos;
	}

	public void setMostrarfecha_emision_desdeListadoMovimientos(Boolean mostrarfecha_emision_desdeListadoMovimientos) {
		this.mostrarfecha_emision_desdeListadoMovimientos= mostrarfecha_emision_desdeListadoMovimientos;
	}

	public Boolean getActivarfecha_emision_desdeListadoMovimientos() {
		return this.activarfecha_emision_desdeListadoMovimientos;
	}

	public void setActivarfecha_emision_desdeListadoMovimientos(Boolean activarfecha_emision_desdeListadoMovimientos) {
		this.activarfecha_emision_desdeListadoMovimientos= activarfecha_emision_desdeListadoMovimientos;
	}

	public Border setResaltarfecha_emision_hastaListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaListadoMovimientos() {
		return this.resaltarfecha_emision_hastaListadoMovimientos;
	}

	public void setResaltarfecha_emision_hastaListadoMovimientos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaListadoMovimientos() {
		return this.mostrarfecha_emision_hastaListadoMovimientos;
	}

	public void setMostrarfecha_emision_hastaListadoMovimientos(Boolean mostrarfecha_emision_hastaListadoMovimientos) {
		this.mostrarfecha_emision_hastaListadoMovimientos= mostrarfecha_emision_hastaListadoMovimientos;
	}

	public Boolean getActivarfecha_emision_hastaListadoMovimientos() {
		return this.activarfecha_emision_hastaListadoMovimientos;
	}

	public void setActivarfecha_emision_hastaListadoMovimientos(Boolean activarfecha_emision_hastaListadoMovimientos) {
		this.activarfecha_emision_hastaListadoMovimientos= activarfecha_emision_hastaListadoMovimientos;
	}

	public Border setResaltarnombre_transaccionListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionListadoMovimientos() {
		return this.resaltarnombre_transaccionListadoMovimientos;
	}

	public void setResaltarnombre_transaccionListadoMovimientos(Border borderResaltar) {
		this.resaltarnombre_transaccionListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionListadoMovimientos() {
		return this.mostrarnombre_transaccionListadoMovimientos;
	}

	public void setMostrarnombre_transaccionListadoMovimientos(Boolean mostrarnombre_transaccionListadoMovimientos) {
		this.mostrarnombre_transaccionListadoMovimientos= mostrarnombre_transaccionListadoMovimientos;
	}

	public Boolean getActivarnombre_transaccionListadoMovimientos() {
		return this.activarnombre_transaccionListadoMovimientos;
	}

	public void setActivarnombre_transaccionListadoMovimientos(Boolean activarnombre_transaccionListadoMovimientos) {
		this.activarnombre_transaccionListadoMovimientos= activarnombre_transaccionListadoMovimientos;
	}

	public Border setResaltarfecha_emisionListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionListadoMovimientos() {
		return this.resaltarfecha_emisionListadoMovimientos;
	}

	public void setResaltarfecha_emisionListadoMovimientos(Border borderResaltar) {
		this.resaltarfecha_emisionListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionListadoMovimientos() {
		return this.mostrarfecha_emisionListadoMovimientos;
	}

	public void setMostrarfecha_emisionListadoMovimientos(Boolean mostrarfecha_emisionListadoMovimientos) {
		this.mostrarfecha_emisionListadoMovimientos= mostrarfecha_emisionListadoMovimientos;
	}

	public Boolean getActivarfecha_emisionListadoMovimientos() {
		return this.activarfecha_emisionListadoMovimientos;
	}

	public void setActivarfecha_emisionListadoMovimientos(Boolean activarfecha_emisionListadoMovimientos) {
		this.activarfecha_emisionListadoMovimientos= activarfecha_emisionListadoMovimientos;
	}

	public Border setResaltarfecha_ventaListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarfecha_ventaListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ventaListadoMovimientos() {
		return this.resaltarfecha_ventaListadoMovimientos;
	}

	public void setResaltarfecha_ventaListadoMovimientos(Border borderResaltar) {
		this.resaltarfecha_ventaListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarfecha_ventaListadoMovimientos() {
		return this.mostrarfecha_ventaListadoMovimientos;
	}

	public void setMostrarfecha_ventaListadoMovimientos(Boolean mostrarfecha_ventaListadoMovimientos) {
		this.mostrarfecha_ventaListadoMovimientos= mostrarfecha_ventaListadoMovimientos;
	}

	public Boolean getActivarfecha_ventaListadoMovimientos() {
		return this.activarfecha_ventaListadoMovimientos;
	}

	public void setActivarfecha_ventaListadoMovimientos(Boolean activarfecha_ventaListadoMovimientos) {
		this.activarfecha_ventaListadoMovimientos= activarfecha_ventaListadoMovimientos;
	}

	public Border setResaltarnumero_comprobanteListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteListadoMovimientos() {
		return this.resaltarnumero_comprobanteListadoMovimientos;
	}

	public void setResaltarnumero_comprobanteListadoMovimientos(Border borderResaltar) {
		this.resaltarnumero_comprobanteListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteListadoMovimientos() {
		return this.mostrarnumero_comprobanteListadoMovimientos;
	}

	public void setMostrarnumero_comprobanteListadoMovimientos(Boolean mostrarnumero_comprobanteListadoMovimientos) {
		this.mostrarnumero_comprobanteListadoMovimientos= mostrarnumero_comprobanteListadoMovimientos;
	}

	public Boolean getActivarnumero_comprobanteListadoMovimientos() {
		return this.activarnumero_comprobanteListadoMovimientos;
	}

	public void setActivarnumero_comprobanteListadoMovimientos(Boolean activarnumero_comprobanteListadoMovimientos) {
		this.activarnumero_comprobanteListadoMovimientos= activarnumero_comprobanteListadoMovimientos;
	}

	public Border setResaltarnombre_clienteListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteListadoMovimientos() {
		return this.resaltarnombre_clienteListadoMovimientos;
	}

	public void setResaltarnombre_clienteListadoMovimientos(Border borderResaltar) {
		this.resaltarnombre_clienteListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteListadoMovimientos() {
		return this.mostrarnombre_clienteListadoMovimientos;
	}

	public void setMostrarnombre_clienteListadoMovimientos(Boolean mostrarnombre_clienteListadoMovimientos) {
		this.mostrarnombre_clienteListadoMovimientos= mostrarnombre_clienteListadoMovimientos;
	}

	public Boolean getActivarnombre_clienteListadoMovimientos() {
		return this.activarnombre_clienteListadoMovimientos;
	}

	public void setActivarnombre_clienteListadoMovimientos(Boolean activarnombre_clienteListadoMovimientos) {
		this.activarnombre_clienteListadoMovimientos= activarnombre_clienteListadoMovimientos;
	}

	public Border setResaltardebito_mone_localListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localListadoMovimientos() {
		return this.resaltardebito_mone_localListadoMovimientos;
	}

	public void setResaltardebito_mone_localListadoMovimientos(Border borderResaltar) {
		this.resaltardebito_mone_localListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localListadoMovimientos() {
		return this.mostrardebito_mone_localListadoMovimientos;
	}

	public void setMostrardebito_mone_localListadoMovimientos(Boolean mostrardebito_mone_localListadoMovimientos) {
		this.mostrardebito_mone_localListadoMovimientos= mostrardebito_mone_localListadoMovimientos;
	}

	public Boolean getActivardebito_mone_localListadoMovimientos() {
		return this.activardebito_mone_localListadoMovimientos;
	}

	public void setActivardebito_mone_localListadoMovimientos(Boolean activardebito_mone_localListadoMovimientos) {
		this.activardebito_mone_localListadoMovimientos= activardebito_mone_localListadoMovimientos;
	}

	public Border setResaltarcredito_mone_localListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localListadoMovimientos() {
		return this.resaltarcredito_mone_localListadoMovimientos;
	}

	public void setResaltarcredito_mone_localListadoMovimientos(Border borderResaltar) {
		this.resaltarcredito_mone_localListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localListadoMovimientos() {
		return this.mostrarcredito_mone_localListadoMovimientos;
	}

	public void setMostrarcredito_mone_localListadoMovimientos(Boolean mostrarcredito_mone_localListadoMovimientos) {
		this.mostrarcredito_mone_localListadoMovimientos= mostrarcredito_mone_localListadoMovimientos;
	}

	public Boolean getActivarcredito_mone_localListadoMovimientos() {
		return this.activarcredito_mone_localListadoMovimientos;
	}

	public void setActivarcredito_mone_localListadoMovimientos(Boolean activarcredito_mone_localListadoMovimientos) {
		this.activarcredito_mone_localListadoMovimientos= activarcredito_mone_localListadoMovimientos;
	}

	public Border setResaltardescripcionListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//listadomovimientosBeanSwingJInternalFrame.jTtoolBarListadoMovimientos.setBorder(borderResaltar);
		
		this.resaltardescripcionListadoMovimientos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionListadoMovimientos() {
		return this.resaltardescripcionListadoMovimientos;
	}

	public void setResaltardescripcionListadoMovimientos(Border borderResaltar) {
		this.resaltardescripcionListadoMovimientos= borderResaltar;
	}

	public Boolean getMostrardescripcionListadoMovimientos() {
		return this.mostrardescripcionListadoMovimientos;
	}

	public void setMostrardescripcionListadoMovimientos(Boolean mostrardescripcionListadoMovimientos) {
		this.mostrardescripcionListadoMovimientos= mostrardescripcionListadoMovimientos;
	}

	public Boolean getActivardescripcionListadoMovimientos() {
		return this.activardescripcionListadoMovimientos;
	}

	public void setActivardescripcionListadoMovimientos(Boolean activardescripcionListadoMovimientos) {
		this.activardescripcionListadoMovimientos= activardescripcionListadoMovimientos;
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
		
		
		this.setMostraridListadoMovimientos(esInicial);
		this.setMostrarid_empresaListadoMovimientos(esInicial);
		this.setMostrarfecha_emision_desdeListadoMovimientos(esInicial);
		this.setMostrarfecha_emision_hastaListadoMovimientos(esInicial);
		this.setMostrarnombre_transaccionListadoMovimientos(esInicial);
		this.setMostrarfecha_emisionListadoMovimientos(esInicial);
		this.setMostrarfecha_ventaListadoMovimientos(esInicial);
		this.setMostrarnumero_comprobanteListadoMovimientos(esInicial);
		this.setMostrarnombre_clienteListadoMovimientos(esInicial);
		this.setMostrardebito_mone_localListadoMovimientos(esInicial);
		this.setMostrarcredito_mone_localListadoMovimientos(esInicial);
		this.setMostrardescripcionListadoMovimientos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.ID)) {
				this.setMostraridListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAVENTA)) {
				this.setMostrarfecha_ventaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionListadoMovimientos(esAsigna);
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
		
		
		this.setActivaridListadoMovimientos(esInicial);
		this.setActivarid_empresaListadoMovimientos(esInicial);
		this.setActivarfecha_emision_desdeListadoMovimientos(esInicial);
		this.setActivarfecha_emision_hastaListadoMovimientos(esInicial);
		this.setActivarnombre_transaccionListadoMovimientos(esInicial);
		this.setActivarfecha_emisionListadoMovimientos(esInicial);
		this.setActivarfecha_ventaListadoMovimientos(esInicial);
		this.setActivarnumero_comprobanteListadoMovimientos(esInicial);
		this.setActivarnombre_clienteListadoMovimientos(esInicial);
		this.setActivardebito_mone_localListadoMovimientos(esInicial);
		this.setActivarcredito_mone_localListadoMovimientos(esInicial);
		this.setActivardescripcionListadoMovimientos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.ID)) {
				this.setActivaridListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAVENTA)) {
				this.setActivarfecha_ventaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionListadoMovimientos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridListadoMovimientos(esInicial);
		this.setResaltarid_empresaListadoMovimientos(esInicial);
		this.setResaltarfecha_emision_desdeListadoMovimientos(esInicial);
		this.setResaltarfecha_emision_hastaListadoMovimientos(esInicial);
		this.setResaltarnombre_transaccionListadoMovimientos(esInicial);
		this.setResaltarfecha_emisionListadoMovimientos(esInicial);
		this.setResaltarfecha_ventaListadoMovimientos(esInicial);
		this.setResaltarnumero_comprobanteListadoMovimientos(esInicial);
		this.setResaltarnombre_clienteListadoMovimientos(esInicial);
		this.setResaltardebito_mone_localListadoMovimientos(esInicial);
		this.setResaltarcredito_mone_localListadoMovimientos(esInicial);
		this.setResaltardescripcionListadoMovimientos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.ID)) {
				this.setResaltaridListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.FECHAVENTA)) {
				this.setResaltarfecha_ventaListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localListadoMovimientos(esAsigna);
				continue;
			}

			if(campo.clase.equals(ListadoMovimientosConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionListadoMovimientos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaListadoMovimientosListadoMovimientos=true;

	public Boolean getMostrarBusquedaListadoMovimientosListadoMovimientos() {
		return this.mostrarBusquedaListadoMovimientosListadoMovimientos;
	}

	public void setMostrarBusquedaListadoMovimientosListadoMovimientos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaListadoMovimientosListadoMovimientos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaListadoMovimientosListadoMovimientos=true;

	public Boolean getActivarBusquedaListadoMovimientosListadoMovimientos() {
		return this.activarBusquedaListadoMovimientosListadoMovimientos;
	}

	public void setActivarBusquedaListadoMovimientosListadoMovimientos(Boolean habilitarResaltar) {
		this.activarBusquedaListadoMovimientosListadoMovimientos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaListadoMovimientosListadoMovimientos=null;

	public Border getResaltarBusquedaListadoMovimientosListadoMovimientos() {
		return this.resaltarBusquedaListadoMovimientosListadoMovimientos;
	}

	public void setResaltarBusquedaListadoMovimientosListadoMovimientos(Border borderResaltar) {
		this.resaltarBusquedaListadoMovimientosListadoMovimientos= borderResaltar;
	}

	public void setResaltarBusquedaListadoMovimientosListadoMovimientos(ParametroGeneralUsuario parametroGeneralUsuario/*ListadoMovimientosBeanSwingJInternalFrame listadomovimientosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaListadoMovimientosListadoMovimientos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}