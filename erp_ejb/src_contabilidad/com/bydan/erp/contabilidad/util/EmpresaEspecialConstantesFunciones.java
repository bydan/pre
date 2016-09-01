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


import com.bydan.erp.contabilidad.util.EmpresaEspecialConstantesFunciones;
import com.bydan.erp.contabilidad.util.EmpresaEspecialParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EmpresaEspecialParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpresaEspecialConstantesFunciones extends EmpresaEspecialConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="EmpresaEspecial";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="EmpresaEspecial"+EmpresaEspecialConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpresaEspecialHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpresaEspecialHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpresaEspecialConstantesFunciones.SCHEMA+"_"+EmpresaEspecialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpresaEspecialHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpresaEspecialConstantesFunciones.SCHEMA+"_"+EmpresaEspecialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpresaEspecialConstantesFunciones.SCHEMA+"_"+EmpresaEspecialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpresaEspecialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpresaEspecialConstantesFunciones.SCHEMA+"_"+EmpresaEspecialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaEspecialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpresaEspecialHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaEspecialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaEspecialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpresaEspecialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpresaEspecialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpresaEspecialConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpresaEspecialConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpresaEspecialConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpresaEspecialConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empresa Especiales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Empresa Especial";
	public static final String SCLASSWEBTITULO_LOWER="Empresa Especial";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="EmpresaEspecial";
	public static final String OBJECTNAME="empresaespecial";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="empresa_especial";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empresaespecial from "+EmpresaEspecialConstantesFunciones.SPERSISTENCENAME+" empresaespecial";
	public static String QUERYSELECTNATIVE="select "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".id,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".version_row,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".numero_resolucion,"+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME+".fecha_resolucion from "+EmpresaEspecialConstantesFunciones.SCHEMA+"."+EmpresaEspecialConstantesFunciones.TABLENAME;//+" as "+EmpresaEspecialConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpresaEspecialConstantesFuncionesAdditional empresaespecialConstantesFuncionesAdditional=null;
	
	public EmpresaEspecialConstantesFuncionesAdditional getEmpresaEspecialConstantesFuncionesAdditional() {
		return this.empresaespecialConstantesFuncionesAdditional;
	}
	
	public void setEmpresaEspecialConstantesFuncionesAdditional(EmpresaEspecialConstantesFuncionesAdditional empresaespecialConstantesFuncionesAdditional) {
		try {
			this.empresaespecialConstantesFuncionesAdditional=empresaespecialConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NUMERORESOLUCION= "numero_resolucion";
    public static final String FECHARESOLUCION= "fecha_resolucion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NUMERORESOLUCION= "Numero Resolucion";
		public static final String LABEL_NUMERORESOLUCION_LOWER= "Numero Resolucion";
    	public static final String LABEL_FECHARESOLUCION= "Fecha Resolucion";
		public static final String LABEL_FECHARESOLUCION_LOWER= "Fecha Resolucion";
	
		
		
	public static final String SREGEXNUMERO_RESOLUCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RESOLUCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getEmpresaEspecialLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpresaEspecialConstantesFunciones.NUMERORESOLUCION)) {sLabelColumna=EmpresaEspecialConstantesFunciones.LABEL_NUMERORESOLUCION;}
		if(sNombreColumna.equals(EmpresaEspecialConstantesFunciones.FECHARESOLUCION)) {sLabelColumna=EmpresaEspecialConstantesFunciones.LABEL_FECHARESOLUCION;}
		
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
	
	
	
			
			
			
			
	
	public static String getEmpresaEspecialDescripcion(EmpresaEspecial empresaespecial) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empresaespecial !=null/* && empresaespecial.getId()!=0*/) {
			sDescripcion=empresaespecial.getnumero_resolucion();//empresaespecialempresaespecial.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpresaEspecialDescripcionDetallado(EmpresaEspecial empresaespecial) {
		String sDescripcion="";
			
		sDescripcion+=EmpresaEspecialConstantesFunciones.ID+"=";
		sDescripcion+=empresaespecial.getId().toString()+",";
		sDescripcion+=EmpresaEspecialConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empresaespecial.getVersionRow().toString()+",";
		sDescripcion+=EmpresaEspecialConstantesFunciones.NUMERORESOLUCION+"=";
		sDescripcion+=empresaespecial.getnumero_resolucion()+",";
		sDescripcion+=EmpresaEspecialConstantesFunciones.FECHARESOLUCION+"=";
		sDescripcion+=empresaespecial.getfecha_resolucion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpresaEspecialDescripcion(EmpresaEspecial empresaespecial,String sValor) throws Exception {			
		if(empresaespecial !=null) {
			empresaespecial.setnumero_resolucion(sValor);//empresaespecialempresaespecial.getId().toString();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosEmpresaEspecial(EmpresaEspecial empresaespecial,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empresaespecial.setnumero_resolucion(empresaespecial.getnumero_resolucion().trim());
	}
	
	public static void quitarEspaciosEmpresaEspecials(List<EmpresaEspecial> empresaespecials,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(EmpresaEspecial empresaespecial: empresaespecials) {
			empresaespecial.setnumero_resolucion(empresaespecial.getnumero_resolucion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpresaEspecial(EmpresaEspecial empresaespecial,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empresaespecial.getConCambioAuxiliar()) {
			empresaespecial.setIsDeleted(empresaespecial.getIsDeletedAuxiliar());	
			empresaespecial.setIsNew(empresaespecial.getIsNewAuxiliar());	
			empresaespecial.setIsChanged(empresaespecial.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empresaespecial.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empresaespecial.setIsDeletedAuxiliar(false);	
			empresaespecial.setIsNewAuxiliar(false);	
			empresaespecial.setIsChangedAuxiliar(false);
			
			empresaespecial.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpresaEspecials(List<EmpresaEspecial> empresaespecials,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(EmpresaEspecial empresaespecial : empresaespecials) {
			if(conAsignarBase && empresaespecial.getConCambioAuxiliar()) {
				empresaespecial.setIsDeleted(empresaespecial.getIsDeletedAuxiliar());	
				empresaespecial.setIsNew(empresaespecial.getIsNewAuxiliar());	
				empresaespecial.setIsChanged(empresaespecial.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empresaespecial.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empresaespecial.setIsDeletedAuxiliar(false);	
				empresaespecial.setIsNewAuxiliar(false);	
				empresaespecial.setIsChangedAuxiliar(false);
				
				empresaespecial.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpresaEspecial(EmpresaEspecial empresaespecial,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpresaEspecials(List<EmpresaEspecial> empresaespecials,Boolean conEnteros) throws Exception  {
		
		for(EmpresaEspecial empresaespecial: empresaespecials) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpresaEspecial(List<EmpresaEspecial> empresaespecials,EmpresaEspecial empresaespecialAux) throws Exception  {
		EmpresaEspecialConstantesFunciones.InicializarValoresEmpresaEspecial(empresaespecialAux,true);
		
		for(EmpresaEspecial empresaespecial: empresaespecials) {
			if(empresaespecial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpresaEspecial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpresaEspecialConstantesFunciones.getArrayColumnasGlobalesEmpresaEspecial(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpresaEspecial(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpresaEspecial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<EmpresaEspecial> empresaespecials,EmpresaEspecial empresaespecial,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(EmpresaEspecial empresaespecialAux: empresaespecials) {
			if(empresaespecialAux!=null && empresaespecial!=null) {
				if((empresaespecialAux.getId()==null && empresaespecial.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empresaespecialAux.getId()!=null && empresaespecial.getId()!=null){
					if(empresaespecialAux.getId().equals(empresaespecial.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpresaEspecial(List<EmpresaEspecial> empresaespecials) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(EmpresaEspecial empresaespecial: empresaespecials) {			
			if(empresaespecial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpresaEspecial() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpresaEspecialConstantesFunciones.LABEL_ID, EmpresaEspecialConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaEspecialConstantesFunciones.LABEL_VERSIONROW, EmpresaEspecialConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaEspecialConstantesFunciones.LABEL_NUMERORESOLUCION, EmpresaEspecialConstantesFunciones.NUMERORESOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpresaEspecialConstantesFunciones.LABEL_FECHARESOLUCION, EmpresaEspecialConstantesFunciones.FECHARESOLUCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpresaEspecial() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpresaEspecialConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaEspecialConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaEspecialConstantesFunciones.NUMERORESOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpresaEspecialConstantesFunciones.FECHARESOLUCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpresaEspecial() throws Exception  {
		return EmpresaEspecialConstantesFunciones.getTiposSeleccionarEmpresaEspecial(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpresaEspecial(Boolean conFk) throws Exception  {
		return EmpresaEspecialConstantesFunciones.getTiposSeleccionarEmpresaEspecial(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpresaEspecial(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaEspecialConstantesFunciones.LABEL_NUMERORESOLUCION);
			reporte.setsDescripcion(EmpresaEspecialConstantesFunciones.LABEL_NUMERORESOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpresaEspecialConstantesFunciones.LABEL_FECHARESOLUCION);
			reporte.setsDescripcion(EmpresaEspecialConstantesFunciones.LABEL_FECHARESOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpresaEspecial(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpresaEspecial(EmpresaEspecial empresaespecialAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesEmpresaEspecial(List<EmpresaEspecial> empresaespecialsTemp) throws Exception {
		for(EmpresaEspecial empresaespecialAux:empresaespecialsTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpresaEspecial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpresaEspecial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpresaEspecial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpresaEspecialConstantesFunciones.getClassesRelationshipsOfEmpresaEspecial(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpresaEspecial(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpresaEspecial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpresaEspecialConstantesFunciones.getClassesRelationshipsFromStringsOfEmpresaEspecial(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpresaEspecial(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(EmpresaEspecial empresaespecial,List<EmpresaEspecial> empresaespecials,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			EmpresaEspecial empresaespecialEncontrado=null;
			
			for(EmpresaEspecial empresaespecialLocal:empresaespecials) {
				if(empresaespecialLocal.getId().equals(empresaespecial.getId())) {
					empresaespecialEncontrado=empresaespecialLocal;
					
					empresaespecialLocal.setIsChanged(empresaespecial.getIsChanged());
					empresaespecialLocal.setIsNew(empresaespecial.getIsNew());
					empresaespecialLocal.setIsDeleted(empresaespecial.getIsDeleted());
					
					empresaespecialLocal.setGeneralEntityOriginal(empresaespecial.getGeneralEntityOriginal());
					
					empresaespecialLocal.setId(empresaespecial.getId());	
					empresaespecialLocal.setVersionRow(empresaespecial.getVersionRow());	
					empresaespecialLocal.setnumero_resolucion(empresaespecial.getnumero_resolucion());	
					empresaespecialLocal.setfecha_resolucion(empresaespecial.getfecha_resolucion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!empresaespecial.getIsDeleted()) {
				if(!existe) {
					empresaespecials.add(empresaespecial);
				}
			} else {
				if(empresaespecialEncontrado!=null && permiteQuitar)  {
					empresaespecials.remove(empresaespecialEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(EmpresaEspecial empresaespecial,List<EmpresaEspecial> empresaespecials) throws Exception {
		try	{			
			for(EmpresaEspecial empresaespecialLocal:empresaespecials) {
				if(empresaespecialLocal.getId().equals(empresaespecial.getId())) {
					empresaespecialLocal.setIsSelected(empresaespecial.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpresaEspecial(List<EmpresaEspecial> empresaespecialsAux) throws Exception {
		//this.empresaespecialsAux=empresaespecialsAux;
		
		for(EmpresaEspecial empresaespecialAux:empresaespecialsAux) {
			if(empresaespecialAux.getIsChanged()) {
				empresaespecialAux.setIsChanged(false);
			}		
			
			if(empresaespecialAux.getIsNew()) {
				empresaespecialAux.setIsNew(false);
			}	
			
			if(empresaespecialAux.getIsDeleted()) {
				empresaespecialAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpresaEspecial(EmpresaEspecial empresaespecialAux) throws Exception {
		//this.empresaespecialAux=empresaespecialAux;
		
			if(empresaespecialAux.getIsChanged()) {
				empresaespecialAux.setIsChanged(false);
			}		
			
			if(empresaespecialAux.getIsNew()) {
				empresaespecialAux.setIsNew(false);
			}	
			
			if(empresaespecialAux.getIsDeleted()) {
				empresaespecialAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(EmpresaEspecial empresaespecialAsignar,EmpresaEspecial empresaespecial) throws Exception {
		empresaespecialAsignar.setId(empresaespecial.getId());	
		empresaespecialAsignar.setVersionRow(empresaespecial.getVersionRow());	
		empresaespecialAsignar.setnumero_resolucion(empresaespecial.getnumero_resolucion());	
		empresaespecialAsignar.setfecha_resolucion(empresaespecial.getfecha_resolucion());	
	}
	
	public static void inicializarEmpresaEspecial(EmpresaEspecial empresaespecial) throws Exception {
		try {
				empresaespecial.setId(0L);	
					
				empresaespecial.setnumero_resolucion("");	
				empresaespecial.setfecha_resolucion(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpresaEspecial(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaEspecialConstantesFunciones.LABEL_NUMERORESOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpresaEspecialConstantesFunciones.LABEL_FECHARESOLUCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpresaEspecial(String sTipo,Row row,Workbook workbook,EmpresaEspecial empresaespecial,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empresaespecial.getnumero_resolucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empresaespecial.getfecha_resolucion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpresaEspecial=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpresaEspecial() {
		return this.sFinalQueryEmpresaEspecial;
	}
	
	public void setsFinalQueryEmpresaEspecial(String sFinalQueryEmpresaEspecial) {
		this.sFinalQueryEmpresaEspecial= sFinalQueryEmpresaEspecial;
	}
	
	public Border resaltarSeleccionarEmpresaEspecial=null;
	
	public Border setResaltarSeleccionarEmpresaEspecial(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaEspecialBeanSwingJInternalFrame empresaespecialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empresaespecialBeanSwingJInternalFrame.jTtoolBarEmpresaEspecial.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpresaEspecial= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpresaEspecial() {
		return this.resaltarSeleccionarEmpresaEspecial;
	}
	
	public void setResaltarSeleccionarEmpresaEspecial(Border borderResaltarSeleccionarEmpresaEspecial) {
		this.resaltarSeleccionarEmpresaEspecial= borderResaltarSeleccionarEmpresaEspecial;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpresaEspecial=null;
	public Boolean mostraridEmpresaEspecial=true;
	public Boolean activaridEmpresaEspecial=true;

	public Border resaltarnumero_resolucionEmpresaEspecial=null;
	public Boolean mostrarnumero_resolucionEmpresaEspecial=true;
	public Boolean activarnumero_resolucionEmpresaEspecial=true;

	public Border resaltarfecha_resolucionEmpresaEspecial=null;
	public Boolean mostrarfecha_resolucionEmpresaEspecial=true;
	public Boolean activarfecha_resolucionEmpresaEspecial=false;

	
	

	public Border setResaltaridEmpresaEspecial(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaEspecialBeanSwingJInternalFrame empresaespecialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaespecialBeanSwingJInternalFrame.jTtoolBarEmpresaEspecial.setBorder(borderResaltar);
		
		this.resaltaridEmpresaEspecial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpresaEspecial() {
		return this.resaltaridEmpresaEspecial;
	}

	public void setResaltaridEmpresaEspecial(Border borderResaltar) {
		this.resaltaridEmpresaEspecial= borderResaltar;
	}

	public Boolean getMostraridEmpresaEspecial() {
		return this.mostraridEmpresaEspecial;
	}

	public void setMostraridEmpresaEspecial(Boolean mostraridEmpresaEspecial) {
		this.mostraridEmpresaEspecial= mostraridEmpresaEspecial;
	}

	public Boolean getActivaridEmpresaEspecial() {
		return this.activaridEmpresaEspecial;
	}

	public void setActivaridEmpresaEspecial(Boolean activaridEmpresaEspecial) {
		this.activaridEmpresaEspecial= activaridEmpresaEspecial;
	}

	public Border setResaltarnumero_resolucionEmpresaEspecial(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaEspecialBeanSwingJInternalFrame empresaespecialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaespecialBeanSwingJInternalFrame.jTtoolBarEmpresaEspecial.setBorder(borderResaltar);
		
		this.resaltarnumero_resolucionEmpresaEspecial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_resolucionEmpresaEspecial() {
		return this.resaltarnumero_resolucionEmpresaEspecial;
	}

	public void setResaltarnumero_resolucionEmpresaEspecial(Border borderResaltar) {
		this.resaltarnumero_resolucionEmpresaEspecial= borderResaltar;
	}

	public Boolean getMostrarnumero_resolucionEmpresaEspecial() {
		return this.mostrarnumero_resolucionEmpresaEspecial;
	}

	public void setMostrarnumero_resolucionEmpresaEspecial(Boolean mostrarnumero_resolucionEmpresaEspecial) {
		this.mostrarnumero_resolucionEmpresaEspecial= mostrarnumero_resolucionEmpresaEspecial;
	}

	public Boolean getActivarnumero_resolucionEmpresaEspecial() {
		return this.activarnumero_resolucionEmpresaEspecial;
	}

	public void setActivarnumero_resolucionEmpresaEspecial(Boolean activarnumero_resolucionEmpresaEspecial) {
		this.activarnumero_resolucionEmpresaEspecial= activarnumero_resolucionEmpresaEspecial;
	}

	public Border setResaltarfecha_resolucionEmpresaEspecial(ParametroGeneralUsuario parametroGeneralUsuario/*EmpresaEspecialBeanSwingJInternalFrame empresaespecialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empresaespecialBeanSwingJInternalFrame.jTtoolBarEmpresaEspecial.setBorder(borderResaltar);
		
		this.resaltarfecha_resolucionEmpresaEspecial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_resolucionEmpresaEspecial() {
		return this.resaltarfecha_resolucionEmpresaEspecial;
	}

	public void setResaltarfecha_resolucionEmpresaEspecial(Border borderResaltar) {
		this.resaltarfecha_resolucionEmpresaEspecial= borderResaltar;
	}

	public Boolean getMostrarfecha_resolucionEmpresaEspecial() {
		return this.mostrarfecha_resolucionEmpresaEspecial;
	}

	public void setMostrarfecha_resolucionEmpresaEspecial(Boolean mostrarfecha_resolucionEmpresaEspecial) {
		this.mostrarfecha_resolucionEmpresaEspecial= mostrarfecha_resolucionEmpresaEspecial;
	}

	public Boolean getActivarfecha_resolucionEmpresaEspecial() {
		return this.activarfecha_resolucionEmpresaEspecial;
	}

	public void setActivarfecha_resolucionEmpresaEspecial(Boolean activarfecha_resolucionEmpresaEspecial) {
		this.activarfecha_resolucionEmpresaEspecial= activarfecha_resolucionEmpresaEspecial;
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
		
		
		this.setMostraridEmpresaEspecial(esInicial);
		this.setMostrarnumero_resolucionEmpresaEspecial(esInicial);
		this.setMostrarfecha_resolucionEmpresaEspecial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.ID)) {
				this.setMostraridEmpresaEspecial(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.NUMERORESOLUCION)) {
				this.setMostrarnumero_resolucionEmpresaEspecial(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.FECHARESOLUCION)) {
				this.setMostrarfecha_resolucionEmpresaEspecial(esAsigna);
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
		
		
		this.setActivaridEmpresaEspecial(esInicial);
		this.setActivarnumero_resolucionEmpresaEspecial(esInicial);
		this.setActivarfecha_resolucionEmpresaEspecial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.ID)) {
				this.setActivaridEmpresaEspecial(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.NUMERORESOLUCION)) {
				this.setActivarnumero_resolucionEmpresaEspecial(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.FECHARESOLUCION)) {
				this.setActivarfecha_resolucionEmpresaEspecial(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpresaEspecialBeanSwingJInternalFrame empresaespecialBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpresaEspecial(esInicial);
		this.setResaltarnumero_resolucionEmpresaEspecial(esInicial);
		this.setResaltarfecha_resolucionEmpresaEspecial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.ID)) {
				this.setResaltaridEmpresaEspecial(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.NUMERORESOLUCION)) {
				this.setResaltarnumero_resolucionEmpresaEspecial(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpresaEspecialConstantesFunciones.FECHARESOLUCION)) {
				this.setResaltarfecha_resolucionEmpresaEspecial(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpresaEspecialBeanSwingJInternalFrame empresaespecialBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}