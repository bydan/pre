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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoContratoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoContratoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoContratoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoContratoConstantesFunciones extends TipoContratoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoContrato";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoContrato"+TipoContratoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoContratoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoContratoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoContratoConstantesFunciones.SCHEMA+"_"+TipoContratoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoContratoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoContratoConstantesFunciones.SCHEMA+"_"+TipoContratoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoContratoConstantesFunciones.SCHEMA+"_"+TipoContratoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoContratoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoContratoConstantesFunciones.SCHEMA+"_"+TipoContratoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoContratoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoContratoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoContratoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoContratoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoContratoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoContratoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoContratoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoContratoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoContratoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoContratoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Contratos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Contrato";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Contrato";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoContrato";
	public static final String OBJECTNAME="tipocontrato";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_contrato";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocontrato from "+TipoContratoConstantesFunciones.SPERSISTENCENAME+" tipocontrato";
	public static String QUERYSELECTNATIVE="select "+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".id,"+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".version_row,"+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".id_empresa,"+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".id_formato,"+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".codigo,"+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".nombre,"+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME+".numero_dias from "+TipoContratoConstantesFunciones.SCHEMA+"."+TipoContratoConstantesFunciones.TABLENAME;//+" as "+TipoContratoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoContratoConstantesFuncionesAdditional tipocontratoConstantesFuncionesAdditional=null;
	
	public TipoContratoConstantesFuncionesAdditional getTipoContratoConstantesFuncionesAdditional() {
		return this.tipocontratoConstantesFuncionesAdditional;
	}
	
	public void setTipoContratoConstantesFuncionesAdditional(TipoContratoConstantesFuncionesAdditional tipocontratoConstantesFuncionesAdditional) {
		try {
			this.tipocontratoConstantesFuncionesAdditional=tipocontratoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDFORMATO= "id_formato";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NUMERODIAS= "numero_dias";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoContratoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoContratoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoContratoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoContratoConstantesFunciones.IDFORMATO)) {sLabelColumna=TipoContratoConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(TipoContratoConstantesFunciones.CODIGO)) {sLabelColumna=TipoContratoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoContratoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoContratoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoContratoConstantesFunciones.NUMERODIAS)) {sLabelColumna=TipoContratoConstantesFunciones.LABEL_NUMERODIAS;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getTipoContratoDescripcion(TipoContrato tipocontrato) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocontrato !=null/* && tipocontrato.getId()!=0*/) {
			sDescripcion=tipocontrato.getcodigo();//tipocontratotipocontrato.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoContratoDescripcionDetallado(TipoContrato tipocontrato) {
		String sDescripcion="";
			
		sDescripcion+=TipoContratoConstantesFunciones.ID+"=";
		sDescripcion+=tipocontrato.getId().toString()+",";
		sDescripcion+=TipoContratoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocontrato.getVersionRow().toString()+",";
		sDescripcion+=TipoContratoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocontrato.getid_empresa().toString()+",";
		sDescripcion+=TipoContratoConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=tipocontrato.getid_formato().toString()+",";
		sDescripcion+=TipoContratoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocontrato.getcodigo()+",";
		sDescripcion+=TipoContratoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocontrato.getnombre()+",";
		sDescripcion+=TipoContratoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=tipocontrato.getnumero_dias().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoContratoDescripcion(TipoContrato tipocontrato,String sValor) throws Exception {			
		if(tipocontrato !=null) {
			tipocontrato.setcodigo(sValor);;//tipocontratotipocontrato.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoContrato")) {
			sNombreIndice="Tipo=  Por Formato";
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

	public static String getDetalleIndiceFK_IdTipoContrato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoContrato(TipoContrato tipocontrato,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocontrato.setcodigo(tipocontrato.getcodigo().trim());
		tipocontrato.setnombre(tipocontrato.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoContratos(List<TipoContrato> tipocontratos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoContrato tipocontrato: tipocontratos) {
			tipocontrato.setcodigo(tipocontrato.getcodigo().trim());
			tipocontrato.setnombre(tipocontrato.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoContrato(TipoContrato tipocontrato,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocontrato.getConCambioAuxiliar()) {
			tipocontrato.setIsDeleted(tipocontrato.getIsDeletedAuxiliar());	
			tipocontrato.setIsNew(tipocontrato.getIsNewAuxiliar());	
			tipocontrato.setIsChanged(tipocontrato.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocontrato.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocontrato.setIsDeletedAuxiliar(false);	
			tipocontrato.setIsNewAuxiliar(false);	
			tipocontrato.setIsChangedAuxiliar(false);
			
			tipocontrato.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoContratos(List<TipoContrato> tipocontratos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoContrato tipocontrato : tipocontratos) {
			if(conAsignarBase && tipocontrato.getConCambioAuxiliar()) {
				tipocontrato.setIsDeleted(tipocontrato.getIsDeletedAuxiliar());	
				tipocontrato.setIsNew(tipocontrato.getIsNewAuxiliar());	
				tipocontrato.setIsChanged(tipocontrato.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocontrato.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocontrato.setIsDeletedAuxiliar(false);	
				tipocontrato.setIsNewAuxiliar(false);	
				tipocontrato.setIsChangedAuxiliar(false);
				
				tipocontrato.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoContrato(TipoContrato tipocontrato,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			tipocontrato.setnumero_dias(0);
		}
	}		
	
	public static void InicializarValoresTipoContratos(List<TipoContrato> tipocontratos,Boolean conEnteros) throws Exception  {
		
		for(TipoContrato tipocontrato: tipocontratos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				tipocontrato.setnumero_dias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoContrato(List<TipoContrato> tipocontratos,TipoContrato tipocontratoAux) throws Exception  {
		TipoContratoConstantesFunciones.InicializarValoresTipoContrato(tipocontratoAux,true);
		
		for(TipoContrato tipocontrato: tipocontratos) {
			if(tipocontrato.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipocontratoAux.setnumero_dias(tipocontratoAux.getnumero_dias()+tipocontrato.getnumero_dias());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoContrato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoContratoConstantesFunciones.getArrayColumnasGlobalesTipoContrato(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoContrato(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoContratoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoContratoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoContrato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoContrato> tipocontratos,TipoContrato tipocontrato,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoContrato tipocontratoAux: tipocontratos) {
			if(tipocontratoAux!=null && tipocontrato!=null) {
				if((tipocontratoAux.getId()==null && tipocontrato.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocontratoAux.getId()!=null && tipocontrato.getId()!=null){
					if(tipocontratoAux.getId().equals(tipocontrato.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoContrato(List<TipoContrato> tipocontratos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoContrato tipocontrato: tipocontratos) {			
			if(tipocontrato.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoContrato() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_ID, TipoContratoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_VERSIONROW, TipoContratoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_IDEMPRESA, TipoContratoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_IDFORMATO, TipoContratoConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_CODIGO, TipoContratoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_NOMBRE, TipoContratoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoContratoConstantesFunciones.LABEL_NUMERODIAS, TipoContratoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoContrato() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoContratoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoContrato() throws Exception  {
		return TipoContratoConstantesFunciones.getTiposSeleccionarTipoContrato(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoContrato(Boolean conFk) throws Exception  {
		return TipoContratoConstantesFunciones.getTiposSeleccionarTipoContrato(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoContrato(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoContratoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoContratoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoContratoConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(TipoContratoConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoContratoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoContratoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoContratoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoContratoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoContratoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(TipoContratoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoContrato(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoContrato(TipoContrato tipocontratoAux) throws Exception {
		
			tipocontratoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocontratoAux.getEmpresa()));
			tipocontratoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(tipocontratoAux.getFormato()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoContrato(List<TipoContrato> tipocontratosTemp) throws Exception {
		for(TipoContrato tipocontratoAux:tipocontratosTemp) {
			
			tipocontratoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocontratoAux.getEmpresa()));
			tipocontratoAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(tipocontratoAux.getFormato()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoContrato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Formato.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoContrato(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoContrato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoContratoConstantesFunciones.getClassesRelationshipsOfTipoContrato(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoContrato(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoContrato(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoContratoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoContrato(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoContrato(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
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
	public static void actualizarLista(TipoContrato tipocontrato,List<TipoContrato> tipocontratos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoContrato tipocontratoEncontrado=null;
			
			for(TipoContrato tipocontratoLocal:tipocontratos) {
				if(tipocontratoLocal.getId().equals(tipocontrato.getId())) {
					tipocontratoEncontrado=tipocontratoLocal;
					
					tipocontratoLocal.setIsChanged(tipocontrato.getIsChanged());
					tipocontratoLocal.setIsNew(tipocontrato.getIsNew());
					tipocontratoLocal.setIsDeleted(tipocontrato.getIsDeleted());
					
					tipocontratoLocal.setGeneralEntityOriginal(tipocontrato.getGeneralEntityOriginal());
					
					tipocontratoLocal.setId(tipocontrato.getId());	
					tipocontratoLocal.setVersionRow(tipocontrato.getVersionRow());	
					tipocontratoLocal.setid_empresa(tipocontrato.getid_empresa());	
					tipocontratoLocal.setid_formato(tipocontrato.getid_formato());	
					tipocontratoLocal.setcodigo(tipocontrato.getcodigo());	
					tipocontratoLocal.setnombre(tipocontrato.getnombre());	
					tipocontratoLocal.setnumero_dias(tipocontrato.getnumero_dias());	
					
					
					tipocontratoLocal.setDatoGeneralEmpleados(tipocontrato.getDatoGeneralEmpleados());
					tipocontratoLocal.setEmpleados(tipocontrato.getEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipocontrato.getIsDeleted()) {
				if(!existe) {
					tipocontratos.add(tipocontrato);
				}
			} else {
				if(tipocontratoEncontrado!=null && permiteQuitar)  {
					tipocontratos.remove(tipocontratoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoContrato tipocontrato,List<TipoContrato> tipocontratos) throws Exception {
		try	{			
			for(TipoContrato tipocontratoLocal:tipocontratos) {
				if(tipocontratoLocal.getId().equals(tipocontrato.getId())) {
					tipocontratoLocal.setIsSelected(tipocontrato.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoContrato(List<TipoContrato> tipocontratosAux) throws Exception {
		//this.tipocontratosAux=tipocontratosAux;
		
		for(TipoContrato tipocontratoAux:tipocontratosAux) {
			if(tipocontratoAux.getIsChanged()) {
				tipocontratoAux.setIsChanged(false);
			}		
			
			if(tipocontratoAux.getIsNew()) {
				tipocontratoAux.setIsNew(false);
			}	
			
			if(tipocontratoAux.getIsDeleted()) {
				tipocontratoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoContrato(TipoContrato tipocontratoAux) throws Exception {
		//this.tipocontratoAux=tipocontratoAux;
		
			if(tipocontratoAux.getIsChanged()) {
				tipocontratoAux.setIsChanged(false);
			}		
			
			if(tipocontratoAux.getIsNew()) {
				tipocontratoAux.setIsNew(false);
			}	
			
			if(tipocontratoAux.getIsDeleted()) {
				tipocontratoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoContrato tipocontratoAsignar,TipoContrato tipocontrato) throws Exception {
		tipocontratoAsignar.setId(tipocontrato.getId());	
		tipocontratoAsignar.setVersionRow(tipocontrato.getVersionRow());	
		tipocontratoAsignar.setid_empresa(tipocontrato.getid_empresa());
		tipocontratoAsignar.setempresa_descripcion(tipocontrato.getempresa_descripcion());	
		tipocontratoAsignar.setid_formato(tipocontrato.getid_formato());
		tipocontratoAsignar.setformato_descripcion(tipocontrato.getformato_descripcion());	
		tipocontratoAsignar.setcodigo(tipocontrato.getcodigo());	
		tipocontratoAsignar.setnombre(tipocontrato.getnombre());	
		tipocontratoAsignar.setnumero_dias(tipocontrato.getnumero_dias());	
	}
	
	public static void inicializarTipoContrato(TipoContrato tipocontrato) throws Exception {
		try {
				tipocontrato.setId(0L);	
					
				tipocontrato.setid_empresa(-1L);	
				tipocontrato.setid_formato(-1L);	
				tipocontrato.setcodigo("");	
				tipocontrato.setnombre("");	
				tipocontrato.setnumero_dias(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoContrato(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoContratoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoContratoConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoContratoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoContratoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoContratoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoContrato(String sTipo,Row row,Workbook workbook,TipoContrato tipocontrato,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocontrato.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocontrato.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocontrato.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocontrato.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocontrato.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoContrato=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoContrato() {
		return this.sFinalQueryTipoContrato;
	}
	
	public void setsFinalQueryTipoContrato(String sFinalQueryTipoContrato) {
		this.sFinalQueryTipoContrato= sFinalQueryTipoContrato;
	}
	
	public Border resaltarSeleccionarTipoContrato=null;
	
	public Border setResaltarSeleccionarTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoContrato= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoContrato() {
		return this.resaltarSeleccionarTipoContrato;
	}
	
	public void setResaltarSeleccionarTipoContrato(Border borderResaltarSeleccionarTipoContrato) {
		this.resaltarSeleccionarTipoContrato= borderResaltarSeleccionarTipoContrato;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoContrato=null;
	public Boolean mostraridTipoContrato=true;
	public Boolean activaridTipoContrato=true;

	public Border resaltarid_empresaTipoContrato=null;
	public Boolean mostrarid_empresaTipoContrato=true;
	public Boolean activarid_empresaTipoContrato=true;
	public Boolean cargarid_empresaTipoContrato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoContrato=false;//ConEventDepend=true

	public Border resaltarid_formatoTipoContrato=null;
	public Boolean mostrarid_formatoTipoContrato=true;
	public Boolean activarid_formatoTipoContrato=true;
	public Boolean cargarid_formatoTipoContrato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoTipoContrato=false;//ConEventDepend=true

	public Border resaltarcodigoTipoContrato=null;
	public Boolean mostrarcodigoTipoContrato=true;
	public Boolean activarcodigoTipoContrato=true;

	public Border resaltarnombreTipoContrato=null;
	public Boolean mostrarnombreTipoContrato=true;
	public Boolean activarnombreTipoContrato=true;

	public Border resaltarnumero_diasTipoContrato=null;
	public Boolean mostrarnumero_diasTipoContrato=true;
	public Boolean activarnumero_diasTipoContrato=true;

	
	

	public Border setResaltaridTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltaridTipoContrato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoContrato() {
		return this.resaltaridTipoContrato;
	}

	public void setResaltaridTipoContrato(Border borderResaltar) {
		this.resaltaridTipoContrato= borderResaltar;
	}

	public Boolean getMostraridTipoContrato() {
		return this.mostraridTipoContrato;
	}

	public void setMostraridTipoContrato(Boolean mostraridTipoContrato) {
		this.mostraridTipoContrato= mostraridTipoContrato;
	}

	public Boolean getActivaridTipoContrato() {
		return this.activaridTipoContrato;
	}

	public void setActivaridTipoContrato(Boolean activaridTipoContrato) {
		this.activaridTipoContrato= activaridTipoContrato;
	}

	public Border setResaltarid_empresaTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoContrato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoContrato() {
		return this.resaltarid_empresaTipoContrato;
	}

	public void setResaltarid_empresaTipoContrato(Border borderResaltar) {
		this.resaltarid_empresaTipoContrato= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoContrato() {
		return this.mostrarid_empresaTipoContrato;
	}

	public void setMostrarid_empresaTipoContrato(Boolean mostrarid_empresaTipoContrato) {
		this.mostrarid_empresaTipoContrato= mostrarid_empresaTipoContrato;
	}

	public Boolean getActivarid_empresaTipoContrato() {
		return this.activarid_empresaTipoContrato;
	}

	public void setActivarid_empresaTipoContrato(Boolean activarid_empresaTipoContrato) {
		this.activarid_empresaTipoContrato= activarid_empresaTipoContrato;
	}

	public Boolean getCargarid_empresaTipoContrato() {
		return this.cargarid_empresaTipoContrato;
	}

	public void setCargarid_empresaTipoContrato(Boolean cargarid_empresaTipoContrato) {
		this.cargarid_empresaTipoContrato= cargarid_empresaTipoContrato;
	}

	public Border setResaltarid_formatoTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltarid_formatoTipoContrato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoTipoContrato() {
		return this.resaltarid_formatoTipoContrato;
	}

	public void setResaltarid_formatoTipoContrato(Border borderResaltar) {
		this.resaltarid_formatoTipoContrato= borderResaltar;
	}

	public Boolean getMostrarid_formatoTipoContrato() {
		return this.mostrarid_formatoTipoContrato;
	}

	public void setMostrarid_formatoTipoContrato(Boolean mostrarid_formatoTipoContrato) {
		this.mostrarid_formatoTipoContrato= mostrarid_formatoTipoContrato;
	}

	public Boolean getActivarid_formatoTipoContrato() {
		return this.activarid_formatoTipoContrato;
	}

	public void setActivarid_formatoTipoContrato(Boolean activarid_formatoTipoContrato) {
		this.activarid_formatoTipoContrato= activarid_formatoTipoContrato;
	}

	public Boolean getCargarid_formatoTipoContrato() {
		return this.cargarid_formatoTipoContrato;
	}

	public void setCargarid_formatoTipoContrato(Boolean cargarid_formatoTipoContrato) {
		this.cargarid_formatoTipoContrato= cargarid_formatoTipoContrato;
	}

	public Border setResaltarcodigoTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoContrato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoContrato() {
		return this.resaltarcodigoTipoContrato;
	}

	public void setResaltarcodigoTipoContrato(Border borderResaltar) {
		this.resaltarcodigoTipoContrato= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoContrato() {
		return this.mostrarcodigoTipoContrato;
	}

	public void setMostrarcodigoTipoContrato(Boolean mostrarcodigoTipoContrato) {
		this.mostrarcodigoTipoContrato= mostrarcodigoTipoContrato;
	}

	public Boolean getActivarcodigoTipoContrato() {
		return this.activarcodigoTipoContrato;
	}

	public void setActivarcodigoTipoContrato(Boolean activarcodigoTipoContrato) {
		this.activarcodigoTipoContrato= activarcodigoTipoContrato;
	}

	public Border setResaltarnombreTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltarnombreTipoContrato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoContrato() {
		return this.resaltarnombreTipoContrato;
	}

	public void setResaltarnombreTipoContrato(Border borderResaltar) {
		this.resaltarnombreTipoContrato= borderResaltar;
	}

	public Boolean getMostrarnombreTipoContrato() {
		return this.mostrarnombreTipoContrato;
	}

	public void setMostrarnombreTipoContrato(Boolean mostrarnombreTipoContrato) {
		this.mostrarnombreTipoContrato= mostrarnombreTipoContrato;
	}

	public Boolean getActivarnombreTipoContrato() {
		return this.activarnombreTipoContrato;
	}

	public void setActivarnombreTipoContrato(Boolean activarnombreTipoContrato) {
		this.activarnombreTipoContrato= activarnombreTipoContrato;
	}

	public Border setResaltarnumero_diasTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltar);
		
		this.resaltarnumero_diasTipoContrato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasTipoContrato() {
		return this.resaltarnumero_diasTipoContrato;
	}

	public void setResaltarnumero_diasTipoContrato(Border borderResaltar) {
		this.resaltarnumero_diasTipoContrato= borderResaltar;
	}

	public Boolean getMostrarnumero_diasTipoContrato() {
		return this.mostrarnumero_diasTipoContrato;
	}

	public void setMostrarnumero_diasTipoContrato(Boolean mostrarnumero_diasTipoContrato) {
		this.mostrarnumero_diasTipoContrato= mostrarnumero_diasTipoContrato;
	}

	public Boolean getActivarnumero_diasTipoContrato() {
		return this.activarnumero_diasTipoContrato;
	}

	public void setActivarnumero_diasTipoContrato(Boolean activarnumero_diasTipoContrato) {
		this.activarnumero_diasTipoContrato= activarnumero_diasTipoContrato;
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
		
		
		this.setMostraridTipoContrato(esInicial);
		this.setMostrarid_empresaTipoContrato(esInicial);
		this.setMostrarid_formatoTipoContrato(esInicial);
		this.setMostrarcodigoTipoContrato(esInicial);
		this.setMostrarnombreTipoContrato(esInicial);
		this.setMostrarnumero_diasTipoContrato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoContratoConstantesFunciones.ID)) {
				this.setMostraridTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasTipoContrato(esAsigna);
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
		
		
		this.setActivaridTipoContrato(esInicial);
		this.setActivarid_empresaTipoContrato(esInicial);
		this.setActivarid_formatoTipoContrato(esInicial);
		this.setActivarcodigoTipoContrato(esInicial);
		this.setActivarnombreTipoContrato(esInicial);
		this.setActivarnumero_diasTipoContrato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoContratoConstantesFunciones.ID)) {
				this.setActivaridTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasTipoContrato(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoContrato(esInicial);
		this.setResaltarid_empresaTipoContrato(esInicial);
		this.setResaltarid_formatoTipoContrato(esInicial);
		this.setResaltarcodigoTipoContrato(esInicial);
		this.setResaltarnombreTipoContrato(esInicial);
		this.setResaltarnumero_diasTipoContrato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoContratoConstantesFunciones.ID)) {
				this.setResaltaridTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoContrato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoContratoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasTipoContrato(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDatoGeneralEmpleadoTipoContrato=null;

	public Border getResaltarDatoGeneralEmpleadoTipoContrato() {
		return this.resaltarDatoGeneralEmpleadoTipoContrato;
	}

	public void setResaltarDatoGeneralEmpleadoTipoContrato(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoTipoContrato= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoTipoContrato= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoTipoContrato=true;

	public Boolean getMostrarDatoGeneralEmpleadoTipoContrato() {
		return this.mostrarDatoGeneralEmpleadoTipoContrato;
	}

	public void setMostrarDatoGeneralEmpleadoTipoContrato(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoTipoContrato= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoTipoContrato=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoTipoContrato() {
		return this.activarDatoGeneralEmpleadoTipoContrato;
	}

	public void setActivarDatoGeneralEmpleadoTipoContrato(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoTipoContrato= habilitarResaltarDatoGeneralEmpleado;
	}


	public Border resaltarEmpleadoTipoContrato=null;

	public Border getResaltarEmpleadoTipoContrato() {
		return this.resaltarEmpleadoTipoContrato;
	}

	public void setResaltarEmpleadoTipoContrato(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoTipoContrato= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipocontratoBeanSwingJInternalFrame.jTtoolBarTipoContrato.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoTipoContrato= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoTipoContrato=true;

	public Boolean getMostrarEmpleadoTipoContrato() {
		return this.mostrarEmpleadoTipoContrato;
	}

	public void setMostrarEmpleadoTipoContrato(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoTipoContrato= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoTipoContrato=true;

	public Boolean gethabilitarResaltarEmpleadoTipoContrato() {
		return this.activarEmpleadoTipoContrato;
	}

	public void setActivarEmpleadoTipoContrato(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoTipoContrato= habilitarResaltarEmpleado;
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

		this.setMostrarDatoGeneralEmpleadoTipoContrato(esInicial);
		this.setMostrarEmpleadoTipoContrato(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoTipoContrato(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoTipoContrato(esAsigna);
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

		this.setActivarDatoGeneralEmpleadoTipoContrato(esInicial);
		this.setActivarEmpleadoTipoContrato(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoTipoContrato(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoTipoContrato(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDatoGeneralEmpleadoTipoContrato(esInicial);
		this.setResaltarEmpleadoTipoContrato(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoTipoContrato(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoTipoContrato(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoContrato=true;

	public Boolean getMostrarFK_IdEmpresaTipoContrato() {
		return this.mostrarFK_IdEmpresaTipoContrato;
	}

	public void setMostrarFK_IdEmpresaTipoContrato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoContrato= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoContratoTipoContrato=true;

	public Boolean getMostrarFK_IdTipoContratoTipoContrato() {
		return this.mostrarFK_IdTipoContratoTipoContrato;
	}

	public void setMostrarFK_IdTipoContratoTipoContrato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoContratoTipoContrato= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoContrato=true;

	public Boolean getActivarFK_IdEmpresaTipoContrato() {
		return this.activarFK_IdEmpresaTipoContrato;
	}

	public void setActivarFK_IdEmpresaTipoContrato(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoContrato= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoContratoTipoContrato=true;

	public Boolean getActivarFK_IdTipoContratoTipoContrato() {
		return this.activarFK_IdTipoContratoTipoContrato;
	}

	public void setActivarFK_IdTipoContratoTipoContrato(Boolean habilitarResaltar) {
		this.activarFK_IdTipoContratoTipoContrato= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoContrato=null;

	public Border getResaltarFK_IdEmpresaTipoContrato() {
		return this.resaltarFK_IdEmpresaTipoContrato;
	}

	public void setResaltarFK_IdEmpresaTipoContrato(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoContrato= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoContrato= borderResaltar;
	}

	public Border resaltarFK_IdTipoContratoTipoContrato=null;

	public Border getResaltarFK_IdTipoContratoTipoContrato() {
		return this.resaltarFK_IdTipoContratoTipoContrato;
	}

	public void setResaltarFK_IdTipoContratoTipoContrato(Border borderResaltar) {
		this.resaltarFK_IdTipoContratoTipoContrato= borderResaltar;
	}

	public void setResaltarFK_IdTipoContratoTipoContrato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoContratoBeanSwingJInternalFrame tipocontratoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoContratoTipoContrato= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}