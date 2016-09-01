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


import com.bydan.erp.facturacion.util.TerminoProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.TerminoProformaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TerminoProformaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TerminoProformaConstantesFunciones extends TerminoProformaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TerminoProforma";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TerminoProforma"+TerminoProformaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TerminoProformaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TerminoProformaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TerminoProformaConstantesFunciones.SCHEMA+"_"+TerminoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TerminoProformaConstantesFunciones.SCHEMA+"_"+TerminoProformaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TerminoProformaConstantesFunciones.SCHEMA+"_"+TerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TerminoProformaConstantesFunciones.SCHEMA+"_"+TerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TerminoProformaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TerminoProformaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TerminoProformaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TerminoProformaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TerminoProformaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TerminoProformaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Termino Proformas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Termino Proforma";
	public static final String SCLASSWEBTITULO_LOWER="Termino Proforma";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TerminoProforma";
	public static final String OBJECTNAME="terminoproforma";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="termino_proforma";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select terminoproforma from "+TerminoProformaConstantesFunciones.SPERSISTENCENAME+" terminoproforma";
	public static String QUERYSELECTNATIVE="select "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".version_row,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_empresa,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_sucursal,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_moneda,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".id_proforma,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".atencion,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".registro_sanitario,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".referencia,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".descripcion,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".descripcion2,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".marca,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".origen,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".garantia_tecnica,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".fecha_pago,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".fecha_entrega,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".adjunto,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".responsable,"+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME+".cargo from "+TerminoProformaConstantesFunciones.SCHEMA+"."+TerminoProformaConstantesFunciones.TABLENAME;//+" as "+TerminoProformaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected TerminoProformaConstantesFuncionesAdditional terminoproformaConstantesFuncionesAdditional=null;
	
	public TerminoProformaConstantesFuncionesAdditional getTerminoProformaConstantesFuncionesAdditional() {
		return this.terminoproformaConstantesFuncionesAdditional;
	}
	
	public void setTerminoProformaConstantesFuncionesAdditional(TerminoProformaConstantesFuncionesAdditional terminoproformaConstantesFuncionesAdditional) {
		try {
			this.terminoproformaConstantesFuncionesAdditional=terminoproformaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDPROFORMA= "id_proforma";
    public static final String ATENCION= "atencion";
    public static final String REGISTROSANITARIO= "registro_sanitario";
    public static final String REFERENCIA= "referencia";
    public static final String DESCRIPCION= "descripcion";
    public static final String DESCRIPCION2= "descripcion2";
    public static final String MARCA= "marca";
    public static final String ORIGEN= "origen";
    public static final String GARANTIATECNICA= "garantia_tecnica";
    public static final String FECHAPAGO= "fecha_pago";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String ADJUNTO= "adjunto";
    public static final String RESPONSABLE= "responsable";
    public static final String CARGO= "cargo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDPROFORMA= "Proforma";
		public static final String LABEL_IDPROFORMA_LOWER= "Proforma";
    	public static final String LABEL_ATENCION= "Atencion";
		public static final String LABEL_ATENCION_LOWER= "Atencion";
    	public static final String LABEL_REGISTROSANITARIO= "Registro Sanitario";
		public static final String LABEL_REGISTROSANITARIO_LOWER= "Registro Sanitario";
    	public static final String LABEL_REFERENCIA= "Referencia";
		public static final String LABEL_REFERENCIA_LOWER= "Referencia";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_DESCRIPCION2= "Descripcion2";
		public static final String LABEL_DESCRIPCION2_LOWER= "Descripcion2";
    	public static final String LABEL_MARCA= "Marca";
		public static final String LABEL_MARCA_LOWER= "Marca";
    	public static final String LABEL_ORIGEN= "Origen";
		public static final String LABEL_ORIGEN_LOWER= "Origen";
    	public static final String LABEL_GARANTIATECNICA= "Garantia Tecnica";
		public static final String LABEL_GARANTIATECNICA_LOWER= "Garantia Tecnica";
    	public static final String LABEL_FECHAPAGO= "Fecha Pago";
		public static final String LABEL_FECHAPAGO_LOWER= "Fecha Pago";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_ADJUNTO= "Adjunto";
		public static final String LABEL_ADJUNTO_LOWER= "Adjunto";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_CARGO= "Cargo";
		public static final String LABEL_CARGO_LOWER= "Cargo";
	
		
		
		
		
		
		
	public static final String SREGEXATENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXATENCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREGISTRO_SANITARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREGISTRO_SANITARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREFERENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREFERENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION2=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXORIGEN=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXORIGEN=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXGARANTIA_TECNICA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXGARANTIA_TECNICA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFECHA_PAGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFECHA_PAGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFECHA_ENTREGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFECHA_ENTREGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXADJUNTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXADJUNTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCARGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCARGO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTerminoProformaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.IDMONEDA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.IDPROFORMA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_IDPROFORMA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.ATENCION)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_ATENCION;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.REGISTROSANITARIO)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_REGISTROSANITARIO;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.REFERENCIA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_REFERENCIA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.DESCRIPCION2)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_DESCRIPCION2;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.MARCA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_MARCA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.ORIGEN)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_ORIGEN;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.GARANTIATECNICA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_GARANTIATECNICA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.FECHAPAGO)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_FECHAPAGO;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.FECHAENTREGA)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.ADJUNTO)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_ADJUNTO;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.RESPONSABLE)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(TerminoProformaConstantesFunciones.CARGO)) {sLabelColumna=TerminoProformaConstantesFunciones.LABEL_CARGO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTerminoProformaDescripcion(TerminoProforma terminoproforma) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(terminoproforma !=null/* && terminoproforma.getId()!=0*/) {
			if(terminoproforma.getId()!=null) {
				sDescripcion=terminoproforma.getId().toString();
			}//terminoproformaterminoproforma.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTerminoProformaDescripcionDetallado(TerminoProforma terminoproforma) {
		String sDescripcion="";
			
		sDescripcion+=TerminoProformaConstantesFunciones.ID+"=";
		sDescripcion+=terminoproforma.getId().toString()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=terminoproforma.getVersionRow().toString()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=terminoproforma.getid_empresa().toString()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=terminoproforma.getid_sucursal().toString()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=terminoproforma.getid_moneda().toString()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.IDPROFORMA+"=";
		sDescripcion+=terminoproforma.getid_proforma().toString()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.ATENCION+"=";
		sDescripcion+=terminoproforma.getatencion()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.REGISTROSANITARIO+"=";
		sDescripcion+=terminoproforma.getregistro_sanitario()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.REFERENCIA+"=";
		sDescripcion+=terminoproforma.getreferencia()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=terminoproforma.getdescripcion()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.DESCRIPCION2+"=";
		sDescripcion+=terminoproforma.getdescripcion2()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.MARCA+"=";
		sDescripcion+=terminoproforma.getmarca()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.ORIGEN+"=";
		sDescripcion+=terminoproforma.getorigen()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.GARANTIATECNICA+"=";
		sDescripcion+=terminoproforma.getgarantia_tecnica()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.FECHAPAGO+"=";
		sDescripcion+=terminoproforma.getfecha_pago()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=terminoproforma.getfecha_entrega()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.ADJUNTO+"=";
		sDescripcion+=terminoproforma.getadjunto()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=terminoproforma.getresponsable()+",";
		sDescripcion+=TerminoProformaConstantesFunciones.CARGO+"=";
		sDescripcion+=terminoproforma.getcargo()+",";
			
		return sDescripcion;
	}
	
	public static void setTerminoProformaDescripcion(TerminoProforma terminoproforma,String sValor) throws Exception {			
		if(terminoproforma !=null) {
			//terminoproformaterminoproforma.getId().toString();
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getProformaDescripcion(Proforma proforma) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(proforma!=null/*&&proforma.getId()>0*/) {
			sDescripcion=ProformaConstantesFunciones.getProformaDescripcion(proforma);
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
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdProforma")) {
			sNombreIndice="Tipo=  Por Proforma";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProforma(Long id_proforma) {
		String sDetalleIndice=" Parametros->";
		if(id_proforma!=null) {sDetalleIndice+=" Codigo Unico De Proforma="+id_proforma.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTerminoProforma(TerminoProforma terminoproforma,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		terminoproforma.setatencion(terminoproforma.getatencion().trim());
		terminoproforma.setregistro_sanitario(terminoproforma.getregistro_sanitario().trim());
		terminoproforma.setreferencia(terminoproforma.getreferencia().trim());
		terminoproforma.setdescripcion(terminoproforma.getdescripcion().trim());
		terminoproforma.setdescripcion2(terminoproforma.getdescripcion2().trim());
		terminoproforma.setmarca(terminoproforma.getmarca().trim());
		terminoproforma.setorigen(terminoproforma.getorigen().trim());
		terminoproforma.setgarantia_tecnica(terminoproforma.getgarantia_tecnica().trim());
		terminoproforma.setfecha_pago(terminoproforma.getfecha_pago().trim());
		terminoproforma.setfecha_entrega(terminoproforma.getfecha_entrega().trim());
		terminoproforma.setadjunto(terminoproforma.getadjunto().trim());
		terminoproforma.setresponsable(terminoproforma.getresponsable().trim());
		terminoproforma.setcargo(terminoproforma.getcargo().trim());
	}
	
	public static void quitarEspaciosTerminoProformas(List<TerminoProforma> terminoproformas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TerminoProforma terminoproforma: terminoproformas) {
			terminoproforma.setatencion(terminoproforma.getatencion().trim());
			terminoproforma.setregistro_sanitario(terminoproforma.getregistro_sanitario().trim());
			terminoproforma.setreferencia(terminoproforma.getreferencia().trim());
			terminoproforma.setdescripcion(terminoproforma.getdescripcion().trim());
			terminoproforma.setdescripcion2(terminoproforma.getdescripcion2().trim());
			terminoproforma.setmarca(terminoproforma.getmarca().trim());
			terminoproforma.setorigen(terminoproforma.getorigen().trim());
			terminoproforma.setgarantia_tecnica(terminoproforma.getgarantia_tecnica().trim());
			terminoproforma.setfecha_pago(terminoproforma.getfecha_pago().trim());
			terminoproforma.setfecha_entrega(terminoproforma.getfecha_entrega().trim());
			terminoproforma.setadjunto(terminoproforma.getadjunto().trim());
			terminoproforma.setresponsable(terminoproforma.getresponsable().trim());
			terminoproforma.setcargo(terminoproforma.getcargo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTerminoProforma(TerminoProforma terminoproforma,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && terminoproforma.getConCambioAuxiliar()) {
			terminoproforma.setIsDeleted(terminoproforma.getIsDeletedAuxiliar());	
			terminoproforma.setIsNew(terminoproforma.getIsNewAuxiliar());	
			terminoproforma.setIsChanged(terminoproforma.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			terminoproforma.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			terminoproforma.setIsDeletedAuxiliar(false);	
			terminoproforma.setIsNewAuxiliar(false);	
			terminoproforma.setIsChangedAuxiliar(false);
			
			terminoproforma.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTerminoProformas(List<TerminoProforma> terminoproformas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TerminoProforma terminoproforma : terminoproformas) {
			if(conAsignarBase && terminoproforma.getConCambioAuxiliar()) {
				terminoproforma.setIsDeleted(terminoproforma.getIsDeletedAuxiliar());	
				terminoproforma.setIsNew(terminoproforma.getIsNewAuxiliar());	
				terminoproforma.setIsChanged(terminoproforma.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				terminoproforma.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				terminoproforma.setIsDeletedAuxiliar(false);	
				terminoproforma.setIsNewAuxiliar(false);	
				terminoproforma.setIsChangedAuxiliar(false);
				
				terminoproforma.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTerminoProforma(TerminoProforma terminoproforma,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTerminoProformas(List<TerminoProforma> terminoproformas,Boolean conEnteros) throws Exception  {
		
		for(TerminoProforma terminoproforma: terminoproformas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTerminoProforma(List<TerminoProforma> terminoproformas,TerminoProforma terminoproformaAux) throws Exception  {
		TerminoProformaConstantesFunciones.InicializarValoresTerminoProforma(terminoproformaAux,true);
		
		for(TerminoProforma terminoproforma: terminoproformas) {
			if(terminoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTerminoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TerminoProformaConstantesFunciones.getArrayColumnasGlobalesTerminoProforma(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTerminoProforma(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TerminoProformaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TerminoProformaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TerminoProformaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TerminoProformaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TerminoProformaConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TerminoProformaConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTerminoProforma(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TerminoProforma> terminoproformas,TerminoProforma terminoproforma,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TerminoProforma terminoproformaAux: terminoproformas) {
			if(terminoproformaAux!=null && terminoproforma!=null) {
				if((terminoproformaAux.getId()==null && terminoproforma.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(terminoproformaAux.getId()!=null && terminoproforma.getId()!=null){
					if(terminoproformaAux.getId().equals(terminoproforma.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTerminoProforma(List<TerminoProforma> terminoproformas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TerminoProforma terminoproforma: terminoproformas) {			
			if(terminoproforma.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTerminoProforma() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_ID, TerminoProformaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_VERSIONROW, TerminoProformaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_IDEMPRESA, TerminoProformaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_IDSUCURSAL, TerminoProformaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_IDMONEDA, TerminoProformaConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_IDPROFORMA, TerminoProformaConstantesFunciones.IDPROFORMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_ATENCION, TerminoProformaConstantesFunciones.ATENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_REGISTROSANITARIO, TerminoProformaConstantesFunciones.REGISTROSANITARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_REFERENCIA, TerminoProformaConstantesFunciones.REFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_DESCRIPCION, TerminoProformaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_DESCRIPCION2, TerminoProformaConstantesFunciones.DESCRIPCION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_MARCA, TerminoProformaConstantesFunciones.MARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_ORIGEN, TerminoProformaConstantesFunciones.ORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_GARANTIATECNICA, TerminoProformaConstantesFunciones.GARANTIATECNICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_FECHAPAGO, TerminoProformaConstantesFunciones.FECHAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_FECHAENTREGA, TerminoProformaConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_ADJUNTO, TerminoProformaConstantesFunciones.ADJUNTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_RESPONSABLE, TerminoProformaConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TerminoProformaConstantesFunciones.LABEL_CARGO, TerminoProformaConstantesFunciones.CARGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTerminoProforma() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.IDPROFORMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.ATENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.REGISTROSANITARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.REFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.DESCRIPCION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.MARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.ORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.GARANTIATECNICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.FECHAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.ADJUNTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TerminoProformaConstantesFunciones.CARGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTerminoProforma() throws Exception  {
		return TerminoProformaConstantesFunciones.getTiposSeleccionarTerminoProforma(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTerminoProforma(Boolean conFk) throws Exception  {
		return TerminoProformaConstantesFunciones.getTiposSeleccionarTerminoProforma(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTerminoProforma(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_IDPROFORMA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_IDPROFORMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_ATENCION);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_ATENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_REGISTROSANITARIO);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_REGISTROSANITARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_REFERENCIA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_REFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_DESCRIPCION2);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_DESCRIPCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_MARCA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_MARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_ORIGEN);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_ORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_GARANTIATECNICA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_GARANTIATECNICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_FECHAPAGO);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_FECHAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_ADJUNTO);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_ADJUNTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TerminoProformaConstantesFunciones.LABEL_CARGO);
			reporte.setsDescripcion(TerminoProformaConstantesFunciones.LABEL_CARGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTerminoProforma(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTerminoProforma(TerminoProforma terminoproformaAux) throws Exception {
		
			terminoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(terminoproformaAux.getEmpresa()));
			terminoproformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(terminoproformaAux.getSucursal()));
			terminoproformaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(terminoproformaAux.getMoneda()));
			terminoproformaAux.setproforma_descripcion(ProformaConstantesFunciones.getProformaDescripcion(terminoproformaAux.getProforma()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTerminoProforma(List<TerminoProforma> terminoproformasTemp) throws Exception {
		for(TerminoProforma terminoproformaAux:terminoproformasTemp) {
			
			terminoproformaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(terminoproformaAux.getEmpresa()));
			terminoproformaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(terminoproformaAux.getSucursal()));
			terminoproformaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(terminoproformaAux.getMoneda()));
			terminoproformaAux.setproforma_descripcion(ProformaConstantesFunciones.getProformaDescripcion(terminoproformaAux.getProforma()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Proforma.class));
				
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
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Proforma.class)) {
						classes.add(new Classe(Proforma.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTerminoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
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

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Proforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Proforma.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TerminoProformaConstantesFunciones.getClassesRelationshipsOfTerminoProforma(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTerminoProforma(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleTerminoProforma.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleTerminoProforma.class)) {
						classes.add(new Classe(DetalleTerminoProforma.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTerminoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TerminoProformaConstantesFunciones.getClassesRelationshipsFromStringsOfTerminoProforma(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTerminoProforma(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleTerminoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTerminoProforma.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleTerminoProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTerminoProforma.class)); continue;
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
	public static void actualizarLista(TerminoProforma terminoproforma,List<TerminoProforma> terminoproformas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TerminoProforma terminoproformaEncontrado=null;
			
			for(TerminoProforma terminoproformaLocal:terminoproformas) {
				if(terminoproformaLocal.getId().equals(terminoproforma.getId())) {
					terminoproformaEncontrado=terminoproformaLocal;
					
					terminoproformaLocal.setIsChanged(terminoproforma.getIsChanged());
					terminoproformaLocal.setIsNew(terminoproforma.getIsNew());
					terminoproformaLocal.setIsDeleted(terminoproforma.getIsDeleted());
					
					terminoproformaLocal.setGeneralEntityOriginal(terminoproforma.getGeneralEntityOriginal());
					
					terminoproformaLocal.setId(terminoproforma.getId());	
					terminoproformaLocal.setVersionRow(terminoproforma.getVersionRow());	
					terminoproformaLocal.setid_empresa(terminoproforma.getid_empresa());	
					terminoproformaLocal.setid_sucursal(terminoproforma.getid_sucursal());	
					terminoproformaLocal.setid_moneda(terminoproforma.getid_moneda());	
					terminoproformaLocal.setid_proforma(terminoproforma.getid_proforma());	
					terminoproformaLocal.setatencion(terminoproforma.getatencion());	
					terminoproformaLocal.setregistro_sanitario(terminoproforma.getregistro_sanitario());	
					terminoproformaLocal.setreferencia(terminoproforma.getreferencia());	
					terminoproformaLocal.setdescripcion(terminoproforma.getdescripcion());	
					terminoproformaLocal.setdescripcion2(terminoproforma.getdescripcion2());	
					terminoproformaLocal.setmarca(terminoproforma.getmarca());	
					terminoproformaLocal.setorigen(terminoproforma.getorigen());	
					terminoproformaLocal.setgarantia_tecnica(terminoproforma.getgarantia_tecnica());	
					terminoproformaLocal.setfecha_pago(terminoproforma.getfecha_pago());	
					terminoproformaLocal.setfecha_entrega(terminoproforma.getfecha_entrega());	
					terminoproformaLocal.setadjunto(terminoproforma.getadjunto());	
					terminoproformaLocal.setresponsable(terminoproforma.getresponsable());	
					terminoproformaLocal.setcargo(terminoproforma.getcargo());	
					
					
					terminoproformaLocal.setDetalleTerminoProformas(terminoproforma.getDetalleTerminoProformas());
					
					existe=true;
					break;
				}
			}
			
			if(!terminoproforma.getIsDeleted()) {
				if(!existe) {
					terminoproformas.add(terminoproforma);
				}
			} else {
				if(terminoproformaEncontrado!=null && permiteQuitar)  {
					terminoproformas.remove(terminoproformaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TerminoProforma terminoproforma,List<TerminoProforma> terminoproformas) throws Exception {
		try	{			
			for(TerminoProforma terminoproformaLocal:terminoproformas) {
				if(terminoproformaLocal.getId().equals(terminoproforma.getId())) {
					terminoproformaLocal.setIsSelected(terminoproforma.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTerminoProforma(List<TerminoProforma> terminoproformasAux) throws Exception {
		//this.terminoproformasAux=terminoproformasAux;
		
		for(TerminoProforma terminoproformaAux:terminoproformasAux) {
			if(terminoproformaAux.getIsChanged()) {
				terminoproformaAux.setIsChanged(false);
			}		
			
			if(terminoproformaAux.getIsNew()) {
				terminoproformaAux.setIsNew(false);
			}	
			
			if(terminoproformaAux.getIsDeleted()) {
				terminoproformaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTerminoProforma(TerminoProforma terminoproformaAux) throws Exception {
		//this.terminoproformaAux=terminoproformaAux;
		
			if(terminoproformaAux.getIsChanged()) {
				terminoproformaAux.setIsChanged(false);
			}		
			
			if(terminoproformaAux.getIsNew()) {
				terminoproformaAux.setIsNew(false);
			}	
			
			if(terminoproformaAux.getIsDeleted()) {
				terminoproformaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TerminoProforma terminoproformaAsignar,TerminoProforma terminoproforma) throws Exception {
		terminoproformaAsignar.setId(terminoproforma.getId());	
		terminoproformaAsignar.setVersionRow(terminoproforma.getVersionRow());	
		terminoproformaAsignar.setid_empresa(terminoproforma.getid_empresa());
		terminoproformaAsignar.setempresa_descripcion(terminoproforma.getempresa_descripcion());	
		terminoproformaAsignar.setid_sucursal(terminoproforma.getid_sucursal());
		terminoproformaAsignar.setsucursal_descripcion(terminoproforma.getsucursal_descripcion());	
		terminoproformaAsignar.setid_moneda(terminoproforma.getid_moneda());
		terminoproformaAsignar.setmoneda_descripcion(terminoproforma.getmoneda_descripcion());	
		terminoproformaAsignar.setid_proforma(terminoproforma.getid_proforma());
		terminoproformaAsignar.setproforma_descripcion(terminoproforma.getproforma_descripcion());	
		terminoproformaAsignar.setatencion(terminoproforma.getatencion());	
		terminoproformaAsignar.setregistro_sanitario(terminoproforma.getregistro_sanitario());	
		terminoproformaAsignar.setreferencia(terminoproforma.getreferencia());	
		terminoproformaAsignar.setdescripcion(terminoproforma.getdescripcion());	
		terminoproformaAsignar.setdescripcion2(terminoproforma.getdescripcion2());	
		terminoproformaAsignar.setmarca(terminoproforma.getmarca());	
		terminoproformaAsignar.setorigen(terminoproforma.getorigen());	
		terminoproformaAsignar.setgarantia_tecnica(terminoproforma.getgarantia_tecnica());	
		terminoproformaAsignar.setfecha_pago(terminoproforma.getfecha_pago());	
		terminoproformaAsignar.setfecha_entrega(terminoproforma.getfecha_entrega());	
		terminoproformaAsignar.setadjunto(terminoproforma.getadjunto());	
		terminoproformaAsignar.setresponsable(terminoproforma.getresponsable());	
		terminoproformaAsignar.setcargo(terminoproforma.getcargo());	
	}
	
	public static void inicializarTerminoProforma(TerminoProforma terminoproforma) throws Exception {
		try {
				terminoproforma.setId(0L);	
					
				terminoproforma.setid_empresa(-1L);	
				terminoproforma.setid_sucursal(-1L);	
				terminoproforma.setid_moneda(-1L);	
				terminoproforma.setid_proforma(-1L);	
				terminoproforma.setatencion("");	
				terminoproforma.setregistro_sanitario("");	
				terminoproforma.setreferencia("");	
				terminoproforma.setdescripcion("");	
				terminoproforma.setdescripcion2("");	
				terminoproforma.setmarca("");	
				terminoproforma.setorigen("");	
				terminoproforma.setgarantia_tecnica("");	
				terminoproforma.setfecha_pago("");	
				terminoproforma.setfecha_entrega("");	
				terminoproforma.setadjunto("");	
				terminoproforma.setresponsable("");	
				terminoproforma.setcargo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTerminoProforma(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_IDPROFORMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_ATENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_REGISTROSANITARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_REFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_DESCRIPCION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_MARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_ORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_GARANTIATECNICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_FECHAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_ADJUNTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TerminoProformaConstantesFunciones.LABEL_CARGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTerminoProforma(String sTipo,Row row,Workbook workbook,TerminoProforma terminoproforma,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getproforma_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getatencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getregistro_sanitario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getreferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getdescripcion2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getmarca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getorigen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getgarantia_tecnica());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getfecha_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getadjunto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(terminoproforma.getcargo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTerminoProforma=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTerminoProforma() {
		return this.sFinalQueryTerminoProforma;
	}
	
	public void setsFinalQueryTerminoProforma(String sFinalQueryTerminoProforma) {
		this.sFinalQueryTerminoProforma= sFinalQueryTerminoProforma;
	}
	
	public Border resaltarSeleccionarTerminoProforma=null;
	
	public Border setResaltarSeleccionarTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTerminoProforma= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTerminoProforma() {
		return this.resaltarSeleccionarTerminoProforma;
	}
	
	public void setResaltarSeleccionarTerminoProforma(Border borderResaltarSeleccionarTerminoProforma) {
		this.resaltarSeleccionarTerminoProforma= borderResaltarSeleccionarTerminoProforma;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTerminoProforma=null;
	public Boolean mostraridTerminoProforma=true;
	public Boolean activaridTerminoProforma=true;

	public Border resaltarid_empresaTerminoProforma=null;
	public Boolean mostrarid_empresaTerminoProforma=true;
	public Boolean activarid_empresaTerminoProforma=true;
	public Boolean cargarid_empresaTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTerminoProforma=false;//ConEventDepend=true

	public Border resaltarid_sucursalTerminoProforma=null;
	public Boolean mostrarid_sucursalTerminoProforma=true;
	public Boolean activarid_sucursalTerminoProforma=true;
	public Boolean cargarid_sucursalTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTerminoProforma=false;//ConEventDepend=true

	public Border resaltarid_monedaTerminoProforma=null;
	public Boolean mostrarid_monedaTerminoProforma=true;
	public Boolean activarid_monedaTerminoProforma=true;
	public Boolean cargarid_monedaTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaTerminoProforma=false;//ConEventDepend=true

	public Border resaltarid_proformaTerminoProforma=null;
	public Boolean mostrarid_proformaTerminoProforma=true;
	public Boolean activarid_proformaTerminoProforma=true;
	public Boolean cargarid_proformaTerminoProforma=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_proformaTerminoProforma=false;//ConEventDepend=true

	public Border resaltaratencionTerminoProforma=null;
	public Boolean mostraratencionTerminoProforma=true;
	public Boolean activaratencionTerminoProforma=true;

	public Border resaltarregistro_sanitarioTerminoProforma=null;
	public Boolean mostrarregistro_sanitarioTerminoProforma=true;
	public Boolean activarregistro_sanitarioTerminoProforma=true;

	public Border resaltarreferenciaTerminoProforma=null;
	public Boolean mostrarreferenciaTerminoProforma=true;
	public Boolean activarreferenciaTerminoProforma=true;

	public Border resaltardescripcionTerminoProforma=null;
	public Boolean mostrardescripcionTerminoProforma=true;
	public Boolean activardescripcionTerminoProforma=true;

	public Border resaltardescripcion2TerminoProforma=null;
	public Boolean mostrardescripcion2TerminoProforma=true;
	public Boolean activardescripcion2TerminoProforma=true;

	public Border resaltarmarcaTerminoProforma=null;
	public Boolean mostrarmarcaTerminoProforma=true;
	public Boolean activarmarcaTerminoProforma=true;

	public Border resaltarorigenTerminoProforma=null;
	public Boolean mostrarorigenTerminoProforma=true;
	public Boolean activarorigenTerminoProforma=true;

	public Border resaltargarantia_tecnicaTerminoProforma=null;
	public Boolean mostrargarantia_tecnicaTerminoProforma=true;
	public Boolean activargarantia_tecnicaTerminoProforma=true;

	public Border resaltarfecha_pagoTerminoProforma=null;
	public Boolean mostrarfecha_pagoTerminoProforma=true;
	public Boolean activarfecha_pagoTerminoProforma=true;

	public Border resaltarfecha_entregaTerminoProforma=null;
	public Boolean mostrarfecha_entregaTerminoProforma=true;
	public Boolean activarfecha_entregaTerminoProforma=true;

	public Border resaltaradjuntoTerminoProforma=null;
	public Boolean mostraradjuntoTerminoProforma=true;
	public Boolean activaradjuntoTerminoProforma=true;

	public Border resaltarresponsableTerminoProforma=null;
	public Boolean mostrarresponsableTerminoProforma=true;
	public Boolean activarresponsableTerminoProforma=true;

	public Border resaltarcargoTerminoProforma=null;
	public Boolean mostrarcargoTerminoProforma=true;
	public Boolean activarcargoTerminoProforma=true;

	
	

	public Border setResaltaridTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltaridTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTerminoProforma() {
		return this.resaltaridTerminoProforma;
	}

	public void setResaltaridTerminoProforma(Border borderResaltar) {
		this.resaltaridTerminoProforma= borderResaltar;
	}

	public Boolean getMostraridTerminoProforma() {
		return this.mostraridTerminoProforma;
	}

	public void setMostraridTerminoProforma(Boolean mostraridTerminoProforma) {
		this.mostraridTerminoProforma= mostraridTerminoProforma;
	}

	public Boolean getActivaridTerminoProforma() {
		return this.activaridTerminoProforma;
	}

	public void setActivaridTerminoProforma(Boolean activaridTerminoProforma) {
		this.activaridTerminoProforma= activaridTerminoProforma;
	}

	public Border setResaltarid_empresaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_empresaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTerminoProforma() {
		return this.resaltarid_empresaTerminoProforma;
	}

	public void setResaltarid_empresaTerminoProforma(Border borderResaltar) {
		this.resaltarid_empresaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_empresaTerminoProforma() {
		return this.mostrarid_empresaTerminoProforma;
	}

	public void setMostrarid_empresaTerminoProforma(Boolean mostrarid_empresaTerminoProforma) {
		this.mostrarid_empresaTerminoProforma= mostrarid_empresaTerminoProforma;
	}

	public Boolean getActivarid_empresaTerminoProforma() {
		return this.activarid_empresaTerminoProforma;
	}

	public void setActivarid_empresaTerminoProforma(Boolean activarid_empresaTerminoProforma) {
		this.activarid_empresaTerminoProforma= activarid_empresaTerminoProforma;
	}

	public Boolean getCargarid_empresaTerminoProforma() {
		return this.cargarid_empresaTerminoProforma;
	}

	public void setCargarid_empresaTerminoProforma(Boolean cargarid_empresaTerminoProforma) {
		this.cargarid_empresaTerminoProforma= cargarid_empresaTerminoProforma;
	}

	public Border setResaltarid_sucursalTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTerminoProforma() {
		return this.resaltarid_sucursalTerminoProforma;
	}

	public void setResaltarid_sucursalTerminoProforma(Border borderResaltar) {
		this.resaltarid_sucursalTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTerminoProforma() {
		return this.mostrarid_sucursalTerminoProforma;
	}

	public void setMostrarid_sucursalTerminoProforma(Boolean mostrarid_sucursalTerminoProforma) {
		this.mostrarid_sucursalTerminoProforma= mostrarid_sucursalTerminoProforma;
	}

	public Boolean getActivarid_sucursalTerminoProforma() {
		return this.activarid_sucursalTerminoProforma;
	}

	public void setActivarid_sucursalTerminoProforma(Boolean activarid_sucursalTerminoProforma) {
		this.activarid_sucursalTerminoProforma= activarid_sucursalTerminoProforma;
	}

	public Boolean getCargarid_sucursalTerminoProforma() {
		return this.cargarid_sucursalTerminoProforma;
	}

	public void setCargarid_sucursalTerminoProforma(Boolean cargarid_sucursalTerminoProforma) {
		this.cargarid_sucursalTerminoProforma= cargarid_sucursalTerminoProforma;
	}

	public Border setResaltarid_monedaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_monedaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaTerminoProforma() {
		return this.resaltarid_monedaTerminoProforma;
	}

	public void setResaltarid_monedaTerminoProforma(Border borderResaltar) {
		this.resaltarid_monedaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_monedaTerminoProforma() {
		return this.mostrarid_monedaTerminoProforma;
	}

	public void setMostrarid_monedaTerminoProforma(Boolean mostrarid_monedaTerminoProforma) {
		this.mostrarid_monedaTerminoProforma= mostrarid_monedaTerminoProforma;
	}

	public Boolean getActivarid_monedaTerminoProforma() {
		return this.activarid_monedaTerminoProforma;
	}

	public void setActivarid_monedaTerminoProforma(Boolean activarid_monedaTerminoProforma) {
		this.activarid_monedaTerminoProforma= activarid_monedaTerminoProforma;
	}

	public Boolean getCargarid_monedaTerminoProforma() {
		return this.cargarid_monedaTerminoProforma;
	}

	public void setCargarid_monedaTerminoProforma(Boolean cargarid_monedaTerminoProforma) {
		this.cargarid_monedaTerminoProforma= cargarid_monedaTerminoProforma;
	}

	public Border setResaltarid_proformaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarid_proformaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_proformaTerminoProforma() {
		return this.resaltarid_proformaTerminoProforma;
	}

	public void setResaltarid_proformaTerminoProforma(Border borderResaltar) {
		this.resaltarid_proformaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarid_proformaTerminoProforma() {
		return this.mostrarid_proformaTerminoProforma;
	}

	public void setMostrarid_proformaTerminoProforma(Boolean mostrarid_proformaTerminoProforma) {
		this.mostrarid_proformaTerminoProforma= mostrarid_proformaTerminoProforma;
	}

	public Boolean getActivarid_proformaTerminoProforma() {
		return this.activarid_proformaTerminoProforma;
	}

	public void setActivarid_proformaTerminoProforma(Boolean activarid_proformaTerminoProforma) {
		this.activarid_proformaTerminoProforma= activarid_proformaTerminoProforma;
	}

	public Boolean getCargarid_proformaTerminoProforma() {
		return this.cargarid_proformaTerminoProforma;
	}

	public void setCargarid_proformaTerminoProforma(Boolean cargarid_proformaTerminoProforma) {
		this.cargarid_proformaTerminoProforma= cargarid_proformaTerminoProforma;
	}

	public Border setResaltaratencionTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltaratencionTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaratencionTerminoProforma() {
		return this.resaltaratencionTerminoProforma;
	}

	public void setResaltaratencionTerminoProforma(Border borderResaltar) {
		this.resaltaratencionTerminoProforma= borderResaltar;
	}

	public Boolean getMostraratencionTerminoProforma() {
		return this.mostraratencionTerminoProforma;
	}

	public void setMostraratencionTerminoProforma(Boolean mostraratencionTerminoProforma) {
		this.mostraratencionTerminoProforma= mostraratencionTerminoProforma;
	}

	public Boolean getActivaratencionTerminoProforma() {
		return this.activaratencionTerminoProforma;
	}

	public void setActivaratencionTerminoProforma(Boolean activaratencionTerminoProforma) {
		this.activaratencionTerminoProforma= activaratencionTerminoProforma;
	}

	public Border setResaltarregistro_sanitarioTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarregistro_sanitarioTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarregistro_sanitarioTerminoProforma() {
		return this.resaltarregistro_sanitarioTerminoProforma;
	}

	public void setResaltarregistro_sanitarioTerminoProforma(Border borderResaltar) {
		this.resaltarregistro_sanitarioTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarregistro_sanitarioTerminoProforma() {
		return this.mostrarregistro_sanitarioTerminoProforma;
	}

	public void setMostrarregistro_sanitarioTerminoProforma(Boolean mostrarregistro_sanitarioTerminoProforma) {
		this.mostrarregistro_sanitarioTerminoProforma= mostrarregistro_sanitarioTerminoProforma;
	}

	public Boolean getActivarregistro_sanitarioTerminoProforma() {
		return this.activarregistro_sanitarioTerminoProforma;
	}

	public void setActivarregistro_sanitarioTerminoProforma(Boolean activarregistro_sanitarioTerminoProforma) {
		this.activarregistro_sanitarioTerminoProforma= activarregistro_sanitarioTerminoProforma;
	}

	public Border setResaltarreferenciaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarreferenciaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarreferenciaTerminoProforma() {
		return this.resaltarreferenciaTerminoProforma;
	}

	public void setResaltarreferenciaTerminoProforma(Border borderResaltar) {
		this.resaltarreferenciaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarreferenciaTerminoProforma() {
		return this.mostrarreferenciaTerminoProforma;
	}

	public void setMostrarreferenciaTerminoProforma(Boolean mostrarreferenciaTerminoProforma) {
		this.mostrarreferenciaTerminoProforma= mostrarreferenciaTerminoProforma;
	}

	public Boolean getActivarreferenciaTerminoProforma() {
		return this.activarreferenciaTerminoProforma;
	}

	public void setActivarreferenciaTerminoProforma(Boolean activarreferenciaTerminoProforma) {
		this.activarreferenciaTerminoProforma= activarreferenciaTerminoProforma;
	}

	public Border setResaltardescripcionTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltardescripcionTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTerminoProforma() {
		return this.resaltardescripcionTerminoProforma;
	}

	public void setResaltardescripcionTerminoProforma(Border borderResaltar) {
		this.resaltardescripcionTerminoProforma= borderResaltar;
	}

	public Boolean getMostrardescripcionTerminoProforma() {
		return this.mostrardescripcionTerminoProforma;
	}

	public void setMostrardescripcionTerminoProforma(Boolean mostrardescripcionTerminoProforma) {
		this.mostrardescripcionTerminoProforma= mostrardescripcionTerminoProforma;
	}

	public Boolean getActivardescripcionTerminoProforma() {
		return this.activardescripcionTerminoProforma;
	}

	public void setActivardescripcionTerminoProforma(Boolean activardescripcionTerminoProforma) {
		this.activardescripcionTerminoProforma= activardescripcionTerminoProforma;
	}

	public Border setResaltardescripcion2TerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltardescripcion2TerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion2TerminoProforma() {
		return this.resaltardescripcion2TerminoProforma;
	}

	public void setResaltardescripcion2TerminoProforma(Border borderResaltar) {
		this.resaltardescripcion2TerminoProforma= borderResaltar;
	}

	public Boolean getMostrardescripcion2TerminoProforma() {
		return this.mostrardescripcion2TerminoProforma;
	}

	public void setMostrardescripcion2TerminoProforma(Boolean mostrardescripcion2TerminoProforma) {
		this.mostrardescripcion2TerminoProforma= mostrardescripcion2TerminoProforma;
	}

	public Boolean getActivardescripcion2TerminoProforma() {
		return this.activardescripcion2TerminoProforma;
	}

	public void setActivardescripcion2TerminoProforma(Boolean activardescripcion2TerminoProforma) {
		this.activardescripcion2TerminoProforma= activardescripcion2TerminoProforma;
	}

	public Border setResaltarmarcaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarmarcaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmarcaTerminoProforma() {
		return this.resaltarmarcaTerminoProforma;
	}

	public void setResaltarmarcaTerminoProforma(Border borderResaltar) {
		this.resaltarmarcaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarmarcaTerminoProforma() {
		return this.mostrarmarcaTerminoProforma;
	}

	public void setMostrarmarcaTerminoProforma(Boolean mostrarmarcaTerminoProforma) {
		this.mostrarmarcaTerminoProforma= mostrarmarcaTerminoProforma;
	}

	public Boolean getActivarmarcaTerminoProforma() {
		return this.activarmarcaTerminoProforma;
	}

	public void setActivarmarcaTerminoProforma(Boolean activarmarcaTerminoProforma) {
		this.activarmarcaTerminoProforma= activarmarcaTerminoProforma;
	}

	public Border setResaltarorigenTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarorigenTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarorigenTerminoProforma() {
		return this.resaltarorigenTerminoProforma;
	}

	public void setResaltarorigenTerminoProforma(Border borderResaltar) {
		this.resaltarorigenTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarorigenTerminoProforma() {
		return this.mostrarorigenTerminoProforma;
	}

	public void setMostrarorigenTerminoProforma(Boolean mostrarorigenTerminoProforma) {
		this.mostrarorigenTerminoProforma= mostrarorigenTerminoProforma;
	}

	public Boolean getActivarorigenTerminoProforma() {
		return this.activarorigenTerminoProforma;
	}

	public void setActivarorigenTerminoProforma(Boolean activarorigenTerminoProforma) {
		this.activarorigenTerminoProforma= activarorigenTerminoProforma;
	}

	public Border setResaltargarantia_tecnicaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltargarantia_tecnicaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargarantia_tecnicaTerminoProforma() {
		return this.resaltargarantia_tecnicaTerminoProforma;
	}

	public void setResaltargarantia_tecnicaTerminoProforma(Border borderResaltar) {
		this.resaltargarantia_tecnicaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrargarantia_tecnicaTerminoProforma() {
		return this.mostrargarantia_tecnicaTerminoProforma;
	}

	public void setMostrargarantia_tecnicaTerminoProforma(Boolean mostrargarantia_tecnicaTerminoProforma) {
		this.mostrargarantia_tecnicaTerminoProforma= mostrargarantia_tecnicaTerminoProforma;
	}

	public Boolean getActivargarantia_tecnicaTerminoProforma() {
		return this.activargarantia_tecnicaTerminoProforma;
	}

	public void setActivargarantia_tecnicaTerminoProforma(Boolean activargarantia_tecnicaTerminoProforma) {
		this.activargarantia_tecnicaTerminoProforma= activargarantia_tecnicaTerminoProforma;
	}

	public Border setResaltarfecha_pagoTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarfecha_pagoTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pagoTerminoProforma() {
		return this.resaltarfecha_pagoTerminoProforma;
	}

	public void setResaltarfecha_pagoTerminoProforma(Border borderResaltar) {
		this.resaltarfecha_pagoTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarfecha_pagoTerminoProforma() {
		return this.mostrarfecha_pagoTerminoProforma;
	}

	public void setMostrarfecha_pagoTerminoProforma(Boolean mostrarfecha_pagoTerminoProforma) {
		this.mostrarfecha_pagoTerminoProforma= mostrarfecha_pagoTerminoProforma;
	}

	public Boolean getActivarfecha_pagoTerminoProforma() {
		return this.activarfecha_pagoTerminoProforma;
	}

	public void setActivarfecha_pagoTerminoProforma(Boolean activarfecha_pagoTerminoProforma) {
		this.activarfecha_pagoTerminoProforma= activarfecha_pagoTerminoProforma;
	}

	public Border setResaltarfecha_entregaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaTerminoProforma() {
		return this.resaltarfecha_entregaTerminoProforma;
	}

	public void setResaltarfecha_entregaTerminoProforma(Border borderResaltar) {
		this.resaltarfecha_entregaTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaTerminoProforma() {
		return this.mostrarfecha_entregaTerminoProforma;
	}

	public void setMostrarfecha_entregaTerminoProforma(Boolean mostrarfecha_entregaTerminoProforma) {
		this.mostrarfecha_entregaTerminoProforma= mostrarfecha_entregaTerminoProforma;
	}

	public Boolean getActivarfecha_entregaTerminoProforma() {
		return this.activarfecha_entregaTerminoProforma;
	}

	public void setActivarfecha_entregaTerminoProforma(Boolean activarfecha_entregaTerminoProforma) {
		this.activarfecha_entregaTerminoProforma= activarfecha_entregaTerminoProforma;
	}

	public Border setResaltaradjuntoTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltaradjuntoTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaradjuntoTerminoProforma() {
		return this.resaltaradjuntoTerminoProforma;
	}

	public void setResaltaradjuntoTerminoProforma(Border borderResaltar) {
		this.resaltaradjuntoTerminoProforma= borderResaltar;
	}

	public Boolean getMostraradjuntoTerminoProforma() {
		return this.mostraradjuntoTerminoProforma;
	}

	public void setMostraradjuntoTerminoProforma(Boolean mostraradjuntoTerminoProforma) {
		this.mostraradjuntoTerminoProforma= mostraradjuntoTerminoProforma;
	}

	public Boolean getActivaradjuntoTerminoProforma() {
		return this.activaradjuntoTerminoProforma;
	}

	public void setActivaradjuntoTerminoProforma(Boolean activaradjuntoTerminoProforma) {
		this.activaradjuntoTerminoProforma= activaradjuntoTerminoProforma;
	}

	public Border setResaltarresponsableTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarresponsableTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableTerminoProforma() {
		return this.resaltarresponsableTerminoProforma;
	}

	public void setResaltarresponsableTerminoProforma(Border borderResaltar) {
		this.resaltarresponsableTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarresponsableTerminoProforma() {
		return this.mostrarresponsableTerminoProforma;
	}

	public void setMostrarresponsableTerminoProforma(Boolean mostrarresponsableTerminoProforma) {
		this.mostrarresponsableTerminoProforma= mostrarresponsableTerminoProforma;
	}

	public Boolean getActivarresponsableTerminoProforma() {
		return this.activarresponsableTerminoProforma;
	}

	public void setActivarresponsableTerminoProforma(Boolean activarresponsableTerminoProforma) {
		this.activarresponsableTerminoProforma= activarresponsableTerminoProforma;
	}

	public Border setResaltarcargoTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltar);
		
		this.resaltarcargoTerminoProforma= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcargoTerminoProforma() {
		return this.resaltarcargoTerminoProforma;
	}

	public void setResaltarcargoTerminoProforma(Border borderResaltar) {
		this.resaltarcargoTerminoProforma= borderResaltar;
	}

	public Boolean getMostrarcargoTerminoProforma() {
		return this.mostrarcargoTerminoProforma;
	}

	public void setMostrarcargoTerminoProforma(Boolean mostrarcargoTerminoProforma) {
		this.mostrarcargoTerminoProforma= mostrarcargoTerminoProforma;
	}

	public Boolean getActivarcargoTerminoProforma() {
		return this.activarcargoTerminoProforma;
	}

	public void setActivarcargoTerminoProforma(Boolean activarcargoTerminoProforma) {
		this.activarcargoTerminoProforma= activarcargoTerminoProforma;
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
		
		
		this.setMostraridTerminoProforma(esInicial);
		this.setMostrarid_empresaTerminoProforma(esInicial);
		this.setMostrarid_sucursalTerminoProforma(esInicial);
		this.setMostrarid_monedaTerminoProforma(esInicial);
		this.setMostrarid_proformaTerminoProforma(esInicial);
		this.setMostraratencionTerminoProforma(esInicial);
		this.setMostrarregistro_sanitarioTerminoProforma(esInicial);
		this.setMostrarreferenciaTerminoProforma(esInicial);
		this.setMostrardescripcionTerminoProforma(esInicial);
		this.setMostrardescripcion2TerminoProforma(esInicial);
		this.setMostrarmarcaTerminoProforma(esInicial);
		this.setMostrarorigenTerminoProforma(esInicial);
		this.setMostrargarantia_tecnicaTerminoProforma(esInicial);
		this.setMostrarfecha_pagoTerminoProforma(esInicial);
		this.setMostrarfecha_entregaTerminoProforma(esInicial);
		this.setMostraradjuntoTerminoProforma(esInicial);
		this.setMostrarresponsableTerminoProforma(esInicial);
		this.setMostrarcargoTerminoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ID)) {
				this.setMostraridTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDPROFORMA)) {
				this.setMostrarid_proformaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ATENCION)) {
				this.setMostraratencionTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.REGISTROSANITARIO)) {
				this.setMostrarregistro_sanitarioTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.REFERENCIA)) {
				this.setMostrarreferenciaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.DESCRIPCION2)) {
				this.setMostrardescripcion2TerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.MARCA)) {
				this.setMostrarmarcaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ORIGEN)) {
				this.setMostrarorigenTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.GARANTIATECNICA)) {
				this.setMostrargarantia_tecnicaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.FECHAPAGO)) {
				this.setMostrarfecha_pagoTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ADJUNTO)) {
				this.setMostraradjuntoTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.CARGO)) {
				this.setMostrarcargoTerminoProforma(esAsigna);
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
		
		
		this.setActivaridTerminoProforma(esInicial);
		this.setActivarid_empresaTerminoProforma(esInicial);
		this.setActivarid_sucursalTerminoProforma(esInicial);
		this.setActivarid_monedaTerminoProforma(esInicial);
		this.setActivarid_proformaTerminoProforma(esInicial);
		this.setActivaratencionTerminoProforma(esInicial);
		this.setActivarregistro_sanitarioTerminoProforma(esInicial);
		this.setActivarreferenciaTerminoProforma(esInicial);
		this.setActivardescripcionTerminoProforma(esInicial);
		this.setActivardescripcion2TerminoProforma(esInicial);
		this.setActivarmarcaTerminoProforma(esInicial);
		this.setActivarorigenTerminoProforma(esInicial);
		this.setActivargarantia_tecnicaTerminoProforma(esInicial);
		this.setActivarfecha_pagoTerminoProforma(esInicial);
		this.setActivarfecha_entregaTerminoProforma(esInicial);
		this.setActivaradjuntoTerminoProforma(esInicial);
		this.setActivarresponsableTerminoProforma(esInicial);
		this.setActivarcargoTerminoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ID)) {
				this.setActivaridTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDPROFORMA)) {
				this.setActivarid_proformaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ATENCION)) {
				this.setActivaratencionTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.REGISTROSANITARIO)) {
				this.setActivarregistro_sanitarioTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.REFERENCIA)) {
				this.setActivarreferenciaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.DESCRIPCION2)) {
				this.setActivardescripcion2TerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.MARCA)) {
				this.setActivarmarcaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ORIGEN)) {
				this.setActivarorigenTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.GARANTIATECNICA)) {
				this.setActivargarantia_tecnicaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.FECHAPAGO)) {
				this.setActivarfecha_pagoTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ADJUNTO)) {
				this.setActivaradjuntoTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.CARGO)) {
				this.setActivarcargoTerminoProforma(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTerminoProforma(esInicial);
		this.setResaltarid_empresaTerminoProforma(esInicial);
		this.setResaltarid_sucursalTerminoProforma(esInicial);
		this.setResaltarid_monedaTerminoProforma(esInicial);
		this.setResaltarid_proformaTerminoProforma(esInicial);
		this.setResaltaratencionTerminoProforma(esInicial);
		this.setResaltarregistro_sanitarioTerminoProforma(esInicial);
		this.setResaltarreferenciaTerminoProforma(esInicial);
		this.setResaltardescripcionTerminoProforma(esInicial);
		this.setResaltardescripcion2TerminoProforma(esInicial);
		this.setResaltarmarcaTerminoProforma(esInicial);
		this.setResaltarorigenTerminoProforma(esInicial);
		this.setResaltargarantia_tecnicaTerminoProforma(esInicial);
		this.setResaltarfecha_pagoTerminoProforma(esInicial);
		this.setResaltarfecha_entregaTerminoProforma(esInicial);
		this.setResaltaradjuntoTerminoProforma(esInicial);
		this.setResaltarresponsableTerminoProforma(esInicial);
		this.setResaltarcargoTerminoProforma(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ID)) {
				this.setResaltaridTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.IDPROFORMA)) {
				this.setResaltarid_proformaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ATENCION)) {
				this.setResaltaratencionTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.REGISTROSANITARIO)) {
				this.setResaltarregistro_sanitarioTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.REFERENCIA)) {
				this.setResaltarreferenciaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.DESCRIPCION2)) {
				this.setResaltardescripcion2TerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.MARCA)) {
				this.setResaltarmarcaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ORIGEN)) {
				this.setResaltarorigenTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.GARANTIATECNICA)) {
				this.setResaltargarantia_tecnicaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.FECHAPAGO)) {
				this.setResaltarfecha_pagoTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.ADJUNTO)) {
				this.setResaltaradjuntoTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableTerminoProforma(esAsigna);
				continue;
			}

			if(campo.clase.equals(TerminoProformaConstantesFunciones.CARGO)) {
				this.setResaltarcargoTerminoProforma(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleTerminoProformaTerminoProforma=null;

	public Border getResaltarDetalleTerminoProformaTerminoProforma() {
		return this.resaltarDetalleTerminoProformaTerminoProforma;
	}

	public void setResaltarDetalleTerminoProformaTerminoProforma(Border borderResaltarDetalleTerminoProforma) {
		if(borderResaltarDetalleTerminoProforma!=null) {
			this.resaltarDetalleTerminoProformaTerminoProforma= borderResaltarDetalleTerminoProforma;
		}
	}

	public Border setResaltarDetalleTerminoProformaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleTerminoProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//terminoproformaBeanSwingJInternalFrame.jTtoolBarTerminoProforma.setBorder(borderResaltarDetalleTerminoProforma);
			
		this.resaltarDetalleTerminoProformaTerminoProforma= borderResaltarDetalleTerminoProforma;

		 return borderResaltarDetalleTerminoProforma;
	}



	public Boolean mostrarDetalleTerminoProformaTerminoProforma=true;

	public Boolean getMostrarDetalleTerminoProformaTerminoProforma() {
		return this.mostrarDetalleTerminoProformaTerminoProforma;
	}

	public void setMostrarDetalleTerminoProformaTerminoProforma(Boolean visibilidadResaltarDetalleTerminoProforma) {
		this.mostrarDetalleTerminoProformaTerminoProforma= visibilidadResaltarDetalleTerminoProforma;
	}



	public Boolean activarDetalleTerminoProformaTerminoProforma=true;

	public Boolean gethabilitarResaltarDetalleTerminoProformaTerminoProforma() {
		return this.activarDetalleTerminoProformaTerminoProforma;
	}

	public void setActivarDetalleTerminoProformaTerminoProforma(Boolean habilitarResaltarDetalleTerminoProforma) {
		this.activarDetalleTerminoProformaTerminoProforma= habilitarResaltarDetalleTerminoProforma;
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

		this.setMostrarDetalleTerminoProformaTerminoProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTerminoProforma.class)) {
				this.setMostrarDetalleTerminoProformaTerminoProforma(esAsigna);
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

		this.setActivarDetalleTerminoProformaTerminoProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTerminoProforma.class)) {
				this.setActivarDetalleTerminoProformaTerminoProforma(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleTerminoProformaTerminoProforma(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTerminoProforma.class)) {
				this.setResaltarDetalleTerminoProformaTerminoProforma(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTerminoProforma=true;

	public Boolean getMostrarFK_IdEmpresaTerminoProforma() {
		return this.mostrarFK_IdEmpresaTerminoProforma;
	}

	public void setMostrarFK_IdEmpresaTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTerminoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaTerminoProforma=true;

	public Boolean getMostrarFK_IdMonedaTerminoProforma() {
		return this.mostrarFK_IdMonedaTerminoProforma;
	}

	public void setMostrarFK_IdMonedaTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaTerminoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProformaTerminoProforma=true;

	public Boolean getMostrarFK_IdProformaTerminoProforma() {
		return this.mostrarFK_IdProformaTerminoProforma;
	}

	public void setMostrarFK_IdProformaTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProformaTerminoProforma= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTerminoProforma=true;

	public Boolean getMostrarFK_IdSucursalTerminoProforma() {
		return this.mostrarFK_IdSucursalTerminoProforma;
	}

	public void setMostrarFK_IdSucursalTerminoProforma(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTerminoProforma= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTerminoProforma=true;

	public Boolean getActivarFK_IdEmpresaTerminoProforma() {
		return this.activarFK_IdEmpresaTerminoProforma;
	}

	public void setActivarFK_IdEmpresaTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTerminoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaTerminoProforma=true;

	public Boolean getActivarFK_IdMonedaTerminoProforma() {
		return this.activarFK_IdMonedaTerminoProforma;
	}

	public void setActivarFK_IdMonedaTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaTerminoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdProformaTerminoProforma=true;

	public Boolean getActivarFK_IdProformaTerminoProforma() {
		return this.activarFK_IdProformaTerminoProforma;
	}

	public void setActivarFK_IdProformaTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdProformaTerminoProforma= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTerminoProforma=true;

	public Boolean getActivarFK_IdSucursalTerminoProforma() {
		return this.activarFK_IdSucursalTerminoProforma;
	}

	public void setActivarFK_IdSucursalTerminoProforma(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTerminoProforma= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTerminoProforma=null;

	public Border getResaltarFK_IdEmpresaTerminoProforma() {
		return this.resaltarFK_IdEmpresaTerminoProforma;
	}

	public void setResaltarFK_IdEmpresaTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTerminoProforma= borderResaltar;
	}

	public Border resaltarFK_IdMonedaTerminoProforma=null;

	public Border getResaltarFK_IdMonedaTerminoProforma() {
		return this.resaltarFK_IdMonedaTerminoProforma;
	}

	public void setResaltarFK_IdMonedaTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdMonedaTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdMonedaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaTerminoProforma= borderResaltar;
	}

	public Border resaltarFK_IdProformaTerminoProforma=null;

	public Border getResaltarFK_IdProformaTerminoProforma() {
		return this.resaltarFK_IdProformaTerminoProforma;
	}

	public void setResaltarFK_IdProformaTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdProformaTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdProformaTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProformaTerminoProforma= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTerminoProforma=null;

	public Border getResaltarFK_IdSucursalTerminoProforma() {
		return this.resaltarFK_IdSucursalTerminoProforma;
	}

	public void setResaltarFK_IdSucursalTerminoProforma(Border borderResaltar) {
		this.resaltarFK_IdSucursalTerminoProforma= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTerminoProforma(ParametroGeneralUsuario parametroGeneralUsuario/*TerminoProformaBeanSwingJInternalFrame terminoproformaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTerminoProforma= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}