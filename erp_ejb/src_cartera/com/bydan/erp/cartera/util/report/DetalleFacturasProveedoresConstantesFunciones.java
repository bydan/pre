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


import com.bydan.erp.cartera.util.report.DetalleFacturasProveedoresConstantesFunciones;
import com.bydan.erp.cartera.util.report.DetalleFacturasProveedoresParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.DetalleFacturasProveedoresParameterGeneral;

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
final public class DetalleFacturasProveedoresConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleFacturasProveedores";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleFacturasProveedores"+DetalleFacturasProveedoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleFacturasProveedoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleFacturasProveedoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"_"+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"_"+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"_"+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"_"+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleFacturasProveedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleFacturasProveedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleFacturasProveedoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleFacturasProveedoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleFacturasProveedoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleFacturasProveedoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Facturas Proveedoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Facturas Proveedores";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Facturas Proveedores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleFacturasProveedores";
	public static final String OBJECTNAME="detallefacturasproveedores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_facturas_proveedores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallefacturasproveedores from "+DetalleFacturasProveedoresConstantesFunciones.SPERSISTENCENAME+" detallefacturasproveedores";
	public static String QUERYSELECTNATIVE="select "+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".id,"+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".version_row,"+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".id_empresa,"+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".nombre_cliente,"+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".cantidad_facturas,"+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".total_valor,"+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME+".mes from "+DetalleFacturasProveedoresConstantesFunciones.SCHEMA+"."+DetalleFacturasProveedoresConstantesFunciones.TABLENAME;//+" as "+DetalleFacturasProveedoresConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String CANTIDADFACTURAS= "cantidad_facturas";
    public static final String TOTALVALOR= "total_valor";
    public static final String MES= "mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_CANTIDADFACTURAS= "Cantad Facturas";
		public static final String LABEL_CANTIDADFACTURAS_LOWER= "Cantidad Facturas";
    	public static final String LABEL_TOTALVALOR= "Total Valor";
		public static final String LABEL_TOTALVALOR_LOWER= "Total Valor";
    	public static final String LABEL_MES= "Mes";
		public static final String LABEL_MES_LOWER= "Mes";
	
		
		
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getDetalleFacturasProveedoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=DetalleFacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS)) {sLabelColumna=DetalleFacturasProveedoresConstantesFunciones.LABEL_CANTIDADFACTURAS;}
		if(sNombreColumna.equals(DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR)) {sLabelColumna=DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR;}
		if(sNombreColumna.equals(DetalleFacturasProveedoresConstantesFunciones.MES)) {sLabelColumna=DetalleFacturasProveedoresConstantesFunciones.LABEL_MES;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getDetalleFacturasProveedoresDescripcion(DetalleFacturasProveedores detallefacturasproveedores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallefacturasproveedores !=null/* && detallefacturasproveedores.getId()!=0*/) {
			sDescripcion=detallefacturasproveedores.getnombre_cliente();//detallefacturasproveedoresdetallefacturasproveedores.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleFacturasProveedoresDescripcionDetallado(DetalleFacturasProveedores detallefacturasproveedores) {
		String sDescripcion="";
			
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.ID+"=";
		sDescripcion+=detallefacturasproveedores.getId().toString()+",";
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallefacturasproveedores.getVersionRow().toString()+",";
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallefacturasproveedores.getid_empresa().toString()+",";
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=detallefacturasproveedores.getnombre_cliente()+",";
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS+"=";
		sDescripcion+=detallefacturasproveedores.getcantidad_facturas().toString()+",";
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR+"=";
		sDescripcion+=detallefacturasproveedores.gettotal_valor().toString()+",";
		sDescripcion+=DetalleFacturasProveedoresConstantesFunciones.MES+"=";
		sDescripcion+=detallefacturasproveedores.getmes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleFacturasProveedoresDescripcion(DetalleFacturasProveedores detallefacturasproveedores,String sValor) throws Exception {			
		if(detallefacturasproveedores !=null) {
			detallefacturasproveedores.setnombre_cliente(sValor);//detallefacturasproveedoresdetallefacturasproveedores.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaDetalleFacturasProveedores")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDetalleFacturasProveedores(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallefacturasproveedores.setnombre_cliente(detallefacturasproveedores.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosDetalleFacturasProveedoress(List<DetalleFacturasProveedores> detallefacturasproveedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleFacturasProveedores detallefacturasproveedores: detallefacturasproveedoress) {
			detallefacturasproveedores.setnombre_cliente(detallefacturasproveedores.getnombre_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallefacturasproveedores.getConCambioAuxiliar()) {
			detallefacturasproveedores.setIsDeleted(detallefacturasproveedores.getIsDeletedAuxiliar());	
			detallefacturasproveedores.setIsNew(detallefacturasproveedores.getIsNewAuxiliar());	
			detallefacturasproveedores.setIsChanged(detallefacturasproveedores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallefacturasproveedores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallefacturasproveedores.setIsDeletedAuxiliar(false);	
			detallefacturasproveedores.setIsNewAuxiliar(false);	
			detallefacturasproveedores.setIsChangedAuxiliar(false);
			
			detallefacturasproveedores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleFacturasProveedoress(List<DetalleFacturasProveedores> detallefacturasproveedoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleFacturasProveedores detallefacturasproveedores : detallefacturasproveedoress) {
			if(conAsignarBase && detallefacturasproveedores.getConCambioAuxiliar()) {
				detallefacturasproveedores.setIsDeleted(detallefacturasproveedores.getIsDeletedAuxiliar());	
				detallefacturasproveedores.setIsNew(detallefacturasproveedores.getIsNewAuxiliar());	
				detallefacturasproveedores.setIsChanged(detallefacturasproveedores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallefacturasproveedores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallefacturasproveedores.setIsDeletedAuxiliar(false);	
				detallefacturasproveedores.setIsNewAuxiliar(false);	
				detallefacturasproveedores.setIsChangedAuxiliar(false);
				
				detallefacturasproveedores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedores,Boolean conEnteros) throws Exception  {
		detallefacturasproveedores.settotal_valor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallefacturasproveedores.setcantidad_facturas(0);
			detallefacturasproveedores.setmes(0);
		}
	}		
	
	public static void InicializarValoresDetalleFacturasProveedoress(List<DetalleFacturasProveedores> detallefacturasproveedoress,Boolean conEnteros) throws Exception  {
		
		for(DetalleFacturasProveedores detallefacturasproveedores: detallefacturasproveedoress) {
			detallefacturasproveedores.settotal_valor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallefacturasproveedores.setcantidad_facturas(0);
				detallefacturasproveedores.setmes(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleFacturasProveedores(List<DetalleFacturasProveedores> detallefacturasproveedoress,DetalleFacturasProveedores detallefacturasproveedoresAux) throws Exception  {
		DetalleFacturasProveedoresConstantesFunciones.InicializarValoresDetalleFacturasProveedores(detallefacturasproveedoresAux,true);
		
		for(DetalleFacturasProveedores detallefacturasproveedores: detallefacturasproveedoress) {
			if(detallefacturasproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallefacturasproveedoresAux.setcantidad_facturas(detallefacturasproveedoresAux.getcantidad_facturas()+detallefacturasproveedores.getcantidad_facturas());			
			detallefacturasproveedoresAux.settotal_valor(detallefacturasproveedoresAux.gettotal_valor()+detallefacturasproveedores.gettotal_valor());			
			detallefacturasproveedoresAux.setmes(detallefacturasproveedoresAux.getmes()+detallefacturasproveedores.getmes());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleFacturasProveedoresConstantesFunciones.getArrayColumnasGlobalesDetalleFacturasProveedores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleFacturasProveedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleFacturasProveedores> detallefacturasproveedoress,DetalleFacturasProveedores detallefacturasproveedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleFacturasProveedores detallefacturasproveedoresAux: detallefacturasproveedoress) {
			if(detallefacturasproveedoresAux!=null && detallefacturasproveedores!=null) {
				if((detallefacturasproveedoresAux.getId()==null && detallefacturasproveedores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallefacturasproveedoresAux.getId()!=null && detallefacturasproveedores.getId()!=null){
					if(detallefacturasproveedoresAux.getId().equals(detallefacturasproveedores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleFacturasProveedores(List<DetalleFacturasProveedores> detallefacturasproveedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_valorTotal=0.0;
	
		for(DetalleFacturasProveedores detallefacturasproveedores: detallefacturasproveedoress) {			
			if(detallefacturasproveedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_valorTotal+=detallefacturasproveedores.gettotal_valor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR);
		datoGeneral.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR);
		datoGeneral.setdValorDouble(total_valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleFacturasProveedores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleFacturasProveedoresConstantesFunciones.LABEL_ID, DetalleFacturasProveedoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturasProveedoresConstantesFunciones.LABEL_VERSIONROW, DetalleFacturasProveedoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE, DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturasProveedoresConstantesFunciones.LABEL_CANTIDADFACTURAS, DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR, DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleFacturasProveedoresConstantesFunciones.LABEL_MES, DetalleFacturasProveedoresConstantesFunciones.MES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleFacturasProveedores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturasProveedoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturasProveedoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleFacturasProveedoresConstantesFunciones.MES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturasProveedores() throws Exception  {
		return DetalleFacturasProveedoresConstantesFunciones.getTiposSeleccionarDetalleFacturasProveedores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturasProveedores(Boolean conFk) throws Exception  {
		return DetalleFacturasProveedoresConstantesFunciones.getTiposSeleccionarDetalleFacturasProveedores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleFacturasProveedores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.LABEL_CANTIDADFACTURAS);
			reporte.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_CANTIDADFACTURAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR);
			reporte.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleFacturasProveedoresConstantesFunciones.LABEL_MES);
			reporte.setsDescripcion(DetalleFacturasProveedoresConstantesFunciones.LABEL_MES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleFacturasProveedores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedoresAux) throws Exception {
		
			detallefacturasproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturasproveedoresAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleFacturasProveedores(List<DetalleFacturasProveedores> detallefacturasproveedoressTemp) throws Exception {
		for(DetalleFacturasProveedores detallefacturasproveedoresAux:detallefacturasproveedoressTemp) {
			
			detallefacturasproveedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallefacturasproveedoresAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturasProveedoresConstantesFunciones.getClassesRelationshipsOfDetalleFacturasProveedores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleFacturasProveedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleFacturasProveedoresConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleFacturasProveedores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleFacturasProveedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleFacturasProveedores detallefacturasproveedores,List<DetalleFacturasProveedores> detallefacturasproveedoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DetalleFacturasProveedores detallefacturasproveedores,List<DetalleFacturasProveedores> detallefacturasproveedoress) throws Exception {
		try	{			
			for(DetalleFacturasProveedores detallefacturasproveedoresLocal:detallefacturasproveedoress) {
				if(detallefacturasproveedoresLocal.getId().equals(detallefacturasproveedores.getId())) {
					detallefacturasproveedoresLocal.setIsSelected(detallefacturasproveedores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleFacturasProveedores(List<DetalleFacturasProveedores> detallefacturasproveedoressAux) throws Exception {
		//this.detallefacturasproveedoressAux=detallefacturasproveedoressAux;
		
		for(DetalleFacturasProveedores detallefacturasproveedoresAux:detallefacturasproveedoressAux) {
			if(detallefacturasproveedoresAux.getIsChanged()) {
				detallefacturasproveedoresAux.setIsChanged(false);
			}		
			
			if(detallefacturasproveedoresAux.getIsNew()) {
				detallefacturasproveedoresAux.setIsNew(false);
			}	
			
			if(detallefacturasproveedoresAux.getIsDeleted()) {
				detallefacturasproveedoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedoresAux) throws Exception {
		//this.detallefacturasproveedoresAux=detallefacturasproveedoresAux;
		
			if(detallefacturasproveedoresAux.getIsChanged()) {
				detallefacturasproveedoresAux.setIsChanged(false);
			}		
			
			if(detallefacturasproveedoresAux.getIsNew()) {
				detallefacturasproveedoresAux.setIsNew(false);
			}	
			
			if(detallefacturasproveedoresAux.getIsDeleted()) {
				detallefacturasproveedoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleFacturasProveedores detallefacturasproveedoresAsignar,DetalleFacturasProveedores detallefacturasproveedores) throws Exception {
		detallefacturasproveedoresAsignar.setId(detallefacturasproveedores.getId());	
		detallefacturasproveedoresAsignar.setVersionRow(detallefacturasproveedores.getVersionRow());	
		detallefacturasproveedoresAsignar.setnombre_cliente(detallefacturasproveedores.getnombre_cliente());	
		detallefacturasproveedoresAsignar.setcantidad_facturas(detallefacturasproveedores.getcantidad_facturas());	
		detallefacturasproveedoresAsignar.settotal_valor(detallefacturasproveedores.gettotal_valor());	
		detallefacturasproveedoresAsignar.setmes(detallefacturasproveedores.getmes());	
	}
	
	public static void inicializarDetalleFacturasProveedores(DetalleFacturasProveedores detallefacturasproveedores) throws Exception {
		try {
				detallefacturasproveedores.setId(0L);	
					
				detallefacturasproveedores.setnombre_cliente("");	
				detallefacturasproveedores.setcantidad_facturas(0);	
				detallefacturasproveedores.settotal_valor(0.0);	
				detallefacturasproveedores.setmes(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleFacturasProveedores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturasProveedoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturasProveedoresConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturasProveedoresConstantesFunciones.LABEL_CANTIDADFACTURAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturasProveedoresConstantesFunciones.LABEL_TOTALVALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleFacturasProveedoresConstantesFunciones.LABEL_MES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleFacturasProveedores(String sTipo,Row row,Workbook workbook,DetalleFacturasProveedores detallefacturasproveedores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturasproveedores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturasproveedores.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturasproveedores.getcantidad_facturas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturasproveedores.gettotal_valor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallefacturasproveedores.getmes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleFacturasProveedores="";
	
	public String getsFinalQueryDetalleFacturasProveedores() {
		return this.sFinalQueryDetalleFacturasProveedores;
	}
	
	public void setsFinalQueryDetalleFacturasProveedores(String sFinalQueryDetalleFacturasProveedores) {
		this.sFinalQueryDetalleFacturasProveedores= sFinalQueryDetalleFacturasProveedores;
	}
	
	public Border resaltarSeleccionarDetalleFacturasProveedores=null;
	
	public Border setResaltarSeleccionarDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleFacturasProveedores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleFacturasProveedores() {
		return this.resaltarSeleccionarDetalleFacturasProveedores;
	}
	
	public void setResaltarSeleccionarDetalleFacturasProveedores(Border borderResaltarSeleccionarDetalleFacturasProveedores) {
		this.resaltarSeleccionarDetalleFacturasProveedores= borderResaltarSeleccionarDetalleFacturasProveedores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleFacturasProveedores=null;
	public Boolean mostraridDetalleFacturasProveedores=true;
	public Boolean activaridDetalleFacturasProveedores=true;

	public Border resaltarid_empresaDetalleFacturasProveedores=null;
	public Boolean mostrarid_empresaDetalleFacturasProveedores=true;
	public Boolean activarid_empresaDetalleFacturasProveedores=true;
	public Boolean cargarid_empresaDetalleFacturasProveedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleFacturasProveedores=false;//ConEventDepend=true

	public Border resaltarnombre_clienteDetalleFacturasProveedores=null;
	public Boolean mostrarnombre_clienteDetalleFacturasProveedores=true;
	public Boolean activarnombre_clienteDetalleFacturasProveedores=true;

	public Border resaltarcantidad_facturasDetalleFacturasProveedores=null;
	public Boolean mostrarcantidad_facturasDetalleFacturasProveedores=true;
	public Boolean activarcantidad_facturasDetalleFacturasProveedores=true;

	public Border resaltartotal_valorDetalleFacturasProveedores=null;
	public Boolean mostrartotal_valorDetalleFacturasProveedores=true;
	public Boolean activartotal_valorDetalleFacturasProveedores=true;

	public Border resaltarmesDetalleFacturasProveedores=null;
	public Boolean mostrarmesDetalleFacturasProveedores=true;
	public Boolean activarmesDetalleFacturasProveedores=true;

	
	

	public Border setResaltaridDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltaridDetalleFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleFacturasProveedores() {
		return this.resaltaridDetalleFacturasProveedores;
	}

	public void setResaltaridDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltaridDetalleFacturasProveedores= borderResaltar;
	}

	public Boolean getMostraridDetalleFacturasProveedores() {
		return this.mostraridDetalleFacturasProveedores;
	}

	public void setMostraridDetalleFacturasProveedores(Boolean mostraridDetalleFacturasProveedores) {
		this.mostraridDetalleFacturasProveedores= mostraridDetalleFacturasProveedores;
	}

	public Boolean getActivaridDetalleFacturasProveedores() {
		return this.activaridDetalleFacturasProveedores;
	}

	public void setActivaridDetalleFacturasProveedores(Boolean activaridDetalleFacturasProveedores) {
		this.activaridDetalleFacturasProveedores= activaridDetalleFacturasProveedores;
	}

	public Border setResaltarid_empresaDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleFacturasProveedores() {
		return this.resaltarid_empresaDetalleFacturasProveedores;
	}

	public void setResaltarid_empresaDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltarid_empresaDetalleFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleFacturasProveedores() {
		return this.mostrarid_empresaDetalleFacturasProveedores;
	}

	public void setMostrarid_empresaDetalleFacturasProveedores(Boolean mostrarid_empresaDetalleFacturasProveedores) {
		this.mostrarid_empresaDetalleFacturasProveedores= mostrarid_empresaDetalleFacturasProveedores;
	}

	public Boolean getActivarid_empresaDetalleFacturasProveedores() {
		return this.activarid_empresaDetalleFacturasProveedores;
	}

	public void setActivarid_empresaDetalleFacturasProveedores(Boolean activarid_empresaDetalleFacturasProveedores) {
		this.activarid_empresaDetalleFacturasProveedores= activarid_empresaDetalleFacturasProveedores;
	}

	public Boolean getCargarid_empresaDetalleFacturasProveedores() {
		return this.cargarid_empresaDetalleFacturasProveedores;
	}

	public void setCargarid_empresaDetalleFacturasProveedores(Boolean cargarid_empresaDetalleFacturasProveedores) {
		this.cargarid_empresaDetalleFacturasProveedores= cargarid_empresaDetalleFacturasProveedores;
	}

	public Border setResaltarnombre_clienteDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteDetalleFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteDetalleFacturasProveedores() {
		return this.resaltarnombre_clienteDetalleFacturasProveedores;
	}

	public void setResaltarnombre_clienteDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltarnombre_clienteDetalleFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteDetalleFacturasProveedores() {
		return this.mostrarnombre_clienteDetalleFacturasProveedores;
	}

	public void setMostrarnombre_clienteDetalleFacturasProveedores(Boolean mostrarnombre_clienteDetalleFacturasProveedores) {
		this.mostrarnombre_clienteDetalleFacturasProveedores= mostrarnombre_clienteDetalleFacturasProveedores;
	}

	public Boolean getActivarnombre_clienteDetalleFacturasProveedores() {
		return this.activarnombre_clienteDetalleFacturasProveedores;
	}

	public void setActivarnombre_clienteDetalleFacturasProveedores(Boolean activarnombre_clienteDetalleFacturasProveedores) {
		this.activarnombre_clienteDetalleFacturasProveedores= activarnombre_clienteDetalleFacturasProveedores;
	}

	public Border setResaltarcantidad_facturasDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarcantidad_facturasDetalleFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_facturasDetalleFacturasProveedores() {
		return this.resaltarcantidad_facturasDetalleFacturasProveedores;
	}

	public void setResaltarcantidad_facturasDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltarcantidad_facturasDetalleFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarcantidad_facturasDetalleFacturasProveedores() {
		return this.mostrarcantidad_facturasDetalleFacturasProveedores;
	}

	public void setMostrarcantidad_facturasDetalleFacturasProveedores(Boolean mostrarcantidad_facturasDetalleFacturasProveedores) {
		this.mostrarcantidad_facturasDetalleFacturasProveedores= mostrarcantidad_facturasDetalleFacturasProveedores;
	}

	public Boolean getActivarcantidad_facturasDetalleFacturasProveedores() {
		return this.activarcantidad_facturasDetalleFacturasProveedores;
	}

	public void setActivarcantidad_facturasDetalleFacturasProveedores(Boolean activarcantidad_facturasDetalleFacturasProveedores) {
		this.activarcantidad_facturasDetalleFacturasProveedores= activarcantidad_facturasDetalleFacturasProveedores;
	}

	public Border setResaltartotal_valorDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltartotal_valorDetalleFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_valorDetalleFacturasProveedores() {
		return this.resaltartotal_valorDetalleFacturasProveedores;
	}

	public void setResaltartotal_valorDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltartotal_valorDetalleFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrartotal_valorDetalleFacturasProveedores() {
		return this.mostrartotal_valorDetalleFacturasProveedores;
	}

	public void setMostrartotal_valorDetalleFacturasProveedores(Boolean mostrartotal_valorDetalleFacturasProveedores) {
		this.mostrartotal_valorDetalleFacturasProveedores= mostrartotal_valorDetalleFacturasProveedores;
	}

	public Boolean getActivartotal_valorDetalleFacturasProveedores() {
		return this.activartotal_valorDetalleFacturasProveedores;
	}

	public void setActivartotal_valorDetalleFacturasProveedores(Boolean activartotal_valorDetalleFacturasProveedores) {
		this.activartotal_valorDetalleFacturasProveedores= activartotal_valorDetalleFacturasProveedores;
	}

	public Border setResaltarmesDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallefacturasproveedoresBeanSwingJInternalFrame.jTtoolBarDetalleFacturasProveedores.setBorder(borderResaltar);
		
		this.resaltarmesDetalleFacturasProveedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmesDetalleFacturasProveedores() {
		return this.resaltarmesDetalleFacturasProveedores;
	}

	public void setResaltarmesDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltarmesDetalleFacturasProveedores= borderResaltar;
	}

	public Boolean getMostrarmesDetalleFacturasProveedores() {
		return this.mostrarmesDetalleFacturasProveedores;
	}

	public void setMostrarmesDetalleFacturasProveedores(Boolean mostrarmesDetalleFacturasProveedores) {
		this.mostrarmesDetalleFacturasProveedores= mostrarmesDetalleFacturasProveedores;
	}

	public Boolean getActivarmesDetalleFacturasProveedores() {
		return this.activarmesDetalleFacturasProveedores;
	}

	public void setActivarmesDetalleFacturasProveedores(Boolean activarmesDetalleFacturasProveedores) {
		this.activarmesDetalleFacturasProveedores= activarmesDetalleFacturasProveedores;
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
		
		
		this.setMostraridDetalleFacturasProveedores(esInicial);
		this.setMostrarid_empresaDetalleFacturasProveedores(esInicial);
		this.setMostrarnombre_clienteDetalleFacturasProveedores(esInicial);
		this.setMostrarcantidad_facturasDetalleFacturasProveedores(esInicial);
		this.setMostrartotal_valorDetalleFacturasProveedores(esInicial);
		this.setMostrarmesDetalleFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.ID)) {
				this.setMostraridDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS)) {
				this.setMostrarcantidad_facturasDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR)) {
				this.setMostrartotal_valorDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.MES)) {
				this.setMostrarmesDetalleFacturasProveedores(esAsigna);
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
		
		
		this.setActivaridDetalleFacturasProveedores(esInicial);
		this.setActivarid_empresaDetalleFacturasProveedores(esInicial);
		this.setActivarnombre_clienteDetalleFacturasProveedores(esInicial);
		this.setActivarcantidad_facturasDetalleFacturasProveedores(esInicial);
		this.setActivartotal_valorDetalleFacturasProveedores(esInicial);
		this.setActivarmesDetalleFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.ID)) {
				this.setActivaridDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS)) {
				this.setActivarcantidad_facturasDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR)) {
				this.setActivartotal_valorDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.MES)) {
				this.setActivarmesDetalleFacturasProveedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleFacturasProveedores(esInicial);
		this.setResaltarid_empresaDetalleFacturasProveedores(esInicial);
		this.setResaltarnombre_clienteDetalleFacturasProveedores(esInicial);
		this.setResaltarcantidad_facturasDetalleFacturasProveedores(esInicial);
		this.setResaltartotal_valorDetalleFacturasProveedores(esInicial);
		this.setResaltarmesDetalleFacturasProveedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.ID)) {
				this.setResaltaridDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.CANTIDADFACTURAS)) {
				this.setResaltarcantidad_facturasDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.TOTALVALOR)) {
				this.setResaltartotal_valorDetalleFacturasProveedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleFacturasProveedoresConstantesFunciones.MES)) {
				this.setResaltarmesDetalleFacturasProveedores(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores=true;

	public Boolean getMostrarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores() {
		return this.mostrarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores;
	}

	public void setMostrarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores=true;

	public Boolean getActivarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores() {
		return this.activarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores;
	}

	public void setActivarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores(Boolean habilitarResaltar) {
		this.activarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores=null;

	public Border getResaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores() {
		return this.resaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores;
	}

	public void setResaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores(Border borderResaltar) {
		this.resaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores= borderResaltar;
	}

	public void setResaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleFacturasProveedoresBeanSwingJInternalFrame detallefacturasproveedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDetalleFacturasProveedoresDetalleFacturasProveedores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}