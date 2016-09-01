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


import com.bydan.erp.facturacion.util.DetalleTerminoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleTerminoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleTerminoProformaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleTerminoProformaConstantesFunciones extends DetalleTerminoProformaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleTerminoProforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleTerminoProforma"+DetalleTerminoProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleTerminoProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleTerminoProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleTerminoProformaConstantesFunciones.SCHEMA+"_"+DetalleTerminoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleTerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleTerminoProformaConstantesFunciones.SCHEMA+"_"+DetalleTerminoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleTerminoProformaConstantesFunciones.SCHEMA+"_"+DetalleTerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleTerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleTerminoProformaConstantesFunciones.SCHEMA+"_"+DetalleTerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleTerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleTerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleTerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleTerminoProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleTerminoProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleTerminoProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleTerminoProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Termino Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Termino Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Termino Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleTerminoProforma";
	public static final String OBJECTNAME="detalleterminoproforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="detalle_termino_proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleterminoproforma from "+DetalleTerminoProformaConstantesFunciones.SPERSISTENCENAME+" detalleterminoproforma";
	public static String QUERYSELECTNATIVE="select "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".version_row,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".id_termino_proforma,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".numero,"+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME+".detalle from "+DetalleTerminoProformaConstantesFunciones.SCHEMA+"."+DetalleTerminoProformaConstantesFunciones.TABLENAME;//+" as "+DetalleTerminoProformaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleTerminoProformaConstantesFuncionesAdditional detalleterminoproformaConstantesFuncionesAdditional=null;
	
	public DetalleTerminoProformaConstantesFuncionesAdditional getDetalleTerminoProformaConstantesFuncionesAdditional() {
		return this.detalleterminoproformaConstantesFuncionesAdditional;
	}
	
	public void setDetalleTerminoProformaConstantesFuncionesAdditional(DetalleTerminoProformaConstantesFuncionesAdditional detalleterminoproformaConstantesFuncionesAdditional) {
		try {
			this.detalleterminoproformaConstantesFuncionesAdditional=detalleterminoproformaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTERMINOPROFORMA= "id_termino_proforma";
    public static final String NUMERO= "numero";
    public static final String DETALLE= "detalle";
	//TITULO CAMPO
    	public static final String LABEL_ID= "id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTERMINOPROFORMA= "Termino Proforma";
		public static final String LABEL_IDTERMINOPROFORMA_LOWER= "Termino Proforma";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
	
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleTerminoProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleTerminoProformaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleTerminoProformaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleTerminoProformaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleTerminoProformaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA)) {sLabelColumna=DetalleTerminoProformaConstantesFunciones.LABEL_IDTERMINOPROFORMA;}
		if(sNombreColumna.equals(DetalleTerminoProformaConstantesFunciones.NUMERO)) {sLabelColumna=DetalleTerminoProformaConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(DetalleTerminoProformaConstantesFunciones.DETALLE)) {sLabelColumna=DetalleTerminoProformaConstantesFunciones.LABEL_DETALLE;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getDetalleTerminoProformaDescripcion(DetalleTerminoProforma detalleterminoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleterminoproforma !=null/* && detalleterminoproforma.getId()!=0*/) {
			if(detalleterminoproforma.getId()!=null) {
				sDescripcion=detalleterminoproforma.getId().toString();
			}//detalleterminoproformadetalleterminoproforma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleTerminoProformaDescripcionDetallado(DetalleTerminoProforma detalleterminoproforma) {
		String sDescripcion="";
			
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.ID+"=";
		sDescripcion+=detalleterminoproforma.getId().toString()+",";
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleterminoproforma.getVersionRow().toString()+",";
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleterminoproforma.getid_empresa().toString()+",";
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleterminoproforma.getid_sucursal().toString()+",";
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA+"=";
		sDescripcion+=detalleterminoproforma.getid_termino_proforma().toString()+",";
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.NUMERO+"=";
		sDescripcion+=detalleterminoproforma.getnumero().toString()+",";
		sDescripcion+=DetalleTerminoProformaConstantesFunciones.DETALLE+"=";
		sDescripcion+=detalleterminoproforma.getdetalle()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleTerminoProformaDescripcion(DetalleTerminoProforma detalleterminoproforma,String sValor) throws Exception {			
		if(detalleterminoproforma !=null) {
			//detalleterminoproformadetalleterminoproforma.getId().toString();
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

	public static String getTerminoProformaDescripcion(TerminoProforma terminoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(terminoproforma!=null/*&&terminoproforma.getId()>0*/) {
			sDescripcion=TerminoProformaConstantesFunciones.getTerminoProformaDescripcion(terminoproforma);
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTerminoProforma")) {
			sNombreIndice="Tipo=  Por Termino Proforma";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTerminoProforma(Long id_termino_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_termino_proforma!=null) {sDetalleIndice+=" Codigo Unico De Termino Proforma="+id_termino_proforma.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleterminoproforma.setdetalle(detalleterminoproforma.getdetalle().trim());
	}
	
	public static void quitarEspaciosDetalleTerminoProformas(List<DetalleTerminoProforma> detalleterminoproformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleTerminoProforma detalleterminoproforma: detalleterminoproformas) {
			detalleterminoproforma.setdetalle(detalleterminoproforma.getdetalle().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleterminoproforma.getConCambioAuxiliar()) {
			detalleterminoproforma.setIsDeleted(detalleterminoproforma.getIsDeletedAuxiliar());	
			detalleterminoproforma.setIsNew(detalleterminoproforma.getIsNewAuxiliar());	
			detalleterminoproforma.setIsChanged(detalleterminoproforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleterminoproforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleterminoproforma.setIsDeletedAuxiliar(false);	
			detalleterminoproforma.setIsNewAuxiliar(false);	
			detalleterminoproforma.setIsChangedAuxiliar(false);
			
			detalleterminoproforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleTerminoProformas(List<DetalleTerminoProforma> detalleterminoproformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleTerminoProforma detalleterminoproforma : detalleterminoproformas) {
			if(conAsignarBase && detalleterminoproforma.getConCambioAuxiliar()) {
				detalleterminoproforma.setIsDeleted(detalleterminoproforma.getIsDeletedAuxiliar());	
				detalleterminoproforma.setIsNew(detalleterminoproforma.getIsNewAuxiliar());	
				detalleterminoproforma.setIsChanged(detalleterminoproforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleterminoproforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleterminoproforma.setIsDeletedAuxiliar(false);	
				detalleterminoproforma.setIsNewAuxiliar(false);	
				detalleterminoproforma.setIsChangedAuxiliar(false);
				
				detalleterminoproforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproforma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			detalleterminoproforma.setnumero(0);
		}
	}		
	
	public static void InicializarValoresDetalleTerminoProformas(List<DetalleTerminoProforma> detalleterminoproformas,Boolean conEnteros) throws Exception  {
		
		for(DetalleTerminoProforma detalleterminoproforma: detalleterminoproformas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				detalleterminoproforma.setnumero(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleTerminoProforma(List<DetalleTerminoProforma> detalleterminoproformas,DetalleTerminoProforma detalleterminoproformaAux) throws Exception  {
		DetalleTerminoProformaConstantesFunciones.InicializarValoresDetalleTerminoProforma(detalleterminoproformaAux,true);
		
		for(DetalleTerminoProforma detalleterminoproforma: detalleterminoproformas) {
			if(detalleterminoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleterminoproformaAux.setnumero(detalleterminoproformaAux.getnumero()+detalleterminoproforma.getnumero());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleTerminoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleTerminoProformaConstantesFunciones.getArrayColumnasGlobalesDetalleTerminoProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleTerminoProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTerminoProformaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTerminoProformaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleTerminoProformaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleTerminoProformaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleTerminoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleTerminoProforma> detalleterminoproformas,DetalleTerminoProforma detalleterminoproforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleTerminoProforma detalleterminoproformaAux: detalleterminoproformas) {
			if(detalleterminoproformaAux!=null && detalleterminoproforma!=null) {
				if((detalleterminoproformaAux.getId()==null && detalleterminoproforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleterminoproformaAux.getId()!=null && detalleterminoproforma.getId()!=null){
					if(detalleterminoproformaAux.getId().equals(detalleterminoproforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleTerminoProforma(List<DetalleTerminoProforma> detalleterminoproformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleTerminoProforma detalleterminoproforma: detalleterminoproformas) {			
			if(detalleterminoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleTerminoProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_ID, DetalleTerminoProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_VERSIONROW, DetalleTerminoProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_IDEMPRESA, DetalleTerminoProformaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_IDSUCURSAL, DetalleTerminoProformaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_IDTERMINOPROFORMA, DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_NUMERO, DetalleTerminoProformaConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleTerminoProformaConstantesFunciones.LABEL_DETALLE, DetalleTerminoProformaConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleTerminoProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleTerminoProformaConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTerminoProforma() throws Exception  {
		return DetalleTerminoProformaConstantesFunciones.getTiposSeleccionarDetalleTerminoProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTerminoProforma(Boolean conFk) throws Exception  {
		return DetalleTerminoProformaConstantesFunciones.getTiposSeleccionarDetalleTerminoProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleTerminoProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTerminoProformaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleTerminoProformaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTerminoProformaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleTerminoProformaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTerminoProformaConstantesFunciones.LABEL_IDTERMINOPROFORMA);
			reporte.setsDescripcion(DetalleTerminoProformaConstantesFunciones.LABEL_IDTERMINOPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTerminoProformaConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(DetalleTerminoProformaConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleTerminoProformaConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(DetalleTerminoProformaConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleTerminoProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproformaAux) throws Exception {
		
			detalleterminoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleterminoproformaAux.getEmpresa()));
			detalleterminoproformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleterminoproformaAux.getSucursal()));
			detalleterminoproformaAux.setterminoproforma_descripcion(TerminoProformaConstantesFunciones.getTerminoProformaDescripcion(detalleterminoproformaAux.getTerminoProforma()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleTerminoProforma(List<DetalleTerminoProforma> detalleterminoproformasTemp) throws Exception {
		for(DetalleTerminoProforma detalleterminoproformaAux:detalleterminoproformasTemp) {
			
			detalleterminoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleterminoproformaAux.getEmpresa()));
			detalleterminoproformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleterminoproformaAux.getSucursal()));
			detalleterminoproformaAux.setterminoproforma_descripcion(TerminoProformaConstantesFunciones.getTerminoProformaDescripcion(detalleterminoproformaAux.getTerminoProforma()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TerminoProforma.class));
				
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
					if(clas.clas.equals(TerminoProforma.class)) {
						classes.add(new Classe(TerminoProforma.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleTerminoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TerminoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TerminoProforma.class)); continue;
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

					if(TerminoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TerminoProforma.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleTerminoProformaConstantesFunciones.getClassesRelationshipsOfDetalleTerminoProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleTerminoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleTerminoProformaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleTerminoProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleTerminoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleTerminoProforma detalleterminoproforma,List<DetalleTerminoProforma> detalleterminoproformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleTerminoProforma detalleterminoproformaEncontrado=null;
			
			for(DetalleTerminoProforma detalleterminoproformaLocal:detalleterminoproformas) {
				if(detalleterminoproformaLocal.getId().equals(detalleterminoproforma.getId())) {
					detalleterminoproformaEncontrado=detalleterminoproformaLocal;
					
					detalleterminoproformaLocal.setIsChanged(detalleterminoproforma.getIsChanged());
					detalleterminoproformaLocal.setIsNew(detalleterminoproforma.getIsNew());
					detalleterminoproformaLocal.setIsDeleted(detalleterminoproforma.getIsDeleted());
					
					detalleterminoproformaLocal.setGeneralEntityOriginal(detalleterminoproforma.getGeneralEntityOriginal());
					
					detalleterminoproformaLocal.setId(detalleterminoproforma.getId());	
					detalleterminoproformaLocal.setVersionRow(detalleterminoproforma.getVersionRow());	
					detalleterminoproformaLocal.setid_empresa(detalleterminoproforma.getid_empresa());	
					detalleterminoproformaLocal.setid_sucursal(detalleterminoproforma.getid_sucursal());	
					detalleterminoproformaLocal.setid_termino_proforma(detalleterminoproforma.getid_termino_proforma());	
					detalleterminoproformaLocal.setnumero(detalleterminoproforma.getnumero());	
					detalleterminoproformaLocal.setdetalle(detalleterminoproforma.getdetalle());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleterminoproforma.getIsDeleted()) {
				if(!existe) {
					detalleterminoproformas.add(detalleterminoproforma);
				}
			} else {
				if(detalleterminoproformaEncontrado!=null && permiteQuitar)  {
					detalleterminoproformas.remove(detalleterminoproformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleTerminoProforma detalleterminoproforma,List<DetalleTerminoProforma> detalleterminoproformas) throws Exception {
		try	{			
			for(DetalleTerminoProforma detalleterminoproformaLocal:detalleterminoproformas) {
				if(detalleterminoproformaLocal.getId().equals(detalleterminoproforma.getId())) {
					detalleterminoproformaLocal.setIsSelected(detalleterminoproforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleTerminoProforma(List<DetalleTerminoProforma> detalleterminoproformasAux) throws Exception {
		//this.detalleterminoproformasAux=detalleterminoproformasAux;
		
		for(DetalleTerminoProforma detalleterminoproformaAux:detalleterminoproformasAux) {
			if(detalleterminoproformaAux.getIsChanged()) {
				detalleterminoproformaAux.setIsChanged(false);
			}		
			
			if(detalleterminoproformaAux.getIsNew()) {
				detalleterminoproformaAux.setIsNew(false);
			}	
			
			if(detalleterminoproformaAux.getIsDeleted()) {
				detalleterminoproformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproformaAux) throws Exception {
		//this.detalleterminoproformaAux=detalleterminoproformaAux;
		
			if(detalleterminoproformaAux.getIsChanged()) {
				detalleterminoproformaAux.setIsChanged(false);
			}		
			
			if(detalleterminoproformaAux.getIsNew()) {
				detalleterminoproformaAux.setIsNew(false);
			}	
			
			if(detalleterminoproformaAux.getIsDeleted()) {
				detalleterminoproformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleTerminoProforma detalleterminoproformaAsignar,DetalleTerminoProforma detalleterminoproforma) throws Exception {
		detalleterminoproformaAsignar.setId(detalleterminoproforma.getId());	
		detalleterminoproformaAsignar.setVersionRow(detalleterminoproforma.getVersionRow());	
		detalleterminoproformaAsignar.setid_empresa(detalleterminoproforma.getid_empresa());
		detalleterminoproformaAsignar.setempresa_descripcion(detalleterminoproforma.getempresa_descripcion());	
		detalleterminoproformaAsignar.setid_sucursal(detalleterminoproforma.getid_sucursal());
		detalleterminoproformaAsignar.setsucursal_descripcion(detalleterminoproforma.getsucursal_descripcion());	
		detalleterminoproformaAsignar.setid_termino_proforma(detalleterminoproforma.getid_termino_proforma());
		detalleterminoproformaAsignar.setterminoproforma_descripcion(detalleterminoproforma.getterminoproforma_descripcion());	
		detalleterminoproformaAsignar.setnumero(detalleterminoproforma.getnumero());	
		detalleterminoproformaAsignar.setdetalle(detalleterminoproforma.getdetalle());	
	}
	
	public static void inicializarDetalleTerminoProforma(DetalleTerminoProforma detalleterminoproforma) throws Exception {
		try {
				detalleterminoproforma.setId(0L);	
					
				detalleterminoproforma.setid_empresa(-1L);	
				detalleterminoproforma.setid_sucursal(-1L);	
				detalleterminoproforma.setid_termino_proforma(-1L);	
				detalleterminoproforma.setnumero(0);	
				detalleterminoproforma.setdetalle("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleTerminoProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTerminoProformaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTerminoProformaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTerminoProformaConstantesFunciones.LABEL_IDTERMINOPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTerminoProformaConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleTerminoProformaConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleTerminoProforma(String sTipo,Row row,Workbook workbook,DetalleTerminoProforma detalleterminoproforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleterminoproforma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleterminoproforma.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleterminoproforma.getterminoproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleterminoproforma.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleterminoproforma.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleTerminoProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleTerminoProforma() {
		return this.sFinalQueryDetalleTerminoProforma;
	}
	
	public void setsFinalQueryDetalleTerminoProforma(String sFinalQueryDetalleTerminoProforma) {
		this.sFinalQueryDetalleTerminoProforma= sFinalQueryDetalleTerminoProforma;
	}
	
	public Border resaltarSeleccionarDetalleTerminoProforma=null;
	
	public Border setResaltarSeleccionarDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleTerminoProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleTerminoProforma() {
		return this.resaltarSeleccionarDetalleTerminoProforma;
	}
	
	public void setResaltarSeleccionarDetalleTerminoProforma(Border borderResaltarSeleccionarDetalleTerminoProforma) {
		this.resaltarSeleccionarDetalleTerminoProforma= borderResaltarSeleccionarDetalleTerminoProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleTerminoProforma=null;
	public Boolean mostraridDetalleTerminoProforma=true;
	public Boolean activaridDetalleTerminoProforma=true;

	public Border resaltarid_empresaDetalleTerminoProforma=null;
	public Boolean mostrarid_empresaDetalleTerminoProforma=true;
	public Boolean activarid_empresaDetalleTerminoProforma=true;
	public Boolean cargarid_empresaDetalleTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleTerminoProforma=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleTerminoProforma=null;
	public Boolean mostrarid_sucursalDetalleTerminoProforma=true;
	public Boolean activarid_sucursalDetalleTerminoProforma=true;
	public Boolean cargarid_sucursalDetalleTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleTerminoProforma=false;//ConEventDepend=true

	public Border resaltarid_termino_proformaDetalleTerminoProforma=null;
	public Boolean mostrarid_termino_proformaDetalleTerminoProforma=true;
	public Boolean activarid_termino_proformaDetalleTerminoProforma=true;
	public Boolean cargarid_termino_proformaDetalleTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_termino_proformaDetalleTerminoProforma=false;//ConEventDepend=true

	public Border resaltarnumeroDetalleTerminoProforma=null;
	public Boolean mostrarnumeroDetalleTerminoProforma=true;
	public Boolean activarnumeroDetalleTerminoProforma=true;

	public Border resaltardetalleDetalleTerminoProforma=null;
	public Boolean mostrardetalleDetalleTerminoProforma=true;
	public Boolean activardetalleDetalleTerminoProforma=true;

	
	

	public Border setResaltaridDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltaridDetalleTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleTerminoProforma() {
		return this.resaltaridDetalleTerminoProforma;
	}

	public void setResaltaridDetalleTerminoProforma(Border borderResaltar) {
		this.resaltaridDetalleTerminoProforma= borderResaltar;
	}

	public Boolean getMostraridDetalleTerminoProforma() {
		return this.mostraridDetalleTerminoProforma;
	}

	public void setMostraridDetalleTerminoProforma(Boolean mostraridDetalleTerminoProforma) {
		this.mostraridDetalleTerminoProforma= mostraridDetalleTerminoProforma;
	}

	public Boolean getActivaridDetalleTerminoProforma() {
		return this.activaridDetalleTerminoProforma;
	}

	public void setActivaridDetalleTerminoProforma(Boolean activaridDetalleTerminoProforma) {
		this.activaridDetalleTerminoProforma= activaridDetalleTerminoProforma;
	}

	public Border setResaltarid_empresaDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleTerminoProforma() {
		return this.resaltarid_empresaDetalleTerminoProforma;
	}

	public void setResaltarid_empresaDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarid_empresaDetalleTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleTerminoProforma() {
		return this.mostrarid_empresaDetalleTerminoProforma;
	}

	public void setMostrarid_empresaDetalleTerminoProforma(Boolean mostrarid_empresaDetalleTerminoProforma) {
		this.mostrarid_empresaDetalleTerminoProforma= mostrarid_empresaDetalleTerminoProforma;
	}

	public Boolean getActivarid_empresaDetalleTerminoProforma() {
		return this.activarid_empresaDetalleTerminoProforma;
	}

	public void setActivarid_empresaDetalleTerminoProforma(Boolean activarid_empresaDetalleTerminoProforma) {
		this.activarid_empresaDetalleTerminoProforma= activarid_empresaDetalleTerminoProforma;
	}

	public Boolean getCargarid_empresaDetalleTerminoProforma() {
		return this.cargarid_empresaDetalleTerminoProforma;
	}

	public void setCargarid_empresaDetalleTerminoProforma(Boolean cargarid_empresaDetalleTerminoProforma) {
		this.cargarid_empresaDetalleTerminoProforma= cargarid_empresaDetalleTerminoProforma;
	}

	public Border setResaltarid_sucursalDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleTerminoProforma() {
		return this.resaltarid_sucursalDetalleTerminoProforma;
	}

	public void setResaltarid_sucursalDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarid_sucursalDetalleTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleTerminoProforma() {
		return this.mostrarid_sucursalDetalleTerminoProforma;
	}

	public void setMostrarid_sucursalDetalleTerminoProforma(Boolean mostrarid_sucursalDetalleTerminoProforma) {
		this.mostrarid_sucursalDetalleTerminoProforma= mostrarid_sucursalDetalleTerminoProforma;
	}

	public Boolean getActivarid_sucursalDetalleTerminoProforma() {
		return this.activarid_sucursalDetalleTerminoProforma;
	}

	public void setActivarid_sucursalDetalleTerminoProforma(Boolean activarid_sucursalDetalleTerminoProforma) {
		this.activarid_sucursalDetalleTerminoProforma= activarid_sucursalDetalleTerminoProforma;
	}

	public Boolean getCargarid_sucursalDetalleTerminoProforma() {
		return this.cargarid_sucursalDetalleTerminoProforma;
	}

	public void setCargarid_sucursalDetalleTerminoProforma(Boolean cargarid_sucursalDetalleTerminoProforma) {
		this.cargarid_sucursalDetalleTerminoProforma= cargarid_sucursalDetalleTerminoProforma;
	}

	public Border setResaltarid_termino_proformaDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_termino_proformaDetalleTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_termino_proformaDetalleTerminoProforma() {
		return this.resaltarid_termino_proformaDetalleTerminoProforma;
	}

	public void setResaltarid_termino_proformaDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarid_termino_proformaDetalleTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_termino_proformaDetalleTerminoProforma() {
		return this.mostrarid_termino_proformaDetalleTerminoProforma;
	}

	public void setMostrarid_termino_proformaDetalleTerminoProforma(Boolean mostrarid_termino_proformaDetalleTerminoProforma) {
		this.mostrarid_termino_proformaDetalleTerminoProforma= mostrarid_termino_proformaDetalleTerminoProforma;
	}

	public Boolean getActivarid_termino_proformaDetalleTerminoProforma() {
		return this.activarid_termino_proformaDetalleTerminoProforma;
	}

	public void setActivarid_termino_proformaDetalleTerminoProforma(Boolean activarid_termino_proformaDetalleTerminoProforma) {
		this.activarid_termino_proformaDetalleTerminoProforma= activarid_termino_proformaDetalleTerminoProforma;
	}

	public Boolean getCargarid_termino_proformaDetalleTerminoProforma() {
		return this.cargarid_termino_proformaDetalleTerminoProforma;
	}

	public void setCargarid_termino_proformaDetalleTerminoProforma(Boolean cargarid_termino_proformaDetalleTerminoProforma) {
		this.cargarid_termino_proformaDetalleTerminoProforma= cargarid_termino_proformaDetalleTerminoProforma;
	}

	public Border setResaltarnumeroDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarnumeroDetalleTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroDetalleTerminoProforma() {
		return this.resaltarnumeroDetalleTerminoProforma;
	}

	public void setResaltarnumeroDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarnumeroDetalleTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarnumeroDetalleTerminoProforma() {
		return this.mostrarnumeroDetalleTerminoProforma;
	}

	public void setMostrarnumeroDetalleTerminoProforma(Boolean mostrarnumeroDetalleTerminoProforma) {
		this.mostrarnumeroDetalleTerminoProforma= mostrarnumeroDetalleTerminoProforma;
	}

	public Boolean getActivarnumeroDetalleTerminoProforma() {
		return this.activarnumeroDetalleTerminoProforma;
	}

	public void setActivarnumeroDetalleTerminoProforma(Boolean activarnumeroDetalleTerminoProforma) {
		this.activarnumeroDetalleTerminoProforma= activarnumeroDetalleTerminoProforma;
	}

	public Border setResaltardetalleDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleterminoproformaBeanSwingJInternalFrame.jTtoolBarDetalleTerminoProforma.setBorder(borderResaltar);
		
		this.resaltardetalleDetalleTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleDetalleTerminoProforma() {
		return this.resaltardetalleDetalleTerminoProforma;
	}

	public void setResaltardetalleDetalleTerminoProforma(Border borderResaltar) {
		this.resaltardetalleDetalleTerminoProforma= borderResaltar;
	}

	public Boolean getMostrardetalleDetalleTerminoProforma() {
		return this.mostrardetalleDetalleTerminoProforma;
	}

	public void setMostrardetalleDetalleTerminoProforma(Boolean mostrardetalleDetalleTerminoProforma) {
		this.mostrardetalleDetalleTerminoProforma= mostrardetalleDetalleTerminoProforma;
	}

	public Boolean getActivardetalleDetalleTerminoProforma() {
		return this.activardetalleDetalleTerminoProforma;
	}

	public void setActivardetalleDetalleTerminoProforma(Boolean activardetalleDetalleTerminoProforma) {
		this.activardetalleDetalleTerminoProforma= activardetalleDetalleTerminoProforma;
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
		
		
		this.setMostraridDetalleTerminoProforma(esInicial);
		this.setMostrarid_empresaDetalleTerminoProforma(esInicial);
		this.setMostrarid_sucursalDetalleTerminoProforma(esInicial);
		this.setMostrarid_termino_proformaDetalleTerminoProforma(esInicial);
		this.setMostrarnumeroDetalleTerminoProforma(esInicial);
		this.setMostrardetalleDetalleTerminoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.ID)) {
				this.setMostraridDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA)) {
				this.setMostrarid_termino_proformaDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.DETALLE)) {
				this.setMostrardetalleDetalleTerminoProforma(esAsigna);
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
		
		
		this.setActivaridDetalleTerminoProforma(esInicial);
		this.setActivarid_empresaDetalleTerminoProforma(esInicial);
		this.setActivarid_sucursalDetalleTerminoProforma(esInicial);
		this.setActivarid_termino_proformaDetalleTerminoProforma(esInicial);
		this.setActivarnumeroDetalleTerminoProforma(esInicial);
		this.setActivardetalleDetalleTerminoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.ID)) {
				this.setActivaridDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA)) {
				this.setActivarid_termino_proformaDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.NUMERO)) {
				this.setActivarnumeroDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.DETALLE)) {
				this.setActivardetalleDetalleTerminoProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleTerminoProforma(esInicial);
		this.setResaltarid_empresaDetalleTerminoProforma(esInicial);
		this.setResaltarid_sucursalDetalleTerminoProforma(esInicial);
		this.setResaltarid_termino_proformaDetalleTerminoProforma(esInicial);
		this.setResaltarnumeroDetalleTerminoProforma(esInicial);
		this.setResaltardetalleDetalleTerminoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.ID)) {
				this.setResaltaridDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.IDTERMINOPROFORMA)) {
				this.setResaltarid_termino_proformaDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroDetalleTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleTerminoProformaConstantesFunciones.DETALLE)) {
				this.setResaltardetalleDetalleTerminoProforma(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaDetalleTerminoProforma=true;

	public Boolean getMostrarFK_IdEmpresaDetalleTerminoProforma() {
		return this.mostrarFK_IdEmpresaDetalleTerminoProforma;
	}

	public void setMostrarFK_IdEmpresaDetalleTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleTerminoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleTerminoProforma=true;

	public Boolean getMostrarFK_IdSucursalDetalleTerminoProforma() {
		return this.mostrarFK_IdSucursalDetalleTerminoProforma;
	}

	public void setMostrarFK_IdSucursalDetalleTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleTerminoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTerminoProformaDetalleTerminoProforma=true;

	public Boolean getMostrarFK_IdTerminoProformaDetalleTerminoProforma() {
		return this.mostrarFK_IdTerminoProformaDetalleTerminoProforma;
	}

	public void setMostrarFK_IdTerminoProformaDetalleTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTerminoProformaDetalleTerminoProforma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaDetalleTerminoProforma=true;

	public Boolean getActivarFK_IdEmpresaDetalleTerminoProforma() {
		return this.activarFK_IdEmpresaDetalleTerminoProforma;
	}

	public void setActivarFK_IdEmpresaDetalleTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleTerminoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleTerminoProforma=true;

	public Boolean getActivarFK_IdSucursalDetalleTerminoProforma() {
		return this.activarFK_IdSucursalDetalleTerminoProforma;
	}

	public void setActivarFK_IdSucursalDetalleTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleTerminoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdTerminoProformaDetalleTerminoProforma=true;

	public Boolean getActivarFK_IdTerminoProformaDetalleTerminoProforma() {
		return this.activarFK_IdTerminoProformaDetalleTerminoProforma;
	}

	public void setActivarFK_IdTerminoProformaDetalleTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdTerminoProformaDetalleTerminoProforma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaDetalleTerminoProforma=null;

	public Border getResaltarFK_IdEmpresaDetalleTerminoProforma() {
		return this.resaltarFK_IdEmpresaDetalleTerminoProforma;
	}

	public void setResaltarFK_IdEmpresaDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleTerminoProforma= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleTerminoProforma=null;

	public Border getResaltarFK_IdSucursalDetalleTerminoProforma() {
		return this.resaltarFK_IdSucursalDetalleTerminoProforma;
	}

	public void setResaltarFK_IdSucursalDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleTerminoProforma= borderResaltar;
	}

	public Border resaltarFK_IdTerminoProformaDetalleTerminoProforma=null;

	public Border getResaltarFK_IdTerminoProformaDetalleTerminoProforma() {
		return this.resaltarFK_IdTerminoProformaDetalleTerminoProforma;
	}

	public void setResaltarFK_IdTerminoProformaDetalleTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdTerminoProformaDetalleTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdTerminoProformaDetalleTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleTerminoProformaBeanSwingJInternalFrame detalleterminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTerminoProformaDetalleTerminoProforma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}