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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.EstadoFisicoFacturaEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoFisicoFacturaEmpresaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoFisicoFacturaEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EstadoFisicoFacturaEmpresaConstantesFunciones extends EstadoFisicoFacturaEmpresaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EstadoFisicoFacturaEmpresa";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EstadoFisicoFacturaEmpresa"+EstadoFisicoFacturaEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EstadoFisicoFacturaEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EstadoFisicoFacturaEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"_"+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EstadoFisicoFacturaEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EstadoFisicoFacturaEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EstadoFisicoFacturaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EstadoFisicoFacturaEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EstadoFisicoFacturaEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EstadoFisicoFacturaEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Estado Fisico Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Estado Fisico Factura";
	public static final String SCLASSWEBTITULO_LOWER="Estado Fisico Factura Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EstadoFisicoFacturaEmpresa";
	public static final String OBJECTNAME="estadofisicofacturaempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="estado_fisico_factura_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select estadofisicofacturaempresa from "+EstadoFisicoFacturaEmpresaConstantesFunciones.SPERSISTENCENAME+" estadofisicofacturaempresa";
	public static String QUERYSELECTNATIVE="select "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".id,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".version_row,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".codigo,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".nombre,"+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME+".es_pendiente from "+EstadoFisicoFacturaEmpresaConstantesFunciones.SCHEMA+"."+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME;//+" as "+EstadoFisicoFacturaEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EstadoFisicoFacturaEmpresaConstantesFuncionesAdditional estadofisicofacturaempresaConstantesFuncionesAdditional=null;
	
	public EstadoFisicoFacturaEmpresaConstantesFuncionesAdditional getEstadoFisicoFacturaEmpresaConstantesFuncionesAdditional() {
		return this.estadofisicofacturaempresaConstantesFuncionesAdditional;
	}
	
	public void setEstadoFisicoFacturaEmpresaConstantesFuncionesAdditional(EstadoFisicoFacturaEmpresaConstantesFuncionesAdditional estadofisicofacturaempresaConstantesFuncionesAdditional) {
		try {
			this.estadofisicofacturaempresaConstantesFuncionesAdditional=estadofisicofacturaempresaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESPENDIENTE= "es_pendiente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESPENDIENTE= "Es Pendiente";
		public static final String LABEL_ESPENDIENTE_LOWER= "Es Pendiente";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEstadoFisicoFacturaEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE)) {sLabelColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_ESPENDIENTE;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_pendienteDescripcion(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!estadofisicofacturaempresa.getes_pendiente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_pendienteHtmlDescripcion(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(estadofisicofacturaempresa.getId(),estadofisicofacturaempresa.getes_pendiente());

		return sDescripcion;
	}	
	
	public static String getEstadoFisicoFacturaEmpresaDescripcion(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(estadofisicofacturaempresa !=null/* && estadofisicofacturaempresa.getId()!=0*/) {
			sDescripcion=estadofisicofacturaempresa.getcodigo();//estadofisicofacturaempresaestadofisicofacturaempresa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getEstadoFisicoFacturaEmpresaDescripcionDetallado(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) {
		String sDescripcion="";
			
		sDescripcion+=EstadoFisicoFacturaEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=estadofisicofacturaempresa.getId().toString()+",";
		sDescripcion+=EstadoFisicoFacturaEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=estadofisicofacturaempresa.getVersionRow().toString()+",";
		sDescripcion+=EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=estadofisicofacturaempresa.getid_empresa().toString()+",";
		sDescripcion+=EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=estadofisicofacturaempresa.getcodigo()+",";
		sDescripcion+=EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=estadofisicofacturaempresa.getnombre()+",";
		sDescripcion+=EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE+"=";
		sDescripcion+=estadofisicofacturaempresa.getes_pendiente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEstadoFisicoFacturaEmpresaDescripcion(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,String sValor) throws Exception {			
		if(estadofisicofacturaempresa !=null) {
			estadofisicofacturaempresa.setcodigo(sValor);;//estadofisicofacturaempresaestadofisicofacturaempresa.getcodigo().trim();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		estadofisicofacturaempresa.setcodigo(estadofisicofacturaempresa.getcodigo().trim());
		estadofisicofacturaempresa.setnombre(estadofisicofacturaempresa.getnombre().trim());
	}
	
	public static void quitarEspaciosEstadoFisicoFacturaEmpresas(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa: estadofisicofacturaempresas) {
			estadofisicofacturaempresa.setcodigo(estadofisicofacturaempresa.getcodigo().trim());
			estadofisicofacturaempresa.setnombre(estadofisicofacturaempresa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && estadofisicofacturaempresa.getConCambioAuxiliar()) {
			estadofisicofacturaempresa.setIsDeleted(estadofisicofacturaempresa.getIsDeletedAuxiliar());	
			estadofisicofacturaempresa.setIsNew(estadofisicofacturaempresa.getIsNewAuxiliar());	
			estadofisicofacturaempresa.setIsChanged(estadofisicofacturaempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			estadofisicofacturaempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			estadofisicofacturaempresa.setIsDeletedAuxiliar(false);	
			estadofisicofacturaempresa.setIsNewAuxiliar(false);	
			estadofisicofacturaempresa.setIsChangedAuxiliar(false);
			
			estadofisicofacturaempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEstadoFisicoFacturaEmpresas(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa : estadofisicofacturaempresas) {
			if(conAsignarBase && estadofisicofacturaempresa.getConCambioAuxiliar()) {
				estadofisicofacturaempresa.setIsDeleted(estadofisicofacturaempresa.getIsDeletedAuxiliar());	
				estadofisicofacturaempresa.setIsNew(estadofisicofacturaempresa.getIsNewAuxiliar());	
				estadofisicofacturaempresa.setIsChanged(estadofisicofacturaempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				estadofisicofacturaempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				estadofisicofacturaempresa.setIsDeletedAuxiliar(false);	
				estadofisicofacturaempresa.setIsNewAuxiliar(false);	
				estadofisicofacturaempresa.setIsChangedAuxiliar(false);
				
				estadofisicofacturaempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEstadoFisicoFacturaEmpresas(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,Boolean conEnteros) throws Exception  {
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa: estadofisicofacturaempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEstadoFisicoFacturaEmpresa(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux) throws Exception  {
		EstadoFisicoFacturaEmpresaConstantesFunciones.InicializarValoresEstadoFisicoFacturaEmpresa(estadofisicofacturaempresaAux,true);
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa: estadofisicofacturaempresas) {
			if(estadofisicofacturaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFisicoFacturaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EstadoFisicoFacturaEmpresaConstantesFunciones.getArrayColumnasGlobalesEstadoFisicoFacturaEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEstadoFisicoFacturaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEstadoFisicoFacturaEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux: estadofisicofacturaempresas) {
			if(estadofisicofacturaempresaAux!=null && estadofisicofacturaempresa!=null) {
				if((estadofisicofacturaempresaAux.getId()==null && estadofisicofacturaempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(estadofisicofacturaempresaAux.getId()!=null && estadofisicofacturaempresa.getId()!=null){
					if(estadofisicofacturaempresaAux.getId().equals(estadofisicofacturaempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEstadoFisicoFacturaEmpresa(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa: estadofisicofacturaempresas) {			
			if(estadofisicofacturaempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEstadoFisicoFacturaEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_ID, EstadoFisicoFacturaEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_VERSIONROW, EstadoFisicoFacturaEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_IDEMPRESA, EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_CODIGO, EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_NOMBRE, EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_ESPENDIENTE, EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEstadoFisicoFacturaEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFisicoFacturaEmpresa() throws Exception  {
		return EstadoFisicoFacturaEmpresaConstantesFunciones.getTiposSeleccionarEstadoFisicoFacturaEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFisicoFacturaEmpresa(Boolean conFk) throws Exception  {
		return EstadoFisicoFacturaEmpresaConstantesFunciones.getTiposSeleccionarEstadoFisicoFacturaEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEstadoFisicoFacturaEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_ESPENDIENTE);
			reporte.setsDescripcion(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_ESPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEstadoFisicoFacturaEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux) throws Exception {
		
			estadofisicofacturaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadofisicofacturaempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEstadoFisicoFacturaEmpresa(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresasTemp) throws Exception {
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux:estadofisicofacturaempresasTemp) {
			
			estadofisicofacturaempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(estadofisicofacturaempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoFisicoFacturaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEstadoFisicoFacturaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFisicoFacturaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFisicoFacturaEmpresaConstantesFunciones.getClassesRelationshipsOfEstadoFisicoFacturaEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoFisicoFacturaEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Factura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFisicoFacturaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EstadoFisicoFacturaEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfEstadoFisicoFacturaEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEstadoFisicoFacturaEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	public static void actualizarLista(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EstadoFisicoFacturaEmpresa estadofisicofacturaempresaEncontrado=null;
			
			for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaLocal:estadofisicofacturaempresas) {
				if(estadofisicofacturaempresaLocal.getId().equals(estadofisicofacturaempresa.getId())) {
					estadofisicofacturaempresaEncontrado=estadofisicofacturaempresaLocal;
					
					estadofisicofacturaempresaLocal.setIsChanged(estadofisicofacturaempresa.getIsChanged());
					estadofisicofacturaempresaLocal.setIsNew(estadofisicofacturaempresa.getIsNew());
					estadofisicofacturaempresaLocal.setIsDeleted(estadofisicofacturaempresa.getIsDeleted());
					
					estadofisicofacturaempresaLocal.setGeneralEntityOriginal(estadofisicofacturaempresa.getGeneralEntityOriginal());
					
					estadofisicofacturaempresaLocal.setId(estadofisicofacturaempresa.getId());	
					estadofisicofacturaempresaLocal.setVersionRow(estadofisicofacturaempresa.getVersionRow());	
					estadofisicofacturaempresaLocal.setid_empresa(estadofisicofacturaempresa.getid_empresa());	
					estadofisicofacturaempresaLocal.setcodigo(estadofisicofacturaempresa.getcodigo());	
					estadofisicofacturaempresaLocal.setnombre(estadofisicofacturaempresa.getnombre());	
					estadofisicofacturaempresaLocal.setes_pendiente(estadofisicofacturaempresa.getes_pendiente());	
					
					
					estadofisicofacturaempresaLocal.setFacturas(estadofisicofacturaempresa.getFacturas());
					
					existe=true;
					break;
				}
			}
			
			if(!estadofisicofacturaempresa.getIsDeleted()) {
				if(!existe) {
					estadofisicofacturaempresas.add(estadofisicofacturaempresa);
				}
			} else {
				if(estadofisicofacturaempresaEncontrado!=null && permiteQuitar)  {
					estadofisicofacturaempresas.remove(estadofisicofacturaempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresas) throws Exception {
		try	{			
			for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaLocal:estadofisicofacturaempresas) {
				if(estadofisicofacturaempresaLocal.getId().equals(estadofisicofacturaempresa.getId())) {
					estadofisicofacturaempresaLocal.setIsSelected(estadofisicofacturaempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEstadoFisicoFacturaEmpresa(List<EstadoFisicoFacturaEmpresa> estadofisicofacturaempresasAux) throws Exception {
		//this.estadofisicofacturaempresasAux=estadofisicofacturaempresasAux;
		
		for(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux:estadofisicofacturaempresasAux) {
			if(estadofisicofacturaempresaAux.getIsChanged()) {
				estadofisicofacturaempresaAux.setIsChanged(false);
			}		
			
			if(estadofisicofacturaempresaAux.getIsNew()) {
				estadofisicofacturaempresaAux.setIsNew(false);
			}	
			
			if(estadofisicofacturaempresaAux.getIsDeleted()) {
				estadofisicofacturaempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAux) throws Exception {
		//this.estadofisicofacturaempresaAux=estadofisicofacturaempresaAux;
		
			if(estadofisicofacturaempresaAux.getIsChanged()) {
				estadofisicofacturaempresaAux.setIsChanged(false);
			}		
			
			if(estadofisicofacturaempresaAux.getIsNew()) {
				estadofisicofacturaempresaAux.setIsNew(false);
			}	
			
			if(estadofisicofacturaempresaAux.getIsDeleted()) {
				estadofisicofacturaempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EstadoFisicoFacturaEmpresa estadofisicofacturaempresaAsignar,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		estadofisicofacturaempresaAsignar.setId(estadofisicofacturaempresa.getId());	
		estadofisicofacturaempresaAsignar.setVersionRow(estadofisicofacturaempresa.getVersionRow());	
		estadofisicofacturaempresaAsignar.setid_empresa(estadofisicofacturaempresa.getid_empresa());
		estadofisicofacturaempresaAsignar.setempresa_descripcion(estadofisicofacturaempresa.getempresa_descripcion());	
		estadofisicofacturaempresaAsignar.setcodigo(estadofisicofacturaempresa.getcodigo());	
		estadofisicofacturaempresaAsignar.setnombre(estadofisicofacturaempresa.getnombre());	
		estadofisicofacturaempresaAsignar.setes_pendiente(estadofisicofacturaempresa.getes_pendiente());	
	}
	
	public static void inicializarEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) throws Exception {
		try {
				estadofisicofacturaempresa.setId(0L);	
					
				estadofisicofacturaempresa.setid_empresa(-1L);	
				estadofisicofacturaempresa.setcodigo("");	
				estadofisicofacturaempresa.setnombre("");	
				estadofisicofacturaempresa.setes_pendiente(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEstadoFisicoFacturaEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EstadoFisicoFacturaEmpresaConstantesFunciones.LABEL_ESPENDIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEstadoFisicoFacturaEmpresa(String sTipo,Row row,Workbook workbook,EstadoFisicoFacturaEmpresa estadofisicofacturaempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofisicofacturaempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofisicofacturaempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(estadofisicofacturaempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(estadofisicofacturaempresa.getes_pendiente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEstadoFisicoFacturaEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEstadoFisicoFacturaEmpresa() {
		return this.sFinalQueryEstadoFisicoFacturaEmpresa;
	}
	
	public void setsFinalQueryEstadoFisicoFacturaEmpresa(String sFinalQueryEstadoFisicoFacturaEmpresa) {
		this.sFinalQueryEstadoFisicoFacturaEmpresa= sFinalQueryEstadoFisicoFacturaEmpresa;
	}
	
	public Border resaltarSeleccionarEstadoFisicoFacturaEmpresa=null;
	
	public Border setResaltarSeleccionarEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEstadoFisicoFacturaEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEstadoFisicoFacturaEmpresa() {
		return this.resaltarSeleccionarEstadoFisicoFacturaEmpresa;
	}
	
	public void setResaltarSeleccionarEstadoFisicoFacturaEmpresa(Border borderResaltarSeleccionarEstadoFisicoFacturaEmpresa) {
		this.resaltarSeleccionarEstadoFisicoFacturaEmpresa= borderResaltarSeleccionarEstadoFisicoFacturaEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEstadoFisicoFacturaEmpresa=null;
	public Boolean mostraridEstadoFisicoFacturaEmpresa=true;
	public Boolean activaridEstadoFisicoFacturaEmpresa=true;

	public Border resaltarid_empresaEstadoFisicoFacturaEmpresa=null;
	public Boolean mostrarid_empresaEstadoFisicoFacturaEmpresa=true;
	public Boolean activarid_empresaEstadoFisicoFacturaEmpresa=true;
	public Boolean cargarid_empresaEstadoFisicoFacturaEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEstadoFisicoFacturaEmpresa=false;//ConEventDepend=true

	public Border resaltarcodigoEstadoFisicoFacturaEmpresa=null;
	public Boolean mostrarcodigoEstadoFisicoFacturaEmpresa=true;
	public Boolean activarcodigoEstadoFisicoFacturaEmpresa=true;

	public Border resaltarnombreEstadoFisicoFacturaEmpresa=null;
	public Boolean mostrarnombreEstadoFisicoFacturaEmpresa=true;
	public Boolean activarnombreEstadoFisicoFacturaEmpresa=true;

	public Border resaltares_pendienteEstadoFisicoFacturaEmpresa=null;
	public Boolean mostrares_pendienteEstadoFisicoFacturaEmpresa=true;
	public Boolean activares_pendienteEstadoFisicoFacturaEmpresa=true;

	
	

	public Border setResaltaridEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltar);
		
		this.resaltaridEstadoFisicoFacturaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEstadoFisicoFacturaEmpresa() {
		return this.resaltaridEstadoFisicoFacturaEmpresa;
	}

	public void setResaltaridEstadoFisicoFacturaEmpresa(Border borderResaltar) {
		this.resaltaridEstadoFisicoFacturaEmpresa= borderResaltar;
	}

	public Boolean getMostraridEstadoFisicoFacturaEmpresa() {
		return this.mostraridEstadoFisicoFacturaEmpresa;
	}

	public void setMostraridEstadoFisicoFacturaEmpresa(Boolean mostraridEstadoFisicoFacturaEmpresa) {
		this.mostraridEstadoFisicoFacturaEmpresa= mostraridEstadoFisicoFacturaEmpresa;
	}

	public Boolean getActivaridEstadoFisicoFacturaEmpresa() {
		return this.activaridEstadoFisicoFacturaEmpresa;
	}

	public void setActivaridEstadoFisicoFacturaEmpresa(Boolean activaridEstadoFisicoFacturaEmpresa) {
		this.activaridEstadoFisicoFacturaEmpresa= activaridEstadoFisicoFacturaEmpresa;
	}

	public Border setResaltarid_empresaEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaEstadoFisicoFacturaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEstadoFisicoFacturaEmpresa() {
		return this.resaltarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public void setResaltarid_empresaEstadoFisicoFacturaEmpresa(Border borderResaltar) {
		this.resaltarid_empresaEstadoFisicoFacturaEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaEstadoFisicoFacturaEmpresa() {
		return this.mostrarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public void setMostrarid_empresaEstadoFisicoFacturaEmpresa(Boolean mostrarid_empresaEstadoFisicoFacturaEmpresa) {
		this.mostrarid_empresaEstadoFisicoFacturaEmpresa= mostrarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public Boolean getActivarid_empresaEstadoFisicoFacturaEmpresa() {
		return this.activarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public void setActivarid_empresaEstadoFisicoFacturaEmpresa(Boolean activarid_empresaEstadoFisicoFacturaEmpresa) {
		this.activarid_empresaEstadoFisicoFacturaEmpresa= activarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public Boolean getCargarid_empresaEstadoFisicoFacturaEmpresa() {
		return this.cargarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public void setCargarid_empresaEstadoFisicoFacturaEmpresa(Boolean cargarid_empresaEstadoFisicoFacturaEmpresa) {
		this.cargarid_empresaEstadoFisicoFacturaEmpresa= cargarid_empresaEstadoFisicoFacturaEmpresa;
	}

	public Border setResaltarcodigoEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoEstadoFisicoFacturaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoEstadoFisicoFacturaEmpresa() {
		return this.resaltarcodigoEstadoFisicoFacturaEmpresa;
	}

	public void setResaltarcodigoEstadoFisicoFacturaEmpresa(Border borderResaltar) {
		this.resaltarcodigoEstadoFisicoFacturaEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoEstadoFisicoFacturaEmpresa() {
		return this.mostrarcodigoEstadoFisicoFacturaEmpresa;
	}

	public void setMostrarcodigoEstadoFisicoFacturaEmpresa(Boolean mostrarcodigoEstadoFisicoFacturaEmpresa) {
		this.mostrarcodigoEstadoFisicoFacturaEmpresa= mostrarcodigoEstadoFisicoFacturaEmpresa;
	}

	public Boolean getActivarcodigoEstadoFisicoFacturaEmpresa() {
		return this.activarcodigoEstadoFisicoFacturaEmpresa;
	}

	public void setActivarcodigoEstadoFisicoFacturaEmpresa(Boolean activarcodigoEstadoFisicoFacturaEmpresa) {
		this.activarcodigoEstadoFisicoFacturaEmpresa= activarcodigoEstadoFisicoFacturaEmpresa;
	}

	public Border setResaltarnombreEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreEstadoFisicoFacturaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreEstadoFisicoFacturaEmpresa() {
		return this.resaltarnombreEstadoFisicoFacturaEmpresa;
	}

	public void setResaltarnombreEstadoFisicoFacturaEmpresa(Border borderResaltar) {
		this.resaltarnombreEstadoFisicoFacturaEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreEstadoFisicoFacturaEmpresa() {
		return this.mostrarnombreEstadoFisicoFacturaEmpresa;
	}

	public void setMostrarnombreEstadoFisicoFacturaEmpresa(Boolean mostrarnombreEstadoFisicoFacturaEmpresa) {
		this.mostrarnombreEstadoFisicoFacturaEmpresa= mostrarnombreEstadoFisicoFacturaEmpresa;
	}

	public Boolean getActivarnombreEstadoFisicoFacturaEmpresa() {
		return this.activarnombreEstadoFisicoFacturaEmpresa;
	}

	public void setActivarnombreEstadoFisicoFacturaEmpresa(Boolean activarnombreEstadoFisicoFacturaEmpresa) {
		this.activarnombreEstadoFisicoFacturaEmpresa= activarnombreEstadoFisicoFacturaEmpresa;
	}

	public Border setResaltares_pendienteEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltar);
		
		this.resaltares_pendienteEstadoFisicoFacturaEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_pendienteEstadoFisicoFacturaEmpresa() {
		return this.resaltares_pendienteEstadoFisicoFacturaEmpresa;
	}

	public void setResaltares_pendienteEstadoFisicoFacturaEmpresa(Border borderResaltar) {
		this.resaltares_pendienteEstadoFisicoFacturaEmpresa= borderResaltar;
	}

	public Boolean getMostrares_pendienteEstadoFisicoFacturaEmpresa() {
		return this.mostrares_pendienteEstadoFisicoFacturaEmpresa;
	}

	public void setMostrares_pendienteEstadoFisicoFacturaEmpresa(Boolean mostrares_pendienteEstadoFisicoFacturaEmpresa) {
		this.mostrares_pendienteEstadoFisicoFacturaEmpresa= mostrares_pendienteEstadoFisicoFacturaEmpresa;
	}

	public Boolean getActivares_pendienteEstadoFisicoFacturaEmpresa() {
		return this.activares_pendienteEstadoFisicoFacturaEmpresa;
	}

	public void setActivares_pendienteEstadoFisicoFacturaEmpresa(Boolean activares_pendienteEstadoFisicoFacturaEmpresa) {
		this.activares_pendienteEstadoFisicoFacturaEmpresa= activares_pendienteEstadoFisicoFacturaEmpresa;
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
		
		
		this.setMostraridEstadoFisicoFacturaEmpresa(esInicial);
		this.setMostrarid_empresaEstadoFisicoFacturaEmpresa(esInicial);
		this.setMostrarcodigoEstadoFisicoFacturaEmpresa(esInicial);
		this.setMostrarnombreEstadoFisicoFacturaEmpresa(esInicial);
		this.setMostrares_pendienteEstadoFisicoFacturaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ID)) {
				this.setMostraridEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE)) {
				this.setMostrares_pendienteEstadoFisicoFacturaEmpresa(esAsigna);
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
		
		
		this.setActivaridEstadoFisicoFacturaEmpresa(esInicial);
		this.setActivarid_empresaEstadoFisicoFacturaEmpresa(esInicial);
		this.setActivarcodigoEstadoFisicoFacturaEmpresa(esInicial);
		this.setActivarnombreEstadoFisicoFacturaEmpresa(esInicial);
		this.setActivares_pendienteEstadoFisicoFacturaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ID)) {
				this.setActivaridEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE)) {
				this.setActivares_pendienteEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEstadoFisicoFacturaEmpresa(esInicial);
		this.setResaltarid_empresaEstadoFisicoFacturaEmpresa(esInicial);
		this.setResaltarcodigoEstadoFisicoFacturaEmpresa(esInicial);
		this.setResaltarnombreEstadoFisicoFacturaEmpresa(esInicial);
		this.setResaltares_pendienteEstadoFisicoFacturaEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ID)) {
				this.setResaltaridEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(EstadoFisicoFacturaEmpresaConstantesFunciones.ESPENDIENTE)) {
				this.setResaltares_pendienteEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFacturaEstadoFisicoFacturaEmpresa=null;

	public Border getResaltarFacturaEstadoFisicoFacturaEmpresa() {
		return this.resaltarFacturaEstadoFisicoFacturaEmpresa;
	}

	public void setResaltarFacturaEstadoFisicoFacturaEmpresa(Border borderResaltarFactura) {
		if(borderResaltarFactura!=null) {
			this.resaltarFacturaEstadoFisicoFacturaEmpresa= borderResaltarFactura;
		}
	}

	public Border setResaltarFacturaEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarFactura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//estadofisicofacturaempresaBeanSwingJInternalFrame.jTtoolBarEstadoFisicoFacturaEmpresa.setBorder(borderResaltarFactura);
			
		this.resaltarFacturaEstadoFisicoFacturaEmpresa= borderResaltarFactura;

		 return borderResaltarFactura;
	}



	public Boolean mostrarFacturaEstadoFisicoFacturaEmpresa=true;

	public Boolean getMostrarFacturaEstadoFisicoFacturaEmpresa() {
		return this.mostrarFacturaEstadoFisicoFacturaEmpresa;
	}

	public void setMostrarFacturaEstadoFisicoFacturaEmpresa(Boolean visibilidadResaltarFactura) {
		this.mostrarFacturaEstadoFisicoFacturaEmpresa= visibilidadResaltarFactura;
	}



	public Boolean activarFacturaEstadoFisicoFacturaEmpresa=true;

	public Boolean gethabilitarResaltarFacturaEstadoFisicoFacturaEmpresa() {
		return this.activarFacturaEstadoFisicoFacturaEmpresa;
	}

	public void setActivarFacturaEstadoFisicoFacturaEmpresa(Boolean habilitarResaltarFactura) {
		this.activarFacturaEstadoFisicoFacturaEmpresa= habilitarResaltarFactura;
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

		this.setMostrarFacturaEstadoFisicoFacturaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setMostrarFacturaEstadoFisicoFacturaEmpresa(esAsigna);
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

		this.setActivarFacturaEstadoFisicoFacturaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setActivarFacturaEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFacturaEstadoFisicoFacturaEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Factura.class)) {
				this.setResaltarFacturaEstadoFisicoFacturaEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaEstadoFisicoFacturaEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaEstadoFisicoFacturaEmpresa() {
		return this.mostrarFK_IdEmpresaEstadoFisicoFacturaEmpresa;
	}

	public void setMostrarFK_IdEmpresaEstadoFisicoFacturaEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEstadoFisicoFacturaEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaEstadoFisicoFacturaEmpresa=true;

	public Boolean getActivarFK_IdEmpresaEstadoFisicoFacturaEmpresa() {
		return this.activarFK_IdEmpresaEstadoFisicoFacturaEmpresa;
	}

	public void setActivarFK_IdEmpresaEstadoFisicoFacturaEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEstadoFisicoFacturaEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa=null;

	public Border getResaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa() {
		return this.resaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa;
	}

	public void setResaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*EstadoFisicoFacturaEmpresaBeanSwingJInternalFrame estadofisicofacturaempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEstadoFisicoFacturaEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}