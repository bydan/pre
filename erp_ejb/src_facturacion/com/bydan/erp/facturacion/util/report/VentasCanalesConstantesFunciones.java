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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.VentasCanalesConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasCanalesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasCanalesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VentasCanalesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasCanales";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasCanales"+VentasCanalesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasCanalesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasCanalesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasCanalesConstantesFunciones.SCHEMA+"_"+VentasCanalesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasCanalesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasCanalesConstantesFunciones.SCHEMA+"_"+VentasCanalesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasCanalesConstantesFunciones.SCHEMA+"_"+VentasCanalesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasCanalesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasCanalesConstantesFunciones.SCHEMA+"_"+VentasCanalesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCanalesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasCanalesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCanalesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCanalesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasCanalesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasCanalesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasCanalesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasCanalesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasCanalesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasCanalesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Canaleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Canales";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Canales";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasCanales";
	public static final String OBJECTNAME="ventascanales";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_canales";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventascanales from "+VentasCanalesConstantesFunciones.SPERSISTENCENAME+" ventascanales";
	public static String QUERYSELECTNATIVE="select "+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".id,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".version_row,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".id_empresa,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".id_titulo_cliente,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".nombre_titulo_cliente,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".monto,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".codigo_titulo_cliente,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".notas_credito,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".venta_neta,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".porcentaje,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".acumulado,"+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME+".tipo from "+VentasCanalesConstantesFunciones.SCHEMA+"."+VentasCanalesConstantesFunciones.TABLENAME;//+" as "+VentasCanalesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTITULOCLIENTE= "id_titulo_cliente";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRETITULOCLIENTE= "nombre_titulo_cliente";
    public static final String MONTO= "monto";
    public static final String CODIGOTITULOCLIENTE= "codigo_titulo_cliente";
    public static final String NOTASCREDITO= "notas_credito";
    public static final String VENTANETA= "venta_neta";
    public static final String PORCENTAJE= "porcentaje";
    public static final String ACUMULADO= "acumulado";
    public static final String TIPO= "tipo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTITULOCLIENTE= "Titulo Cliente";
		public static final String LABEL_IDTITULOCLIENTE_LOWER= "Titulo Cliente";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRETITULOCLIENTE= "Nombre Titulo Cliente";
		public static final String LABEL_NOMBRETITULOCLIENTE_LOWER= "Nombre Titulo Cliente";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_CODIGOTITULOCLIENTE= "Codigo Titulo Cliente";
		public static final String LABEL_CODIGOTITULOCLIENTE_LOWER= "Codigo Titulo Cliente";
    	public static final String LABEL_NOTASCREDITO= "Notas Credito";
		public static final String LABEL_NOTASCREDITO_LOWER= "Notas Credito";
    	public static final String LABEL_VENTANETA= "Venta Neta";
		public static final String LABEL_VENTANETA_LOWER= "Venta Neta";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_ACUMULADO= "Acumulado";
		public static final String LABEL_ACUMULADO_LOWER= "Acumulado";
    	public static final String LABEL_TIPO= "Tipo";
		public static final String LABEL_TIPO_LOWER= "Tipo";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_TITULO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TITULO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_TITULO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TITULO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXTIPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVentasCanalesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.IDTITULOCLIENTE)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_IDTITULOCLIENTE;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_NOMBRETITULOCLIENTE;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.MONTO)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_CODIGOTITULOCLIENTE;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.NOTASCREDITO)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.VENTANETA)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_VENTANETA;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.PORCENTAJE)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.ACUMULADO)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_ACUMULADO;}
		if(sNombreColumna.equals(VentasCanalesConstantesFunciones.TIPO)) {sLabelColumna=VentasCanalesConstantesFunciones.LABEL_TIPO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasCanalesDescripcion(VentasCanales ventascanales) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventascanales !=null/* && ventascanales.getId()!=0*/) {
			sDescripcion=ventascanales.getfecha_emision_desde().toString();//ventascanalesventascanales.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasCanalesDescripcionDetallado(VentasCanales ventascanales) {
		String sDescripcion="";
			
		sDescripcion+=VentasCanalesConstantesFunciones.ID+"=";
		sDescripcion+=ventascanales.getId().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventascanales.getVersionRow().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventascanales.getid_empresa().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.IDTITULOCLIENTE+"=";
		sDescripcion+=ventascanales.getid_titulo_cliente().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventascanales.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventascanales.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE+"=";
		sDescripcion+=ventascanales.getnombre_titulo_cliente()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.MONTO+"=";
		sDescripcion+=ventascanales.getmonto().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE+"=";
		sDescripcion+=ventascanales.getcodigo_titulo_cliente()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.NOTASCREDITO+"=";
		sDescripcion+=ventascanales.getnotas_credito().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.VENTANETA+"=";
		sDescripcion+=ventascanales.getventa_neta().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=ventascanales.getporcentaje().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.ACUMULADO+"=";
		sDescripcion+=ventascanales.getacumulado().toString()+",";
		sDescripcion+=VentasCanalesConstantesFunciones.TIPO+"=";
		sDescripcion+=ventascanales.gettipo()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasCanalesDescripcion(VentasCanales ventascanales,String sValor) throws Exception {			
		if(ventascanales !=null) {
			//ventascanalesventascanales.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTituloClienteDescripcion(TituloCliente titulocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(titulocliente!=null/*&&titulocliente.getId()>0*/) {
			sDescripcion=TituloClienteConstantesFunciones.getTituloClienteDescripcion(titulocliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentasCanales")) {
			sNombreIndice="Tipo=  Por Titulo Cliente Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTituloCliente")) {
			sNombreIndice="Tipo=  Por Titulo Cliente";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasCanales(Long id_titulo_cliente,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_titulo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Titulo Cliente="+id_titulo_cliente.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTituloCliente(Long id_titulo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_titulo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Titulo Cliente="+id_titulo_cliente.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVentasCanales(VentasCanales ventascanales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventascanales.setnombre_titulo_cliente(ventascanales.getnombre_titulo_cliente().trim());
		ventascanales.setcodigo_titulo_cliente(ventascanales.getcodigo_titulo_cliente().trim());
		ventascanales.settipo(ventascanales.gettipo().trim());
	}
	
	public static void quitarEspaciosVentasCanaless(List<VentasCanales> ventascanaless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasCanales ventascanales: ventascanaless) {
			ventascanales.setnombre_titulo_cliente(ventascanales.getnombre_titulo_cliente().trim());
			ventascanales.setcodigo_titulo_cliente(ventascanales.getcodigo_titulo_cliente().trim());
			ventascanales.settipo(ventascanales.gettipo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasCanales(VentasCanales ventascanales,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventascanales.getConCambioAuxiliar()) {
			ventascanales.setIsDeleted(ventascanales.getIsDeletedAuxiliar());	
			ventascanales.setIsNew(ventascanales.getIsNewAuxiliar());	
			ventascanales.setIsChanged(ventascanales.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventascanales.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventascanales.setIsDeletedAuxiliar(false);	
			ventascanales.setIsNewAuxiliar(false);	
			ventascanales.setIsChangedAuxiliar(false);
			
			ventascanales.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasCanaless(List<VentasCanales> ventascanaless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasCanales ventascanales : ventascanaless) {
			if(conAsignarBase && ventascanales.getConCambioAuxiliar()) {
				ventascanales.setIsDeleted(ventascanales.getIsDeletedAuxiliar());	
				ventascanales.setIsNew(ventascanales.getIsNewAuxiliar());	
				ventascanales.setIsChanged(ventascanales.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventascanales.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventascanales.setIsDeletedAuxiliar(false);	
				ventascanales.setIsNewAuxiliar(false);	
				ventascanales.setIsChangedAuxiliar(false);
				
				ventascanales.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasCanales(VentasCanales ventascanales,Boolean conEnteros) throws Exception  {
		ventascanales.setmonto(0.0);
		ventascanales.setnotas_credito(0.0);
		ventascanales.setventa_neta(0.0);
		ventascanales.setporcentaje(0.0);
		ventascanales.setacumulado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasCanaless(List<VentasCanales> ventascanaless,Boolean conEnteros) throws Exception  {
		
		for(VentasCanales ventascanales: ventascanaless) {
			ventascanales.setmonto(0.0);
			ventascanales.setnotas_credito(0.0);
			ventascanales.setventa_neta(0.0);
			ventascanales.setporcentaje(0.0);
			ventascanales.setacumulado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasCanales(List<VentasCanales> ventascanaless,VentasCanales ventascanalesAux) throws Exception  {
		VentasCanalesConstantesFunciones.InicializarValoresVentasCanales(ventascanalesAux,true);
		
		for(VentasCanales ventascanales: ventascanaless) {
			if(ventascanales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventascanalesAux.setmonto(ventascanalesAux.getmonto()+ventascanales.getmonto());			
			ventascanalesAux.setnotas_credito(ventascanalesAux.getnotas_credito()+ventascanales.getnotas_credito());			
			ventascanalesAux.setventa_neta(ventascanalesAux.getventa_neta()+ventascanales.getventa_neta());			
			ventascanalesAux.setporcentaje(ventascanalesAux.getporcentaje()+ventascanales.getporcentaje());			
			ventascanalesAux.setacumulado(ventascanalesAux.getacumulado()+ventascanales.getacumulado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasCanales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasCanalesConstantesFunciones.getArrayColumnasGlobalesVentasCanales(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasCanales(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasCanalesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasCanalesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasCanales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasCanales> ventascanaless,VentasCanales ventascanales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasCanales ventascanalesAux: ventascanaless) {
			if(ventascanalesAux!=null && ventascanales!=null) {
				if((ventascanalesAux.getId()==null && ventascanales.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventascanalesAux.getId()!=null && ventascanales.getId()!=null){
					if(ventascanalesAux.getId().equals(ventascanales.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasCanales(List<VentasCanales> ventascanaless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double notas_creditoTotal=0.0;
		Double venta_netaTotal=0.0;
		Double porcentajeTotal=0.0;
		Double acumuladoTotal=0.0;
	
		for(VentasCanales ventascanales: ventascanaless) {			
			if(ventascanales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=ventascanales.getmonto();
			notas_creditoTotal+=ventascanales.getnotas_credito();
			venta_netaTotal+=ventascanales.getventa_neta();
			porcentajeTotal+=ventascanales.getporcentaje();
			acumuladoTotal+=ventascanales.getacumulado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.NOTASCREDITO);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO);
		datoGeneral.setdValorDouble(notas_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.VENTANETA);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_VENTANETA);
		datoGeneral.setdValorDouble(venta_netaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasCanalesConstantesFunciones.ACUMULADO);
		datoGeneral.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_ACUMULADO);
		datoGeneral.setdValorDouble(acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasCanales() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_ID, VentasCanalesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_VERSIONROW, VentasCanalesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_NOMBRETITULOCLIENTE, VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_MONTO, VentasCanalesConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_CODIGOTITULOCLIENTE, VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO, VentasCanalesConstantesFunciones.NOTASCREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_VENTANETA, VentasCanalesConstantesFunciones.VENTANETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_PORCENTAJE, VentasCanalesConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_ACUMULADO, VentasCanalesConstantesFunciones.ACUMULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasCanalesConstantesFunciones.LABEL_TIPO, VentasCanalesConstantesFunciones.TIPO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasCanales() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.NOTASCREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.VENTANETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.ACUMULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasCanalesConstantesFunciones.TIPO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasCanales() throws Exception  {
		return VentasCanalesConstantesFunciones.getTiposSeleccionarVentasCanales(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasCanales(Boolean conFk) throws Exception  {
		return VentasCanalesConstantesFunciones.getTiposSeleccionarVentasCanales(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasCanales(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_IDTITULOCLIENTE);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_IDTITULOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_NOMBRETITULOCLIENTE);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_NOMBRETITULOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_CODIGOTITULOCLIENTE);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_CODIGOTITULOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_VENTANETA);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_VENTANETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_ACUMULADO);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_ACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasCanalesConstantesFunciones.LABEL_TIPO);
			reporte.setsDescripcion(VentasCanalesConstantesFunciones.LABEL_TIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasCanales(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasCanales(VentasCanales ventascanalesAux) throws Exception {
		
			ventascanalesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventascanalesAux.getEmpresa()));
			ventascanalesAux.settitulocliente_descripcion(TituloClienteConstantesFunciones.getTituloClienteDescripcion(ventascanalesAux.getTituloCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasCanales(List<VentasCanales> ventascanalessTemp) throws Exception {
		for(VentasCanales ventascanalesAux:ventascanalessTemp) {
			
			ventascanalesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventascanalesAux.getEmpresa()));
			ventascanalesAux.settitulocliente_descripcion(TituloClienteConstantesFunciones.getTituloClienteDescripcion(ventascanalesAux.getTituloCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasCanales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TituloCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TituloCliente.class)) {
						classes.add(new Classe(TituloCliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasCanales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TituloCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TituloCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TituloCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TituloCliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasCanales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasCanalesConstantesFunciones.getClassesRelationshipsOfVentasCanales(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasCanales(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasCanales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasCanalesConstantesFunciones.getClassesRelationshipsFromStringsOfVentasCanales(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasCanales(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasCanales ventascanales,List<VentasCanales> ventascanaless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasCanales ventascanales,List<VentasCanales> ventascanaless) throws Exception {
		try	{			
			for(VentasCanales ventascanalesLocal:ventascanaless) {
				if(ventascanalesLocal.getId().equals(ventascanales.getId())) {
					ventascanalesLocal.setIsSelected(ventascanales.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasCanales(List<VentasCanales> ventascanalessAux) throws Exception {
		//this.ventascanalessAux=ventascanalessAux;
		
		for(VentasCanales ventascanalesAux:ventascanalessAux) {
			if(ventascanalesAux.getIsChanged()) {
				ventascanalesAux.setIsChanged(false);
			}		
			
			if(ventascanalesAux.getIsNew()) {
				ventascanalesAux.setIsNew(false);
			}	
			
			if(ventascanalesAux.getIsDeleted()) {
				ventascanalesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasCanales(VentasCanales ventascanalesAux) throws Exception {
		//this.ventascanalesAux=ventascanalesAux;
		
			if(ventascanalesAux.getIsChanged()) {
				ventascanalesAux.setIsChanged(false);
			}		
			
			if(ventascanalesAux.getIsNew()) {
				ventascanalesAux.setIsNew(false);
			}	
			
			if(ventascanalesAux.getIsDeleted()) {
				ventascanalesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasCanales ventascanalesAsignar,VentasCanales ventascanales) throws Exception {
		ventascanalesAsignar.setId(ventascanales.getId());	
		ventascanalesAsignar.setVersionRow(ventascanales.getVersionRow());	
		ventascanalesAsignar.setnombre_titulo_cliente(ventascanales.getnombre_titulo_cliente());	
		ventascanalesAsignar.setmonto(ventascanales.getmonto());	
		ventascanalesAsignar.setcodigo_titulo_cliente(ventascanales.getcodigo_titulo_cliente());	
		ventascanalesAsignar.setnotas_credito(ventascanales.getnotas_credito());	
		ventascanalesAsignar.setventa_neta(ventascanales.getventa_neta());	
		ventascanalesAsignar.setporcentaje(ventascanales.getporcentaje());	
		ventascanalesAsignar.setacumulado(ventascanales.getacumulado());	
		ventascanalesAsignar.settipo(ventascanales.gettipo());	
	}
	
	public static void inicializarVentasCanales(VentasCanales ventascanales) throws Exception {
		try {
				ventascanales.setId(0L);	
					
				ventascanales.setnombre_titulo_cliente("");	
				ventascanales.setmonto(0.0);	
				ventascanales.setcodigo_titulo_cliente("");	
				ventascanales.setnotas_credito(0.0);	
				ventascanales.setventa_neta(0.0);	
				ventascanales.setporcentaje(0.0);	
				ventascanales.setacumulado(0.0);	
				ventascanales.settipo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasCanales(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_IDTITULOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_NOMBRETITULOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_CODIGOTITULOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_NOTASCREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_VENTANETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_ACUMULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasCanalesConstantesFunciones.LABEL_TIPO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasCanales(String sTipo,Row row,Workbook workbook,VentasCanales ventascanales,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.gettitulocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getnombre_titulo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getcodigo_titulo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getnotas_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getventa_neta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.getacumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventascanales.gettipo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasCanales="";
	
	public String getsFinalQueryVentasCanales() {
		return this.sFinalQueryVentasCanales;
	}
	
	public void setsFinalQueryVentasCanales(String sFinalQueryVentasCanales) {
		this.sFinalQueryVentasCanales= sFinalQueryVentasCanales;
	}
	
	public Border resaltarSeleccionarVentasCanales=null;
	
	public Border setResaltarSeleccionarVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasCanales= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasCanales() {
		return this.resaltarSeleccionarVentasCanales;
	}
	
	public void setResaltarSeleccionarVentasCanales(Border borderResaltarSeleccionarVentasCanales) {
		this.resaltarSeleccionarVentasCanales= borderResaltarSeleccionarVentasCanales;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasCanales=null;
	public Boolean mostraridVentasCanales=true;
	public Boolean activaridVentasCanales=true;

	public Border resaltarid_empresaVentasCanales=null;
	public Boolean mostrarid_empresaVentasCanales=true;
	public Boolean activarid_empresaVentasCanales=true;
	public Boolean cargarid_empresaVentasCanales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasCanales=false;//ConEventDepend=true

	public Border resaltarid_titulo_clienteVentasCanales=null;
	public Boolean mostrarid_titulo_clienteVentasCanales=true;
	public Boolean activarid_titulo_clienteVentasCanales=true;
	public Boolean cargarid_titulo_clienteVentasCanales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_titulo_clienteVentasCanales=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasCanales=null;
	public Boolean mostrarfecha_emision_desdeVentasCanales=true;
	public Boolean activarfecha_emision_desdeVentasCanales=true;

	public Border resaltarfecha_emision_hastaVentasCanales=null;
	public Boolean mostrarfecha_emision_hastaVentasCanales=true;
	public Boolean activarfecha_emision_hastaVentasCanales=true;

	public Border resaltarnombre_titulo_clienteVentasCanales=null;
	public Boolean mostrarnombre_titulo_clienteVentasCanales=true;
	public Boolean activarnombre_titulo_clienteVentasCanales=true;

	public Border resaltarmontoVentasCanales=null;
	public Boolean mostrarmontoVentasCanales=true;
	public Boolean activarmontoVentasCanales=true;

	public Border resaltarcodigo_titulo_clienteVentasCanales=null;
	public Boolean mostrarcodigo_titulo_clienteVentasCanales=true;
	public Boolean activarcodigo_titulo_clienteVentasCanales=true;

	public Border resaltarnotas_creditoVentasCanales=null;
	public Boolean mostrarnotas_creditoVentasCanales=true;
	public Boolean activarnotas_creditoVentasCanales=true;

	public Border resaltarventa_netaVentasCanales=null;
	public Boolean mostrarventa_netaVentasCanales=true;
	public Boolean activarventa_netaVentasCanales=true;

	public Border resaltarporcentajeVentasCanales=null;
	public Boolean mostrarporcentajeVentasCanales=true;
	public Boolean activarporcentajeVentasCanales=true;

	public Border resaltaracumuladoVentasCanales=null;
	public Boolean mostraracumuladoVentasCanales=true;
	public Boolean activaracumuladoVentasCanales=true;

	public Border resaltartipoVentasCanales=null;
	public Boolean mostrartipoVentasCanales=true;
	public Boolean activartipoVentasCanales=true;

	
	

	public Border setResaltaridVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltaridVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasCanales() {
		return this.resaltaridVentasCanales;
	}

	public void setResaltaridVentasCanales(Border borderResaltar) {
		this.resaltaridVentasCanales= borderResaltar;
	}

	public Boolean getMostraridVentasCanales() {
		return this.mostraridVentasCanales;
	}

	public void setMostraridVentasCanales(Boolean mostraridVentasCanales) {
		this.mostraridVentasCanales= mostraridVentasCanales;
	}

	public Boolean getActivaridVentasCanales() {
		return this.activaridVentasCanales;
	}

	public void setActivaridVentasCanales(Boolean activaridVentasCanales) {
		this.activaridVentasCanales= activaridVentasCanales;
	}

	public Border setResaltarid_empresaVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasCanales() {
		return this.resaltarid_empresaVentasCanales;
	}

	public void setResaltarid_empresaVentasCanales(Border borderResaltar) {
		this.resaltarid_empresaVentasCanales= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasCanales() {
		return this.mostrarid_empresaVentasCanales;
	}

	public void setMostrarid_empresaVentasCanales(Boolean mostrarid_empresaVentasCanales) {
		this.mostrarid_empresaVentasCanales= mostrarid_empresaVentasCanales;
	}

	public Boolean getActivarid_empresaVentasCanales() {
		return this.activarid_empresaVentasCanales;
	}

	public void setActivarid_empresaVentasCanales(Boolean activarid_empresaVentasCanales) {
		this.activarid_empresaVentasCanales= activarid_empresaVentasCanales;
	}

	public Boolean getCargarid_empresaVentasCanales() {
		return this.cargarid_empresaVentasCanales;
	}

	public void setCargarid_empresaVentasCanales(Boolean cargarid_empresaVentasCanales) {
		this.cargarid_empresaVentasCanales= cargarid_empresaVentasCanales;
	}

	public Border setResaltarid_titulo_clienteVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarid_titulo_clienteVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_titulo_clienteVentasCanales() {
		return this.resaltarid_titulo_clienteVentasCanales;
	}

	public void setResaltarid_titulo_clienteVentasCanales(Border borderResaltar) {
		this.resaltarid_titulo_clienteVentasCanales= borderResaltar;
	}

	public Boolean getMostrarid_titulo_clienteVentasCanales() {
		return this.mostrarid_titulo_clienteVentasCanales;
	}

	public void setMostrarid_titulo_clienteVentasCanales(Boolean mostrarid_titulo_clienteVentasCanales) {
		this.mostrarid_titulo_clienteVentasCanales= mostrarid_titulo_clienteVentasCanales;
	}

	public Boolean getActivarid_titulo_clienteVentasCanales() {
		return this.activarid_titulo_clienteVentasCanales;
	}

	public void setActivarid_titulo_clienteVentasCanales(Boolean activarid_titulo_clienteVentasCanales) {
		this.activarid_titulo_clienteVentasCanales= activarid_titulo_clienteVentasCanales;
	}

	public Boolean getCargarid_titulo_clienteVentasCanales() {
		return this.cargarid_titulo_clienteVentasCanales;
	}

	public void setCargarid_titulo_clienteVentasCanales(Boolean cargarid_titulo_clienteVentasCanales) {
		this.cargarid_titulo_clienteVentasCanales= cargarid_titulo_clienteVentasCanales;
	}

	public Border setResaltarfecha_emision_desdeVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasCanales() {
		return this.resaltarfecha_emision_desdeVentasCanales;
	}

	public void setResaltarfecha_emision_desdeVentasCanales(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasCanales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasCanales() {
		return this.mostrarfecha_emision_desdeVentasCanales;
	}

	public void setMostrarfecha_emision_desdeVentasCanales(Boolean mostrarfecha_emision_desdeVentasCanales) {
		this.mostrarfecha_emision_desdeVentasCanales= mostrarfecha_emision_desdeVentasCanales;
	}

	public Boolean getActivarfecha_emision_desdeVentasCanales() {
		return this.activarfecha_emision_desdeVentasCanales;
	}

	public void setActivarfecha_emision_desdeVentasCanales(Boolean activarfecha_emision_desdeVentasCanales) {
		this.activarfecha_emision_desdeVentasCanales= activarfecha_emision_desdeVentasCanales;
	}

	public Border setResaltarfecha_emision_hastaVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasCanales() {
		return this.resaltarfecha_emision_hastaVentasCanales;
	}

	public void setResaltarfecha_emision_hastaVentasCanales(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasCanales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasCanales() {
		return this.mostrarfecha_emision_hastaVentasCanales;
	}

	public void setMostrarfecha_emision_hastaVentasCanales(Boolean mostrarfecha_emision_hastaVentasCanales) {
		this.mostrarfecha_emision_hastaVentasCanales= mostrarfecha_emision_hastaVentasCanales;
	}

	public Boolean getActivarfecha_emision_hastaVentasCanales() {
		return this.activarfecha_emision_hastaVentasCanales;
	}

	public void setActivarfecha_emision_hastaVentasCanales(Boolean activarfecha_emision_hastaVentasCanales) {
		this.activarfecha_emision_hastaVentasCanales= activarfecha_emision_hastaVentasCanales;
	}

	public Border setResaltarnombre_titulo_clienteVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarnombre_titulo_clienteVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_titulo_clienteVentasCanales() {
		return this.resaltarnombre_titulo_clienteVentasCanales;
	}

	public void setResaltarnombre_titulo_clienteVentasCanales(Border borderResaltar) {
		this.resaltarnombre_titulo_clienteVentasCanales= borderResaltar;
	}

	public Boolean getMostrarnombre_titulo_clienteVentasCanales() {
		return this.mostrarnombre_titulo_clienteVentasCanales;
	}

	public void setMostrarnombre_titulo_clienteVentasCanales(Boolean mostrarnombre_titulo_clienteVentasCanales) {
		this.mostrarnombre_titulo_clienteVentasCanales= mostrarnombre_titulo_clienteVentasCanales;
	}

	public Boolean getActivarnombre_titulo_clienteVentasCanales() {
		return this.activarnombre_titulo_clienteVentasCanales;
	}

	public void setActivarnombre_titulo_clienteVentasCanales(Boolean activarnombre_titulo_clienteVentasCanales) {
		this.activarnombre_titulo_clienteVentasCanales= activarnombre_titulo_clienteVentasCanales;
	}

	public Border setResaltarmontoVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarmontoVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoVentasCanales() {
		return this.resaltarmontoVentasCanales;
	}

	public void setResaltarmontoVentasCanales(Border borderResaltar) {
		this.resaltarmontoVentasCanales= borderResaltar;
	}

	public Boolean getMostrarmontoVentasCanales() {
		return this.mostrarmontoVentasCanales;
	}

	public void setMostrarmontoVentasCanales(Boolean mostrarmontoVentasCanales) {
		this.mostrarmontoVentasCanales= mostrarmontoVentasCanales;
	}

	public Boolean getActivarmontoVentasCanales() {
		return this.activarmontoVentasCanales;
	}

	public void setActivarmontoVentasCanales(Boolean activarmontoVentasCanales) {
		this.activarmontoVentasCanales= activarmontoVentasCanales;
	}

	public Border setResaltarcodigo_titulo_clienteVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarcodigo_titulo_clienteVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_titulo_clienteVentasCanales() {
		return this.resaltarcodigo_titulo_clienteVentasCanales;
	}

	public void setResaltarcodigo_titulo_clienteVentasCanales(Border borderResaltar) {
		this.resaltarcodigo_titulo_clienteVentasCanales= borderResaltar;
	}

	public Boolean getMostrarcodigo_titulo_clienteVentasCanales() {
		return this.mostrarcodigo_titulo_clienteVentasCanales;
	}

	public void setMostrarcodigo_titulo_clienteVentasCanales(Boolean mostrarcodigo_titulo_clienteVentasCanales) {
		this.mostrarcodigo_titulo_clienteVentasCanales= mostrarcodigo_titulo_clienteVentasCanales;
	}

	public Boolean getActivarcodigo_titulo_clienteVentasCanales() {
		return this.activarcodigo_titulo_clienteVentasCanales;
	}

	public void setActivarcodigo_titulo_clienteVentasCanales(Boolean activarcodigo_titulo_clienteVentasCanales) {
		this.activarcodigo_titulo_clienteVentasCanales= activarcodigo_titulo_clienteVentasCanales;
	}

	public Border setResaltarnotas_creditoVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarnotas_creditoVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnotas_creditoVentasCanales() {
		return this.resaltarnotas_creditoVentasCanales;
	}

	public void setResaltarnotas_creditoVentasCanales(Border borderResaltar) {
		this.resaltarnotas_creditoVentasCanales= borderResaltar;
	}

	public Boolean getMostrarnotas_creditoVentasCanales() {
		return this.mostrarnotas_creditoVentasCanales;
	}

	public void setMostrarnotas_creditoVentasCanales(Boolean mostrarnotas_creditoVentasCanales) {
		this.mostrarnotas_creditoVentasCanales= mostrarnotas_creditoVentasCanales;
	}

	public Boolean getActivarnotas_creditoVentasCanales() {
		return this.activarnotas_creditoVentasCanales;
	}

	public void setActivarnotas_creditoVentasCanales(Boolean activarnotas_creditoVentasCanales) {
		this.activarnotas_creditoVentasCanales= activarnotas_creditoVentasCanales;
	}

	public Border setResaltarventa_netaVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarventa_netaVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarventa_netaVentasCanales() {
		return this.resaltarventa_netaVentasCanales;
	}

	public void setResaltarventa_netaVentasCanales(Border borderResaltar) {
		this.resaltarventa_netaVentasCanales= borderResaltar;
	}

	public Boolean getMostrarventa_netaVentasCanales() {
		return this.mostrarventa_netaVentasCanales;
	}

	public void setMostrarventa_netaVentasCanales(Boolean mostrarventa_netaVentasCanales) {
		this.mostrarventa_netaVentasCanales= mostrarventa_netaVentasCanales;
	}

	public Boolean getActivarventa_netaVentasCanales() {
		return this.activarventa_netaVentasCanales;
	}

	public void setActivarventa_netaVentasCanales(Boolean activarventa_netaVentasCanales) {
		this.activarventa_netaVentasCanales= activarventa_netaVentasCanales;
	}

	public Border setResaltarporcentajeVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltarporcentajeVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeVentasCanales() {
		return this.resaltarporcentajeVentasCanales;
	}

	public void setResaltarporcentajeVentasCanales(Border borderResaltar) {
		this.resaltarporcentajeVentasCanales= borderResaltar;
	}

	public Boolean getMostrarporcentajeVentasCanales() {
		return this.mostrarporcentajeVentasCanales;
	}

	public void setMostrarporcentajeVentasCanales(Boolean mostrarporcentajeVentasCanales) {
		this.mostrarporcentajeVentasCanales= mostrarporcentajeVentasCanales;
	}

	public Boolean getActivarporcentajeVentasCanales() {
		return this.activarporcentajeVentasCanales;
	}

	public void setActivarporcentajeVentasCanales(Boolean activarporcentajeVentasCanales) {
		this.activarporcentajeVentasCanales= activarporcentajeVentasCanales;
	}

	public Border setResaltaracumuladoVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltaracumuladoVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaracumuladoVentasCanales() {
		return this.resaltaracumuladoVentasCanales;
	}

	public void setResaltaracumuladoVentasCanales(Border borderResaltar) {
		this.resaltaracumuladoVentasCanales= borderResaltar;
	}

	public Boolean getMostraracumuladoVentasCanales() {
		return this.mostraracumuladoVentasCanales;
	}

	public void setMostraracumuladoVentasCanales(Boolean mostraracumuladoVentasCanales) {
		this.mostraracumuladoVentasCanales= mostraracumuladoVentasCanales;
	}

	public Boolean getActivaracumuladoVentasCanales() {
		return this.activaracumuladoVentasCanales;
	}

	public void setActivaracumuladoVentasCanales(Boolean activaracumuladoVentasCanales) {
		this.activaracumuladoVentasCanales= activaracumuladoVentasCanales;
	}

	public Border setResaltartipoVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventascanalesBeanSwingJInternalFrame.jTtoolBarVentasCanales.setBorder(borderResaltar);
		
		this.resaltartipoVentasCanales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipoVentasCanales() {
		return this.resaltartipoVentasCanales;
	}

	public void setResaltartipoVentasCanales(Border borderResaltar) {
		this.resaltartipoVentasCanales= borderResaltar;
	}

	public Boolean getMostrartipoVentasCanales() {
		return this.mostrartipoVentasCanales;
	}

	public void setMostrartipoVentasCanales(Boolean mostrartipoVentasCanales) {
		this.mostrartipoVentasCanales= mostrartipoVentasCanales;
	}

	public Boolean getActivartipoVentasCanales() {
		return this.activartipoVentasCanales;
	}

	public void setActivartipoVentasCanales(Boolean activartipoVentasCanales) {
		this.activartipoVentasCanales= activartipoVentasCanales;
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
		
		
		this.setMostraridVentasCanales(esInicial);
		this.setMostrarid_empresaVentasCanales(esInicial);
		this.setMostrarid_titulo_clienteVentasCanales(esInicial);
		this.setMostrarfecha_emision_desdeVentasCanales(esInicial);
		this.setMostrarfecha_emision_hastaVentasCanales(esInicial);
		this.setMostrarnombre_titulo_clienteVentasCanales(esInicial);
		this.setMostrarmontoVentasCanales(esInicial);
		this.setMostrarcodigo_titulo_clienteVentasCanales(esInicial);
		this.setMostrarnotas_creditoVentasCanales(esInicial);
		this.setMostrarventa_netaVentasCanales(esInicial);
		this.setMostrarporcentajeVentasCanales(esInicial);
		this.setMostraracumuladoVentasCanales(esInicial);
		this.setMostrartipoVentasCanales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasCanalesConstantesFunciones.ID)) {
				this.setMostraridVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.IDTITULOCLIENTE)) {
				this.setMostrarid_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE)) {
				this.setMostrarnombre_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.MONTO)) {
				this.setMostrarmontoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE)) {
				this.setMostrarcodigo_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.NOTASCREDITO)) {
				this.setMostrarnotas_creditoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.VENTANETA)) {
				this.setMostrarventa_netaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.ACUMULADO)) {
				this.setMostraracumuladoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.TIPO)) {
				this.setMostrartipoVentasCanales(esAsigna);
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
		
		
		this.setActivaridVentasCanales(esInicial);
		this.setActivarid_empresaVentasCanales(esInicial);
		this.setActivarid_titulo_clienteVentasCanales(esInicial);
		this.setActivarfecha_emision_desdeVentasCanales(esInicial);
		this.setActivarfecha_emision_hastaVentasCanales(esInicial);
		this.setActivarnombre_titulo_clienteVentasCanales(esInicial);
		this.setActivarmontoVentasCanales(esInicial);
		this.setActivarcodigo_titulo_clienteVentasCanales(esInicial);
		this.setActivarnotas_creditoVentasCanales(esInicial);
		this.setActivarventa_netaVentasCanales(esInicial);
		this.setActivarporcentajeVentasCanales(esInicial);
		this.setActivaracumuladoVentasCanales(esInicial);
		this.setActivartipoVentasCanales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasCanalesConstantesFunciones.ID)) {
				this.setActivaridVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.IDTITULOCLIENTE)) {
				this.setActivarid_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE)) {
				this.setActivarnombre_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.MONTO)) {
				this.setActivarmontoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE)) {
				this.setActivarcodigo_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.NOTASCREDITO)) {
				this.setActivarnotas_creditoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.VENTANETA)) {
				this.setActivarventa_netaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.ACUMULADO)) {
				this.setActivaracumuladoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.TIPO)) {
				this.setActivartipoVentasCanales(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasCanales(esInicial);
		this.setResaltarid_empresaVentasCanales(esInicial);
		this.setResaltarid_titulo_clienteVentasCanales(esInicial);
		this.setResaltarfecha_emision_desdeVentasCanales(esInicial);
		this.setResaltarfecha_emision_hastaVentasCanales(esInicial);
		this.setResaltarnombre_titulo_clienteVentasCanales(esInicial);
		this.setResaltarmontoVentasCanales(esInicial);
		this.setResaltarcodigo_titulo_clienteVentasCanales(esInicial);
		this.setResaltarnotas_creditoVentasCanales(esInicial);
		this.setResaltarventa_netaVentasCanales(esInicial);
		this.setResaltarporcentajeVentasCanales(esInicial);
		this.setResaltaracumuladoVentasCanales(esInicial);
		this.setResaltartipoVentasCanales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasCanalesConstantesFunciones.ID)) {
				this.setResaltaridVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.IDTITULOCLIENTE)) {
				this.setResaltarid_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.NOMBRETITULOCLIENTE)) {
				this.setResaltarnombre_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.MONTO)) {
				this.setResaltarmontoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.CODIGOTITULOCLIENTE)) {
				this.setResaltarcodigo_titulo_clienteVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.NOTASCREDITO)) {
				this.setResaltarnotas_creditoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.VENTANETA)) {
				this.setResaltarventa_netaVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.ACUMULADO)) {
				this.setResaltaracumuladoVentasCanales(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasCanalesConstantesFunciones.TIPO)) {
				this.setResaltartipoVentasCanales(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasCanalesVentasCanales=true;

	public Boolean getMostrarBusquedaVentasCanalesVentasCanales() {
		return this.mostrarBusquedaVentasCanalesVentasCanales;
	}

	public void setMostrarBusquedaVentasCanalesVentasCanales(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasCanalesVentasCanales= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasCanalesVentasCanales=true;

	public Boolean getActivarBusquedaVentasCanalesVentasCanales() {
		return this.activarBusquedaVentasCanalesVentasCanales;
	}

	public void setActivarBusquedaVentasCanalesVentasCanales(Boolean habilitarResaltar) {
		this.activarBusquedaVentasCanalesVentasCanales= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasCanalesVentasCanales=null;

	public Border getResaltarBusquedaVentasCanalesVentasCanales() {
		return this.resaltarBusquedaVentasCanalesVentasCanales;
	}

	public void setResaltarBusquedaVentasCanalesVentasCanales(Border borderResaltar) {
		this.resaltarBusquedaVentasCanalesVentasCanales= borderResaltar;
	}

	public void setResaltarBusquedaVentasCanalesVentasCanales(ParametroGeneralUsuario parametroGeneralUsuario/*VentasCanalesBeanSwingJInternalFrame ventascanalesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasCanalesVentasCanales= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}