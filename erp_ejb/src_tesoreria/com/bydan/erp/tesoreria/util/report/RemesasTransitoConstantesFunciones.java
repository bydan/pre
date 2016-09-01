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


import com.bydan.erp.tesoreria.util.report.RemesasTransitoConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.RemesasTransitoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.RemesasTransitoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RemesasTransitoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="RemesasTransito";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RemesasTransito"+RemesasTransitoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RemesasTransitoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RemesasTransitoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RemesasTransitoConstantesFunciones.SCHEMA+"_"+RemesasTransitoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RemesasTransitoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RemesasTransitoConstantesFunciones.SCHEMA+"_"+RemesasTransitoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RemesasTransitoConstantesFunciones.SCHEMA+"_"+RemesasTransitoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RemesasTransitoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RemesasTransitoConstantesFunciones.SCHEMA+"_"+RemesasTransitoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RemesasTransitoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RemesasTransitoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RemesasTransitoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RemesasTransitoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RemesasTransitoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RemesasTransitoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RemesasTransitoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RemesasTransitoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RemesasTransitoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RemesasTransitoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Remesas Transitos";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Remesas Transito";
	public static final String SCLASSWEBTITULO_LOWER="Remesas Transito";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RemesasTransito";
	public static final String OBJECTNAME="remesastransito";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="remesas_transito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select remesastransito from "+RemesasTransitoConstantesFunciones.SPERSISTENCENAME+" remesastransito";
	public static String QUERYSELECTNATIVE="select "+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".id,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".version_row,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".id_empresa,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".nombre_banco,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".nombre_girador,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".numero_cuenta,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".numero_cheque,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".valor_monto,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".valor,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".numero_mayor,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".codigo,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".fecha_vencimiento_original,"+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME+".numero_cambio from "+RemesasTransitoConstantesFunciones.SCHEMA+"."+RemesasTransitoConstantesFunciones.TABLENAME;//+" as "+RemesasTransitoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String NOMBREGIRADOR= "nombre_girador";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String VALORMONTO= "valor_monto";
    public static final String VALOR= "valor";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String CODIGO= "codigo";
    public static final String FECHAVENCIMIENTOORIGINAL= "fecha_vencimiento_original";
    public static final String NUMEROCAMBIO= "numero_cambio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_NOMBREGIRADOR= "Nombre Girador";
		public static final String LABEL_NOMBREGIRADOR_LOWER= "Nombre Girador";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_VALORMONTO= "Valor Monto";
		public static final String LABEL_VALORMONTO_LOWER= "Valor Monto";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHAVENCIMIENTOORIGINAL= "Fecha Vencimiento Original";
		public static final String LABEL_FECHAVENCIMIENTOORIGINAL_LOWER= "Fecha Vencimiento Original";
    	public static final String LABEL_NUMEROCAMBIO= "Numero Cambio";
		public static final String LABEL_NUMEROCAMBIO_LOWER= "Numero Cambio";
	
		
		
		
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GIRADOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GIRADOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getRemesasTransitoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.IDEMPRESA)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.NOMBREBANCO)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.NOMBREGIRADOR)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_NOMBREGIRADOR;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.VALORMONTO)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_VALORMONTO;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.VALOR)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.CODIGO)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL;}
		if(sNombreColumna.equals(RemesasTransitoConstantesFunciones.NUMEROCAMBIO)) {sLabelColumna=RemesasTransitoConstantesFunciones.LABEL_NUMEROCAMBIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRemesasTransitoDescripcion(RemesasTransito remesastransito) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(remesastransito !=null/* && remesastransito.getId()!=0*/) {
			sDescripcion=remesastransito.getcodigo();//remesastransitoremesastransito.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRemesasTransitoDescripcionDetallado(RemesasTransito remesastransito) {
		String sDescripcion="";
			
		sDescripcion+=RemesasTransitoConstantesFunciones.ID+"=";
		sDescripcion+=remesastransito.getId().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=remesastransito.getVersionRow().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=remesastransito.getid_empresa().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=remesastransito.getnombre_banco()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.NOMBREGIRADOR+"=";
		sDescripcion+=remesastransito.getnombre_girador()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=remesastransito.getfecha_vencimiento().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=remesastransito.getnumero_cuenta()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=remesastransito.getnumero_cheque()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.VALORMONTO+"=";
		sDescripcion+=remesastransito.getvalor_monto().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.VALOR+"=";
		sDescripcion+=remesastransito.getvalor().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=remesastransito.getnumero_mayor()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.CODIGO+"=";
		sDescripcion+=remesastransito.getcodigo()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL+"=";
		sDescripcion+=remesastransito.getfecha_vencimiento_original().toString()+",";
		sDescripcion+=RemesasTransitoConstantesFunciones.NUMEROCAMBIO+"=";
		sDescripcion+=remesastransito.getnumero_cambio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRemesasTransitoDescripcion(RemesasTransito remesastransito,String sValor) throws Exception {			
		if(remesastransito !=null) {
			remesastransito.setcodigo(sValor);;//remesastransitoremesastransito.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaRemesasTransito")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaRemesasTransito(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" ="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRemesasTransito(RemesasTransito remesastransito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		remesastransito.setnombre_banco(remesastransito.getnombre_banco().trim());
		remesastransito.setnombre_girador(remesastransito.getnombre_girador().trim());
		remesastransito.setnumero_cuenta(remesastransito.getnumero_cuenta().trim());
		remesastransito.setnumero_cheque(remesastransito.getnumero_cheque().trim());
		remesastransito.setnumero_mayor(remesastransito.getnumero_mayor().trim());
		remesastransito.setcodigo(remesastransito.getcodigo().trim());
	}
	
	public static void quitarEspaciosRemesasTransitos(List<RemesasTransito> remesastransitos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RemesasTransito remesastransito: remesastransitos) {
			remesastransito.setnombre_banco(remesastransito.getnombre_banco().trim());
			remesastransito.setnombre_girador(remesastransito.getnombre_girador().trim());
			remesastransito.setnumero_cuenta(remesastransito.getnumero_cuenta().trim());
			remesastransito.setnumero_cheque(remesastransito.getnumero_cheque().trim());
			remesastransito.setnumero_mayor(remesastransito.getnumero_mayor().trim());
			remesastransito.setcodigo(remesastransito.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRemesasTransito(RemesasTransito remesastransito,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && remesastransito.getConCambioAuxiliar()) {
			remesastransito.setIsDeleted(remesastransito.getIsDeletedAuxiliar());	
			remesastransito.setIsNew(remesastransito.getIsNewAuxiliar());	
			remesastransito.setIsChanged(remesastransito.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			remesastransito.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			remesastransito.setIsDeletedAuxiliar(false);	
			remesastransito.setIsNewAuxiliar(false);	
			remesastransito.setIsChangedAuxiliar(false);
			
			remesastransito.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRemesasTransitos(List<RemesasTransito> remesastransitos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RemesasTransito remesastransito : remesastransitos) {
			if(conAsignarBase && remesastransito.getConCambioAuxiliar()) {
				remesastransito.setIsDeleted(remesastransito.getIsDeletedAuxiliar());	
				remesastransito.setIsNew(remesastransito.getIsNewAuxiliar());	
				remesastransito.setIsChanged(remesastransito.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				remesastransito.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				remesastransito.setIsDeletedAuxiliar(false);	
				remesastransito.setIsNewAuxiliar(false);	
				remesastransito.setIsChangedAuxiliar(false);
				
				remesastransito.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRemesasTransito(RemesasTransito remesastransito,Boolean conEnteros) throws Exception  {
		remesastransito.setvalor_monto(0.0);
		remesastransito.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			remesastransito.setnumero_cambio(0);
		}
	}		
	
	public static void InicializarValoresRemesasTransitos(List<RemesasTransito> remesastransitos,Boolean conEnteros) throws Exception  {
		
		for(RemesasTransito remesastransito: remesastransitos) {
			remesastransito.setvalor_monto(0.0);
			remesastransito.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				remesastransito.setnumero_cambio(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaRemesasTransito(List<RemesasTransito> remesastransitos,RemesasTransito remesastransitoAux) throws Exception  {
		RemesasTransitoConstantesFunciones.InicializarValoresRemesasTransito(remesastransitoAux,true);
		
		for(RemesasTransito remesastransito: remesastransitos) {
			if(remesastransito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			remesastransitoAux.setvalor_monto(remesastransitoAux.getvalor_monto()+remesastransito.getvalor_monto());			
			remesastransitoAux.setvalor(remesastransitoAux.getvalor()+remesastransito.getvalor());			
			remesastransitoAux.setnumero_cambio(remesastransitoAux.getnumero_cambio()+remesastransito.getnumero_cambio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRemesasTransito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RemesasTransitoConstantesFunciones.getArrayColumnasGlobalesRemesasTransito(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRemesasTransito(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RemesasTransitoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RemesasTransitoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRemesasTransito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RemesasTransito> remesastransitos,RemesasTransito remesastransito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RemesasTransito remesastransitoAux: remesastransitos) {
			if(remesastransitoAux!=null && remesastransito!=null) {
				if((remesastransitoAux.getId()==null && remesastransito.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(remesastransitoAux.getId()!=null && remesastransito.getId()!=null){
					if(remesastransitoAux.getId().equals(remesastransito.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRemesasTransito(List<RemesasTransito> remesastransitos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_montoTotal=0.0;
		Double valorTotal=0.0;
	
		for(RemesasTransito remesastransito: remesastransitos) {			
			if(remesastransito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_montoTotal+=remesastransito.getvalor_monto();
			valorTotal+=remesastransito.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RemesasTransitoConstantesFunciones.VALORMONTO);
		datoGeneral.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_VALORMONTO);
		datoGeneral.setdValorDouble(valor_montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RemesasTransitoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRemesasTransito() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_ID, RemesasTransitoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_VERSIONROW, RemesasTransitoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_NOMBREBANCO, RemesasTransitoConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_NOMBREGIRADOR, RemesasTransitoConstantesFunciones.NOMBREGIRADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTO, RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_NUMEROCUENTA, RemesasTransitoConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_NUMEROCHEQUE, RemesasTransitoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_VALORMONTO, RemesasTransitoConstantesFunciones.VALORMONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_VALOR, RemesasTransitoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_NUMEROMAYOR, RemesasTransitoConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_CODIGO, RemesasTransitoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL, RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RemesasTransitoConstantesFunciones.LABEL_NUMEROCAMBIO, RemesasTransitoConstantesFunciones.NUMEROCAMBIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRemesasTransito() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.NOMBREGIRADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.VALORMONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RemesasTransitoConstantesFunciones.NUMEROCAMBIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRemesasTransito() throws Exception  {
		return RemesasTransitoConstantesFunciones.getTiposSeleccionarRemesasTransito(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRemesasTransito(Boolean conFk) throws Exception  {
		return RemesasTransitoConstantesFunciones.getTiposSeleccionarRemesasTransito(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRemesasTransito(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_NOMBREGIRADOR);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_NOMBREGIRADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_VALORMONTO);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_VALORMONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RemesasTransitoConstantesFunciones.LABEL_NUMEROCAMBIO);
			reporte.setsDescripcion(RemesasTransitoConstantesFunciones.LABEL_NUMEROCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRemesasTransito(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRemesasTransito(RemesasTransito remesastransitoAux) throws Exception {
		
			remesastransitoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(remesastransitoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRemesasTransito(List<RemesasTransito> remesastransitosTemp) throws Exception {
		for(RemesasTransito remesastransitoAux:remesastransitosTemp) {
			
			remesastransitoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(remesastransitoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRemesasTransito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRemesasTransito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRemesasTransito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RemesasTransitoConstantesFunciones.getClassesRelationshipsOfRemesasTransito(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRemesasTransito(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRemesasTransito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RemesasTransitoConstantesFunciones.getClassesRelationshipsFromStringsOfRemesasTransito(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRemesasTransito(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RemesasTransito remesastransito,List<RemesasTransito> remesastransitos,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(RemesasTransito remesastransito,List<RemesasTransito> remesastransitos) throws Exception {
		try	{			
			for(RemesasTransito remesastransitoLocal:remesastransitos) {
				if(remesastransitoLocal.getId().equals(remesastransito.getId())) {
					remesastransitoLocal.setIsSelected(remesastransito.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRemesasTransito(List<RemesasTransito> remesastransitosAux) throws Exception {
		//this.remesastransitosAux=remesastransitosAux;
		
		for(RemesasTransito remesastransitoAux:remesastransitosAux) {
			if(remesastransitoAux.getIsChanged()) {
				remesastransitoAux.setIsChanged(false);
			}		
			
			if(remesastransitoAux.getIsNew()) {
				remesastransitoAux.setIsNew(false);
			}	
			
			if(remesastransitoAux.getIsDeleted()) {
				remesastransitoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRemesasTransito(RemesasTransito remesastransitoAux) throws Exception {
		//this.remesastransitoAux=remesastransitoAux;
		
			if(remesastransitoAux.getIsChanged()) {
				remesastransitoAux.setIsChanged(false);
			}		
			
			if(remesastransitoAux.getIsNew()) {
				remesastransitoAux.setIsNew(false);
			}	
			
			if(remesastransitoAux.getIsDeleted()) {
				remesastransitoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RemesasTransito remesastransitoAsignar,RemesasTransito remesastransito) throws Exception {
		remesastransitoAsignar.setId(remesastransito.getId());	
		remesastransitoAsignar.setVersionRow(remesastransito.getVersionRow());	
		remesastransitoAsignar.setnombre_banco(remesastransito.getnombre_banco());	
		remesastransitoAsignar.setnombre_girador(remesastransito.getnombre_girador());	
		remesastransitoAsignar.setfecha_vencimiento(remesastransito.getfecha_vencimiento());	
		remesastransitoAsignar.setnumero_cuenta(remesastransito.getnumero_cuenta());	
		remesastransitoAsignar.setnumero_cheque(remesastransito.getnumero_cheque());	
		remesastransitoAsignar.setvalor_monto(remesastransito.getvalor_monto());	
		remesastransitoAsignar.setvalor(remesastransito.getvalor());	
		remesastransitoAsignar.setnumero_mayor(remesastransito.getnumero_mayor());	
		remesastransitoAsignar.setcodigo(remesastransito.getcodigo());	
		remesastransitoAsignar.setfecha_vencimiento_original(remesastransito.getfecha_vencimiento_original());	
		remesastransitoAsignar.setnumero_cambio(remesastransito.getnumero_cambio());	
	}
	
	public static void inicializarRemesasTransito(RemesasTransito remesastransito) throws Exception {
		try {
				remesastransito.setId(0L);	
					
				remesastransito.setnombre_banco("");	
				remesastransito.setnombre_girador("");	
				remesastransito.setfecha_vencimiento(new Date());	
				remesastransito.setnumero_cuenta("");	
				remesastransito.setnumero_cheque("");	
				remesastransito.setvalor_monto(0.0);	
				remesastransito.setvalor(0.0);	
				remesastransito.setnumero_mayor("");	
				remesastransito.setcodigo("");	
				remesastransito.setfecha_vencimiento_original(new Date());	
				remesastransito.setnumero_cambio(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRemesasTransito(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_NOMBREGIRADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_VALORMONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RemesasTransitoConstantesFunciones.LABEL_NUMEROCAMBIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRemesasTransito(String sTipo,Row row,Workbook workbook,RemesasTransito remesastransito,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getnombre_girador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getvalor_monto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getfecha_vencimiento_original());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(remesastransito.getnumero_cambio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRemesasTransito="";
	
	public String getsFinalQueryRemesasTransito() {
		return this.sFinalQueryRemesasTransito;
	}
	
	public void setsFinalQueryRemesasTransito(String sFinalQueryRemesasTransito) {
		this.sFinalQueryRemesasTransito= sFinalQueryRemesasTransito;
	}
	
	public Border resaltarSeleccionarRemesasTransito=null;
	
	public Border setResaltarSeleccionarRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRemesasTransito= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRemesasTransito() {
		return this.resaltarSeleccionarRemesasTransito;
	}
	
	public void setResaltarSeleccionarRemesasTransito(Border borderResaltarSeleccionarRemesasTransito) {
		this.resaltarSeleccionarRemesasTransito= borderResaltarSeleccionarRemesasTransito;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRemesasTransito=null;
	public Boolean mostraridRemesasTransito=true;
	public Boolean activaridRemesasTransito=true;

	public Border resaltarid_empresaRemesasTransito=null;
	public Boolean mostrarid_empresaRemesasTransito=true;
	public Boolean activarid_empresaRemesasTransito=true;
	public Boolean cargarid_empresaRemesasTransito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRemesasTransito=false;//ConEventDepend=true

	public Border resaltarnombre_bancoRemesasTransito=null;
	public Boolean mostrarnombre_bancoRemesasTransito=true;
	public Boolean activarnombre_bancoRemesasTransito=true;

	public Border resaltarnombre_giradorRemesasTransito=null;
	public Boolean mostrarnombre_giradorRemesasTransito=true;
	public Boolean activarnombre_giradorRemesasTransito=true;

	public Border resaltarfecha_vencimientoRemesasTransito=null;
	public Boolean mostrarfecha_vencimientoRemesasTransito=true;
	public Boolean activarfecha_vencimientoRemesasTransito=true;

	public Border resaltarnumero_cuentaRemesasTransito=null;
	public Boolean mostrarnumero_cuentaRemesasTransito=true;
	public Boolean activarnumero_cuentaRemesasTransito=true;

	public Border resaltarnumero_chequeRemesasTransito=null;
	public Boolean mostrarnumero_chequeRemesasTransito=true;
	public Boolean activarnumero_chequeRemesasTransito=true;

	public Border resaltarvalor_montoRemesasTransito=null;
	public Boolean mostrarvalor_montoRemesasTransito=true;
	public Boolean activarvalor_montoRemesasTransito=true;

	public Border resaltarvalorRemesasTransito=null;
	public Boolean mostrarvalorRemesasTransito=true;
	public Boolean activarvalorRemesasTransito=true;

	public Border resaltarnumero_mayorRemesasTransito=null;
	public Boolean mostrarnumero_mayorRemesasTransito=true;
	public Boolean activarnumero_mayorRemesasTransito=true;

	public Border resaltarcodigoRemesasTransito=null;
	public Boolean mostrarcodigoRemesasTransito=true;
	public Boolean activarcodigoRemesasTransito=true;

	public Border resaltarfecha_vencimiento_originalRemesasTransito=null;
	public Boolean mostrarfecha_vencimiento_originalRemesasTransito=true;
	public Boolean activarfecha_vencimiento_originalRemesasTransito=true;

	public Border resaltarnumero_cambioRemesasTransito=null;
	public Boolean mostrarnumero_cambioRemesasTransito=true;
	public Boolean activarnumero_cambioRemesasTransito=true;

	
	

	public Border setResaltaridRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltaridRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRemesasTransito() {
		return this.resaltaridRemesasTransito;
	}

	public void setResaltaridRemesasTransito(Border borderResaltar) {
		this.resaltaridRemesasTransito= borderResaltar;
	}

	public Boolean getMostraridRemesasTransito() {
		return this.mostraridRemesasTransito;
	}

	public void setMostraridRemesasTransito(Boolean mostraridRemesasTransito) {
		this.mostraridRemesasTransito= mostraridRemesasTransito;
	}

	public Boolean getActivaridRemesasTransito() {
		return this.activaridRemesasTransito;
	}

	public void setActivaridRemesasTransito(Boolean activaridRemesasTransito) {
		this.activaridRemesasTransito= activaridRemesasTransito;
	}

	public Border setResaltarid_empresaRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarid_empresaRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRemesasTransito() {
		return this.resaltarid_empresaRemesasTransito;
	}

	public void setResaltarid_empresaRemesasTransito(Border borderResaltar) {
		this.resaltarid_empresaRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarid_empresaRemesasTransito() {
		return this.mostrarid_empresaRemesasTransito;
	}

	public void setMostrarid_empresaRemesasTransito(Boolean mostrarid_empresaRemesasTransito) {
		this.mostrarid_empresaRemesasTransito= mostrarid_empresaRemesasTransito;
	}

	public Boolean getActivarid_empresaRemesasTransito() {
		return this.activarid_empresaRemesasTransito;
	}

	public void setActivarid_empresaRemesasTransito(Boolean activarid_empresaRemesasTransito) {
		this.activarid_empresaRemesasTransito= activarid_empresaRemesasTransito;
	}

	public Boolean getCargarid_empresaRemesasTransito() {
		return this.cargarid_empresaRemesasTransito;
	}

	public void setCargarid_empresaRemesasTransito(Boolean cargarid_empresaRemesasTransito) {
		this.cargarid_empresaRemesasTransito= cargarid_empresaRemesasTransito;
	}

	public Border setResaltarnombre_bancoRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoRemesasTransito() {
		return this.resaltarnombre_bancoRemesasTransito;
	}

	public void setResaltarnombre_bancoRemesasTransito(Border borderResaltar) {
		this.resaltarnombre_bancoRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoRemesasTransito() {
		return this.mostrarnombre_bancoRemesasTransito;
	}

	public void setMostrarnombre_bancoRemesasTransito(Boolean mostrarnombre_bancoRemesasTransito) {
		this.mostrarnombre_bancoRemesasTransito= mostrarnombre_bancoRemesasTransito;
	}

	public Boolean getActivarnombre_bancoRemesasTransito() {
		return this.activarnombre_bancoRemesasTransito;
	}

	public void setActivarnombre_bancoRemesasTransito(Boolean activarnombre_bancoRemesasTransito) {
		this.activarnombre_bancoRemesasTransito= activarnombre_bancoRemesasTransito;
	}

	public Border setResaltarnombre_giradorRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarnombre_giradorRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_giradorRemesasTransito() {
		return this.resaltarnombre_giradorRemesasTransito;
	}

	public void setResaltarnombre_giradorRemesasTransito(Border borderResaltar) {
		this.resaltarnombre_giradorRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarnombre_giradorRemesasTransito() {
		return this.mostrarnombre_giradorRemesasTransito;
	}

	public void setMostrarnombre_giradorRemesasTransito(Boolean mostrarnombre_giradorRemesasTransito) {
		this.mostrarnombre_giradorRemesasTransito= mostrarnombre_giradorRemesasTransito;
	}

	public Boolean getActivarnombre_giradorRemesasTransito() {
		return this.activarnombre_giradorRemesasTransito;
	}

	public void setActivarnombre_giradorRemesasTransito(Boolean activarnombre_giradorRemesasTransito) {
		this.activarnombre_giradorRemesasTransito= activarnombre_giradorRemesasTransito;
	}

	public Border setResaltarfecha_vencimientoRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoRemesasTransito() {
		return this.resaltarfecha_vencimientoRemesasTransito;
	}

	public void setResaltarfecha_vencimientoRemesasTransito(Border borderResaltar) {
		this.resaltarfecha_vencimientoRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoRemesasTransito() {
		return this.mostrarfecha_vencimientoRemesasTransito;
	}

	public void setMostrarfecha_vencimientoRemesasTransito(Boolean mostrarfecha_vencimientoRemesasTransito) {
		this.mostrarfecha_vencimientoRemesasTransito= mostrarfecha_vencimientoRemesasTransito;
	}

	public Boolean getActivarfecha_vencimientoRemesasTransito() {
		return this.activarfecha_vencimientoRemesasTransito;
	}

	public void setActivarfecha_vencimientoRemesasTransito(Boolean activarfecha_vencimientoRemesasTransito) {
		this.activarfecha_vencimientoRemesasTransito= activarfecha_vencimientoRemesasTransito;
	}

	public Border setResaltarnumero_cuentaRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaRemesasTransito() {
		return this.resaltarnumero_cuentaRemesasTransito;
	}

	public void setResaltarnumero_cuentaRemesasTransito(Border borderResaltar) {
		this.resaltarnumero_cuentaRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaRemesasTransito() {
		return this.mostrarnumero_cuentaRemesasTransito;
	}

	public void setMostrarnumero_cuentaRemesasTransito(Boolean mostrarnumero_cuentaRemesasTransito) {
		this.mostrarnumero_cuentaRemesasTransito= mostrarnumero_cuentaRemesasTransito;
	}

	public Boolean getActivarnumero_cuentaRemesasTransito() {
		return this.activarnumero_cuentaRemesasTransito;
	}

	public void setActivarnumero_cuentaRemesasTransito(Boolean activarnumero_cuentaRemesasTransito) {
		this.activarnumero_cuentaRemesasTransito= activarnumero_cuentaRemesasTransito;
	}

	public Border setResaltarnumero_chequeRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeRemesasTransito() {
		return this.resaltarnumero_chequeRemesasTransito;
	}

	public void setResaltarnumero_chequeRemesasTransito(Border borderResaltar) {
		this.resaltarnumero_chequeRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeRemesasTransito() {
		return this.mostrarnumero_chequeRemesasTransito;
	}

	public void setMostrarnumero_chequeRemesasTransito(Boolean mostrarnumero_chequeRemesasTransito) {
		this.mostrarnumero_chequeRemesasTransito= mostrarnumero_chequeRemesasTransito;
	}

	public Boolean getActivarnumero_chequeRemesasTransito() {
		return this.activarnumero_chequeRemesasTransito;
	}

	public void setActivarnumero_chequeRemesasTransito(Boolean activarnumero_chequeRemesasTransito) {
		this.activarnumero_chequeRemesasTransito= activarnumero_chequeRemesasTransito;
	}

	public Border setResaltarvalor_montoRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarvalor_montoRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_montoRemesasTransito() {
		return this.resaltarvalor_montoRemesasTransito;
	}

	public void setResaltarvalor_montoRemesasTransito(Border borderResaltar) {
		this.resaltarvalor_montoRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarvalor_montoRemesasTransito() {
		return this.mostrarvalor_montoRemesasTransito;
	}

	public void setMostrarvalor_montoRemesasTransito(Boolean mostrarvalor_montoRemesasTransito) {
		this.mostrarvalor_montoRemesasTransito= mostrarvalor_montoRemesasTransito;
	}

	public Boolean getActivarvalor_montoRemesasTransito() {
		return this.activarvalor_montoRemesasTransito;
	}

	public void setActivarvalor_montoRemesasTransito(Boolean activarvalor_montoRemesasTransito) {
		this.activarvalor_montoRemesasTransito= activarvalor_montoRemesasTransito;
	}

	public Border setResaltarvalorRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarvalorRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorRemesasTransito() {
		return this.resaltarvalorRemesasTransito;
	}

	public void setResaltarvalorRemesasTransito(Border borderResaltar) {
		this.resaltarvalorRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarvalorRemesasTransito() {
		return this.mostrarvalorRemesasTransito;
	}

	public void setMostrarvalorRemesasTransito(Boolean mostrarvalorRemesasTransito) {
		this.mostrarvalorRemesasTransito= mostrarvalorRemesasTransito;
	}

	public Boolean getActivarvalorRemesasTransito() {
		return this.activarvalorRemesasTransito;
	}

	public void setActivarvalorRemesasTransito(Boolean activarvalorRemesasTransito) {
		this.activarvalorRemesasTransito= activarvalorRemesasTransito;
	}

	public Border setResaltarnumero_mayorRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorRemesasTransito() {
		return this.resaltarnumero_mayorRemesasTransito;
	}

	public void setResaltarnumero_mayorRemesasTransito(Border borderResaltar) {
		this.resaltarnumero_mayorRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorRemesasTransito() {
		return this.mostrarnumero_mayorRemesasTransito;
	}

	public void setMostrarnumero_mayorRemesasTransito(Boolean mostrarnumero_mayorRemesasTransito) {
		this.mostrarnumero_mayorRemesasTransito= mostrarnumero_mayorRemesasTransito;
	}

	public Boolean getActivarnumero_mayorRemesasTransito() {
		return this.activarnumero_mayorRemesasTransito;
	}

	public void setActivarnumero_mayorRemesasTransito(Boolean activarnumero_mayorRemesasTransito) {
		this.activarnumero_mayorRemesasTransito= activarnumero_mayorRemesasTransito;
	}

	public Border setResaltarcodigoRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarcodigoRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoRemesasTransito() {
		return this.resaltarcodigoRemesasTransito;
	}

	public void setResaltarcodigoRemesasTransito(Border borderResaltar) {
		this.resaltarcodigoRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarcodigoRemesasTransito() {
		return this.mostrarcodigoRemesasTransito;
	}

	public void setMostrarcodigoRemesasTransito(Boolean mostrarcodigoRemesasTransito) {
		this.mostrarcodigoRemesasTransito= mostrarcodigoRemesasTransito;
	}

	public Boolean getActivarcodigoRemesasTransito() {
		return this.activarcodigoRemesasTransito;
	}

	public void setActivarcodigoRemesasTransito(Boolean activarcodigoRemesasTransito) {
		this.activarcodigoRemesasTransito= activarcodigoRemesasTransito;
	}

	public Border setResaltarfecha_vencimiento_originalRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_originalRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_originalRemesasTransito() {
		return this.resaltarfecha_vencimiento_originalRemesasTransito;
	}

	public void setResaltarfecha_vencimiento_originalRemesasTransito(Border borderResaltar) {
		this.resaltarfecha_vencimiento_originalRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_originalRemesasTransito() {
		return this.mostrarfecha_vencimiento_originalRemesasTransito;
	}

	public void setMostrarfecha_vencimiento_originalRemesasTransito(Boolean mostrarfecha_vencimiento_originalRemesasTransito) {
		this.mostrarfecha_vencimiento_originalRemesasTransito= mostrarfecha_vencimiento_originalRemesasTransito;
	}

	public Boolean getActivarfecha_vencimiento_originalRemesasTransito() {
		return this.activarfecha_vencimiento_originalRemesasTransito;
	}

	public void setActivarfecha_vencimiento_originalRemesasTransito(Boolean activarfecha_vencimiento_originalRemesasTransito) {
		this.activarfecha_vencimiento_originalRemesasTransito= activarfecha_vencimiento_originalRemesasTransito;
	}

	public Border setResaltarnumero_cambioRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//remesastransitoBeanSwingJInternalFrame.jTtoolBarRemesasTransito.setBorder(borderResaltar);
		
		this.resaltarnumero_cambioRemesasTransito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cambioRemesasTransito() {
		return this.resaltarnumero_cambioRemesasTransito;
	}

	public void setResaltarnumero_cambioRemesasTransito(Border borderResaltar) {
		this.resaltarnumero_cambioRemesasTransito= borderResaltar;
	}

	public Boolean getMostrarnumero_cambioRemesasTransito() {
		return this.mostrarnumero_cambioRemesasTransito;
	}

	public void setMostrarnumero_cambioRemesasTransito(Boolean mostrarnumero_cambioRemesasTransito) {
		this.mostrarnumero_cambioRemesasTransito= mostrarnumero_cambioRemesasTransito;
	}

	public Boolean getActivarnumero_cambioRemesasTransito() {
		return this.activarnumero_cambioRemesasTransito;
	}

	public void setActivarnumero_cambioRemesasTransito(Boolean activarnumero_cambioRemesasTransito) {
		this.activarnumero_cambioRemesasTransito= activarnumero_cambioRemesasTransito;
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
		
		
		this.setMostraridRemesasTransito(esInicial);
		this.setMostrarid_empresaRemesasTransito(esInicial);
		this.setMostrarnombre_bancoRemesasTransito(esInicial);
		this.setMostrarnombre_giradorRemesasTransito(esInicial);
		this.setMostrarfecha_vencimientoRemesasTransito(esInicial);
		this.setMostrarnumero_cuentaRemesasTransito(esInicial);
		this.setMostrarnumero_chequeRemesasTransito(esInicial);
		this.setMostrarvalor_montoRemesasTransito(esInicial);
		this.setMostrarvalorRemesasTransito(esInicial);
		this.setMostrarnumero_mayorRemesasTransito(esInicial);
		this.setMostrarcodigoRemesasTransito(esInicial);
		this.setMostrarfecha_vencimiento_originalRemesasTransito(esInicial);
		this.setMostrarnumero_cambioRemesasTransito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.ID)) {
				this.setMostraridRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NOMBREGIRADOR)) {
				this.setMostrarnombre_giradorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.VALORMONTO)) {
				this.setMostrarvalor_montoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.VALOR)) {
				this.setMostrarvalorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setMostrarfecha_vencimiento_originalRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCAMBIO)) {
				this.setMostrarnumero_cambioRemesasTransito(esAsigna);
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
		
		
		this.setActivaridRemesasTransito(esInicial);
		this.setActivarid_empresaRemesasTransito(esInicial);
		this.setActivarnombre_bancoRemesasTransito(esInicial);
		this.setActivarnombre_giradorRemesasTransito(esInicial);
		this.setActivarfecha_vencimientoRemesasTransito(esInicial);
		this.setActivarnumero_cuentaRemesasTransito(esInicial);
		this.setActivarnumero_chequeRemesasTransito(esInicial);
		this.setActivarvalor_montoRemesasTransito(esInicial);
		this.setActivarvalorRemesasTransito(esInicial);
		this.setActivarnumero_mayorRemesasTransito(esInicial);
		this.setActivarcodigoRemesasTransito(esInicial);
		this.setActivarfecha_vencimiento_originalRemesasTransito(esInicial);
		this.setActivarnumero_cambioRemesasTransito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.ID)) {
				this.setActivaridRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NOMBREGIRADOR)) {
				this.setActivarnombre_giradorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.VALORMONTO)) {
				this.setActivarvalor_montoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.VALOR)) {
				this.setActivarvalorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setActivarfecha_vencimiento_originalRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCAMBIO)) {
				this.setActivarnumero_cambioRemesasTransito(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRemesasTransito(esInicial);
		this.setResaltarid_empresaRemesasTransito(esInicial);
		this.setResaltarnombre_bancoRemesasTransito(esInicial);
		this.setResaltarnombre_giradorRemesasTransito(esInicial);
		this.setResaltarfecha_vencimientoRemesasTransito(esInicial);
		this.setResaltarnumero_cuentaRemesasTransito(esInicial);
		this.setResaltarnumero_chequeRemesasTransito(esInicial);
		this.setResaltarvalor_montoRemesasTransito(esInicial);
		this.setResaltarvalorRemesasTransito(esInicial);
		this.setResaltarnumero_mayorRemesasTransito(esInicial);
		this.setResaltarcodigoRemesasTransito(esInicial);
		this.setResaltarfecha_vencimiento_originalRemesasTransito(esInicial);
		this.setResaltarnumero_cambioRemesasTransito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.ID)) {
				this.setResaltaridRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NOMBREGIRADOR)) {
				this.setResaltarnombre_giradorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.VALORMONTO)) {
				this.setResaltarvalor_montoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.VALOR)) {
				this.setResaltarvalorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setResaltarfecha_vencimiento_originalRemesasTransito(esAsigna);
				continue;
			}

			if(campo.clase.equals(RemesasTransitoConstantesFunciones.NUMEROCAMBIO)) {
				this.setResaltarnumero_cambioRemesasTransito(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaRemesasTransitoRemesasTransito=true;

	public Boolean getMostrarBusquedaRemesasTransitoRemesasTransito() {
		return this.mostrarBusquedaRemesasTransitoRemesasTransito;
	}

	public void setMostrarBusquedaRemesasTransitoRemesasTransito(Boolean visibilidadResaltar) {
		this.mostrarBusquedaRemesasTransitoRemesasTransito= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaRemesasTransitoRemesasTransito=true;

	public Boolean getActivarBusquedaRemesasTransitoRemesasTransito() {
		return this.activarBusquedaRemesasTransitoRemesasTransito;
	}

	public void setActivarBusquedaRemesasTransitoRemesasTransito(Boolean habilitarResaltar) {
		this.activarBusquedaRemesasTransitoRemesasTransito= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaRemesasTransitoRemesasTransito=null;

	public Border getResaltarBusquedaRemesasTransitoRemesasTransito() {
		return this.resaltarBusquedaRemesasTransitoRemesasTransito;
	}

	public void setResaltarBusquedaRemesasTransitoRemesasTransito(Border borderResaltar) {
		this.resaltarBusquedaRemesasTransitoRemesasTransito= borderResaltar;
	}

	public void setResaltarBusquedaRemesasTransitoRemesasTransito(ParametroGeneralUsuario parametroGeneralUsuario/*RemesasTransitoBeanSwingJInternalFrame remesastransitoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaRemesasTransitoRemesasTransito= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}