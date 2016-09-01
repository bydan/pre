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


import com.bydan.erp.inventario.util.PresupuestoLineaConstantesFunciones;
import com.bydan.erp.inventario.util.PresupuestoLineaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PresupuestoLineaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresupuestoLineaConstantesFunciones extends PresupuestoLineaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresupuestoLinea";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresupuestoLinea"+PresupuestoLineaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresupuestoLineaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresupuestoLineaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresupuestoLineaConstantesFunciones.SCHEMA+"_"+PresupuestoLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresupuestoLineaConstantesFunciones.SCHEMA+"_"+PresupuestoLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresupuestoLineaConstantesFunciones.SCHEMA+"_"+PresupuestoLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresupuestoLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresupuestoLineaConstantesFunciones.SCHEMA+"_"+PresupuestoLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresupuestoLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresupuestoLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresupuestoLineaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresupuestoLineaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresupuestoLineaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresupuestoLineaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Presupuesto Lineaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Presupuesto Linea";
	public static final String SCLASSWEBTITULO_LOWER="Presupuesto Linea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresupuestoLinea";
	public static final String OBJECTNAME="presupuestolinea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="presupuesto_linea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presupuestolinea from "+PresupuestoLineaConstantesFunciones.SPERSISTENCENAME+" presupuestolinea";
	public static String QUERYSELECTNATIVE="select "+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".id,"+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".version_row,"+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".id_linea,"+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".margen,"+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".descuento,"+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME+".es_para_presupuesto from "+PresupuestoLineaConstantesFunciones.SCHEMA+"."+PresupuestoLineaConstantesFunciones.TABLENAME;//+" as "+PresupuestoLineaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresupuestoLineaConstantesFuncionesAdditional presupuestolineaConstantesFuncionesAdditional=null;
	
	public PresupuestoLineaConstantesFuncionesAdditional getPresupuestoLineaConstantesFuncionesAdditional() {
		return this.presupuestolineaConstantesFuncionesAdditional;
	}
	
	public void setPresupuestoLineaConstantesFuncionesAdditional(PresupuestoLineaConstantesFuncionesAdditional presupuestolineaConstantesFuncionesAdditional) {
		try {
			this.presupuestolineaConstantesFuncionesAdditional=presupuestolineaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDLINEA= "id_linea";
    public static final String MARGEN= "margen";
    public static final String DESCUENTO= "descuento";
    public static final String ESPARAPRESUPUESTO= "es_para_presupuesto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_MARGEN= "Margen";
		public static final String LABEL_MARGEN_LOWER= "Margen";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_ESPARAPRESUPUESTO= "Para Presupuesto";
		public static final String LABEL_ESPARAPRESUPUESTO_LOWER= "Es Para Presupuesto";
	
		
		
		
		
		
		
		
	
	public static String getPresupuestoLineaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresupuestoLineaConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresupuestoLineaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresupuestoLineaConstantesFunciones.IDLINEA)) {sLabelColumna=PresupuestoLineaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(PresupuestoLineaConstantesFunciones.MARGEN)) {sLabelColumna=PresupuestoLineaConstantesFunciones.LABEL_MARGEN;}
		if(sNombreColumna.equals(PresupuestoLineaConstantesFunciones.DESCUENTO)) {sLabelColumna=PresupuestoLineaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO)) {sLabelColumna=PresupuestoLineaConstantesFunciones.LABEL_ESPARAPRESUPUESTO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getes_para_presupuestoDescripcion(PresupuestoLinea presupuestolinea) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!presupuestolinea.getes_para_presupuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_para_presupuestoHtmlDescripcion(PresupuestoLinea presupuestolinea) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(presupuestolinea.getId(),presupuestolinea.getes_para_presupuesto());

		return sDescripcion;
	}	
	
	public static String getPresupuestoLineaDescripcion(PresupuestoLinea presupuestolinea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presupuestolinea !=null/* && presupuestolinea.getId()!=0*/) {
			if(presupuestolinea.getId()!=null) {
				sDescripcion=presupuestolinea.getId().toString();
			}//presupuestolineapresupuestolinea.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPresupuestoLineaDescripcionDetallado(PresupuestoLinea presupuestolinea) {
		String sDescripcion="";
			
		sDescripcion+=PresupuestoLineaConstantesFunciones.ID+"=";
		sDescripcion+=presupuestolinea.getId().toString()+",";
		sDescripcion+=PresupuestoLineaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presupuestolinea.getVersionRow().toString()+",";
		sDescripcion+=PresupuestoLineaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presupuestolinea.getid_empresa().toString()+",";
		sDescripcion+=PresupuestoLineaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=presupuestolinea.getid_linea().toString()+",";
		sDescripcion+=PresupuestoLineaConstantesFunciones.MARGEN+"=";
		sDescripcion+=presupuestolinea.getmargen().toString()+",";
		sDescripcion+=PresupuestoLineaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=presupuestolinea.getdescuento().toString()+",";
		sDescripcion+=PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO+"=";
		sDescripcion+=presupuestolinea.getes_para_presupuesto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPresupuestoLineaDescripcion(PresupuestoLinea presupuestolinea,String sValor) throws Exception {			
		if(presupuestolinea !=null) {
			//presupuestolineapresupuestolinea.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
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
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
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

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPresupuestoLinea(PresupuestoLinea presupuestolinea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosPresupuestoLineas(List<PresupuestoLinea> presupuestolineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresupuestoLinea presupuestolinea: presupuestolineas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoLinea(PresupuestoLinea presupuestolinea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presupuestolinea.getConCambioAuxiliar()) {
			presupuestolinea.setIsDeleted(presupuestolinea.getIsDeletedAuxiliar());	
			presupuestolinea.setIsNew(presupuestolinea.getIsNewAuxiliar());	
			presupuestolinea.setIsChanged(presupuestolinea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presupuestolinea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presupuestolinea.setIsDeletedAuxiliar(false);	
			presupuestolinea.setIsNewAuxiliar(false);	
			presupuestolinea.setIsChangedAuxiliar(false);
			
			presupuestolinea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresupuestoLineas(List<PresupuestoLinea> presupuestolineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresupuestoLinea presupuestolinea : presupuestolineas) {
			if(conAsignarBase && presupuestolinea.getConCambioAuxiliar()) {
				presupuestolinea.setIsDeleted(presupuestolinea.getIsDeletedAuxiliar());	
				presupuestolinea.setIsNew(presupuestolinea.getIsNewAuxiliar());	
				presupuestolinea.setIsChanged(presupuestolinea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presupuestolinea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presupuestolinea.setIsDeletedAuxiliar(false);	
				presupuestolinea.setIsNewAuxiliar(false);	
				presupuestolinea.setIsChangedAuxiliar(false);
				
				presupuestolinea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresupuestoLinea(PresupuestoLinea presupuestolinea,Boolean conEnteros) throws Exception  {
		presupuestolinea.setmargen(0.0);
		presupuestolinea.setdescuento(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresupuestoLineas(List<PresupuestoLinea> presupuestolineas,Boolean conEnteros) throws Exception  {
		
		for(PresupuestoLinea presupuestolinea: presupuestolineas) {
			presupuestolinea.setmargen(0.0);
			presupuestolinea.setdescuento(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresupuestoLinea(List<PresupuestoLinea> presupuestolineas,PresupuestoLinea presupuestolineaAux) throws Exception  {
		PresupuestoLineaConstantesFunciones.InicializarValoresPresupuestoLinea(presupuestolineaAux,true);
		
		for(PresupuestoLinea presupuestolinea: presupuestolineas) {
			if(presupuestolinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			presupuestolineaAux.setmargen(presupuestolineaAux.getmargen()+presupuestolinea.getmargen());			
			presupuestolineaAux.setdescuento(presupuestolineaAux.getdescuento()+presupuestolinea.getdescuento());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresupuestoLineaConstantesFunciones.getArrayColumnasGlobalesPresupuestoLinea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresupuestoLinea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresupuestoLineaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresupuestoLineaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresupuestoLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresupuestoLinea> presupuestolineas,PresupuestoLinea presupuestolinea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresupuestoLinea presupuestolineaAux: presupuestolineas) {
			if(presupuestolineaAux!=null && presupuestolinea!=null) {
				if((presupuestolineaAux.getId()==null && presupuestolinea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presupuestolineaAux.getId()!=null && presupuestolinea.getId()!=null){
					if(presupuestolineaAux.getId().equals(presupuestolinea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresupuestoLinea(List<PresupuestoLinea> presupuestolineas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double margenTotal=0.0;
		Double descuentoTotal=0.0;
	
		for(PresupuestoLinea presupuestolinea: presupuestolineas) {			
			if(presupuestolinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			margenTotal+=presupuestolinea.getmargen();
			descuentoTotal+=presupuestolinea.getdescuento();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoLineaConstantesFunciones.MARGEN);
		datoGeneral.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_MARGEN);
		datoGeneral.setdValorDouble(margenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PresupuestoLineaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresupuestoLinea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_ID, PresupuestoLineaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_VERSIONROW, PresupuestoLineaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_IDEMPRESA, PresupuestoLineaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_IDLINEA, PresupuestoLineaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_MARGEN, PresupuestoLineaConstantesFunciones.MARGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_DESCUENTO, PresupuestoLineaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresupuestoLineaConstantesFunciones.LABEL_ESPARAPRESUPUESTO, PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresupuestoLinea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.MARGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoLinea() throws Exception  {
		return PresupuestoLineaConstantesFunciones.getTiposSeleccionarPresupuestoLinea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoLinea(Boolean conFk) throws Exception  {
		return PresupuestoLineaConstantesFunciones.getTiposSeleccionarPresupuestoLinea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresupuestoLinea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoLineaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoLineaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoLineaConstantesFunciones.LABEL_MARGEN);
			reporte.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_MARGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoLineaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresupuestoLineaConstantesFunciones.LABEL_ESPARAPRESUPUESTO);
			reporte.setsDescripcion(PresupuestoLineaConstantesFunciones.LABEL_ESPARAPRESUPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresupuestoLinea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoLinea(PresupuestoLinea presupuestolineaAux) throws Exception {
		
			presupuestolineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestolineaAux.getEmpresa()));
			presupuestolineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestolineaAux.getLinea()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresupuestoLinea(List<PresupuestoLinea> presupuestolineasTemp) throws Exception {
		for(PresupuestoLinea presupuestolineaAux:presupuestolineasTemp) {
			
			presupuestolineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presupuestolineaAux.getEmpresa()));
			presupuestolineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(presupuestolineaAux.getLinea()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresupuestoLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresupuestoLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoLineaConstantesFunciones.getClassesRelationshipsOfPresupuestoLinea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresupuestoLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresupuestoLineaConstantesFunciones.getClassesRelationshipsFromStringsOfPresupuestoLinea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresupuestoLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PresupuestoLinea presupuestolinea,List<PresupuestoLinea> presupuestolineas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresupuestoLinea presupuestolineaEncontrado=null;
			
			for(PresupuestoLinea presupuestolineaLocal:presupuestolineas) {
				if(presupuestolineaLocal.getId().equals(presupuestolinea.getId())) {
					presupuestolineaEncontrado=presupuestolineaLocal;
					
					presupuestolineaLocal.setIsChanged(presupuestolinea.getIsChanged());
					presupuestolineaLocal.setIsNew(presupuestolinea.getIsNew());
					presupuestolineaLocal.setIsDeleted(presupuestolinea.getIsDeleted());
					
					presupuestolineaLocal.setGeneralEntityOriginal(presupuestolinea.getGeneralEntityOriginal());
					
					presupuestolineaLocal.setId(presupuestolinea.getId());	
					presupuestolineaLocal.setVersionRow(presupuestolinea.getVersionRow());	
					presupuestolineaLocal.setid_empresa(presupuestolinea.getid_empresa());	
					presupuestolineaLocal.setid_linea(presupuestolinea.getid_linea());	
					presupuestolineaLocal.setmargen(presupuestolinea.getmargen());	
					presupuestolineaLocal.setdescuento(presupuestolinea.getdescuento());	
					presupuestolineaLocal.setes_para_presupuesto(presupuestolinea.getes_para_presupuesto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presupuestolinea.getIsDeleted()) {
				if(!existe) {
					presupuestolineas.add(presupuestolinea);
				}
			} else {
				if(presupuestolineaEncontrado!=null && permiteQuitar)  {
					presupuestolineas.remove(presupuestolineaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresupuestoLinea presupuestolinea,List<PresupuestoLinea> presupuestolineas) throws Exception {
		try	{			
			for(PresupuestoLinea presupuestolineaLocal:presupuestolineas) {
				if(presupuestolineaLocal.getId().equals(presupuestolinea.getId())) {
					presupuestolineaLocal.setIsSelected(presupuestolinea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresupuestoLinea(List<PresupuestoLinea> presupuestolineasAux) throws Exception {
		//this.presupuestolineasAux=presupuestolineasAux;
		
		for(PresupuestoLinea presupuestolineaAux:presupuestolineasAux) {
			if(presupuestolineaAux.getIsChanged()) {
				presupuestolineaAux.setIsChanged(false);
			}		
			
			if(presupuestolineaAux.getIsNew()) {
				presupuestolineaAux.setIsNew(false);
			}	
			
			if(presupuestolineaAux.getIsDeleted()) {
				presupuestolineaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresupuestoLinea(PresupuestoLinea presupuestolineaAux) throws Exception {
		//this.presupuestolineaAux=presupuestolineaAux;
		
			if(presupuestolineaAux.getIsChanged()) {
				presupuestolineaAux.setIsChanged(false);
			}		
			
			if(presupuestolineaAux.getIsNew()) {
				presupuestolineaAux.setIsNew(false);
			}	
			
			if(presupuestolineaAux.getIsDeleted()) {
				presupuestolineaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresupuestoLinea presupuestolineaAsignar,PresupuestoLinea presupuestolinea) throws Exception {
		presupuestolineaAsignar.setId(presupuestolinea.getId());	
		presupuestolineaAsignar.setVersionRow(presupuestolinea.getVersionRow());	
		presupuestolineaAsignar.setid_empresa(presupuestolinea.getid_empresa());
		presupuestolineaAsignar.setempresa_descripcion(presupuestolinea.getempresa_descripcion());	
		presupuestolineaAsignar.setid_linea(presupuestolinea.getid_linea());
		presupuestolineaAsignar.setlinea_descripcion(presupuestolinea.getlinea_descripcion());	
		presupuestolineaAsignar.setmargen(presupuestolinea.getmargen());	
		presupuestolineaAsignar.setdescuento(presupuestolinea.getdescuento());	
		presupuestolineaAsignar.setes_para_presupuesto(presupuestolinea.getes_para_presupuesto());	
	}
	
	public static void inicializarPresupuestoLinea(PresupuestoLinea presupuestolinea) throws Exception {
		try {
				presupuestolinea.setId(0L);	
					
				presupuestolinea.setid_empresa(-1L);	
				presupuestolinea.setid_linea(-1L);	
				presupuestolinea.setmargen(0.0);	
				presupuestolinea.setdescuento(0.0);	
				presupuestolinea.setes_para_presupuesto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresupuestoLinea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoLineaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoLineaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoLineaConstantesFunciones.LABEL_MARGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoLineaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresupuestoLineaConstantesFunciones.LABEL_ESPARAPRESUPUESTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresupuestoLinea(String sTipo,Row row,Workbook workbook,PresupuestoLinea presupuestolinea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestolinea.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestolinea.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestolinea.getmargen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presupuestolinea.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(presupuestolinea.getes_para_presupuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresupuestoLinea=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresupuestoLinea() {
		return this.sFinalQueryPresupuestoLinea;
	}
	
	public void setsFinalQueryPresupuestoLinea(String sFinalQueryPresupuestoLinea) {
		this.sFinalQueryPresupuestoLinea= sFinalQueryPresupuestoLinea;
	}
	
	public Border resaltarSeleccionarPresupuestoLinea=null;
	
	public Border setResaltarSeleccionarPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresupuestoLinea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresupuestoLinea() {
		return this.resaltarSeleccionarPresupuestoLinea;
	}
	
	public void setResaltarSeleccionarPresupuestoLinea(Border borderResaltarSeleccionarPresupuestoLinea) {
		this.resaltarSeleccionarPresupuestoLinea= borderResaltarSeleccionarPresupuestoLinea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresupuestoLinea=null;
	public Boolean mostraridPresupuestoLinea=true;
	public Boolean activaridPresupuestoLinea=true;

	public Border resaltarid_empresaPresupuestoLinea=null;
	public Boolean mostrarid_empresaPresupuestoLinea=true;
	public Boolean activarid_empresaPresupuestoLinea=true;
	public Boolean cargarid_empresaPresupuestoLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresupuestoLinea=false;//ConEventDepend=true

	public Border resaltarid_lineaPresupuestoLinea=null;
	public Boolean mostrarid_lineaPresupuestoLinea=true;
	public Boolean activarid_lineaPresupuestoLinea=true;
	public Boolean cargarid_lineaPresupuestoLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaPresupuestoLinea=false;//ConEventDepend=true

	public Border resaltarmargenPresupuestoLinea=null;
	public Boolean mostrarmargenPresupuestoLinea=true;
	public Boolean activarmargenPresupuestoLinea=true;

	public Border resaltardescuentoPresupuestoLinea=null;
	public Boolean mostrardescuentoPresupuestoLinea=true;
	public Boolean activardescuentoPresupuestoLinea=true;

	public Border resaltares_para_presupuestoPresupuestoLinea=null;
	public Boolean mostrares_para_presupuestoPresupuestoLinea=true;
	public Boolean activares_para_presupuestoPresupuestoLinea=true;

	
	

	public Border setResaltaridPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltaridPresupuestoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresupuestoLinea() {
		return this.resaltaridPresupuestoLinea;
	}

	public void setResaltaridPresupuestoLinea(Border borderResaltar) {
		this.resaltaridPresupuestoLinea= borderResaltar;
	}

	public Boolean getMostraridPresupuestoLinea() {
		return this.mostraridPresupuestoLinea;
	}

	public void setMostraridPresupuestoLinea(Boolean mostraridPresupuestoLinea) {
		this.mostraridPresupuestoLinea= mostraridPresupuestoLinea;
	}

	public Boolean getActivaridPresupuestoLinea() {
		return this.activaridPresupuestoLinea;
	}

	public void setActivaridPresupuestoLinea(Boolean activaridPresupuestoLinea) {
		this.activaridPresupuestoLinea= activaridPresupuestoLinea;
	}

	public Border setResaltarid_empresaPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresupuestoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresupuestoLinea() {
		return this.resaltarid_empresaPresupuestoLinea;
	}

	public void setResaltarid_empresaPresupuestoLinea(Border borderResaltar) {
		this.resaltarid_empresaPresupuestoLinea= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresupuestoLinea() {
		return this.mostrarid_empresaPresupuestoLinea;
	}

	public void setMostrarid_empresaPresupuestoLinea(Boolean mostrarid_empresaPresupuestoLinea) {
		this.mostrarid_empresaPresupuestoLinea= mostrarid_empresaPresupuestoLinea;
	}

	public Boolean getActivarid_empresaPresupuestoLinea() {
		return this.activarid_empresaPresupuestoLinea;
	}

	public void setActivarid_empresaPresupuestoLinea(Boolean activarid_empresaPresupuestoLinea) {
		this.activarid_empresaPresupuestoLinea= activarid_empresaPresupuestoLinea;
	}

	public Boolean getCargarid_empresaPresupuestoLinea() {
		return this.cargarid_empresaPresupuestoLinea;
	}

	public void setCargarid_empresaPresupuestoLinea(Boolean cargarid_empresaPresupuestoLinea) {
		this.cargarid_empresaPresupuestoLinea= cargarid_empresaPresupuestoLinea;
	}

	public Border setResaltarid_lineaPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltarid_lineaPresupuestoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaPresupuestoLinea() {
		return this.resaltarid_lineaPresupuestoLinea;
	}

	public void setResaltarid_lineaPresupuestoLinea(Border borderResaltar) {
		this.resaltarid_lineaPresupuestoLinea= borderResaltar;
	}

	public Boolean getMostrarid_lineaPresupuestoLinea() {
		return this.mostrarid_lineaPresupuestoLinea;
	}

	public void setMostrarid_lineaPresupuestoLinea(Boolean mostrarid_lineaPresupuestoLinea) {
		this.mostrarid_lineaPresupuestoLinea= mostrarid_lineaPresupuestoLinea;
	}

	public Boolean getActivarid_lineaPresupuestoLinea() {
		return this.activarid_lineaPresupuestoLinea;
	}

	public void setActivarid_lineaPresupuestoLinea(Boolean activarid_lineaPresupuestoLinea) {
		this.activarid_lineaPresupuestoLinea= activarid_lineaPresupuestoLinea;
	}

	public Boolean getCargarid_lineaPresupuestoLinea() {
		return this.cargarid_lineaPresupuestoLinea;
	}

	public void setCargarid_lineaPresupuestoLinea(Boolean cargarid_lineaPresupuestoLinea) {
		this.cargarid_lineaPresupuestoLinea= cargarid_lineaPresupuestoLinea;
	}

	public Border setResaltarmargenPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltarmargenPresupuestoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmargenPresupuestoLinea() {
		return this.resaltarmargenPresupuestoLinea;
	}

	public void setResaltarmargenPresupuestoLinea(Border borderResaltar) {
		this.resaltarmargenPresupuestoLinea= borderResaltar;
	}

	public Boolean getMostrarmargenPresupuestoLinea() {
		return this.mostrarmargenPresupuestoLinea;
	}

	public void setMostrarmargenPresupuestoLinea(Boolean mostrarmargenPresupuestoLinea) {
		this.mostrarmargenPresupuestoLinea= mostrarmargenPresupuestoLinea;
	}

	public Boolean getActivarmargenPresupuestoLinea() {
		return this.activarmargenPresupuestoLinea;
	}

	public void setActivarmargenPresupuestoLinea(Boolean activarmargenPresupuestoLinea) {
		this.activarmargenPresupuestoLinea= activarmargenPresupuestoLinea;
	}

	public Border setResaltardescuentoPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltardescuentoPresupuestoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoPresupuestoLinea() {
		return this.resaltardescuentoPresupuestoLinea;
	}

	public void setResaltardescuentoPresupuestoLinea(Border borderResaltar) {
		this.resaltardescuentoPresupuestoLinea= borderResaltar;
	}

	public Boolean getMostrardescuentoPresupuestoLinea() {
		return this.mostrardescuentoPresupuestoLinea;
	}

	public void setMostrardescuentoPresupuestoLinea(Boolean mostrardescuentoPresupuestoLinea) {
		this.mostrardescuentoPresupuestoLinea= mostrardescuentoPresupuestoLinea;
	}

	public Boolean getActivardescuentoPresupuestoLinea() {
		return this.activardescuentoPresupuestoLinea;
	}

	public void setActivardescuentoPresupuestoLinea(Boolean activardescuentoPresupuestoLinea) {
		this.activardescuentoPresupuestoLinea= activardescuentoPresupuestoLinea;
	}

	public Border setResaltares_para_presupuestoPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presupuestolineaBeanSwingJInternalFrame.jTtoolBarPresupuestoLinea.setBorder(borderResaltar);
		
		this.resaltares_para_presupuestoPresupuestoLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_para_presupuestoPresupuestoLinea() {
		return this.resaltares_para_presupuestoPresupuestoLinea;
	}

	public void setResaltares_para_presupuestoPresupuestoLinea(Border borderResaltar) {
		this.resaltares_para_presupuestoPresupuestoLinea= borderResaltar;
	}

	public Boolean getMostrares_para_presupuestoPresupuestoLinea() {
		return this.mostrares_para_presupuestoPresupuestoLinea;
	}

	public void setMostrares_para_presupuestoPresupuestoLinea(Boolean mostrares_para_presupuestoPresupuestoLinea) {
		this.mostrares_para_presupuestoPresupuestoLinea= mostrares_para_presupuestoPresupuestoLinea;
	}

	public Boolean getActivares_para_presupuestoPresupuestoLinea() {
		return this.activares_para_presupuestoPresupuestoLinea;
	}

	public void setActivares_para_presupuestoPresupuestoLinea(Boolean activares_para_presupuestoPresupuestoLinea) {
		this.activares_para_presupuestoPresupuestoLinea= activares_para_presupuestoPresupuestoLinea;
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
		
		
		this.setMostraridPresupuestoLinea(esInicial);
		this.setMostrarid_empresaPresupuestoLinea(esInicial);
		this.setMostrarid_lineaPresupuestoLinea(esInicial);
		this.setMostrarmargenPresupuestoLinea(esInicial);
		this.setMostrardescuentoPresupuestoLinea(esInicial);
		this.setMostrares_para_presupuestoPresupuestoLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.ID)) {
				this.setMostraridPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.MARGEN)) {
				this.setMostrarmargenPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO)) {
				this.setMostrares_para_presupuestoPresupuestoLinea(esAsigna);
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
		
		
		this.setActivaridPresupuestoLinea(esInicial);
		this.setActivarid_empresaPresupuestoLinea(esInicial);
		this.setActivarid_lineaPresupuestoLinea(esInicial);
		this.setActivarmargenPresupuestoLinea(esInicial);
		this.setActivardescuentoPresupuestoLinea(esInicial);
		this.setActivares_para_presupuestoPresupuestoLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.ID)) {
				this.setActivaridPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.MARGEN)) {
				this.setActivarmargenPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO)) {
				this.setActivares_para_presupuestoPresupuestoLinea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresupuestoLinea(esInicial);
		this.setResaltarid_empresaPresupuestoLinea(esInicial);
		this.setResaltarid_lineaPresupuestoLinea(esInicial);
		this.setResaltarmargenPresupuestoLinea(esInicial);
		this.setResaltardescuentoPresupuestoLinea(esInicial);
		this.setResaltares_para_presupuestoPresupuestoLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.ID)) {
				this.setResaltaridPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.MARGEN)) {
				this.setResaltarmargenPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoPresupuestoLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresupuestoLineaConstantesFunciones.ESPARAPRESUPUESTO)) {
				this.setResaltares_para_presupuestoPresupuestoLinea(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaPresupuestoLinea=true;

	public Boolean getMostrarFK_IdEmpresaPresupuestoLinea() {
		return this.mostrarFK_IdEmpresaPresupuestoLinea;
	}

	public void setMostrarFK_IdEmpresaPresupuestoLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresupuestoLinea= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaPresupuestoLinea=true;

	public Boolean getMostrarFK_IdLineaPresupuestoLinea() {
		return this.mostrarFK_IdLineaPresupuestoLinea;
	}

	public void setMostrarFK_IdLineaPresupuestoLinea(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaPresupuestoLinea= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaPresupuestoLinea=true;

	public Boolean getActivarFK_IdEmpresaPresupuestoLinea() {
		return this.activarFK_IdEmpresaPresupuestoLinea;
	}

	public void setActivarFK_IdEmpresaPresupuestoLinea(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresupuestoLinea= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaPresupuestoLinea=true;

	public Boolean getActivarFK_IdLineaPresupuestoLinea() {
		return this.activarFK_IdLineaPresupuestoLinea;
	}

	public void setActivarFK_IdLineaPresupuestoLinea(Boolean habilitarResaltar) {
		this.activarFK_IdLineaPresupuestoLinea= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaPresupuestoLinea=null;

	public Border getResaltarFK_IdEmpresaPresupuestoLinea() {
		return this.resaltarFK_IdEmpresaPresupuestoLinea;
	}

	public void setResaltarFK_IdEmpresaPresupuestoLinea(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresupuestoLinea= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresupuestoLinea= borderResaltar;
	}

	public Border resaltarFK_IdLineaPresupuestoLinea=null;

	public Border getResaltarFK_IdLineaPresupuestoLinea() {
		return this.resaltarFK_IdLineaPresupuestoLinea;
	}

	public void setResaltarFK_IdLineaPresupuestoLinea(Border borderResaltar) {
		this.resaltarFK_IdLineaPresupuestoLinea= borderResaltar;
	}

	public void setResaltarFK_IdLineaPresupuestoLinea(ParametroGeneralUsuario parametroGeneralUsuario/*PresupuestoLineaBeanSwingJInternalFrame presupuestolineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaPresupuestoLinea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}